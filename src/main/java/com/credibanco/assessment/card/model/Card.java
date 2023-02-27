package com.credibanco.assessment.card.model;

import java.math.BigInteger;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String numero;
	
	private String titular;
	
	@Column(length = 15)
	private Long cedula;
	
	private String tipo; 
	
	@Column(length = 10)
	private int telefono;
	
	private String estado;
	
	private int validacion;
	
	@PrePersist
	public void prepersist() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(100);
		validacion = numeroAleatorio;
		Random rand = new Random();
	      BigInteger upperLimit = new BigInteger("9999999999999999999");
	      BigInteger result = new BigInteger(upperLimit.bitLength(), rand);
	      numero = result.toString();
	      estado = "Creada";
	}
}
