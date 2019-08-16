package com.br.exercicio.produtos.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.exercicio.produtos.models.ProdutosModel;
import com.br.exercicio.produtos.services.ProdutosService;

@Controller
public class ProdutosController {
	@Autowired
	private ProdutosService produtosService;
	
	@GetMapping("/")
	public ModelAndView exibirProduto() {
		ModelAndView modelAndView =  new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtosService.pegarTodosProdutos());
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView salvarProduto(@Valid ProdutosModel user, BindingResult bindingResult) {
		ModelAndView modelAndView =  new ModelAndView("produtos.html");
		
		if(bindingResult.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for(ObjectError objectError :bindingResult.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("produtos", produtosService.pegarTodosProdutos());
			modelAndView.addObject("pro", erros);
			return modelAndView;
		}else {
			produtosService.salvarProduto(user);
			modelAndView.addObject("produtos",produtosService.pegarTodosProdutos());
			return modelAndView;
		}
	}
}
