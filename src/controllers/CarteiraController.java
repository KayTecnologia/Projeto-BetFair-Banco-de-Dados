package controllers;

import entidades.Carteira;
import servicos.ServicoCarteira;
import java.util.List;

public class CarteiraController {
    private ServicoCarteira servico;

    public CarteiraController(ServicoCarteira servico) { this.servico = servico; }

    public void cadastrar(Carteira c) { servico.cadastrar(c); }
    public void remover(String id) { servico.remover(id); }
    public Carteira buscar(String id) { return servico.buscar(id); }
    public void atualizar(Carteira c) { servico.atualizar(c); }
    public List<Carteira> listar() { return servico.listar(); }
}
