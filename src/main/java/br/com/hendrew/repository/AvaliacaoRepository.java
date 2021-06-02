package br.com.hendrew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hendrew.datasource.model.Avaliacao;

public interface AvaliacaoRepository 
		extends JpaRepository<Avaliacao, Long>{

}
