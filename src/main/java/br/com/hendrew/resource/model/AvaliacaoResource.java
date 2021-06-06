package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvaliacaoResource implements Serializable{
	
	private static final long serialVersionUID = 7910842596245202L;

	@JsonProperty("id_avaliacao")
	private Long id;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("peso")
	private Double peso;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "AvaliacaoResource [id=" + id + ", descricao=" + descricao + ", peso=" + peso + "]";
	}	
}
