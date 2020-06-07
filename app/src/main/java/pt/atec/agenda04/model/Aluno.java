package pt.atec.agenda04.model;

import androidx.annotation.NonNull;

public class Aluno {

    private final String nome;
    private final String email;
    private final String fone;

    public Aluno(String nome, String email, String fone) {


        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }


//
//    public String getNome() {
//        return nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getFone() {
//        return fone;
//    }
}
