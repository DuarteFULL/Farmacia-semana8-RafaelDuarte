package br.com.farmacia.farmacia8;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import br.com.farmacia.farmacia8.modelo.Fabricante;
import br.com.farmacia.farmacia8.modelo.Produto;
import br.com.farmacia.farmacia8.repository.FabricanteRepository;
import br.com.farmacia.farmacia8.repository.ProdutoRepository;

@Service
public class Principal {

    private static Scanner teclado = new Scanner(System.in);
    private static ProdutoRepository pRepository;
    private static FabricanteRepository fRepository;

    public Principal(ProdutoRepository proRepository, FabricanteRepository fabRepository) {
        this.pRepository = proRepository;
        this.fRepository = fabRepository;
    }

    public void exibeMenu() {

        var opcao = Menu();

        while (opcao != 6) {
            try {
                switch (opcao) {
                    case 1:
                        listarProdutos();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        deletarProduto();
                        break;
                    case 4:
                        alterarDescricaoProduto();
                        break;
                    case 5:
                        buscarPorNome();
                        break;
                }
            } catch (Exception e) {// RegraDenegocioException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                teclado.next();
            }

            opcao = Menu();

        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int Menu() {
        System.out.println("""
                FARMÁCIA - ESCOLHA UMA OPÇÃO:
                1 - Listar produtos
                2 - Cadastrar produto
                3 - Deletar produto
                4 - Alterar descrição do produto
                5 - Buscar por nome
                6 - Sair
                """);
        return teclado.nextInt();
    }

    private static void listarProdutos() {
        System.out.println("Produtos cadastrados:");

        List<Produto> todos = pRepository.findAll();

        if (todos.size() != 0) {
            todos.forEach(p2 -> System.out.println(p2.toString()));
        } else {
            System.out.println("\nNão existe nenhum produto cadastrado.");
        }

        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public static void cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        var nomeDoProduto = teclado.next();

        System.out.println("Digite a descrição do produto:");
        var descricaoDoProduto = teclado.next();

        System.out.println("Digite o valor do produto:");
        var valorDoProduto = teclado.nextFloat();

        System.out.println("Digite o fabricante do produto:");
        var fabricanteDoProduto = teclado.next();

        Fabricante fabricante = new Fabricante(fabricanteDoProduto);
        Produto produto = new Produto(nomeDoProduto, descricaoDoProduto, valorDoProduto, fabricante);

        fRepository.save(fabricante);
        pRepository.save(produto);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void deletarProduto() {
        System.out.print("Digite o ID do produto a ser deletado: ");
        var idDoProduto = teclado.nextInt();
        pRepository.deleteById((long) idDoProduto);

        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public static void alterarDescricaoProduto() {
        //ESSE METODO ESTA COM ERRO, É NECESSÁRIO REFATORAR.
        System.out.println("Digite o ID do produto a ser alterado: ");
        var idDoProduto = teclado.nextInt();

        System.out.println("Digite a nova descrição do produto:");
        var descricaoDoProduto = teclado.next();

        Produto produto = new Produto();
        produto.setId(idDoProduto);
        produto.setDescricao(descricaoDoProduto);

        System.out.println(pRepository.findById((long) idDoProduto));

        pRepository.save(produto);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public static void buscarPorNome() {
        System.out.println("Digite o nome do produto:");
        var nomeDoProduto = teclado.next();

        List<Produto> produtos =  pRepository.findByNome(nomeDoProduto);

        if (produtos.size() != 0) {
            produtos.forEach(p2 -> System.out.println(p2.toString()));
        } else {
            System.out.println("\nNão existe nenhum produto cadastrado com esse nome.");
        }

        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    };

//fim da aplicação
}
