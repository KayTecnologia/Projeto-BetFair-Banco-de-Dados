package controllers;

import entidades.EventoEsportivo;
import servicos.ServicoEventoEsportivo;
import java.util.List;

public class EventoController {
    private ServicoEventoEsportivo servico;

    public EventoController(ServicoEventoEsportivo servico) { this.servico = servico; }

    public void cadastrar(EventoEsportivo e) { servico.cadastrar(e); }
    public void remover(String id) { servico.remover(id); }
    public EventoEsportivo buscar(String id) { return servico.buscar(id); }
    public void atualizar(EventoEsportivo e) { servico.atualizar(e); }
    public List<EventoEsportivo> listar() { return servico.listar(); }
}
