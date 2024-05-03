package com.example.servingwebcontent.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.servingwebcontent.Models.Item;

@Service
public class ItemService {
    public List<Item> getAllItems() {
        String url = "http://localhost:8080/api/items";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Item>> result = restTemplate.exchange(url, 
        HttpMethod.GET, 
        null, 
        new ParameterizedTypeReference<List<Item>>() {
            }
        );

        return result.getBody();
        }

        public Item AddItem(Item item) {
            Optional<Item> existingItem = itemRepository.findById(item.id);
        
            try{
                if(existingItem.get() == null) {
                    itemRepository.insert(item);
                    return itemRepository.save(item);
                } else {
                    existingItem.get().quantity += item.quantity;
                    return itemRepository.save(existingItem.get());
                }
            } catch(Exception ex) {
                itemRepository.insert(item);
                return itemRepository.save(item);
            }
            }
        
        
        
    }

