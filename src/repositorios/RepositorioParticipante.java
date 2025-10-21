package repositorios;

import entidades.Participante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioParticipante implements IRepositorioParticipante {

    @Override
    public void cadastrar(Participante participante) {
        String sql = "INSERT INTO participante (id, nome) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, participante.getId());
            stmt.setString(2, participante.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar participante: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(String id) {
        String sql = "DELETE FROM participante WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover participante: " + e.getMessage(), e);
        }
    }

    @Override
    public Participante buscar(String id) {
        String sql = "SELECT id, nome FROM participante WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    final String pid = rs.getString("id");
                    final String pnome = rs.getString("nome");
                    // instância anônima de Participante (implementa o método abstrato)
                    return new Participante(pnome, pid) {
                        @Override
                        public String exibirInformacoes() {
                            return "Participante: " + pnome + " (ID: " + pid + ")";
                        }
                    };
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar participante: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void atualizar(Participante participante) {
        String sql = "UPDATE participante SET nome = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, participante.getNome());
            stmt.setString(2, participante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar participante: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Participante> listar() {
        List<Participante> lista = new ArrayList<>();
        String sql = "SELECT id, nome FROM participante";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                final String pid = rs.getString("id");
                final String pnome = rs.getString("nome");
                lista.add(new Participante(pnome, pid) {
                    @Override
                    public String exibirInformacoes() {
                        return "Participante: " + pnome + " (ID: " + pid + ")";
                    }
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar participantes: " + e.getMessage(), e);
        }
        return lista;
    }
}
