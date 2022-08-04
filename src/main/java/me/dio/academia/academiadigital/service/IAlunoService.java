package me.dio.academia.academiadigital.service;

import me.dio.academia.academiadigital.model.Aluno;
import me.dio.academia.academiadigital.model.AvaliacaoFisica;
import me.dio.academia.academiadigital.model.dto.AlunoCreateDTO;
import me.dio.academia.academiadigital.model.dto.AlunoUpdateDTO;

import java.util.List;

public interface IAlunoService {
    Aluno create(AlunoCreateDTO dto);
    Aluno get(Long id);
    List<Aluno> getAll(String dataNascimento);
    List<Aluno> getAll();
    Aluno update(Long id, AlunoUpdateDTO dto);
    void delete(Long id);
    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
    List<AvaliacaoFisica> getAvaliacoesByAlunoId(Long id);
}
