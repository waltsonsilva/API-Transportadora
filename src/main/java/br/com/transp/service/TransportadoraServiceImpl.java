package br.com.transp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.transp.beans.Transportadora;
import br.com.transp.repository.TransportadoraRepository;

@Service
public class TransportadoraServiceImpl implements ITransportadoraService {

	@Autowired
	private TransportadoraRepository transpRepo;

	@Override
	public Transportadora inserir(Transportadora transp) {
		if (transp == null) {
			throw new IllegalArgumentException("A Transportadora não pode ser nulo");
		}
		return transpRepo.save(transp);
	}

	@Override
	public Transportadora atualizar(Transportadora entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transportadora buscarPorId(Long id) throws IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarPorID(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Transportadora> buscarPorTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
