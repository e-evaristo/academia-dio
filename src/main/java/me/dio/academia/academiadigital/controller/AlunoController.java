package me.dio.academia.academiadigital.controller;

import me.dio.academia.academiadigital.model.Aluno;
import me.dio.academia.academiadigital.model.dto.AlunoCreateDTO;
import me.dio.academia.academiadigital.model.dto.AlunoUpdateDTO;
import me.dio.academia.academiadigital.service.impl.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aluno get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Aluno create(@RequestBody AlunoCreateDTO aluno) {
        return service.create(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateDTO aluno) {
        return service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
