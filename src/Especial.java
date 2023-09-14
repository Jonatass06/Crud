import java.util.ArrayList;

public class Especial extends Item{

    private String efeito;
    private int duracao;

    public Especial(String raridade, double preco, String nome, String efeito, int duracao, ArrayList<Item> itens) {
        super(raridade, preco, nome, itens);
        this.efeito = efeito;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Especial{" +
                "efeito='" + efeito + '\'' +
                ", duracao=" + duracao +
                "} " + super.toString();
    }
}
