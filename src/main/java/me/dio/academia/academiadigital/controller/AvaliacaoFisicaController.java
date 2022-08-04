package me.dio.academia.academiadigital.controller;

import me.dio.academia.academiadigital.model.AvaliacaoFisica;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaCreateDTO;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaUpdateDTO;
import me.dio.academia.academiadigital.service.impl.AvaliacaoFisicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService service;

    public AvaliacaoFisicaController(AvaliacaoFisicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaCreateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
