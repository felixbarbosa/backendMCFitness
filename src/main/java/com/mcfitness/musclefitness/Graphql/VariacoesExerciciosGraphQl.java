package com.mcfitness.musclefitness.Graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mcfitness.musclefitness.Model.Exercicio;
import com.mcfitness.musclefitness.Model.Musculo;
import com.mcfitness.musclefitness.Model.VariacoesExercicios;
import com.mcfitness.musclefitness.Model.VariacoesExerciciosInput;
import com.mcfitness.musclefitness.Repository.VariacoesExerciciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariacoesExerciciosGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private VariacoesExerciciosRepository variacoesExerciciosRepo;


    public List<VariacoesExercicios> obterVariacoes(int exercicioId){

        List<VariacoesExercicios> lista = variacoesExerciciosRepo.obterVariacoes(exercicioId);
        return lista;    
    }

    public VariacoesExercicios salvarVariacoesExercicios(VariacoesExerciciosInput variacoesExerciciosInput, int exercicioId){
 
        VariacoesExercicios variacoesExercicios= new VariacoesExercicios();
        Exercicio exercicio = new Exercicio();
        Musculo musculo = new Musculo();

        variacoesExercicios.setId(variacoesExerciciosInput.getId());
        variacoesExercicios.setDescricao(variacoesExerciciosInput.getDescricao());

        musculo.setId(variacoesExerciciosInput.getMusculo());
        variacoesExercicios.setMusculo(musculo);

        exercicio.setId(variacoesExerciciosInput.getExercicio());
        variacoesExercicios.setExercicio(exercicio);

        if(variacoesExercicios.getId() == 0){
            variacoesExercicios = variacoesExerciciosRepo.cadastrarVariacao(variacoesExercicios, exercicioId);
        }
        return variacoesExercicios;
    }
      
}
