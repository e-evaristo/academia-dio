package me.dio.academia.academiadigital.service.impl;

import me.dio.academia.academiadigital.model.Aluno;
import me.dio.academia.academiadigital.model.AvaliacaoFisica;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaCreateDTO;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaUpdateDTO;
import me.dio.academia.academiadigital.repository.AlunoRepository;
import me.dio.academia.academiadigital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.academiadigital.service.IAvaliacaoFisicaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository repository;
    private final AlunoRepository alunoRepository;

    public AvaliacaoFisicaService(AvaliacaoFisicaRepository repository, AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaCreateDTO dto) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setPeso(dto.getPeso());
        avaliacaoFisica.setAltura(dto.getAltura());
        Aluno aluno = alunoRepository.getReferenceById(dto.getAlunoId());
        avaliacaoFisica.setAluno(aluno);

        return repository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação física não encontrada"));
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return repository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO dto) {
        AvaliacaoFisica avaliacaoFisica = get(id);
        avaliacaoFisica.setPeso(dto.getPeso());
        avaliacaoFisica.setAltura(dto.getAltura());
        return repository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        AvaliacaoFisica avaliacaoFisica = get(id);
        repository.delete(avaliacaoFisica);
    }
}
