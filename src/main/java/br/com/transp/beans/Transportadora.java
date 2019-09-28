package br.com.transp.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.transp.enums.EstadosBrasil;
import br.com.transp.enums.Modal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transportadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoId;
	private String email;
	private String nome;
	private String empresa;
	private String telefone;
	private String celular;
	private String whatsapp;
	private Modal modal;
	private String cep;
	private EstadosBrasil estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numeroLogradouro;
	private int termoServico;

}
