package edu.curso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
    private long id;
    private Date nascimento;
    private String ra;
    private String nome;

    public String getRa(){
        return ra;
    }
    public void setRa(String ra){
        this.ra = ra;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public Date getNascimento(){
        return nascimento;
    }
    public void setNascimento(Date nascimento){
        this.nascimento = nascimento;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "ID: "+ id + " | Nome: "+ nome + " | RA: "+ ra +" | Nascimento: "+ (nascimento != null ? sdf.format(nascimento) : "N/A");
    }
}
