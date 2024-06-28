package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.domain.Item;
import com.rcarrier.personalwebsite.portfolio.exceptions.ItemNotFoundException;
import com.rcarrier.personalwebsite.portfolio.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController indicates that data returned by each method will be written straight into the response body instead of rendering a template
@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    // inject ItemRepository into the controller
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    List<Item> all() {
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    Item newItem(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }

    @GetMapping("/items/{id}")
    Item one(@PathVariable Long id) {

        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {

        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setDescription(newItem.getDescription());
                    return itemRepository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return itemRepository.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
