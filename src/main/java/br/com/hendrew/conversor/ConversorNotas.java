package br.com.hendrew.conversor;

import org.springframework.stereotype.Component;

import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.resource.model.NotasResource;


@Component
public class ConversorNotas {
	public Notas conversor(NotasResource bimestreResource)
		      throws TratamentoResourceException {
	
		try {
		      Notas notas = new Notas();
		      Long idnotas          = checkLong(bimestreResource.getId());
		      Long idavaliacao      = checkLong(bimestreResource.getIdAvaliacao());
		      Long nota             = checkLong(bimestreResource.getNotas());
		    
		      notas.setId(idnotas);
		      notas.setIdavaliacao(idavaliacao);
		      notas.setNotas(nota);
		     
		      return notas;

		    } catch (Exception e) {
		      throw new TratamentoResourceException(
		          "Falha ao converter o resource para entidade, resouce: " + bimestreResource);
		    }

		  }

	 private Long checkLong(String valor) {
		    return Long.parseLong(valor);
		  }
}
