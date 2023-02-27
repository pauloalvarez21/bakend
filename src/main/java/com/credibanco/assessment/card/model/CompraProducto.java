package com.credibanco.assessment.card.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "compras_productos")
public class CompraProducto {
	
	@EmbeddedId
	private CompraProductoPK id;
	
	private int cantidad;
	
	private Double total;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "id_card", insertable = false, updatable = false)
	private Card card;

}
