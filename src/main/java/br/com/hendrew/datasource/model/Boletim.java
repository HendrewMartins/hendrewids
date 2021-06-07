package br.com.hendrew.datasource.model;

public class Boletim {
	
	private String desaluno;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Double nota4;
	private Long faltas;
	private Double mediafinal;
	private String situacao;
	
	public Boletim() {
		
	}
	
	public String getDesaluno() {
		return desaluno;
	}
	public void setDesaluno(String desaluno) {
		this.desaluno = desaluno;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota3() {
		return nota3;
	}
	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	public Double getNota4() {
		return nota4;
	}
	public void setNota4(Double nota4) {
		this.nota4 = nota4;
	}
	public Long getFaltas() {
		return faltas;
	}
	public void setFaltas(Long faltas) {
		this.faltas = faltas;
	}
	public Double getMediafinal() {
		return mediafinal;
	}
	public void setMediafinal(Double mediafinal) {
		this.mediafinal = mediafinal;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	

}
