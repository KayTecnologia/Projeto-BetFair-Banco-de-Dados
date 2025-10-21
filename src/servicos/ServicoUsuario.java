package servicos;

import entidades.Usuario;
import repositorios.RepositorioUsuario;
import java.util.List;

public class ServicoUsuario implements ServicoInterface<Usuario>, IServicoUsuario {
    private RepositorioUsuario repositorio = new RepositorioUsuario();

    @Override
    public void cadastrar(Usuario usuario) {
        repositorio.cadastrar(usuario);
    }

    @Override
    public void remover(String id) {
        repositorio.remover(id);
    }

    @Override
    public Usuario buscar(String id) {
        return repositorio.buscar(id);
    }

    @Override
    public void atualizar(Usuario usuario) {
        repositorio.atualizar(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.listar();
    }
}