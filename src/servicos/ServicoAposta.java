package servicos;

import entidades.Aposta;
import repositorios.RepositorioAposta;
import java.util.List;

public class ServicoAposta implements IServicoAposta {
    private RepositorioAposta repositorio = new RepositorioAposta();

    @Override
    public void cadastrar(Aposta aposta) {
        repositorio.cadastrar(aposta);
    }

    @Override
    public void remover(String id) {
        repositorio.remover(id);
    }

    @Override
    public Aposta buscar(String id) {
        return repositorio.buscar(id);
    }

    @Override
    public void atualizar(Aposta aposta) {
        repositorio.atualizar(aposta);
    }

    @Override
    public List<Aposta> listar() {
        return repositorio.listar();
    }
}