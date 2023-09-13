import java.util.ArrayList;

public class BancoItens implements ICrud{

    ArrayList<Item> itens;
    @Override
    public void criar(Object objeto) {
        itens.add((Item)objeto);
    }

    @Override
    public void remover(int id) {
        itens.remove((Item)objeto);
    }

    @Override
    public void atualizar(int id, Object objeto) {
        itens.add((Item)objeto);
    }

    @Override
    public Object lerUm(int id) {
        return null;
    }

    @Override
    public ArrayList<Object> lerTodos() {
        return null;
    }
}
