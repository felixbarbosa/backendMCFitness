package com.mcfitness.musclefitness.Graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mcfitness.musclefitness.Model.DiaSemana;
import com.mcfitness.musclefitness.Repository.DiaSemanaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiaSemanaGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private DiaSemanaRepository diaSemanaRepo;


    public List<DiaSemana> obterDiasSemana(){

        List<DiaSemana> lista = diaSemanaRepo.obterDiasSemana();
        return lista;    
    }

    public DiaSemana obterDiaSemanaPorId(int id){

        DiaSemana diaSemana = diaSemanaRepo.obterDiaSemanaPorId(id);
        return diaSemana;    
    }
      
}
