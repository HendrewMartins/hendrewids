package br.com.hendrew.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BimestreResource implements Serializable {

	private static final long serialVersionUID = 5657973691916215319L;
	
	@JsonProperty("id")
    private String id;	
	
	@JsonProperty("bimestre")
	private String bimestre;
	
	@JsonProperty("ano")
	private String ano;
	
	@JsonProperty("faltas")
	private String faltas;
	
	@JsonProperty("idaluno")
	private String idaluno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}

	public String getIdAluno() {
		return idaluno;
	}

	public void setIdAlunos(String idaluno) {
		this.idaluno = idaluno;
	}

	@Override
	public String toString() {
		return "BimestreResource [id=" + id + ", bimestre=" + bimestre + ", ano=" + ano + ", faltas=" + faltas
				+ ", alunos=" + idaluno + "]";
	}
}
