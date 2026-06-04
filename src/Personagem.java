
public class Personagem {
    private String nome;
    private String classeRpg;
    private int nivel;
    private int pontosDeVida;
    private String tipoDeArma;

    public Personagem(String nome, String classeRpg, int nivel, int pontosDeVida, String tipoDeArma) {
        this.nome = nome;
        this.classeRpg = classeRpg;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.tipoDeArma = tipoDeArma;
    }

    public String getNome() {
        return nome;
    }

    public String getClasseRpg() {
        return classeRpg;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public String getTipoDeArma() {
        return tipoDeArma;
    }

    @Override
    public String toString() {
        return "Nível: " + nivel + " | Nome: " + nome + " | Classe: " + classeRpg +
               " | HP: " + pontosDeVida + " | Arma: " + tipoDeArma;
    }
}