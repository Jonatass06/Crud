import java.util.ArrayList;

public class Rpg extends Jogo {

    private String historiaInicial;
    private ArrayList<Item> itens;

    public Rpg(String nome, double preco, String console, ArrayList<Jogo> jogos,
               String historiaInicial, ArrayList<Item> itens) {
        super(nome, preco, console, jogos);
        this.historiaInicial = historiaInicial;
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Rpg{" +
                "historiaInicial='" + historiaInicial + '\'' +
                ", itens=" + itens +
                "} " + super.toString();
    }
}
