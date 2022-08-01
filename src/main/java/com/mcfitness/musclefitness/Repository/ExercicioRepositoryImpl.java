package com.mcfitness.musclefitness.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.mcfitness.musclefitness.Model.Exercicio;
import com.mcfitness.musclefitness.Model.Musculo;

@Repository
public class ExercicioRepositoryImpl implements ExercicioRepository{

    private static String SELECT_EXERCICIO_ID = "select * from mc_exercicio where id = ?";
    private static String SELECT_EXERCICIO_MUSCULO = "select * from mc_exercicio where musculo = ?";
    private static String SELECT_EXERCICIOS = "select * from mc_exercicio";
    private static String INSERT_EXERCICIO = " insert into mc_exercicio (id, descricao, musculo) values " +
        " (nextval('mc_exercicio_id_seq'), ?, ?) ";
    //private static String UPDATE = " update exercicio set visto = ? where id = ?";  

    @Autowired
    private JdbcTemplate jbdcTemplate;

    @Autowired 
    private MusculoRepository musculoRepo;

    
    public void setDataSource(DataSource dataSource){
        this.jbdcTemplate = new JdbcTemplate(dataSource);
    }

    public Exercicio salvarExercicio(Exercicio exercicio) {

        jbdcTemplate.update(INSERT_EXERCICIO, new Object[] {exercicio.getId(), exercicio.getDescricao(), 
        exercicio.getMusculo().getId()});

        return exercicio;
    }

    public Exercicio obterExercicioPorId(int id) {
       
        return jbdcTemplate.queryForObject(SELECT_EXERCICIO_ID, new Object[] {id}, new RowMapper<Exercicio>() {
            @Override
            public Exercicio mapRow(ResultSet rs, int rownumber) throws SQLException {
                
                Exercicio exercicio = new Exercicio();
                Musculo musculo = new Musculo();

                exercicio.setId(rs.getInt("id"));
                exercicio.setDescricao(rs.getString("descricao"));

                musculo = musculoRepo.obterMusculoPorId(rs.getInt("musculo"));
                exercicio.setMusculo(musculo);

                return exercicio;
            }
        });

    }

    /*public Exercicio atualizar(Exercicio exercicio) {
    
        jbdcTemplate.update(UPDATE, new Object[] { exercicio.getVisto(), exercicio.getId()});

        return exercicio; 
    }*/

    /*public List<Exercicio> obterEntregasPendentes(){

        Date data = new Date();
        java.sql.Date dataSQL = new java.sql.Date(data.getTime());

        System.out.println("Data = " + dataSQL.toString());
        return jbdcTemplate.query(SELECT_ENTREGAS_PENDENTES, new RowMapper<Exercicio>(){

            @Override
            public Exercicio mapRow(ResultSet rs, int rownumber) throws SQLException{

                Exercicio exercicio = new Exercicio();
                exercicio.setId(rs.getInt("id"));
                exercicio.setData(rs.getString("data"));
                exercicio.setCodigo(rs.getString("codigo"));
                exercicio.setHora(rs.getString("hora"));
                exercicio.setLocal(rs.getString("local"));
                exercicio.setTurno(rs.getString("turno"));
                exercicio.setVisto(rs.getInt("visto"));
                
                return exercicio;

            }
        }, dataSQL.toString());
    }*/

    public List<Exercicio> obterExercicios(){

        return jbdcTemplate.query(SELECT_EXERCICIOS, new RowMapper<Exercicio>(){

            @Override
            public Exercicio mapRow(ResultSet rs, int rownumber) throws SQLException{

                Exercicio exercicio = new Exercicio();
                Musculo musculo = new Musculo();

                exercicio.setId(rs.getInt("id"));
                exercicio.setDescricao(rs.getString("descricao"));

                musculo = musculoRepo.obterMusculoPorId(rs.getInt("musculo"));
                exercicio.setMusculo(musculo);
                
                return exercicio;

            }
        });
    }

    public List<Exercicio> obterExerciciosPorMusculo(int musculoId){

        return jbdcTemplate.query(SELECT_EXERCICIO_MUSCULO, new RowMapper<Exercicio>(){

            @Override
            public Exercicio mapRow(ResultSet rs, int rownumber) throws SQLException{

                Exercicio exercicio = new Exercicio();
                Musculo musculo = new Musculo();

                exercicio.setId(rs.getInt("id"));
                exercicio.setDescricao(rs.getString("descricao"));

                musculo = musculoRepo.obterMusculoPorId(musculoId);
                exercicio.setMusculo(musculo);
                
                return exercicio;

            }
        }, musculoId);
    }
     
}
