package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.DiaSemana;

public interface DiaSemanaRepository {
    
    List<DiaSemana> obterDiasSemana();

    DiaSemana obterDiaSemanaPorId(int id);
}
