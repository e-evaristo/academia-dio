package me.dio.academia.academiadigital.service.impl;

import me.dio.academia.academiadigital.model.Aluno;
import me.dio.academia.academiadigital.model.AvaliacaoFisica;
import me.dio.academia.academiadigital.model.dto.AlunoCreateDTO;
import me.dio.academia.academiadigital.model.dto.AlunoUpdateDTO;
import me.dio.academia.academiadigital.repository.AlunoRepository;
import me.dio.academia.academiadigital.service.IAlunoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlunoService implements IAlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno create(AlunoCreateDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setCpf(dto.getCpf());
        aluno.setBairro(dto.getBairro());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @Override
    public List<Aluno> getAll(String dataNascimento) {
        return null;
    }

    @Override
    public List<Aluno> getAll() {
        return repository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateDTO dto) {
        Aluno aluno = get(id);
        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setBairro(dto.getBairro());
        return repository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = get(id);
        repository.delete(aluno);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAvaliacoesByAlunoId(Long id) {
        Aluno aluno = get(id);
        return aluno.getAvaliacoes();
    }
}
