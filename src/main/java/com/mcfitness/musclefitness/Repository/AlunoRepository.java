package com.mcfitness.musclefitness.Repository;

import java.util.List;

import com.mcfitness.musclefitness.Model.Aluno;

public interface AlunoRepository {
    
    List<Aluno> obterAlunosProfessor(int professorId);

    Aluno obterAlunoPorId(int id);

    Aluno salvarAluno(Aluno aluno);

    //Aluno atualizarAluno(Aluno aluno);
}
