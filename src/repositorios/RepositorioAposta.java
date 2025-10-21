package repositorios;

import entidades.Aposta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAposta implements IRepositorioAposta {

    @Override
    public void cadastrar(Aposta aposta) {
        String sql = "INSERT INTO aposta (id_aposta, id_usuario, id_evento, valor, resultado_escolhido) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aposta.getIdAposta());
            stmt.setString(2, aposta.getIdUsuario());
            stmt.setString(3, aposta.getIdEvento());
            stmt.setDouble(4, aposta.getValor());
            stmt.setString(5, aposta.getResultadoEscolhido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aposta: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(String id) {
        String sql = "DELETE FROM aposta WHERE id_aposta = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover aposta: " + e.getMessage(), e);
        }
    }

    @Override
    public Aposta buscar(String id) {
        String sql = "SELECT id_aposta, id_usuario, id_evento, valor, resultado_escolhido FROM aposta WHERE id_aposta = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Aposta(
                        rs.getString("id_aposta"),
                        rs.getString("id_usuario"),
                        rs.getString("id_evento"),
                        rs.getDouble("valor"),
                        rs.getString("resultado_escolhido")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aposta: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void atualizar(Aposta aposta) {
        String sql = "UPDATE aposta SET id_usuario = ?, id_evento = ?, valor = ?, resultado_escolhido = ? WHERE id_aposta = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aposta.getIdUsuario());
            stmt.setString(2, aposta.getIdEvento());
            stmt.setDouble(3, aposta.getValor());
            stmt.setString(4, aposta.getResultadoEscolhido());
            stmt.setString(5, aposta.getIdAposta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aposta: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Aposta> listar() {
        List<Aposta> lista = new ArrayList<>();
        String sql = "SELECT id_aposta, id_usuario, id_evento, valor, resultado_escolhido FROM aposta";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Aposta(
                    rs.getString("id_aposta"),
                    rs.getString("id_usuario"),
                    rs.getString("id_evento"),
                    rs.getDouble("valor"),
                    rs.getString("resultado_escolhido")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar apostas: " + e.getMessage(), e);
        }
        return lista;
    }
}
