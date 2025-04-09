package org.anasantana;

import org.anasantana.annotation.utils.TabelaUtils;
import org.anasantana.model.Aluno;
import org.anasantana.model.Turma;
import org.anasantana.repositories.AlunoRepository;
import org.anasantana.repositories.TurmaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;
    public Main(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        System.out.println("\nVerificando se os nomes das tabelas respondem às propostas das anotações customizadas:");
        System.out.println(TabelaUtils.getNomeTabela(Aluno.class));  // "tb_aluno"
        System.out.println(TabelaUtils.getNomeTabela(Turma.class)); // "turma"





    }

    @Override
    public void run(String... args) throws Exception {


       //Verificando os relacionamentos dessas tabelas,se respodem as anotações customizadas:
        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        Turma t1 = new Turma("Vespertino");
        Aluno a1 = new Aluno(t1, "Paulo");
        Aluno a2 = new Aluno(t1, "Maria");
        Aluno a3 = new Aluno(t1, "Sandro");
        Aluno a4 = new Aluno(t1, "Adriana");

        Turma t2 = new Turma("Noturno");
        Aluno a5 = new Aluno(t2, "Saulo");
        Aluno a6 = new Aluno(t2, "Faria");
        Aluno a7 = new Aluno(t2, "Fandro");
        Aluno a8 = new Aluno(t2, "Edriana");

        turmas.addAll(Arrays.asList(t1, t2));
        turmaRepository.saveAll(turmas);

        alunos.addAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8));
        alunoRepository.saveAll(alunos);


        for (Turma turma : turmas) {
            turma.alunosByTurma();
        }
    }
}