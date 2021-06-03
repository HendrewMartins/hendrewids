package br.com.hendrew.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.conversor.ConversorNotas;
import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.repository.NotasRepository;
import br.com.hendrew.resource.model.NotasResource;

@Service
public class NotasService {
	private static final Logger LOG = Logger.getLogger(NotasService.class);

	@Autowired
	private NotasRepository notasRepository;

	@Autowired
	private ConversorNotas service;

	public void cadastroBimestre(NotasResource notasResource) {
		try {
			Notas notas = service.conversor(notasResource);
			notasRepository.saveAndFlush(notas);
		} catch (TratamentoResourceException e) {
			LOG.error("Erro ao salvar o Notas: " + e.getMessage(), e);
		}
	}

	public List<Notas> buscarTodasNotas() {
		List<Notas> listNotas = notasRepository.findAll();
		return listNotas;
	}

	public Notas buscarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Notas> optionalNotas = getOptional(id);
		Notas notas = null;
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Notas nao encontrado atraves do ID: " + id);
		} else {
			notas = optionalNotas.get();
		}
		return notas;
	}
	
	public List<Notas> buscarPorBimestre(Long idbimestre) throws TratamentoNotFoundException {
		Optional<List<Notas>> optionalNotas = getOptionalBimestre(idbimestre);
		List<Notas> notas = null;
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do IDBimestre: " + idbimestre);
		} else {
			notas = optionalNotas.get();
		}
		return notas;
	}

	private Optional<Notas> getOptional(Long id) {
		Optional<Notas> optionalNotas = notasRepository.findById(id);
		return optionalNotas;
	}
	
	private Optional<List<Notas>> getOptionalBimestre(Long idBimestre) {
		Optional<List<Notas>> optionalNotas = Optional.ofNullable(notasRepository.findByIdbimestre(idBimestre));
		return optionalNotas;
	}

	public void deletarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Notas> optionalNotas = getOptional(id);
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			notasRepository.delete(optionalNotas.get());
		}

	}

	public Notas atualizar(Long id, NotasResource notasResource) {
		Optional<Notas> optionalNotas = notasRepository.findById(id);

		if (optionalNotas.isPresent()) {
			try {
				Notas not = service.conversor(notasResource);
				notasRepository.save(not);
				return service.conversor(notasResource);
			} catch (TratamentoResourceException e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}
}
