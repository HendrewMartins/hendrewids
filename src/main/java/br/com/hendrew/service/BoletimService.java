package br.com.hendrew.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.datasource.model.Bimestre_Auxiliar;
import br.com.hendrew.datasource.model.Boletim;
import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.exception.TratamentoNotFoundException;

@Service
public class BoletimService {

	private static final Logger LOG = Logger.getLogger(BoletimService.class);
	
	@Autowired
	private AlunosService servicealunos;
	
	@Autowired
	private AvaliacaoService serviceavaliacao;
	
	@Autowired
	private BimestreService servicebimestre;
	
	@Autowired
	private NotasService servicenotas;
	
	public List<Boletim> buscarboletim() throws TratamentoNotFoundException {
		List<Boletim> lista = new ArrayList<Boletim>();
		List<Alunos> alunos = servicealunos.buscarAlunos();
		
		
		for(int i = 0; i < alunos.size(); i++)
		{
			Double nota1 = 0.00;
			Double nota2 = 0.00;
			Double nota3 = 0.0;
			Double nota4 = 0.0;
			Double notafinal = 0.0;
			long faltas = 0;
			long cont = 0;
			long letivo = 0;
			
			Boletim boletim = new Boletim();
			boletim.setDesaluno(alunos.get(i).getNome());
			
			List<Bimestre> bimestre = servicebimestre.buscarPorAluno(alunos.get(i).getId());
			
			for(int a = 0; a < bimestre.size(); a++)
			{
				faltas = faltas + bimestre.get(a).getFaltas();
				Double nota_aux = 0.0;
				List<Notas> notas = servicenotas.buscarPorBimestre(bimestre.get(a).getId());
				
				for(int b = 0; b < notas.size(); b++) {
					Avaliacao avaliacao = serviceavaliacao.buscarPorIdAvaliacao(notas.get(b).getIdavaliacao());
					Double nota_temp = (notas.get(b).getNotas() * avaliacao.getPeso())/10;
					nota_aux = nota_aux + nota_temp;
				}
				
				if(bimestre.get(a).getBimestre() == 1) {
					cont = cont+1;
					letivo = letivo + 40;
					nota1 = nota_aux;
				} 
				else if(bimestre.get(a).getBimestre() == 2) {
					cont = cont+1;
					letivo = letivo + 40;
					nota2 = nota_aux;
				} 
				else if(bimestre.get(a).getBimestre() == 3) {
					cont = cont+1;
					letivo = letivo + 40;
					nota3 = nota_aux;
				} 
				else if(bimestre.get(a).getBimestre() == 4) {
					cont = cont+1;
					letivo = letivo + 40;
					nota4 = nota_aux;
				}
			
			}
		    System.out.println(cont);
			if(cont > 0) {
			System.out.println((nota1+nota2+nota3+nota4));	
			
			notafinal = (nota1+nota2+nota3+nota4)/cont;
			System.out.println(notafinal);
			}
			
			Double mediafaltas = 0.0;
			
			if(letivo > 0) {
				mediafaltas = (double) (100 - ((faltas/letivo)*100));
			}
					
			if(notafinal >= 6.0 && mediafaltas >= 75) {
				boletim.setSituacao("Aprovado");
			}else if((notafinal >= 5.0 && notafinal < 6.0 )  && mediafaltas >= 75){
				boletim.setSituacao("Recuperação");
			}else {
				boletim.setSituacao("Reprovado");
			}
			boletim.setNota1(nota1);
			boletim.setNota2(nota2);
			boletim.setNota3(nota3);
			boletim.setNota4(nota4);
			boletim.setFaltas(faltas);
			boletim.setMediafinal(notafinal);
			lista.add(i,boletim);
		}
		return lista;
	}	
}
