package edu.curso;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GestaoAlunos {
    private int indice = 0;
    private Aluno[] alunos = new Aluno[50];
    private Scanner scan = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void criar(){
        if(indice < alunos.length){
            Aluno a = new Aluno();
            System.out.print("Digite o ID (long): ");
            a.setId(Long.parseLong(scan.nextLine()));
            System.out.print("Digite o nome: ");
            a.setNome(scan.nextLine());
            System.out.print("Digite o RA: ");
            a.setRa(scan.nextLine());

            try {
                System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
                a.setNascimento(sdf.parse(scan.nextLine()));
            } catch (Exception e) {
                System.out.println("Data Invalida! O Aluno será salvo sem data.");
            }

            alunos[indice] = a;
            indice++;
            System.out.println("Aluno cadastrado com sucesso!");

        } else{
            System.out.println("Capacidade maxima atingida (50 alunos)");
        }
    }        

    public void exibir(){
        System.out.print("Digite o RA para a busca: ");
        String raSearch = scan.nextLine();
        boolean find = false;

        for(int i = 0; i < indice; i++){
            if(alunos[i] != null && alunos[i].getRa().equals(raSearch)){
                System.out.println(alunos[i].toString());
                find = true;
            }
        }
        if(!find){
            System.out.println("Student not find!");
        }
    }

    public void excluir(){
        System.out.print("Digite o RA para excluir: ");
        String raSearch = scan.nextLine();
        boolean removed = false;

        for(int i = 0; i < indice; i++){
            if(alunos[i] != null && alunos[i].getRa().equals(raSearch)){
                //Para remover, deslocamos os elementos subsequentes para a esquerda
                for(int j = i; j < indice - 1; j++){
                    alunos[j] = alunos[j + 1];
                }
                alunos[indice - 1] = null;
                indice--;
                removed = true;
                i--; //Ajusta o indice para não pular o próximo elemento deslocado
            }
        }
        if(removed){
            System.out.println("Aluno(s) removido(s) com sucesso.");
        } else{
            System.out.println("Nenhum aluno encontrado com esse RA.");
        }
    }

    public void atualizar(){
        System.out.print("Digite o RA do aluno que deseja atualizar: ");
        String raSearch = scan.nextLine();

        for(int i = 0; i < indice; i++){
            if(alunos[i] != null && alunos[i].getRa().equals(raSearch)){
                System.out.print("Novo nome: ");
                alunos[i].setNome(scan.nextLine());

                try {
                    System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
                    alunos[i].setNascimento(sdf.parse(scan.nextLine()));
                } catch (Exception e) {
                    System.out.println("Data invalida! Mantendo a anterior ou nula.");
                }
                System.out.println("Dados atualizados!");
                return; // Atualiza apenas o primeiro encontrado, conforme a regra
            }
        }
        System.out.println("Aluno não encontrado");
    }

    public void menu(){
        while (true) {
            System.out.println("\n--- SISTEMA DE GESTAO DE ALUNO ---");
            System.out.println("(C)riar         (E)xibir        (R)emover");
            System.out.println("(A)tualizar     (S)air");
            System.out.println("Escolha uma opcao: ");

            String textoUpper = scan.nextLine().toUpperCase();
            if(textoUpper.isEmpty()){
                continue;
            }

            char letra = textoUpper.charAt(0);

            switch(letra){
                case 'C': criar(); break;
                case 'E': exibir(); break;
                case 'R': excluir(); break;
                case 'A': atualizar(); break;
                case 'S':
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.menu();
    }
}
