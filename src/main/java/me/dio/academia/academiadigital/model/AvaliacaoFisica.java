package me.dio.academia.academiadigital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "avaliacoes")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name="data_avaliacao")
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @Column(name="peso_atual")
    private double peso;

    @Column(name="altura_atual")
    private double altura;

}
