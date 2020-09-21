package com.produtos.apirest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto ,Long> {
	
	Produto findById (long id);
	
	
	

    
}
