package br.com.hendrew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	public List<Avaliacao> buscarAvaliacao() {
		List<Avaliacao> listAvaliacao = avaliacaoRepository.findAll();
		return listAvaliacao;
	}
}
