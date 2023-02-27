package com.credibanco.assessment.card.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.service.CardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@GetMapping("/card")
	public List<Card> listar(){
		return service.findAll();
	}
	
	@PostMapping("/card")
	public ResponseEntity<?> crear(@RequestBody Card card) {
		Card cardNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cardNew = service.save(card);
		} catch(DataAccessException e) {
			response.put("mensaje", "Creación Fallido");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Creación Exitosa");
		response.put("card", cardNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/card/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Card card = null;
		Map<String, Object> response = new HashMap<>();
		try {
			card = service.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Creación Fallido");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(card == null) {
			response.put("mensaje", "La tarjeta no exite");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Card>(card, HttpStatus.OK);
		
	}
	

	@PutMapping("/card/{id}")
	public ResponseEntity<?> update(@RequestBody Card card, @PathVariable Long id) {
		Card cardActual = service.findById(id);
		Card cardUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if(cardActual == null) {
			response.put("mensaje", "La tarjeta no exite");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			cardActual.setNumero(card.getNumero());
			cardActual.setTitular(card.getTitular());
			cardActual.setCedula(card.getCedula());
			cardActual.setTipo(card.getTipo());
			cardActual.setTelefono(card.getTelefono());
			cardActual.setEstado(card.getEstado());
			
			cardUpdate = service.save(cardActual);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error en la inserción en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Card modificada con exito");
		response.put("Card", cardUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/card/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			service.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error en la eliminación en la base de datos");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Card eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
