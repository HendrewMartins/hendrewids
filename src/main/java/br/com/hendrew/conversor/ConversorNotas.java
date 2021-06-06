package br.com.hendrew.conversor;

import org.springframework.stereotype.Component;

import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.resource.model.NotasResource;


@Component
public class ConversorNotas {
	public Notas conversor(NotasResource notasResource)
		      throws TratamentoResourceException {
	
		try {
		      Notas notas = new Notas();
		      
		      
		      if(notasResource.getId() != null) {
		    	  notas.setId(notasResource.getId());
		      }
		      
		      
		      Long idavaliacao      = notasResource.getIdavaliacao();
		      Double nota           = notasResource.getNotas();
		      Long idbimestre       = notasResource.getIdbimestre();
		      Long aluno            = notasResource.getAluno();
		    
		      
		      notas.setIdavaliacao(idavaliacao);
		      notas.setNotas(nota);
		      notas.setIdbimestre(idbimestre);
		      notas.setAluno(aluno);
		     
		      return notas;

		    } catch (Exception e) {
		      throw new TratamentoResourceException(
		          "Falha ao converter o resource para entidade, resouce: " + notasResource);
		    }

		  }

}
