import java.util.ArrayList;

public interface ICrud {

    void criar(Object objeto);
    void remover(int id);
    void atualizar(int id,Object objeto);
    Object lerUm(int id);
    ArrayList<Object> lerTodos();
}
