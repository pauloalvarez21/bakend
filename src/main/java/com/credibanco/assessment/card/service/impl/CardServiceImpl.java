package com.credibanco.assessment.card.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.domain.reposytory.CardRepository;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardRepository repository;

	@Override
	public List<Card> findAll() {
		
		return (List<Card>) repository.findAll();
	}

	@Override
	public Card findById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public Card save(Card card) {
		
		return repository.save(card);
	}

	@Override
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}

}
