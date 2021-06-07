package br.com.hendrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hendrew.datasource.model.Boletim;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.service.BoletimService;



@RestController
@RequestMapping(value = "/api")
public class BoletimController {
	
	@Autowired
	private BoletimService service;
	
	
	@GetMapping(path = "/boletim")
	public List<Boletim> buscarBoletim() throws TratamentoNotFoundException{
		return service.buscarboletim();
	}

}
