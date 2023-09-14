import java.util.ArrayList;

public class Arma extends Item{

    private int tamanhoPente;
    private int dano;

    public Arma(String raridade, double preco, String nome, int tamanhoPente, int dano, ArrayList<Item> itens) {
        super(raridade, preco, nome, itens);
        this.tamanhoPente = tamanhoPente;
        this.dano = dano;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "tamanhoPente=" + tamanhoPente +
                ", dano=" + dano +
                "} " + super.toString();
    }
}
