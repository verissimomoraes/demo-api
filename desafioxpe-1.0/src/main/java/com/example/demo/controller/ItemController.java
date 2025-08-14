package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @Operation(summary = "Retorna todos os items", description = "Lista completa dos items cadastrados")
    @GetMapping
    public List<Item> getAll() {
        return repository.findAll();
    }

    
    @Operation(summary = "Retorna um item por id")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cria um novo item")
    @PostMapping
    public Item create(@RequestBody Item item) {
        return repository.save(item);
    }

    /**
     * Atualiza um item por id.
     *
     * @param id O id do item.
     * @param item O item com os dados atualizados.
     * @return OK com o item atualizado se ele existir, ou NotFound se ele n o existir.
     */
    @Operation(summary = "Atualiza um item por id")
     @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(item.getName());
                    existing.setDescription(item.getDescription());
                    return ResponseEntity.ok(repository.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um item por id.
     *
     * @param id O id do item.
     * @return NoContent se o item existir, ou NotFound se ele n o existir.
     */
    @Operation(summary = "Remove um item por id")
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(item -> {
                    repository.delete(item);
                    return ResponseEntity.noContent().<Void>build(); // CORRETO
                }).orElse(ResponseEntity.notFound().build());
    }
    
}


