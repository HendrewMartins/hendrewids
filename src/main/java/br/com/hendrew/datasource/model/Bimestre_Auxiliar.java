package br.com.hendrew.datasource.model;

public class Bimestre_Auxiliar {
private long id;
	
	private long bimestre;
	private String desbimestre;
	private long ano;
	private long faltas;
	private long idAlunos;
	private String nmAlunos;
	
	public Bimestre_Auxiliar() {
	}
	
	
	public long getIdAlunos() {
		return idAlunos;
	}

	public void setIdAlunos(long idalunos) {
		this.idAlunos = idalunos;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBimestre() {
		return bimestre;
	}
	public void setBimestre(long bimestre) {
		this.bimestre = bimestre;
	}
	public long getAno() {
		return ano;
	}
	public void setAno(long ano) {
		this.ano = ano;
	}
	public long getFaltas() {
		return faltas;
	}
	public void setFaltas(long faltas) {
		this.faltas = faltas;
	}


	public String getNmAlunos() {
		return nmAlunos;
	}


	public void setNmAlunos(String nmAlunos) {
		this.nmAlunos = nmAlunos;
	}


	public String getDesbimestre() {
		return desbimestre;
	}


	public void setDesbimestre(String desbimestre) {
		this.desbimestre = desbimestre;
	}
}
