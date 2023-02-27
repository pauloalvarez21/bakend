package com.credibanco.assessment.card.service;

import java.util.List;

import com.credibanco.assessment.card.model.Card;

public interface CardService {
	
	public List<Card> findAll();
	
	public Card findById(Long id);
	
	public Card save(Card card);
	
	public void delete(Long id);

}
