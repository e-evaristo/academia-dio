package me.dio.academia.academiadigital.service;

import me.dio.academia.academiadigital.model.Matricula;
import me.dio.academia.academiadigital.model.dto.MatriculaCreateDTO;

import java.util.List;

public interface IMatriculaService {
    Matricula create(MatriculaCreateDTO dto);
    Matricula get(Long id);
    List<Matricula> getAll(String bairro);
    void delete(Long id);

}
