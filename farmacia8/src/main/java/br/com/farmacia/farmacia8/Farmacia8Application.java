package br.com.farmacia.farmacia8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Farmacia8Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Farmacia8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Projeto Spring teste");
		//throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
