package org.santana.annotation;

import org.anasantana.Main;
import org.anasantana.model.Aluno;
import org.anasantana.model.Turma;

import org.anasantana.repositories.AlunoRepository;
import org.anasantana.repositories.TurmaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Main.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RelacionamentoJpaTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Test
    @DisplayName("Deve persistir turmas e alunos associados corretamente")
    void devePersistirRelacionamentoTurmaAluno() {
        Turma vespertino = new Turma("Vespertino");
        Turma noturno = new Turma("Noturno");

        turmaRepository.saveAll(List.of(vespertino, noturno));

        Aluno a1 = new Aluno(vespertino, "Paulo");
        Aluno a2 = new Aluno(vespertino, "Maria");
        Aluno a3 = new Aluno(noturno, "Saulo");
        Aluno a4 = new Aluno(noturno, "Faria");

        alunoRepository.saveAll(List.of(a1, a2, a3, a4));

        List<Aluno> alunosVespertino = alunoRepository.findByTurma(vespertino);
        List<Aluno> alunosNoturno = alunoRepository.findByTurma(noturno);

        assertThat(alunosVespertino).extracting(Aluno::getName)
                .containsExactlyInAnyOrder("Paulo", "Maria");

        assertThat(alunosNoturno).extracting(Aluno::getName)
                .containsExactlyInAnyOrder("Saulo", "Faria");

        // Verificando o relacionamento reverso
        Turma turmaVespertinoComAlunos = turmaRepository.findById(vespertino.getId()).orElseThrow();
        assertThat(turmaVespertinoComAlunos.getAlunos())
                .extracting(Aluno::getName)
                .containsExactlyInAnyOrder("Paulo", "Maria");
    }
}
