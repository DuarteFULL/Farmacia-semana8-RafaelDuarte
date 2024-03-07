package br.com.farmacia.farmacia8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.farmacia.farmacia8.repository.FabricanteRepository;
import br.com.farmacia.farmacia8.repository.ProdutoRepository;


@SpringBootApplication
public class Farmacia8Application  implements CommandLineRunner {

    @Autowired
    private ProdutoRepository proRepository;

    @Autowired
    private FabricanteRepository fabRepository;

	public static void main(String[] args) {
		SpringApplication.run(Farmacia8Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Projeto Spring teste");
		//throw new UnsupportedOperationException("Unimplemented method 'run'");
        Principal principal = new Principal(proRepository);
        principal.exibeMenu();
    }
		



}
