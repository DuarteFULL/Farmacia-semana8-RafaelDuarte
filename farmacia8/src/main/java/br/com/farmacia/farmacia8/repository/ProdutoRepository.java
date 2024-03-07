package br.com.farmacia.farmacia8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.farmacia8.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
