package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class NotasResource implements Serializable {

	private static final long serialVersionUID = -5472165565347759718L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("idavaliacao")
	private String idavaliacao;
	
	@JsonProperty("notas")
	private String notas;
	
	@JsonProperty("idbimestre")
	private String idbimestre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public String getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(String idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public String getIdbimestre() {
		return idbimestre;
	}

	public void setIdbimestre(String idbimestre) {
		this.idbimestre = idbimestre;
	}

	@Override
	public String toString() {
		return "NotasResource [id=" + id + ", idavaliacao=" + idavaliacao + ", notas=" + notas + ", idbimestre="
				+ idbimestre + "]";
	}

}
