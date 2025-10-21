package servicos;

import entidades.Carteira;
import repositorios.RepositorioCarteira;
import java.util.List;

public class ServicoCarteira implements IServicoCarteira {
    private RepositorioCarteira repositorio = new RepositorioCarteira();

    @Override
    public void cadastrar(Carteira carteira) {
        repositorio.cadastrar(carteira);
    }

    @Override
    public void remover(String id) {
        repositorio.remover(id);
    }

    @Override
    public Carteira buscar(String id) {
        return repositorio.buscar(id);
    }

    @Override
    public void atualizar(Carteira carteira) {
        repositorio.atualizar(carteira);
    }

    @Override
    public List<Carteira> listar() {
        return repositorio.listar();
    }
}