package pt.atec.agenda04.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pt.atec.agenda04.model.Aluno;

public class AlunoDAO {

    private final  static List<Aluno> alunos = new ArrayList<>();
    public void salvar(Aluno aluno) {
    alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}// fim da class DAO
