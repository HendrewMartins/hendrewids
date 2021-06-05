package br.com.hendrew.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.conversor.ConversorBimestre;
import br.com.hendrew.conversor.ConversorBimestreResource;
import br.com.hendrew.datasource.model.Bimestre;
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

	public Bimestre cadastroBimestre(BimestreResource bimestreResource) {
		Bimestre bimestre = service.conversor(bimestreResource);
		return bimestreRepository.saveAndFlush(bimestre);
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
	
	private Optional<List<Bimestre>> getOptionalAluno(Long idaluno) {
		Optional<List<Bimestre>> optionalBimestre = Optional.ofNullable(bimestreRepository.findByIdalunos(idaluno));
		return optionalBimestre;
	}

	public void deletarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Bimestre> optionalBimestre = getOptional(id);
		if (!optionalBimestre.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			bimestreRepository.delete(optionalBimestre.get());
		}

	}

	public Bimestre atualizar(Long id, BimestreResource bimestreResource) {
		Optional<Bimestre> optionalbimestre = bimestreRepository.findById(id);

		if (optionalbimestre.isPresent()) {
			Bimestre bim = service.conversor(bimestreResource);
			bimestreRepository.save(bim);
			return bimestreRepository.save(bim);
		}
		return null;
	}
}
