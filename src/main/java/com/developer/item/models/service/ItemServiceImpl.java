package com.developer.item.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.developer.item.models.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private RestTemplate clienteRest;
	
	@Autowired
	public ItemServiceImpl(RestTemplate clienteRest) {
		this.clienteRest = clienteRest;
	}

	@Override
	public List<Item> findAll() {
		return null;
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return null;
	}

}
