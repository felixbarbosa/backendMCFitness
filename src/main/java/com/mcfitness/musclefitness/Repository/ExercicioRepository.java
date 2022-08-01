package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.Exercicio;

public interface ExercicioRepository {
    
    List<Exercicio> obterExercicios();

    List<Exercicio> obterExerciciosPorMusculo(int musculoId);

    Exercicio obterExercicioPorId(int id);

    //List<Exercicio> obterEntregasRealizadas();

    Exercicio salvarExercicio(Exercicio exercicio);

    //Exercicio atualizar(Exercicio entregador);
}
