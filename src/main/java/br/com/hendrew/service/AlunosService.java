package br.com.hendrew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.repository.AlunosRepository;

@Service
public class AlunosService {
 
	@Autowired
	private AlunosRepository alunosRepository;
	
	public List<Alunos> buscarAlunos() {
		List<Alunos> listAlunos = alunosRepository.findAll();
		return listAlunos;
	}
	
}
