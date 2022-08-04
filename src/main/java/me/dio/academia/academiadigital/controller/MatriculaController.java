package me.dio.academia.academiadigital.controller;

import me.dio.academia.academiadigital.model.Matricula;
import me.dio.academia.academiadigital.model.dto.MatriculaCreateDTO;
import me.dio.academia.academiadigital.service.impl.MatriculaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Matricula get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaCreateDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

}
