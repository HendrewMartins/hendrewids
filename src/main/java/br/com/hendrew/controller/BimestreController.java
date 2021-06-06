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
import br.com.hendrew.datasource.model.Bimestre_Auxiliar;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.resource.model.BimestreResource;
import br.com.hendrew.service.BimestreService;

@RestController
@RequestMapping(value = "/api")
public class BimestreController {
	
	@Autowired
	private BimestreService service;
	
	@GetMapping(path = "/bimestre")
	public List<Bimestre_Auxiliar> buscarTodosBimestre(){
		return service.buscarTodosBimestreNmAluno();
	}
	
	@GetMapping(path = "/bimestre/id/{id}")
	  public Bimestre buscarBimestrePorId(
	      @PathVariable(name = "id", required = true) Long id) throws TratamentoNotFoundException {
	    return service.buscarPorId(id);
	}
	
	@GetMapping(path = "/bimestre/aluno/{idaluno}")
	  public List<Bimestre_Auxiliar> buscarBimestrePorIdaluno(
	      @PathVariable(name = "idaluno", required = true) Long idaluno) throws TratamentoNotFoundException {
	    return service.buscarPorIdAluno(idaluno);
	}
	
	@PostMapping(path = "/bimestre/save")
	  public Bimestre salvarNutricionista(@RequestBody BimestreResource bimestre) {
	   return service.cadastroBimestre(bimestre);
	}
	
	@DeleteMapping(path = "/bimestre/delete/{id}")
	  public boolean deleteBimestre(@PathVariable(name = "id", required = true) Long id)
	      throws TratamentoNotFoundException {
	   return service.deletarPorId(id);
	  }
	
	@PutMapping(path = "/bimestre/edit/{id}")
	 public Bimestre atualizarBimestre(@PathVariable(name = "id", required = true) Long id, @RequestBody BimestreResource bimestre)
			 	throws TratamentoNotFoundException {
		return service.atualizar(id, bimestre);
	}

}
