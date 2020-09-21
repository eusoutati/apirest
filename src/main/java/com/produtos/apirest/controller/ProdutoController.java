package com.produtos.apirest.controller;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	public ProdutoRepository produtoRepository;

	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return (List<Produto>) produtoRepository.findAll();

	}

	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

	@DeleteMapping("/produto/")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);

	}

	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}

}
