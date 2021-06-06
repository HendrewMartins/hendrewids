package br.com.hendrew.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	public List<Avaliacao> buscarAvaliacao() {
		List<Avaliacao> listAvaliacao = avaliacaoRepository.findAll();
		return listAvaliacao;
	}
	
	public Avaliacao buscarPorIdAvaliacao(Long id) throws TratamentoNotFoundException {
		Optional<Avaliacao> optionalAvaliacao = getOptional(id);
		Avaliacao avaliacao = null;
		
		if (!optionalAvaliacao.isPresent()) {
			throw new TratamentoNotFoundException("Bimestre nao encontrado atraves do ID: " + id);
		} else {
			avaliacao = optionalAvaliacao.get();
		}
		return avaliacao;
	}
	private Optional<Avaliacao> getOptional(Long id) {
		Optional<Avaliacao> optionalAvaliacao = avaliacaoRepository.findById(id);
		return optionalAvaliacao;
	}
}
