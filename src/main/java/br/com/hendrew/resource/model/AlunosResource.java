package br.com.hendrew.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunosResource {
    
	@JsonProperty("id_aluno")
	private Long id;
	
	@JsonProperty("nome_aluno")
	private String nome;
	
	public AlunosResource(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
