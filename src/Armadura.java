import java.util.ArrayList;

public class Armadura extends Item{

    private String material;
    private int defesa;

    public Armadura(String raridade, double preco, String nome, String material, int defesa, ArrayList<Item> itens) {
        super(raridade, preco, nome, itens);
        this.material = material;
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return "Armadura{" +
                "material='" + material + '\'' +
                ", defesa=" + defesa +
                "} " + super.toString();
    }
}
