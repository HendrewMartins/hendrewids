package br.com.hendrew.conversor;

import org.springframework.stereotype.Component;

import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.resource.model.BimestreResource;



@Component
public class ConversorBimestre {
	
	public Bimestre conversor(BimestreResource bimestreResource)
		      throws TratamentoResourceException {
	
		try {
		      Bimestre bimestre = new Bimestre();
		      
		      if(bimestreResource.getId() != null) {
		    	// Long idBimestre   = checkLong(bimestreResource.getId());  
		    	 bimestre.setId(bimestreResource.getId());
		      }
		      
		      Long bimestr      = bimestreResource.getBimestre();//checkLong(bimestreResource.getBimestre());
		      Long ano          = bimestreResource.getAno();//checkLong(bimestreResource.getAno());
		      Long faltas       = bimestreResource.getFaltas();//checkLong(bimestreResource.getFaltas());
		      Long idalunos     = bimestreResource.getIdAluno();//checkLong(bimestreResource.getIdAluno());
		    
		      bimestre.setBimestre(bimestr);
		      bimestre.setAno(ano);
		      bimestre.setFaltas(faltas);
		      bimestre.setIdAlunos(idalunos);
		      return bimestre;

		    } catch (Exception e) {
		      throw new TratamentoResourceException(
		          "Falha ao converter o resource para entidade, resouce: " + bimestreResource);
		    }

		  }

	 private Long checkLong(String valor) {
		    return Long.parseLong(valor);
		  }
	 
	 
	

}
