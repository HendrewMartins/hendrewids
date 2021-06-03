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
		    	  Long idnotas          = checkLong(notasResource.getId()); 
		    	  notas.setId(idnotas);
		      }
		      
		      
		      Long idavaliacao      = checkLong(notasResource.getIdavaliacao());
		      Double nota           = checkDouble(notasResource.getNotas());
		      Long idbimestre       = checkLong(notasResource.getIdbimestre());
		    
		      
		      notas.setIdavaliacao(idavaliacao);
		      notas.setNotas(nota);
		      notas.setIdbimestre(idbimestre);
		     
		      return notas;

		    } catch (Exception e) {
		      throw new TratamentoResourceException(
		          "Falha ao converter o resource para entidade, resouce: " + notasResource);
		    }

		  }

	 private Long checkLong(String valor) {
		    return Long.parseLong(valor);
		  }
	 private Double checkDouble(String valor) {
		    return Double.parseDouble(valor);
		  }
}
