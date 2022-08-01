package com.mcfitness.musclefitness.Graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mcfitness.musclefitness.Model.Objetivo;
import com.mcfitness.musclefitness.Repository.ObjetivoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjetivoGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ObjetivoRepository objetivoRepo;


    public List<Objetivo> obterObjetivos(){

        List<Objetivo> lista = objetivoRepo.obterObjetivos();
        return lista;    
    }

    public Objetivo obterObjetivoPorId(int id){

        Objetivo objetivo = objetivoRepo.obterObjetivoPorId(id);
        return objetivo;    
    }
      
}
