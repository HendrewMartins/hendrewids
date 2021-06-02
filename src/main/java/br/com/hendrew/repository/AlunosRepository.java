package br.com.hendrew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hendrew.datasource.model.Alunos;

public interface AlunosRepository 
		extends JpaRepository<Alunos, Long> {

}
