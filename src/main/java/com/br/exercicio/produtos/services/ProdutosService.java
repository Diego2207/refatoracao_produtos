package com.br.exercicio.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exercicio.produtos.models.ProdutosModel;
import com.br.exercicio.produtos.repositories.ProdutosRepository;

@Service
public class ProdutosService {
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public String salvarProduto(ProdutosModel produto) {
		produtosRepository.save(produto);
		
		return "produto criado";
	}
	public Iterable<ProdutosModel> pegarTodosProdutos(){
		return produtosRepository.findAll();
	}
	
	public void deleteProduto(Integer id) {
		
		produtosRepository.deleteById(id);
	}
	
	public ProdutosModel buscarProduto(Integer id) {
		
		return produtosRepository.findById(id).get();
	}
	
	public void atualizarProduto(int id, ProdutosModel produto) {
		
		produto.setId(id);
		produtosRepository.save(produto);
	}
	
}
