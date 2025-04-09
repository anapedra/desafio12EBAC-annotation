package org.anasantana.annotation.utils;

import org.anasantana.annotation.Tabela;

public class TabelaUtils {
    public static String getNomeTabela(Class<?> clazz) {
        Tabela anotacao = clazz.getAnnotation(Tabela.class);
        if (anotacao != null && !anotacao.nome().isEmpty()) {
            return anotacao.nome();
        }
        return clazz.getSimpleName().toLowerCase();
    }
}
