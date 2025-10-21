package repositorios;

import entidades.Carteira;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCarteira implements IRepositorioCarteira {

    @Override
    public void cadastrar(Carteira carteira) {
        String sql = "INSERT INTO carteira (id_usuario, saldo) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carteira.getIdUsuario());
            stmt.setDouble(2, carteira.getSaldo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar carteira: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(String id) {
        String sql = "DELETE FROM carteira WHERE id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover carteira: " + e.getMessage(), e);
        }
    }

    @Override
    public Carteira buscar(String id) {
        String sql = "SELECT id_usuario, saldo FROM carteira WHERE id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Carteira(rs.getString("id_usuario"), rs.getDouble("saldo"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar carteira: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void atualizar(Carteira carteira) {
        String sql = "UPDATE carteira SET saldo = ? WHERE id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, carteira.getSaldo());
            stmt.setString(2, carteira.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar carteira: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Carteira> listar() {
        List<Carteira> lista = new ArrayList<>();
        String sql = "SELECT id_usuario, saldo FROM carteira";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Carteira(rs.getString("id_usuario"), rs.getDouble("saldo")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar carteiras: " + e.getMessage(), e);
        }
        return lista;
    }
}
