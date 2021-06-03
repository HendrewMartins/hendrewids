package br.com.hendrew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hendrew.datasource.model.Notas;

public interface NotasRepository 
		extends JpaRepository<Notas, Long>{
	
	List <Notas> findByIdbimestre(Long idbimestre);
}
