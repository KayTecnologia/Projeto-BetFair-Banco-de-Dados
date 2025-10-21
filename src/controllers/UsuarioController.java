package controllers;

import entidades.Usuario;
import servicos.ServicoUsuario;
import java.util.List;

public class UsuarioController {
    private ServicoUsuario servico;

    public UsuarioController(ServicoUsuario servico) {
        this.servico = servico;
    }

    public void cadastrar(Usuario u) { servico.cadastrar(u); }
    public void remover(String id) { servico.remover(id); }
    public Usuario buscar(String id) { return servico.buscar(id); }
    public void atualizar(Usuario u) { servico.atualizar(u); }
    public List<Usuario> listar() { return servico.listar(); }
}
