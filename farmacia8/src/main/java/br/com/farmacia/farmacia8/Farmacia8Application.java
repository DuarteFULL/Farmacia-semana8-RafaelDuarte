package br.com.farmacia.farmacia8;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "br.com.farmacia.farmacia8.modelo")
public class Farmacia8Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Farmacia8Application.class, args);
	}

	private static Scanner teclado = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Projeto Spring teste");
		//throw new UnsupportedOperationException("Unimplemented method 'run'");
		var opcao = Menu();

        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1:
                        //listarProdutos();
                        break;
                    case 2:
                        //cadastrarProduto();
                        break;
                    case 3:
                        //deletarProduto();
                        break;
                    case 4:
                        //consultarProduto();
                        break;
                    case 5:
                        //alterarValorProduto();
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

}
