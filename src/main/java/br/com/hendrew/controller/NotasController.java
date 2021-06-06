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

import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.datasource.model.Notas_Auxiliar;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.resource.model.NotasResource;
import br.com.hendrew.service.NotasService;


@RestController
@RequestMapping(value = "/api")
public class NotasController {

	@Autowired
	private NotasService service;
	
	@GetMapping(path = "/notas")
	public List<Notas_Auxiliar> buscarTodasNotas(){
		return service.buscarTodosNotas();
	}
	
	@GetMapping(path = "/notas/id/{id}")
	  public Notas buscarNotasPorId(
	      @PathVariable(name = "id", required = true) Long id) throws TratamentoNotFoundException {
	    return service.buscarPorId(id);
	}
	
	@GetMapping(path = "/notas/bimestre/{idbimestre}")
	  public List<Notas> buscarBimestrePorIdaluno(
	      @PathVariable(name = "idbimestre", required = true) Long idbimestre) throws TratamentoNotFoundException {
	    return service.buscarPorBimestre(idbimestre);
	}
	
	@PostMapping(path = "/notas/save")
	  public Notas salvarNotas(@RequestBody NotasResource notas) {
	   return service.cadastroNotas(notas);
	}
	
	@DeleteMapping(path = "/notas/delete/{id}")
	  public void deleteNotas(@PathVariable(name = "id", required = true) Long id)
	      throws TratamentoNotFoundException {
	    service.deletarPorId(id);
	  }
	
	@PutMapping(path = "/notas/edit/{id}")
	 public Notas atualizarNotas(@PathVariable(name = "id", required = true) Long id, @RequestBody NotasResource notas)
			 	throws TratamentoNotFoundException {
		return service.atualizar(id, notas);
	}

}
