package br.com.transp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.transp.beans.Transportadora;

public interface TransportadoraRepository
		extends JpaRepository<Transportadora, Long>, JpaSpecificationExecutor<Transportadora> {

}
