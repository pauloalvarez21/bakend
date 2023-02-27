package com.credibanco.assessment.card.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_card")
	private Long idCard;
	
	@Column(length = 19)
	private Long numero;
	
	private String titular;
	
	@Column(length = 15)
	private Long cedula;
	
	private String tipo; 
	
	@Column(length = 10)
	private int telefono;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private Compra compra;
	
	private int validacion;
	
	@PrePersist
	public void prepersist() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(100);
		validacion = numeroAleatorio;
	}
}
