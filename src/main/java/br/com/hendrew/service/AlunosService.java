package br.com.hendrew.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.repository.AlunosRepository;

@Service
public class AlunosService {
 
	@Autowired
	private AlunosRepository alunosRepository;
	
	public List<Alunos> buscarAlunos() {
		List<Alunos> listAlunos = alunosRepository.findAll();
		return listAlunos;
	}
	
	public Alunos buscarPorIdAluno(Long id) throws TratamentoNotFoundException {
		Optional<Alunos> optionalBimestre = getOptional(id);
		Alunos bimestre = null;
		
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			bimestre = optionalBimestre.get();
		}
		return bimestre;
	}
	private Optional<Alunos> getOptional(Long id) {
		Optional<Alunos> optionalBimestre = alunosRepository.findById(id);
		return optionalBimestre;
	}
	
}
