package me.dio.academia.academiadigital.service.impl;

import me.dio.academia.academiadigital.model.Aluno;
import me.dio.academia.academiadigital.model.Matricula;
import me.dio.academia.academiadigital.model.dto.MatriculaCreateDTO;
import me.dio.academia.academiadigital.repository.AlunoRepository;
import me.dio.academia.academiadigital.repository.MatriculaRepository;
import me.dio.academia.academiadigital.service.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService {

    private final MatriculaRepository repository;
    private final AlunoRepository alunoRepository;

    public MatriculaService(MatriculaRepository repository, AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Matricula create(MatriculaCreateDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        return repository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Matricula não encontrada."));
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return repository.findAll();
        } else {
            return repository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
