package br.com.hendrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.resource.model.BimestreResource;
import br.com.hendrew.service.BimestreService;

@RestController
@RequestMapping(value = "/api")
public class BimestreController {
	
	@Autowired
	private BimestreService service;
	
	@GetMapping(path = "/bimestre")
	public List<Bimestre> buscarTodosBimestre(){
		return service.buscarTodosBimestre();
	}
	
	@GetMapping(path = "/bimestre/id/{id}")
	  public Bimestre buscarAvaliacaoPorId(
	      @PathVariable(name = "id", required = true) Long id) throws TratamentoNotFoundException {
	    return service.buscarPorId(id);
	}
	
	@PostMapping(path = "/bimestre/save")
	  public void salvarNutricionista(@RequestBody BimestreResource bimestre) {
	    service.cadastroBimestre(bimestre);
	}
	
	@DeleteMapping(path = "/bimestre/delete/{id}")
	  public void deleteBimestre(@PathVariable(name = "id", required = true) Long id)
	      throws TratamentoNotFoundException {
	    service.deletarPorId(id);
	  }
	
	@PutMapping(path = "/bimestre/edit/{id}")
	 public Bimestre atualizarBimestre(@PathVariable(name = "id", required = true) Long id, @RequestBody BimestreResource bimestre)
			 	throws TratamentoNotFoundException {
		return service.atualizar(id, bimestre);
	}

}