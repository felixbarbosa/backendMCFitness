package com.mcfitness.musclefitness.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mcfitness.musclefitness.Model.Aluno;
import com.mcfitness.musclefitness.Model.Personal;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository{

    private static String SELECT_ALUNOS_PROFESSOR = "select * from mc_aluno where personal = " +
    "?";
    private static String SELECT_ALUNO_ID = "select * from mc_aluno where id = " +
    "?";
    private static String INSERT = " insert into mc_aluno (nome, cpf, login, senha, sexo, idade, email) "
            + " values (?, ?, ?, ?, ?, ?, ?) ";
    //private static String UPDATE = " update mc_aluno set nome = ? where id = ?";  

    @Autowired
    private JdbcTemplate jbdcTemplate;

    @Autowired
    private PersonalRepository personalRepo;

    
    public void setDataSource(DataSource dataSource){
        this.jbdcTemplate = new JdbcTemplate(dataSource);
    }

    public Aluno salvarAluno(Aluno aluno) {

        jbdcTemplate.update(INSERT, new Object[] {aluno.getNome(), aluno.getCpf(), aluno.getLogin(), aluno.getSenha(), 
        aluno.getSexo(), aluno.getIdade(), aluno.getEmail()});

        return aluno;
    }

    /*public Aluno atualizarAluno(Aluno aluno) {
    
        jbdcTemplate.update(UPDATE, new Object[] { aluno.getVisto(), aluno.getId()});

        return aluno; 
    }*/

    public Aluno obterAlunoPorId(int id) {
       
        return jbdcTemplate.queryForObject(SELECT_ALUNO_ID, new Object[] {id}, new RowMapper<Aluno>() {
            @Override
            public Aluno mapRow(ResultSet rs, int rownumber) throws SQLException {
                
                Aluno aluno = new Aluno();
                Personal personal = new Personal();

                aluno.setId(rs.getInt("id"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setLogin(rs.getString("login"));
                aluno.setNome(rs.getString("nome"));

                personal = personalRepo.obterPersonalPorId(rs.getInt("personal"));
                aluno.setPersonal(personal);

                aluno.setSenha(rs.getString("senha"));
                aluno.setSexo(rs.getString("sexo"));

                return aluno;
            }
        });

    }

    public List<Aluno> obterAlunosProfessor(int professorId){

        Date data = new Date();
        java.sql.Date dataSQL = new java.sql.Date(data.getTime());

        System.out.println("Data = " + dataSQL.toString());
        return jbdcTemplate.query(SELECT_ALUNOS_PROFESSOR, new RowMapper<Aluno>(){

            @Override
            public Aluno mapRow(ResultSet rs, int rownumber) throws SQLException{

                Aluno aluno = new Aluno();
                Personal personal = new Personal();

                aluno.setId(rs.getInt("id"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setLogin(rs.getString("login"));
                aluno.setNome(rs.getString("nome"));
                personal.setId(rs.getInt("personal"));
                aluno.setPersonal(personal);
                aluno.setSenha(rs.getString("senha"));
                aluno.setSexo(rs.getString("sexo"));
                
                return aluno;

            }
        }, professorId);
    }
     
}
