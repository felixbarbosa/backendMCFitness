package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.Objetivo;

public interface ObjetivoRepository {
    
    List<Objetivo> obterObjetivos();

    Objetivo obterObjetivoPorId(int id);
}
