package br.com.transp.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@NotEmpty
    @Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String empresa;
	private String telefone;
	private String celular;
	private String whatsapp;
	@NotNull
	private Modal modal;
	private String cep;
	@NotNull
	private EstadosBrasil estado;
	@NotEmpty
	private String cidade;
	@NotEmpty
	private String bairro;
	@NotEmpty
	private String logradouro;
	@NotEmpty
	private String numeroLogradouro;
	private int termoServico;

}
