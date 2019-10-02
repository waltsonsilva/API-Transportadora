package br.com.transp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.transp.beans.Transportadora;
import br.com.transp.service.ITransportadoraService;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {

	@Autowired
	private ITransportadoraService transpService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Transportadora transp) {
		transp = transpService.inserir(transp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id)").buildAndExpand(transp.getCodigoId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Transportadora> buscaPorId(@PathVariable Long id) {
		Transportadora transpotadora = null;
		try {
			transpotadora = transpService.buscarPorId(id);
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		return ResponseEntity.ok(transpotadora);

	}

	public List todos() {
		return transpService.buscarPorTodos();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Transportadora> atualizar(@RequestBody Transportadora transportadora, @PathVariable Long id) {
		if (transportadora != null) {
			transportadora.setCodigoId(id);
			transpService.atualizar(transportadora);
		}

		return ResponseEntity.ok().build();

	}

	@GetMapping()
	public ResponseEntity<List<Transportadora>> listaTodos() {
		List<Transportadora> list = transpService.buscarPorTodos();
		try {
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		transpService.deletarPorID(id);
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping(path ="/porFiltro")
	public ResponseEntity<List<Transportadora>> porfiltro(Transportadora transportadora){
		List<Transportadora> transportadoras = transpService.porFiltro(transportadora);
		if(transportadoras != null && !transportadoras.isEmpty()) {
			return new ResponseEntity<>(transportadoras,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
