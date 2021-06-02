package br.com.hendrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.service.AvaliacaoService;

@RestController
@RequestMapping(value = "/api")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService serviceBuscar;
	
	@GetMapping(path = "/avaliacao")
	public List<Avaliacao> buscarTodasAvaliacao(){
		return serviceBuscar.buscarAvaliacao();
	}
	
}
