package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class NotasResource implements Serializable {

	private static final long serialVersionUID = -5472165565347759718L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("idavaliacao")
	private Long idavaliacao;
	
	@JsonProperty("notas")
	private Double notas;
	
	@JsonProperty("idbimestre")
	private Long idbimestre;
	
	@JsonProperty("aluno")
	private Long aluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNotas() {
		return notas;
	}

	public void setNotas(Double notas) {
		this.notas = notas;
	}
	
	public Long getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(Long idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public Long getIdbimestre() {
		return idbimestre;
	}

	public void setIdbimestre(Long idbimestre) {
		this.idbimestre = idbimestre;
	}

	public Long getAluno() {
		return aluno;
	}

	public void setIdAlunos(Long aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "NotasResource [id=" + id + ", idavaliacao=" + idavaliacao + ", notas=" + notas + ", idbimestre="
				+ idbimestre + ", aluno=" + aluno + "]";
	}

	

}
