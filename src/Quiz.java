import java.util.ArrayList;

public class Quiz extends Jogo {

    private ArrayList<String> perguntas;
    private ArrayList<String> respostas;

    public Quiz(String nome, double preco, String console, ArrayList<Jogo> jogos,
                ArrayList<String> perguntas, ArrayList<String> respostas) {
        super(nome, preco, console, jogos);
        this.perguntas = perguntas;
        this.respostas = respostas;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "perguntas=" + perguntas +
                ", respostas=" + respostas +
                "} " + super.toString();
    }
}
