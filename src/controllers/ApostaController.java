package controllers;

import entidades.Aposta;
import servicos.ServicoAposta;
import java.util.List;

public class ApostaController {
    private ServicoAposta servico;

    public ApostaController(ServicoAposta servico) { this.servico = servico; }

    public void cadastrar(Aposta a) { servico.cadastrar(a); }
    public void remover(String id) { servico.remover(id); }
    public Aposta buscar(String id) { return servico.buscar(id); }
    public void atualizar(Aposta a) { servico.atualizar(a); }
    public List<Aposta> listar() { return servico.listar(); }
}
