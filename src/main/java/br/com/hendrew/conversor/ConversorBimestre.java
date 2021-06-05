package br.com.hendrew.conversor;

import org.springframework.stereotype.Component;

import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.resource.model.BimestreResource;



@Component
public class ConversorBimestre {
	
	public Bimestre conversor(BimestreResource bimestreResource) {
	
		try {
		      Bimestre bimestre = new Bimestre();
		      
		      if(bimestreResource.getId() != null) {  
		    	 bimestre.setId(bimestreResource.getId());
		      }
		      
		      Long bimestr      = bimestreResource.getBimestre();
		      Long ano          = bimestreResource.getAno();
		      Long faltas       = bimestreResource.getFaltas();
		      Long idalunos     = bimestreResource.getIdAluno();
		    
		      bimestre.setBimestre(bimestr);
		      bimestre.setAno(ano);
		      bimestre.setFaltas(faltas);
		      bimestre.setIdAlunos(idalunos);
		      return bimestre;

		    } catch (Exception e) {
			      return null;

		    }

		  }

}
