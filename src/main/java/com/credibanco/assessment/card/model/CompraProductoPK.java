package com.credibanco.assessment.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompraProductoPK implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_card")
	private Long idCard;

	@Column(name = "id_compra")
	private Long idCompra;

}
