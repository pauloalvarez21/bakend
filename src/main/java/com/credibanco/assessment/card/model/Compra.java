package com.credibanco.assessment.card.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Long idCompra;
	
	@Column(name = "id_cliente")
	private String idCliente;
	
	@Column(name = "medio_pago")
	private String medioPago;
	
	private String comentario;
	
	private String estado;
	
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	public Cliente cliente;
}
