package org.anasantana.repositories;

import org.anasantana.model.Aluno;
import org.anasantana.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    List<Aluno> findByTurma(Turma vespertino);
}
