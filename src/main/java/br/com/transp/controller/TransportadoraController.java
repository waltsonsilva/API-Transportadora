package br.com.transp.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.transp.beans.Transportadora;
import br.com.transp.service.ITransportadoraService;

@RestController
@RequestMapping("/transportadora")
public class TransportadoraController {
	
	@Autowired
	private ITransportadoraService transpService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Transportadora transp){
		transp = transpService.inserir(transp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id)").buildAndExpand(transp.getCodigoId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

}
