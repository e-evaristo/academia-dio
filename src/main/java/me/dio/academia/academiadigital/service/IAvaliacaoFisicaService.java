package me.dio.academia.academiadigital.service;

import me.dio.academia.academiadigital.model.AvaliacaoFisica;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaCreateDTO;
import me.dio.academia.academiadigital.model.dto.AvaliacaoFisicaUpdateDTO;

import java.util.List;

public interface IAvaliacaoFisicaService {
    AvaliacaoFisica create(AvaliacaoFisicaCreateDTO dto);
    AvaliacaoFisica get(Long id);
    List<AvaliacaoFisica> getAll();
    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO dto);
    void delete(Long id);
}
