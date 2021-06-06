package br.com.hendrew.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.conversor.ConversorBimestre;
import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.datasource.model.Bimestre_Auxiliar;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.repository.BimestreRepository;
import br.com.hendrew.resource.model.BimestreResource;

@Service
public class BimestreService {

	private static final Logger LOG = Logger.getLogger(BimestreService.class);

	@Autowired
	private BimestreRepository bimestreRepository;

	@Autowired
	private ConversorBimestre service;
	
	@Autowired
	private AlunosService servicealunos;

	public Bimestre cadastroBimestre(BimestreResource bimestreResource) {
		try {
			Bimestre bimestre = service.conversor(bimestreResource);
			return bimestreRepository.saveAndFlush(bimestre);
		} catch (TratamentoResourceException e) {
			LOG.error("Erro ao salvar o Notas: " + e.getMessage(), e);
			return null;
		}	
	}

	public List<Bimestre> buscarTodosBimestre() {
		List<Bimestre> listBimestre = bimestreRepository.findAll();
		return listBimestre;
	}

	public Bimestre buscarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Bimestre> optionalBimestre = getOptional(id);
		Bimestre bimestre = null;
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			bimestre = optionalBimestre.get();
		}
		return bimestre;
	}
	
	public List<Bimestre> buscarPorAluno(Long idaluno) throws TratamentoNotFoundException {
		Optional<List<Bimestre>> optionalBimestre = getOptionalAluno(idaluno);
		List<Bimestre> bimestre = null;
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do IDAluno: " + idaluno);
		} else {
			bimestre = optionalBimestre.get();
		}
		return bimestre;
	}

	private Optional<Bimestre> getOptional(Long id) {
		Optional<Bimestre> optionalBimestre = bimestreRepository.findById(id);
		return optionalBimestre;
	}
	
	private Optional<List<Bimestre>> getOptionalAluno(Long idAlunos) {
		Optional<List<Bimestre>> optionalBimestre = Optional.ofNullable(bimestreRepository.findByIdAlunos(idAlunos));
		return optionalBimestre;
	}

	public boolean deletarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Bimestre> optionalBimestre = getOptional(id);
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			bimestreRepository.delete(optionalBimestre.get());
			return true;
		}

	}

	public Bimestre atualizar(Long id, BimestreResource bimestreResource) {
		Optional<Bimestre> optionalbimestre = bimestreRepository.findById(id);
		
		if (optionalbimestre.isPresent()) {
			try {
			Bimestre bim = service.conversor(bimestreResource);
			return bimestreRepository.save(bim);
			
			} catch (TratamentoResourceException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	
	public List<Bimestre_Auxiliar> buscarTodosBimestreNmAluno() {
		List<Bimestre> listBimestre = bimestreRepository.findAll();	
		Alunos aluno = null;
		
		List<Bimestre_Auxiliar> lista = new ArrayList<Bimestre_Auxiliar>();
		for(int i = 0; i < listBimestre.size(); i++)
		{
			Bimestre_Auxiliar aux = new Bimestre_Auxiliar();
			try {
				aluno = servicealunos.buscarPorIdAluno(listBimestre.get(i).getIdAlunos());
				aux.setNmAlunos(aluno.getNome());
				aux.setAno(listBimestre.get(i).getAno());
				aux.setId(listBimestre.get(i).getId());
				aux.setBimestre(listBimestre.get(i).getBimestre());
				aux.setDesbimestre(listBimestre.get(i).getBimestre()+"º"+" Bimestre");
				aux.setIdAlunos(listBimestre.get(i).getIdAlunos());
				aux.setFaltas(listBimestre.get(i).getFaltas());
			} catch (TratamentoNotFoundException e) {
				e.printStackTrace();
			}
			lista.add(i,aux);
		}
		
		return lista;
	}
	
	public List<Bimestre_Auxiliar> buscarPorIdAluno(Long idaluno) throws TratamentoNotFoundException {
		Optional<List<Bimestre>> optionalBimestre = getOptionalAluno(idaluno);
		Alunos aluno = null;
		List<Bimestre_Auxiliar> lista = new ArrayList<Bimestre_Auxiliar>();
		List<Bimestre> bimestre = null;
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do IDAluno: " + idaluno);
		} else {
			bimestre = optionalBimestre.get();
			for(int i = 0; i < bimestre.size(); i++)
			{
				Bimestre_Auxiliar aux = new Bimestre_Auxiliar();
				try {
					aluno = servicealunos.buscarPorIdAluno(bimestre.get(i).getIdAlunos());
					aux.setNmAlunos(aluno.getNome());
					aux.setAno(bimestre.get(i).getAno());
					aux.setId(bimestre.get(i).getId());
					aux.setBimestre(bimestre.get(i).getBimestre());
					aux.setDesbimestre(bimestre.get(i).getBimestre()+"º"+" Bimestre");
					aux.setIdAlunos(bimestre.get(i).getIdAlunos());
					aux.setFaltas(bimestre.get(i).getFaltas());
					
				} catch (TratamentoNotFoundException e) {
					e.printStackTrace();
				}
				lista.add(i,aux);
			}
			
		}
		return lista;
	}
		

}
