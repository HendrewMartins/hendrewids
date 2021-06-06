package br.com.hendrew.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hendrew.conversor.ConversorNotas;
import br.com.hendrew.datasource.model.Alunos;
import br.com.hendrew.datasource.model.Avaliacao;
import br.com.hendrew.datasource.model.Bimestre;
import br.com.hendrew.datasource.model.Notas;
import br.com.hendrew.datasource.model.Notas_Auxiliar;
import br.com.hendrew.exception.TratamentoNotFoundException;
import br.com.hendrew.exception.TratamentoResourceException;
import br.com.hendrew.repository.NotasRepository;
import br.com.hendrew.resource.model.NotasResource;

@Service
public class NotasService {
	private static final Logger LOG = Logger.getLogger(NotasService.class);

	@Autowired
	private NotasRepository notasRepository;

	@Autowired
	private ConversorNotas service;
	
	@Autowired
	private AlunosService servicealunos;
	
	@Autowired
	private AvaliacaoService serviceavaliacao;
	
	@Autowired
	private BimestreService servicebimestre;

	public Notas cadastroNotas(NotasResource notasResource) {
		try {
			Notas notas = service.conversor(notasResource);
			notasRepository.saveAndFlush(notas);
			return notasRepository.saveAndFlush(notas);
		} catch (TratamentoResourceException e) {
			LOG.error("Erro ao salvar o Notas: " + e.getMessage(), e);
			return null;
		}
	}

	public List<Notas> buscarTodasNotas() {
		List<Notas> listNotas = notasRepository.findAll();
		return listNotas;
	}

	public Notas buscarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Notas> optionalNotas = getOptional(id);
		Notas notas = null;
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Notas nao encontrado atraves do ID: " + id);
		} else {
			notas = optionalNotas.get();
		}
		return notas;
	}
	
	public List<Notas> buscarPorBimestre(Long idbimestre) throws TratamentoNotFoundException {
		Optional<List<Notas>> optionalNotas = getOptionalBimestre(idbimestre);
		List<Notas> notas = null;
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Notas nao encontrado atraves do IDBimestre: " + idbimestre);
		} else {
			notas = optionalNotas.get();
		}
		return notas;
	}

	private Optional<Notas> getOptional(Long id) {
		Optional<Notas> optionalNotas = notasRepository.findById(id);
		return optionalNotas;
	}
	
	private Optional<List<Notas>> getOptionalBimestre(Long idBimestre) {
		Optional<List<Notas>> optionalNotas = Optional.ofNullable(notasRepository.findByIdbimestre(idBimestre));
		return optionalNotas;
	}

	public void deletarPorId(Long id) throws TratamentoNotFoundException {
		Optional<Notas> optionalNotas = getOptional(id);
		if (!optionalNotas.isPresent()) {
			throw new TratamentoNotFoundException("Notas nao encontrado atraves do ID: " + id);
		} else {
			notasRepository.delete(optionalNotas.get());
		}

	}

	public Notas atualizar(Long id, NotasResource notasResource) {
		Optional<Notas> optionalNotas = notasRepository.findById(id);

		if (optionalNotas.isPresent()) {
			try {
				Notas not = service.conversor(notasResource);
				return notasRepository.save(not);
			} catch (TratamentoResourceException e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}
	
	public List<Notas_Auxiliar> buscarTodosNotas() {
		List<Notas> listNotas = notasRepository.findAll();	
		Alunos aluno = null;
		Avaliacao avaliacao = null;
		Bimestre  bimestre = null;
		
		List<Notas_Auxiliar> lista = new ArrayList<Notas_Auxiliar>();
		for(int i = 0; i < listNotas.size(); i++)
		{
			Notas_Auxiliar aux = new Notas_Auxiliar();
			try {
				aluno = servicealunos.buscarPorIdAluno(listNotas.get(i).getAluno());
				aux.setDesalunos(aluno.getNome());
				aux.setId(listNotas.get(i).getId());
				aux.setIdbimestre(listNotas.get(i).getIdbimestre());
				aux.setAluno(listNotas.get(i).getAluno());
				aux.setIdavaliacao(listNotas.get(i).getIdavaliacao());
				aux.setNotas(listNotas.get(i).getNotas());
				avaliacao = serviceavaliacao.buscarPorIdAvaliacao(listNotas.get(i).getIdavaliacao());
				aux.setDesavaliacao(avaliacao.getDescricao());
			    bimestre  = servicebimestre.buscarPorId(listNotas.get(i).getIdbimestre()); 
				aux.setAno(bimestre.getAno());
				aux.setDesbimestre(bimestre.getBimestre()+"º"+" Bimestre - "+bimestre.getAno());
			
			} catch (TratamentoNotFoundException e) {
				e.printStackTrace();
			}
			lista.add(i,aux);
		}
		
		return lista;
	}
}
