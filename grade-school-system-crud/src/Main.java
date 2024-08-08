import model.Aluno;
import model.GeraID;
import model.Materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Aluno> alunos= new ArrayList<Aluno>();

        while (true){
            System.out.println("1- Cadastrar Aluno\n2- Listar Alunos\n3- Atualizar Aluno\n4- Deletar Aluno\n5- Sair ");
            String option = scan.next(); // Utilizei String corrigir o problema quando uma opção não numérica for digitada
            // IF CREATE
            if (option.equals("1")){
                // INICIO CADASTRO DOS DADOS DO ALUNO
                System.out.println(" _________________________");
                System.out.println("|--===Cadastrar Aluno===--|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("NOME:");
                String nome = scan.next().toUpperCase();
                System.out.println("SOBRENOME:");
                String sobrenome = scan.next().toUpperCase();
                System.out.println("DATA DE NASCIMENTO DD/MM/AAAA");
                String nascimento = scan.next();
                String[] parts = nascimento.split("/");
                LocalDate dataDeNascimento = LocalDate.of(Integer.parseInt(parts[2]),Integer.parseInt(parts[1]),Integer.parseInt(parts[0]));

                Aluno aluno = new Aluno(GeraID.geraIDAluno(),nome,sobrenome,dataDeNascimento);
                System.out.println("|--===Cadastro Realizado===--|");
                alunos.add(aluno);
                //FIM CADASTRO DOS DADOS DO ALUNO
                //INICIO CADASTRO OPCIONAL DAS MATERIAS PARA O ALUNO RECEM CADASTRADO
                boolean cadastroDeMaterias = true;
                while (cadastroDeMaterias){
                    System.out.println("1- Cadastrar Materia\n2- Listar Materias\n3- Sair");
                    String escolha = scan.next();
                    if (escolha.equals("1")){
                        System.out.println("|--===Cadastar Materia===--|\n");
                        System.out.println("NOME DA MATERIA: ");
                        String nomeMateria = scan.next().toUpperCase();
                        System.out.println("NOTA DA PRIMEIRA PROVA: ");
                        double n1 = scan.nextDouble();
                        System.out.println("NOTA DA SEGUNDA PROVA: ");
                        double n2 = scan.nextDouble();
                        System.out.println("NOTA DO TRABALHO: ");
                        double nTrabalho = scan.nextDouble();
                        System.out.println("NOTA DA TAREFA: ");
                        double nTarefa = scan.nextDouble();

                        Materia materia = new Materia(nomeMateria, n1,n2,nTrabalho,nTarefa);
                        aluno.addMateria(materia);
                    } else if (escolha.equals("2")) {
                        System.out.println("|--===Listar Materias===--|\n");
                        System.out.println(aluno.getListaDeMaterias());
                    } else if (escolha.equals("3")) {
                        System.out.println("|--===Sair===--|\n");
                        cadastroDeMaterias = false;
                    }else{
                        System.out.println(" _________________________");
                        System.out.println("|--===OPÇÃO INVÁLIDA===--|");
                        System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    }
                }
            }
            //IF READ
            else if (option.equals("2")) {
                System.out.println(" _________________________");
                System.out.println("|---===Listar Alunos===---|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                if (alunos.isEmpty()){
                    System.out.println("|--===NÃO HÁ ALUNOS PARA MOSTRAR===--|");
                }else {
                    for (Aluno a:alunos){
                        System.out.println(a);
                    }
                }
            }
            //IF UPDATE
            else if (option.equals("3")) {
                System.out.println(" _________________________");
                System.out.println("|--===Atualizar Aluno===--|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                if (alunos.isEmpty()){
                    System.out.println("|--===NÃO HÁ ALUNOS PARA EDITAR===--|");
                }else {
                    System.out.println("ID DO ALUNO:");
                    int id = scan.nextInt();
                    boolean alunoEncontrado = false;
                    for (Aluno a:alunos){
                        if (id == a.getID()){
                            System.out.println("|--===Aluno Encontrado===--|");
                            System.out.println(a);
                            System.out.println("o que deseja alterar para:"+a.getFullName());
                            System.out.println("1- NOME\n2- SOBRENOME\n3- DATA DE NASCIMENTO DD/MM/AAAA\n4- MATERIA ");
                            String escolha = scan.next();
                            if (escolha.equals("1")){
                                System.out.println("|--===Alterar Nome===--|");
                                System.out.println("NOVO NOME:");
                                a.setNome(scan.next().toUpperCase());
                            } else if (escolha.equals("2")) {
                                System.out.println("|--===Alterar Sobrenome===--|");
                                System.out.println("NOVO SOBRENOME:");
                                a.setSobrenome(scan.next().toUpperCase());

                            } else if (escolha.equals("3")) {
                                System.out.println("|--===Alterar data de nascimento===--|");
                                System.out.println("NOVA DATA DE NASCIMENTO DD/MM/AAAA:");
                                String nascimento = scan.next();
                                String[] parts = nascimento.split("/");
                                a.setNascimento(LocalDate.of(Integer.parseInt(parts[2]),Integer.parseInt(parts[1]),Integer.parseInt(parts[0])));
                            } else if (escolha.equals("4")) {
                                System.out.println("|--===Alterar Materia===--|");
                                for (Materia m: a.getListaDeMaterias()){
                                    System.out.println(m.getNome());
                                }
//                                System.out.println(a.getListaDeMaterias()); //codigo original
                                System.out.println("ESCOLHA A MATERIA");
                                String nomeMateria = scan.next().toUpperCase();
                                for (Materia m: a.getListaDeMaterias()){
                                    if (m.getNome().equals(nomeMateria)){
                                        System.out.println("|--===Materia Encontrada===--|");
                                        System.out.println("NOTA DA PRIMEIRA PROVA: ");
                                        m.setProva1(scan.nextByte());
                                        System.out.println("NOTA DA SEGUNDA PROVA: ");
                                        m.setProva2(scan.nextByte());
                                        System.out.println("NOTA DO TRABALHO: ");
                                        m.setTrabalho(scan.nextByte());
                                        System.out.println("NOTA DA TAREFA: ");
                                        m.setTarefa(scan.nextByte());
                                        System.out.println("|--===Materia Atualizada===--|");
                                        System.out.println(m);
                                    }else {
                                        System.out.println("|--===Materia Não Encontrada===--|");
                                    }
                                }

                            }else{
                                System.out.println("|--===OPÇÃO INVÁLIDA===--|");
                            }
                            alunoEncontrado = true;
                            break;
                        }
                    }
                    if (!alunoEncontrado){
                        System.out.println("|--===Aluno Não Encontrado===--|");
                    }
                }
            }
            //IF DELETE
            else if (option.equals("4")) {
                System.out.println(" _________________________");
                System.out.println("|---===Deletar Aluno===---|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                if (alunos.isEmpty()){
                    System.out.println("|--===NÃO HÁ ALUNOS PARA DELETAR===--|");
                }
                else {
                    System.out.println("ID DO ALUNO:");
                    int id = scan.nextInt();
                    boolean alunoEncontrado = false;
                    for (Aluno a:alunos){
                        if (id == a.getID()){
                            System.out.println(a);
                            alunoEncontrado = true;
                            alunos.remove(a);
                            break;
                        }
                    }
                    if (!alunoEncontrado){
                        System.out.println("|--===Aluno Não Encontrado===--|");
                    }
                }
            }
            //IF SAIR
            else if (option.equals("5")) {
                System.out.println(" _________________________");
                System.out.println("|------===SAINDO===------|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                break;
            }
            //ELSE OPÇÃO INVÁLIDA
            else {
                System.out.println(" _________________________");
                System.out.println("|--===OPÇÃO INVÁLIDA===--|");
                System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            }
        }
    }
}
