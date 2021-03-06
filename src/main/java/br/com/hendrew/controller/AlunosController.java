package br.com.hendrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.service.AlunosService;


@RestController
@RequestMapping(value = "/api")
public class AlunosController {
	
	 @Autowired
	  private AlunosService serviceBuscar;

	@GetMapping(path = "/alunos")
	public List<Alunos> buscarTodosAlunos() {
		return serviceBuscar.buscarAlunos();
	}
}
