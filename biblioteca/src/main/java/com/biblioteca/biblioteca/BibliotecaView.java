package com.biblioteca.biblioteca;
import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaView {
    private Scanner scanner = new Scanner(System.in);
    private LivroController livroController;

    public BibliotecaView(LivroController livroController) {
        this.livroController = livroController;
    }

    public void mostrarMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("[1] Cadastrar Livro");
        System.out.println("[2] Listar Livros");
        System.out.println("[3] Emprestar Livro");
        System.out.println("[4] Devolver Livro");
        System.out.println("[5] Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    public void iniciar() throws SQLException {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    private void cadastrarLivro() throws SQLException {
        scanner.nextLine();
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        Livro livroNovo = new Livro(0, titulo, autor, false);
        livroController.cadastrarLivro(livroNovo);
    }

    private void listarLivros() {
        System.out.println("Listando livros...");
        for (Livro livro : livroController.listarLivros()) {
            System.out.printf("Livro numero: %d \n\tTitulo: %s \n\tAutor: %s\n",livro.getId(), livro.getTitulo(), livro.getAutor());
        }
    }

    private void emprestarLivro() throws SQLException {
        System.out.println("Digite o ID do livro que deseja emprestar:");
        int id = scanner.nextInt();
        Livro livro = livroController.emprestaLivro(id);
        if (livro != null) {
            System.out.println("Você emprestou o livro: " + livro.getTitulo());
        }
    }

    private void devolverLivro() throws SQLException {
        System.out.println("Digite o ID do livro que deseja devolver:");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivro(id);
        if (livro != null) {
            livroController.devolverLivro(livro);
            System.out.println("Você devolveu o livro: " + livro.getTitulo());
        }
    }
}
