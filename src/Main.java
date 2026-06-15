import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        int opcao = 0;

        System.out.println("=========================================");
        System.out.println(" SISTEMA DE CADASTRO DE PERSONAGENS RPG ");
        System.out.println("=========================================");

        while (opcao != 11) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Inserir personagem");
            System.out.println("2. Buscar personagem pelo nível");
            System.out.println("3. Remover personagem");
            System.out.println("4. Exibir personagens em ordem crescente de nível");
            System.out.println("5. Exibir personagem mais forte");
            System.out.println("6. Exibir personagem mais fraco");
            System.out.println("7. Mostrar quantidade de personagens");
            System.out.println("8. Mostrar altura da árvore");
            System.out.println("9. Exibir personagens em pré-ordem");
            System.out.println("10. Exibir personagens em pós-ordem");
            System.out.println("11. Encerrar sistema");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Classe (ex: Mago, Guerreiro): ");
                    String classeRpg = scanner.nextLine();
                    System.out.print("Nível: ");
                    int nivel = scanner.nextInt();

                    if (arvore.buscar(nivel) != null) {
                        System.out.println("\n[ERRO] Já existe um personagem cadastrado com o nível " + nivel + "!");
                        System.out.println("Por favor, tente novamente com um nível diferente.");
                        scanner.nextLine();
                    } else {
                        System.out.print("Pontos de Vida (HP): ");
                        int hp = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tipo de Arma: ");
                        String arma = scanner.nextLine();

                        Personagem novo = new Personagem(nome, classeRpg, nivel, hp, arma);
                        arvore.inserir(novo);
                        System.out.println("\nPersonagem inserido com sucesso!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nível do personagem que deseja buscar: ");
                    int nivelBusca = scanner.nextInt();
                    Personagem encontrado = arvore.buscar(nivelBusca);
                    if (encontrado != null) {
                        System.out.println("Personagem encontrado: " + encontrado.toString());
                    } else {
                        System.out.println("Nenhum personagem encontrado no nível " + nivelBusca);
                    }
                    break;

                case 3:
                    System.out.print("Digite o nível do personagem que deseja remover: ");
                    int nivelRemover = scanner.nextInt();
                    Personagem verificar = arvore.buscar(nivelRemover);
                    if (verificar != null) {
                        arvore.remover(nivelRemover);
                        System.out.println("Personagem removido com sucesso!");
                    } else {
                        System.out.println("Personagem não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Personagens (Ordem Crescente) ---");
                    arvore.exibirEmOrdem();
                    break;

                case 5:
                    Personagem maisForte = arvore.exibirMaisForte();
                    if (maisForte != null) {
                        System.out.println("Personagem Mais Forte: " + maisForte.toString());
                    } else {
                        System.out.println("A árvore está vazia.");
                    }
                    break;

                case 6:
                    Personagem maisFraco = arvore.exibirMaisFraco();
                    if (maisFraco != null) {
                        System.out.println("Personagem Mais Fraco: " + maisFraco.toString());
                    } else {
                        System.out.println("A árvore está vazia.");
                    }
                    break;

                case 7:
                    System.out.println("Total de personagens cadastrados: " + arvore.contarPersonagens());
                    break;

                case 8:
                    System.out.println("Altura atual da árvore: " + arvore.calcularAltura());
                    break;

                case 9:
                    System.out.println("\n--- Personagens (Pré-Ordem) ---");
                    arvore.exibirEmPreOrdem();
                    break;

                case 10:
                    System.out.println("\n--- Personagens (Pós-Ordem) ---");
                    arvore.exibirEmPosOrdem();
                    break;

                case 11:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
