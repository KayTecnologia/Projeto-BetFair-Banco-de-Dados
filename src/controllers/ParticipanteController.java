package controllers;

import entidades.Participante;
import servicos.ServicoParticipante;
import java.util.List;

public class ParticipanteController {
    private ServicoParticipante servico;

    public ParticipanteController(ServicoParticipante servico) {
        this.servico = servico;
    }

    public void cadastrar(Participante p) { servico.cadastrar(p); }
    public void remover(String id) { servico.remover(id); }
    public Participante buscar(String id) { return servico.buscar(id); }
    public void atualizar(Participante p) { servico.atualizar(p); }
    public List<Participante> listar() { return servico.listar(); }
}
