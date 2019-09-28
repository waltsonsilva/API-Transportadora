package br.com.transp.service;

import java.util.List;
import java.util.Optional;

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
	public Transportadora atualizar(Transportadora transp) {
		try {
			Transportadora transportadora = buscarPorId(transp.getCodigoId());
			if(transportadora != null) {
				return transpRepo.save(transp);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Transportadora buscarPorId(Long id) throws IllegalAccessException {
		if(id <= 0) {
			throw new IllegalArgumentException("Id não pode ser <= 0");
		}
		Optional<Transportadora> transportadora = transpRepo.findById(id);
		return transportadora.orElseThrow(()->new IllegalAccessException("Id não encontrado"));
	}

	@Override
	public void deletarPorID(Long id) {
		try {
			buscarPorId(id);
			transpRepo.deleteById(id);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transportadora> buscarPorTodos() {
		List<Transportadora> listaTransp = transpRepo.findAll();
		if(!listaTransp.isEmpty()) {
			return listaTransp;
		}
		return null;
	}

}
