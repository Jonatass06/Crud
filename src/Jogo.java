import java.util.ArrayList;

public class Jogo {

    private String nome;
    private double preco;
    private String console;
    private int cod;

    public Jogo(String nome, double preco, String console, ArrayList<Jogo> jogos) {
        this.nome = nome;
        this.preco = preco;
        this.console = console;
        this.cod = jogos.size() == 0 ? 0 : jogos.get(jogos.size()-1).getCod() + 1;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", console='" + console + '\'' +
                ", cod=" + cod +
                '}';
    }
}
