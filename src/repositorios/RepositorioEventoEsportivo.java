package repositorios;

import entidades.EventoEsportivo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEventoEsportivo implements IRepositorioEventoEsportivo {

    @Override
    public void cadastrar(EventoEsportivo evento) {
        String sql = "INSERT INTO evento_esportivo (id_evento, nome_evento, data, esporte) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getIdEvento());
            stmt.setString(2, evento.getNomeEvento());
            stmt.setString(3, evento.getData());
            stmt.setString(4, evento.getEsporte());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar evento: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(String id) {
        String sql = "DELETE FROM evento_esportivo WHERE id_evento = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover evento: " + e.getMessage(), e);
        }
    }

    @Override
    public EventoEsportivo buscar(String id) {
        String sql = "SELECT id_evento, nome_evento, data, esporte FROM evento_esportivo WHERE id_evento = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EventoEsportivo(
                        rs.getString("id_evento"),
                        rs.getString("nome_evento"),
                        rs.getString("data"),
                        rs.getString("esporte")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar evento: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void atualizar(EventoEsportivo evento) {
        String sql = "UPDATE evento_esportivo SET nome_evento = ?, data = ?, esporte = ? WHERE id_evento = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getNomeEvento());
            stmt.setString(2, evento.getData());
            stmt.setString(3, evento.getEsporte());
            stmt.setString(4, evento.getIdEvento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar evento: " + e.getMessage(), e);
        }
    }

    @Override
    public List<EventoEsportivo> listar() {
        List<EventoEsportivo> lista = new ArrayList<>();
        String sql = "SELECT id_evento, nome_evento, data, esporte FROM evento_esportivo";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new EventoEsportivo(
                    rs.getString("id_evento"),
                    rs.getString("nome_evento"),
                    rs.getString("data"),
                    rs.getString("esporte")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar eventos: " + e.getMessage(), e);
        }
        return lista;
    }
}
