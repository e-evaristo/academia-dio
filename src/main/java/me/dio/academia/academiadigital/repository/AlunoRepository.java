package me.dio.academia.academiadigital.repository;

import me.dio.academia.academiadigital.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
