package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvaliacaoResource implements Serializable{
	
	private static final long serialVersionUID = 7910842596245202L;

	@JsonProperty("id_avaliacao")
	private String id;
	
	@JsonProperty("desc_avaliacao")
	private String descricao;
	
	@JsonProperty("peso_avaliacao")
	private String peso;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "AvaliacaoResource [id=" + id + ", descricao=" + descricao + ", peso=" + peso + "]";
	}	
}
