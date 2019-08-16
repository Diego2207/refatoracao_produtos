package com.br.exercicio.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.exercicio.produtos.models.ProdutosModel;
import com.br.exercicio.produtos.services.ProdutosService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoControllerApi {

	@Autowired
	private ProdutosService produtosService;
	
	@GetMapping
	public ResponseEntity<?> exibirProdutos(){
		
		return ResponseEntity.ok(produtosService.pegarTodosProdutos());
	}
	
	@PostMapping
	public ResponseEntity<?> salvarProduto(@RequestBody ProdutosModel produto){
		
		produtosService.salvarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarprodutoPeloId(@PathVariable int id){
		
		return ResponseEntity.ok(produtosService.buscarProduto(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable int id, @RequestBody ProdutosModel produto){
		
		produtosService.atualizarProduto(id, produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletarProduto(@PathVariable int id){
		
		produtosService.deleteProduto(id);
		return ResponseEntity.ok().build();
	}
	
	
}
