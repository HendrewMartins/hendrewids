package br.com.hendrew.datasource.model;

public class Notas_Auxiliar {

	private long id;
	private long idavaliacao;
	private long idbimestre;
	private double notas;
	private long aluno;
	private long ano;
	private String desavaliacao;
	private String desbimestre;
	private String desalunos;
	
	
	public String getDesavaliacao() {
		return desavaliacao;
	}

	public void setDesavaliacao(String desavaliacao) {
		this.desavaliacao = desavaliacao;
	}

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

	public String getDesalunos() {
		return desalunos;
	}

	public void setDesalunos(String desalunos) {
		this.desalunos = desalunos;
	}

	public Notas_Auxiliar() {
	}
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(long idavaliacao) {
		this.idavaliacao = idavaliacao;
	}
		
	public double getNotas() {
		return notas;
	}
	public void setNotas(double notas) {
		this.notas = notas;
	}

	public long getIdbimestre() {
		return idbimestre;
	}

	public void setIdbimestre(long idbimestre) {
		this.idbimestre = idbimestre;
	}

	public long getAluno() {
		return aluno;
	}

	public void setAluno(long aluno) {
		this.aluno = aluno;
	}

	public String getDesbimestre() {
		return desbimestre;
	}

	public void setDesbimestre(String desbimestre) {
		this.desbimestre = desbimestre;
	}
}
