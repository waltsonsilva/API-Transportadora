package br.com.transp.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import br.com.transp.beans.Transportadora;

public class TransportadoraSpecification implements Specification<Transportadora> {
	@Autowired
	Transportadora transportadora;

	public TransportadoraSpecification(Transportadora transportadora) {
		super();
		this.transportadora = transportadora;
	}

	@Override
	public Predicate toPredicate(Root<Transportadora> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.disjunction();
		if (this.transportadora.getNome() != null) {
			p.getExpressions().add(
					criteriaBuilder.like(root.<String>get("nome"), "%" + this.transportadora.getNome().trim() + "%"));
		}
		if (this.transportadora.getCidade() != null) {
			p.getExpressions().add(criteriaBuilder.like(root.<String>get("cidade"),
					"%" + this.transportadora.getCidade().trim() + "%"));
		}
		if (this.transportadora.getEstado() != null) {
			p.getExpressions().add(criteriaBuilder.like(root.<String>get("cidade"),
					"%" + this.transportadora.getEstado().toString().trim() + "%"));
		}
		if (this.transportadora.getModal() != null) {
			p.getExpressions().add(criteriaBuilder.like(root.<String>get("modal"),
					"%" + this.transportadora.getModal().toString().trim() + "%"));
		}
		return p;
	}

}
