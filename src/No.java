public class No {
    private Personagem personagem;
    private No esquerda;
    private No direita;

    public No(Personagem personagem) {
        this.personagem = personagem;
        this.esquerda = null;
        this.direita = null;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}