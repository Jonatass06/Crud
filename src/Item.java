import java.util.ArrayList;

public class Item {
    private String raridade;
    private double preco;
    private String nome;
    private int cod;

    public Item(String raridade, double preco, String nome, ArrayList<Item> itens) {
        this.raridade = raridade;
        this.preco = preco;
        this.nome = nome;
        this.cod = itens.size() == 0 ? 0 : itens.get(itens.size()-1).getCod() + 1;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Item{" +
                "raridade='" + raridade + '\'' +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", cod=" + cod +
                '}';
    }
}
