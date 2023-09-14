import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Scanner sc2 = new Scanner(System.in);
    private static DBItens dbItens = new DBItens();
    private static DBJogos dbJogos = new DBJogos();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcao;
        do {
            System.out.println("""
                    [0] Cadastrar
                    [1] Atualizar
                    [2] Ler
                    [3] Deletar
                    [4] Sair
                    """);

            opcao = sc.nextInt();

            switch (opcao) {
                case 0 -> diferenciarCadastrar();
                case 1 -> diferenciarAtualizar();
                case 2 -> diferenciarLer();
                case 3 -> deletar();
                case 4 -> System.out.println("Até mais!");
                default -> System.out.println("Valor inválido!");
            }
        } while (opcao != 4);
    }

    private static int diferenciarGenerico() {
        int opcao;
        do {
            System.out.println("""
                    [0] Item
                    [1] Jogo
                    """);
            opcao = sc.nextInt();
        } while (opcao > 1 || opcao < 0);
        return opcao;
    }

    private static int diferenciarEspecifico() {
        int opcao;
        do {
            System.out.println("""
                    --------Jogos--------
                    [0] FPS
                    [1] RPG
                    [2] Quiz
                    --------Itens--------
                    [3] Item Especial
                    [4] Arma
                    [5] Armadura
                    """);
            opcao = sc.nextInt();
        } while (opcao > 5 || opcao < 0);
        return opcao;
    }

    private static void diferenciarCadastrar() {
        int tipo = diferenciarEspecifico();
        switch (tipo) {
            case 0, 1, 2 -> dbJogos.criar(cadastrarJogo(tipo));
            case 3, 4, 5 -> dbItens.criar(cadastrarItem(tipo));
        }
    }

    private static void diferenciarAtualizar() {
        int tipo = diferenciarEspecifico();
        switch (tipo) {
            case 0:
                atualizar(pedirFps());
                break;
            case 1:
                atualizar(pedirRpg());
                break;
            case 2:
                atualizar(pedirQuiz());
                break;
            case 3:
                atualizar(pedirEspecial());
                break;
            case 4:
                atualizar(pedirArma());
                break;
            case 5:
                atualizar(pedirArmadura());
                break;
        }
    }

    private static void deletar() {
        int tipo = diferenciarGenerico();

        if (tipo == 0) {
            if (dbItens.remover(pedirItem().getCod())) {
                System.out.println("Não existe esse item no banco de dados");
            }
        } else {
            if (dbJogos.remover(pedirJogo().getCod())) {
                System.out.println("Não existe esse jogo no banco de dados");
            }
        }
    }

    private static void diferenciarLer() {
        int tipo = diferenciarGenerico();
        int opcao;
        do {
            System.out.println("""
                    [0] Ler Um 
                    [1] Ler Todos
                    """);
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 1);

        if (opcao == 1 && tipo == 0) {
            pedirItens();
        } else if (opcao == 0 && tipo == 0) {
            pedirItem();
        } else if (opcao == 0 && tipo == 1) {
            pedirJogo();
        } else {
            pedirJogos();
        }
    }

    //metodos ler geral
    private static Jogo pedirJogo() {
        int cod;
        Jogo jogo;
        do {
            System.out.println("Digite o codigo do jogo:");
            cod = sc.nextInt();
            jogo = dbJogos.ler(cod);
            if (jogo == null) {
                System.out.println("Jogo não encontrado");
            }
        } while (jogo == null);
        System.out.println(jogo);
        return jogo;
    }

    private static Item pedirItem() {
        int cod;
        Item item;
        do {
            System.out.println("Digite o codigo do itens:");
            cod = sc.nextInt();
            item = dbItens.ler(cod);
            if (item == null) {
                System.out.println("Item não encontrado");
            }
        } while (item == null);

        System.out.println(item);
        return item;
    }

    //metodos ler especifico
    private static Fps pedirFps() {
        Jogo jogo = pedirJogo();
        if (jogo instanceof Fps) {
            return (Fps) jogo;
        }
        return null;
    }

    private static Rpg pedirRpg() {
        Jogo jogo = pedirJogo();
        if (jogo instanceof Rpg) {
            return (Rpg) jogo;
        }
        return null;
    }

    private static Quiz pedirQuiz() {
        Jogo jogo = pedirJogo();
        if (jogo instanceof Quiz) {
            return (Quiz) jogo;
        }
        return null;
    }

    private static Especial pedirEspecial() {
        Item item = pedirItem();
        if (item instanceof Especial) {
            return (Especial) item;
        }
        return null;
    }

    private static Arma pedirArma() {
        Item item = pedirItem();
        if (item instanceof Arma) {
            return (Arma) item;
        }
        return null;
    }

    private static Armadura pedirArmadura() {
        Item item = pedirArmadura();
        if (item instanceof Armadura) {
            return (Armadura) item;
        }
        return null;
    }

    private static void pedirJogos() {
        for (Jogo jogo : dbJogos.ler()) {
            System.out.println(jogo);
        }
    }

    private static void pedirItens() {
        for (Item item : dbItens.ler()) {
            System.out.println(item);
        }
    }

    //metodos atualizar
    private static void atualizar(Quiz quiz) {
        System.out.println(quiz);
        Jogo jogo = cadastrarJogo(2);
        jogo.setCod(quiz.getCod());
        System.out.println(dbJogos.atualizar(jogo));
    }

    private static void atualizar(Rpg rpg) {
        System.out.println(rpg);
        Jogo jogo = cadastrarJogo(1);
        jogo.setCod(rpg.getCod());
        System.out.println(dbJogos.atualizar(jogo));

    }

    private static void atualizar(Fps fps) {
        System.out.println(fps);
        Jogo jogo = cadastrarJogo(0);
        jogo.setCod(fps.getCod());
        System.out.println(dbJogos.atualizar(jogo));

    }


    private static void atualizar(Especial especial) {
        System.out.println(especial);
        Item item = cadastrarItem(3);
        item.setCod(especial.getCod());
        System.out.println(dbItens.atualizar(item));
    }


    private static void atualizar(Arma arma) {
        System.out.println(arma);
        Item item = cadastrarItem(4);
        item.setCod(arma.getCod());
        System.out.println(dbItens.atualizar(item));
    }


    private static void atualizar(Armadura armadura) {
        System.out.println(armadura);
        Item item = cadastrarItem(5);
        item.setCod(armadura.getCod());
        System.out.println(dbItens.atualizar(item));
    }


    //metodos de cadastro geral
    private static Item cadastrarItem(int tipo) {
        System.out.println("Qual o nome do item");
        String nome = sc2.nextLine();
        System.out.println("Qual o preco do item");
        double preco = sc.nextDouble();
        System.out.println("Qual a raridade do item");
        String raridade = sc2.nextLine();

        Item item;
        item = switch (tipo) {
            case 3 -> cadastrarEspecial(nome, preco, raridade);
            case 4 -> cadastrarArma(nome, preco, raridade);
            case 5 -> cadastrarArmadura(nome, preco, raridade);
            default -> null;
        };
        return item;
    }

    private static Jogo cadastrarJogo(int tipo) {
        System.out.println("Qual o nome do jogo");
        String nome = sc2.nextLine();
        System.out.println("Qual o preco do jogo");
        double preco = sc.nextDouble();
        System.out.println("Qual o console no qual o jogo funciona?");
        String console = sc2.nextLine();

        Jogo jogo;
        jogo = switch (tipo) {
            case 0 -> cadastrarFps(nome, preco, console);
            case 1 -> cadastrarRpg(nome, preco, console);
            case 2 -> cadastrarQuiz(nome, preco, console);
            default -> null;
        };
        return jogo;
    }

    //metodos de cadastro especifico
    private static Fps cadastrarFps(String nome, double preco, String console) {
        System.out.println("Quantos times terão nesse Fps?");
        int integrantes = sc.nextInt();

        int opcao;
        ArrayList<Arma> armas = new ArrayList<>();
        do {
            System.out.println("""
                    Cadastrando Armas
                    Voce deseja parar?
                    [0] Sim
                    [Outro] Não""");
            opcao = sc.nextInt();
            if (opcao != 0) {
                Arma arma = pedirArma();
                armas.add(arma);
                if (arma == null) {
                    System.out.println("Essa arma não existe!");
                }
            }
        } while (opcao != 0);

        return new Fps(nome, preco, console, dbJogos.ler(), armas, integrantes);
    }

    private static Rpg cadastrarRpg(String nome, double preco, String console) {
        System.out.println("Escreva a historia do rpg em uma linha corrida:");
        String historia = sc2.nextLine();

        int opcao;
        ArrayList<Item> itens = new ArrayList<>();
        if(dbItens.ler().size() == 0){
            System.out.println("Não existem itens no banco de dados");
        }else{
            do {
                System.out.println("""
                    Cadastrando Itens
                    Voce deseja parar?
                    [0] Sim
                    [Outro] Não""");
                opcao = sc.nextInt();
                if (opcao != 0) {
                    Item item = pedirItem();
                    itens.add(item);
                    if (item == null) {
                        System.out.println("Esse item não existe!");
                    }
                }
            } while (opcao != 0);
        }
        return new Rpg(nome, preco, console, dbJogos.ler(), historia, itens);

    }

    private static Quiz cadastrarQuiz(String nome, double preco, String console) {
        int opcao;

        ArrayList<String> perguntas = new ArrayList<>();
        ArrayList<String> respostas = new ArrayList<>();

        System.out.println("Escreva as perguntas e se lembre da ordem que elas foram inseridas");

        do {
            System.out.println("""
                    Cadastrando perguntas
                    Voce deseja parar?
                    [0] Sim
                    [Outro] Não""");
            opcao = sc.nextInt();
            if (opcao != 0) {
                System.out.println("Digite a pergunta:");
                String pergunta = sc2.nextLine();
                perguntas.add(pergunta);
            }
        } while (opcao != 0);

        System.out.println("Escreva as resposta na ordem das perguntas!");

        do {
            System.out.println("""
                    Cadastrando Respostas
                    Voce deseja parar?
                    [0] Sim
                    [Outro] Não""");
            opcao = sc.nextInt();
            if (opcao != 0) {
                System.out.println("Digite a resposta:");
                String resposta = sc2.nextLine();
                respostas.add(resposta);
            }
        } while (opcao != 0);
        return new Quiz(nome, preco, console, dbJogos.ler(), perguntas, respostas);
    }

    private static Especial cadastrarEspecial(String nome, double preco, String raridade) {
        System.out.println("Qual o efeito da arma?");
        String efeito = sc2.nextLine();
        System.out.println("Quantos segundos o efeito dura?");
        int tempo = sc.nextInt();
        return new Especial(nome, preco, raridade, efeito, tempo, dbItens.ler());
    }

    private static Arma cadastrarArma(String nome, double preco, String raridade) {
        System.out.println("Quantas balas cabem no pente?");
        int pente = sc.nextInt();
        System.out.println("Qual o dano de cada ataque?");
        int dano = sc.nextInt();

        return new Arma(nome, preco, raridade, pente, dano, dbItens.ler());
    }

    private static Armadura cadastrarArmadura(String nome, double preco, String raridade) {
        System.out.println("Qual o material que a compõe?");
        String material = sc2.nextLine();
        System.out.println("Quantos de defesa ela proporciona?");
        int defesa = sc.nextInt();
        return new Armadura(nome, preco, raridade, material, defesa, dbItens.ler());
    }
}