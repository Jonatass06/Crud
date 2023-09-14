import java.util.ArrayList;

public class DBItens implements ICrud<Integer, Item>{

    private ArrayList<Item> itens;

    public DBItens(){
        this.itens = new ArrayList<>();
    }
    @Override
    public Item criar(Item item) {
        this.itens.add(item);
        return item;
    }
    @Override
    public boolean remover(Integer cod) {
        for(Item item : this.itens){
            if (item.getCod() == cod){
                this.itens.remove(cod);
                return true;
            }
        }
        return false;
    }
    @Override
    public Item atualizar(Item itemNovo) {
        for(Item item : this.itens){
            if(item.getCod() == itemNovo.getCod()){
                item = itemNovo;
                return itemNovo;
            }
        }
        return null;
    }
    @Override
    public Item ler(Integer cod) {
        for(Item item : this.itens){
            if(item.getCod() == cod){
                return itens.get(cod);
            }
        }
        return null;
    }
    @Override
    public ArrayList<Item> ler() {
        return this.itens;
    }
}
