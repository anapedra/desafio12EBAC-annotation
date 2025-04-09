package org.anasantana.model;

import jakarta.persistence.*;
import org.anasantana.annotation.Tabela;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Tabela
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @OneToMany(mappedBy = "turma", fetch = FetchType.EAGER)
    private final Set<Aluno> alunos = new TreeSet<>();

    public Turma() {
    }

    public Turma(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void alunosByTurma(){
        String name = " ";
        for (Aluno aluno : alunos){
            name = aluno.getName();
            System.out.println("Aluno: "+ name + "Turma: "+ description +"\n");
        }

    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
