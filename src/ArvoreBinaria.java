public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Personagem personagem) {
        raiz = inserirRecursivo(raiz, personagem);
    }

    private No inserirRecursivo(No atual, Personagem personagem) {
        if (atual == null) {
            return new No(personagem);
        }

        if (personagem.getNivel() < atual.getPersonagem().getNivel()) {
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), personagem));
        } else if (personagem.getNivel() > atual.getPersonagem().getNivel()) {
            atual.setDireita(inserirRecursivo(atual.getDireita(), personagem));
        }

        return atual;
    }

    public Personagem buscar(int nivel) {
        return buscarRecursivo(raiz, nivel);
    }

    private Personagem buscarRecursivo(No atual, int nivel) {
        if (atual == null) {
            return null;
        }

        if (nivel == atual.getPersonagem().getNivel()) {
            return atual.getPersonagem();
        }

        if (nivel < atual.getPersonagem().getNivel()) {
            return buscarRecursivo(atual.getEsquerda(), nivel);
        } else {
            return buscarRecursivo(atual.getDireita(), nivel);
        }
    }

    public void remover(int nivel) {
        raiz = removerRecursivo(raiz, nivel);
    }

    private No removerRecursivo(No atual, int nivel) {
        if (atual == null) {
            return null;
        }

        if (nivel < atual.getPersonagem().getNivel()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), nivel));
        } else if (nivel > atual.getPersonagem().getNivel()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), nivel));
        } else {
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            Personagem menorPersonagem = encontrarMenorRecursivo(atual.getDireita());
            atual.setPersonagem(menorPersonagem);
            atual.setDireita(removerRecursivo(atual.getDireita(), menorPersonagem.getNivel()));
        }

        return atual;
    }

    public Personagem exibirMaisFraco() {
        if (raiz == null) return null;
        return encontrarMenorRecursivo(raiz);
    }

    private Personagem encontrarMenorRecursivo(No atual) {
        if (atual.getEsquerda() == null) {
            return atual.getPersonagem();
        }
        return encontrarMenorRecursivo(atual.getEsquerda());
    }

    public Personagem exibirMaisForte() {
        if (raiz == null) return null;
        return encontrarMaiorRecursivo(raiz);
    }

    private Personagem encontrarMaiorRecursivo(No atual) {
        if (atual.getDireita() == null) {
            return atual.getPersonagem();
        }
        return encontrarMaiorRecursivo(atual.getDireita());
    }

    public void exibirEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.getEsquerda());
            System.out.println(atual.getPersonagem().toString());
            exibirEmOrdemRecursivo(atual.getDireita());
        }
    }

    public void exibirEmPreOrdem() {
        exibirEmPreOrdemRecursivo(raiz);
    }

    private void exibirEmPreOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.println(atual.getPersonagem().toString());
            exibirEmPreOrdemRecursivo(atual.getEsquerda());
            exibirEmPreOrdemRecursivo(atual.getDireita());
        }
    }

    public void exibirEmPosOrdem() {
        exibirEmPosOrdemRecursivo(raiz);
    }

    private void exibirEmPosOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmPosOrdemRecursivo(atual.getEsquerda());
            exibirEmPosOrdemRecursivo(atual.getDireita());
            System.out.println(atual.getPersonagem().toString());
        }
    }

    public int contarPersonagens() {
        return contarRecursivo(raiz);
    }

    private int contarRecursivo(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarRecursivo(atual.getEsquerda()) + contarRecursivo(atual.getDireita());
    }

    public int calcularAltura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = alturaRecursiva(atual.getEsquerda());
        int alturaDireita = alturaRecursiva(atual.getDireita());
        
        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        } else {
            return alturaDireita + 1;
        }
    }
}
