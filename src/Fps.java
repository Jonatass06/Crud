import java.util.ArrayList;

public class Fps extends Jogo {

    private ArrayList<Arma>armas;
    private int qtdeIntegrantesTimes;

    public Fps(String nome, double preco, String console, ArrayList<Jogo> jogos, ArrayList<Arma> armas, int qtdeIntegrantesTimes) {
        super(nome, preco, console, jogos);
        this.armas = armas;
        this.qtdeIntegrantesTimes = qtdeIntegrantesTimes;
    }

    @Override
    public String toString() {
        return "Fps{" +
                "armas=" + armas +
                ", qtdeIntegrantesTimes=" + qtdeIntegrantesTimes +
                "} " + super.toString();
    }
}
