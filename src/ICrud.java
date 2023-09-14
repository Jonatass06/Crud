import java.util.ArrayList;

public interface ICrud <ID, T> {

    T criar(T objeto);
    boolean remover(ID id);
    T atualizar(T objeto);
    T ler(ID id);
    ArrayList<T> ler();
}
