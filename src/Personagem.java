// Classe que representa um personagem de RPG
public class Personagem {

    // Atributos que guardam as informações do personagem
    private String nome;
    private String classeRpg;
    private int nivel;
    private int pontosDeVida;
    private String tipoDeArma;

    // Construtor usado para criar um personagem já com todos os dados
    public Personagem(String nome, String classeRpg, int nivel, int pontosDeVida, String tipoDeArma) {
        this.nome = nome;
        this.classeRpg = classeRpg;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.tipoDeArma = tipoDeArma;
    }

    // Retorna o nome do personagem
    public String getNome() {
        return nome;
    }

    // Retorna a classe do personagem (guerreiro, mago, arqueiro, etc.)
    public String getClasseRpg() {
        return classeRpg;
    }

    // Retorna o nível atual do personagem
    public int getNivel() {
        return nivel;
    }

    // Retorna a quantidade de pontos de vida (HP)
    public int getPontosDeVida() {
        return pontosDeVida;
    }

    // Retorna o tipo de arma que o personagem utiliza
    public String getTipoDeArma() {
        return tipoDeArma;
    }

    // Método que define como as informações do personagem serão exibidas
    @Override
    public String toString() {
        return "Nível: " + nivel + " | Nome: " + nome + " | Classe: " + classeRpg +
               " | HP: " + pontosDeVida + " | Arma: " + tipoDeArma;
    }
}