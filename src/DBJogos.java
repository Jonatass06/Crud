import java.util.ArrayList;

public class DBJogos implements ICrud<Integer, Jogo>{

    private ArrayList<Jogo> jogos;
    public DBJogos(){
        this.jogos = new ArrayList<>();
    }

    @Override
    public Jogo criar(Jogo jogo) {
        this.jogos.add(jogo);
        return jogo;
    }
    @Override
    public Jogo atualizar(Jogo jogoNovo) {
        for(Jogo jogo : this.jogos){
            if(jogo.getCod() == jogoNovo.getCod()){
                jogo = jogoNovo;
                return jogoNovo;
            }
        }
        return null;
    }
    @Override
    public boolean remover(Integer cod) {
        for(Jogo jogo : this.jogos){
            if (jogo.getCod() == cod){
                this.jogos.remove(cod);
                return true;
            }
        }
        return false;
    }
    @Override
    public Jogo ler(Integer cod) {
        for(Jogo jogo : this.jogos){
            if(jogo.getCod() == cod){
                return jogo;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Jogo> ler() {
        return this.jogos;
    }
}
