package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.Musculo;

public interface MusculoRepository {

    Musculo obterMusculoPorId(int id);
    
    List<Musculo> obterMusculos();
}
