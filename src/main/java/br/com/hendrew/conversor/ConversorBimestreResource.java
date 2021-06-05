package br.com.hendrew.conversor;

import org.springframework.stereotype.Component;

import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.resource.model.BimestreResource;
@Component
public class ConversorBimestreResource {
	
	public BimestreResource conversor(Bimestre bimestre)
		      throws TratamentoResourceException {
	
		try {
		      BimestreResource bimestreresource = new BimestreResource();
		      
		       bimestreresource.setId(bimestre.getId());
		      
		      
		      Long bimestr      = bimestre.getBimestre();
		      Long ano          = bimestre.getAno();
		      Long faltas       = bimestre.getFaltas();
		      Long idalunos     = bimestre.getIdAlunos();
		    
		      bimestreresource.setBimestre(bimestr);
		      bimestreresource.setAno(ano);
		      bimestreresource.setFaltas(faltas);
		      bimestreresource.setIdAlunos(idalunos);
		      return bimestreresource;

		    } catch (Exception e) {
		      throw new TratamentoResourceException(
		          "Falha ao converter o resource para entidade, resouce: " + bimestre);
		    }

		  }
}