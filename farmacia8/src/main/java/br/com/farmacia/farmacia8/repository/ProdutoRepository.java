package br.com.farmacia.farmacia8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farmacia.farmacia8.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
