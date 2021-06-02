package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class NotasResource implements Serializable {

	private static final long serialVersionUID = -5472165565347759718L;

	@JsonProperty("id_nota")
	private String id;
	
	@JsonProperty("id_avaliacao")
	private String idavaliacao;
	
	@JsonProperty("nota")
	private String notas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdAvaliacao() {
		return idavaliacao;
	}

	public void setAvaliacao(String idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "NotasResource [id=" + id + ", avaliacao=" + idavaliacao + ", notas=" + notas + "]";
	}
}
