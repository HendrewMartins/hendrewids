package br.com.hendrew.datasource.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bimestre")
public class Bimestre implements Serializable{
	
	private static final long serialVersionUID = -4009265817039735950L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long bimestre;
	private long ano;
	private long faltas;
	private long idalunos;
	
	public Bimestre() {
	}
	
	
	public long getIdAlunos() {
		return idalunos;
	}

	public void setIdAlunos(long idalunos) {
		this.idalunos = idalunos;
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
	

}
