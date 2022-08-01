package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.VariacoesExercicios;

public interface VariacoesExerciciosRepository {
    
    List<VariacoesExercicios> obterVariacoes(int exercicioId);

    VariacoesExercicios cadastrarVariacao(VariacoesExercicios variacoes, int exercicioId);
}
