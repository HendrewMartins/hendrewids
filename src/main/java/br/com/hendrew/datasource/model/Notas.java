package br.com.hendrew.datasource.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Notas implements Serializable {
	
	private static final long serialVersionUID = 8446201008432303346L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long idavaliacao;
	private long notas;
	
	public Notas() {
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
		
	public long getNotas() {
		return notas;
	}
	public void setNotas(long notas) {
		this.notas = notas;
	}
	

}
