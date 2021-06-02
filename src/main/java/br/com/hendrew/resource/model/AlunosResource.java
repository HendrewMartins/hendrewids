package br.com.hendrew.resource.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunosResource implements Serializable {
    
	private static final long serialVersionUID = 1448217369723795910L;

	@JsonProperty("id_aluno")
	private String id;
	
	@JsonProperty("nome_aluno")
	private String nome;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "AlunosResource [id=" + id + ", nome=" + nome + "]";
	}
}
