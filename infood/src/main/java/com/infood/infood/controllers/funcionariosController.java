package com.infood.infood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infood.infood.models.Funcionarios;
import com.infood.infood.repository.FuncionarioRepository;

@Controller
public class funcionariosController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.GET)
	public String form() {
		return "formFuncionarios";
	}
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.POST)
	public String form(Funcionarios funcionario) {
		
		fr.save(funcionario);
		return "redirect:/cadastrarFuncionario";
	}
	
	@RequestMapping("/funcionarios")
	public ModelAndView listaFuncionarios() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Funcionarios> funcionarios = fr.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
	
	@RequestMapping("/deletarFuncionario")
	public String deletarEvento(long codigo){
		Funcionarios funcionario = fr.findByCodigo(codigo);
		fr.delete(funcionario);
		return "redirect:/index";
	}
}

