package com.br.exercicio.produtos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.exercicio.produtos.models.ProdutosModel;

@Repository
public interface ProdutosRepository extends CrudRepository<ProdutosModel, Integer> {
	
}
