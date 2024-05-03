package com.example.servingwebcontent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.Models.Item;
import com.example.servingwebcontent.Services.ItemService;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public String getItems(Model model) {

        List<Item> items = itemService.getAllItems();
        
        model.addAttribute("items", items);
        
        return "items";
    }
}
