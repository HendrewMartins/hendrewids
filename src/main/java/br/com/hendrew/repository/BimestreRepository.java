package br.com.hendrew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hendrew.datasource.model.Bimestre;

public interface BimestreRepository 
		extends JpaRepository<Bimestre, Long>{
	
	List <Bimestre> findByIdAlunos(Long idAlunos);
   
}
