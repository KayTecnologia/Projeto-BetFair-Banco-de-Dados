package servicos;

import entidades.EventoEsportivo;
import repositorios.RepositorioEventoEsportivo;
import java.util.List;

public class ServicoEventoEsportivo implements IServicoEventoEsportivo {
    private RepositorioEventoEsportivo repositorio = new RepositorioEventoEsportivo();

    @Override
    public void cadastrar(EventoEsportivo evento) {
        repositorio.cadastrar(evento);
    }

    @Override
    public void remover(String id) {
        repositorio.remover(id);
    }

    @Override
    public EventoEsportivo buscar(String id) {
        return repositorio.buscar(id);
    }

    @Override
    public void atualizar(EventoEsportivo evento) {
        repositorio.atualizar(evento);
    }

    @Override
    public List<EventoEsportivo> listar() {
        return repositorio.listar();
    }
}