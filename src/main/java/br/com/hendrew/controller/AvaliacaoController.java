package br.com.hendrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.exception.TratamentoNotFoundException;
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
	
	@GetMapping(path = "/avaliacao/id/{id}")
	  public Avaliacao buscarAvaliacaoPorId(
	      @PathVariable(name = "id", required = true) Long id) throws TratamentoNotFoundException {
	    return serviceBuscar.buscarPorIdAvaliacao(id);
	}
	
}
