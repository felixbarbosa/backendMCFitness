package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.Personal;

public interface PersonalRepository {
    
    List<Personal> obterTodosPersonais();

    Personal salvarPersonal(Personal personal);

    Personal obterPersonalPorId(int id);

    Personal atualizarPersonal(Personal personal);
}
