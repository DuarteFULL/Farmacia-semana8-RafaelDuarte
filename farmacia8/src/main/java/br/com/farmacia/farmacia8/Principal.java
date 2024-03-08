package br.com.farmacia.farmacia8;

import java.util.List;
import java.util.Scanner;

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


    public void exibeMenu(){

    var opcao = Menu();

        while (opcao != 8) {
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
                        //consultarProduto();
                        break;
                    case 5:
                        alterarValorProduto();
                        break;
                    case 6:
                        //alterarFabricanteProduto();
                    case 7:
                        //alterarDescricaoProduto();
                }
            } catch (Exception e){//RegraDenegocioException e) {
                System.out.println("Erro: " +e.getMessage());
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
                4 - Consultar produto
                5 - Alterar valor do produto
                6 - Alterar fabricante do produto 
                7 - Alterar descrição do produto
                8 - Sair
                """);
        return teclado.nextInt();
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
    
    private static void listarProdutos() {
        System.out.println("Produtos cadastrados:");

        List<Produto> todos = pRepository.findAll();

        if(todos.size() != 0){
            todos.forEach(p2 -> System.out.println(p2.toString()));
        } else {
            System.out.println("\nNão existe nenhum produto cadastrado.");
        }
    
        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }
    
    private static void deletarProduto() {
        System.out.print("Digite o nome do produto a ser deletado: ");
        var nomeDoProduto = teclado.next();
    //     ProdutoService pService = new ProdutoService();

    //     pService.deletarPorNome(nomeDoProduto);
        
        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void consultarProduto() {
        System.out.print("Digite o nome do produto para consulta: ");
        var nomeDoProduto = teclado.next();

        

    //    ProdutoService pService = new ProdutoService();
    //    pService.buscarProdutoPorNome(nomeDoProduto);
    
        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void alterarValorProduto() {
        System.out.print("Id do produto a ser alterado: ");
        var idDoProduto = teclado.nextInt();
        System.out.print("Digite o novo valor do produto: ");
        var valorDoProduto = teclado.nextDouble();

        Produto produto = new Produto();

        produto.setId(idDoProduto);
        produto.setPreco(valorDoProduto);

        //produto = pRepository.getReferenceById((long)idDoProduto);
        produto.toString();

        //esta com erro, esta salvando os dados novos e deltando os antigos.
        pRepository.save(produto);

        

        System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    // private static void alterarFabricanteProduto() {
    //     System.out.print("Digite o nome do produto: ");
    //     var nomeDoProduto = teclado.next();
    //     System.out.print("Digite o novo fabricante do produto: ");
    //     var fabricanteDoProduto = teclado.next();

    //     ProdutoService pService = new ProdutoService();
    //     Fabricante fabricante = new Fabricante(fabricanteDoProduto);
        
    //     pService.alterarFabricante(nomeDoProduto, fabricante);

    //     System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
    //     teclado.next();
    // }

    // private static void alterarDescricaoProduto() {
    //     System.out.print("Digite o nome do produto: ");
    //     var nomeDoProduto = teclado.next();
    //     System.out.print("Digite a nova descrição do produto: ");
    //     var descricaoDoProduto = teclado.next();

    //     ProdutoService pService = new ProdutoService();

    //     pService.alterarDescricao(nomeDoProduto, descricaoDoProduto);

    //     System.out.println("\nPressione qualquer tecla e de ENTER para voltar ao menu principal");
    //     teclado.next();
    // }

}
