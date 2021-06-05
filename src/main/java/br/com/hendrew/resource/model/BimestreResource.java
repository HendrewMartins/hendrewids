package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BimestreResource implements Serializable {

	private static final long serialVersionUID = 5657973691916215319L;
	
	@JsonProperty("id")
    private Long id;	
	
	@JsonProperty("bimestre")
	private Long bimestre;
	
	@JsonProperty("ano")
	private Long ano;
	
	@JsonProperty("faltas")
	private Long faltas;
	
	@JsonProperty("idalunos")
	private Long idaluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBimestre() {
		return bimestre;
	}

	public void setBimestre(Long bimestre) {
		this.bimestre = bimestre;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Long getFaltas() {
		return faltas;
	}

	public void setFaltas(Long faltas) {
		this.faltas = faltas;
	}

	public Long getIdAluno() {
		return idaluno;
	}

	public void setIdAlunos(Long idaluno) {
		this.idaluno = idaluno;
	}

	@Override
	public String toString() {
		return "BimestreResource [id=" + id + ", bimestre=" + bimestre + ", ano=" + ano + ", faltas=" + faltas
				+ ", alunos=" + idaluno + "]";
	}
}
