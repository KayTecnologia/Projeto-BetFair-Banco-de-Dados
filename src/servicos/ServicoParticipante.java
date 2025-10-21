package servicos;

import entidades.Participante;
import repositorios.RepositorioParticipante;
import java.util.List;

public class ServicoParticipante implements IServicoParticipante {
    private RepositorioParticipante repositorio = new RepositorioParticipante();

    @Override
    public void cadastrar(Participante entidade) {
        repositorio.cadastrar(entidade);
    }

    @Override
    public void remover(String id) {
        repositorio.remover(id);
    }

    @Override
    public Participante buscar(String id) {
        return repositorio.buscar(id);
    }

    @Override
    public void atualizar(Participante entidade) {
        repositorio.atualizar(entidade);
    }

    @Override
    public List<Participante> listar() {
        return repositorio.listar();
    }
}
