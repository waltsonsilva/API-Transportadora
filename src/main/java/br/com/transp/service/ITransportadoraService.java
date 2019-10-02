package br.com.transp.service;

import java.util.List;


import br.com.transp.beans.Transportadora;

public interface ITransportadoraService extends IService<Transportadora> {

	List<Transportadora> porFiltro(Transportadora transportadora);
}
