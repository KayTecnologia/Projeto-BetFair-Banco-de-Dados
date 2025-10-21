package repositorios;

public interface RepositorioInterface<T> {
    void cadastrar(T entidade);
    void remover(String id);
    T buscar(String id);
    void atualizar(T entidade);
    java.util.List<T> listar();
}