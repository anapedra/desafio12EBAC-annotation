package org.santana.annotation;

import org.anasantana.annotation.Tabela;
import org.anasantana.annotation.utils.TabelaUtils;
import org.anasantana.model.Aluno;
import org.anasantana.model.Turma;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class TabelaAnnotationTest {

    @Test
    public void deveRetornarNomeCustomizadoParaAluno() {
        String nomeTabela = TabelaUtils.getNomeTabela(Aluno.class);
        assertEquals("tb_aluno", nomeTabela, "A anotação personalizada deveria retornar 'tb_aluno'");
    }

    @Test
    public void deveRetornarNomePadraoParaTurma() {
        String nomeTabela = TabelaUtils.getNomeTabela(Turma.class);
        assertEquals("turma", nomeTabela, "A anotação personalizada deveria retornar o nome da classe 'turma'");
    }


}
