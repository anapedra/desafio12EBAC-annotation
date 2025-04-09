package org.anasantana.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Anotação para definir o nome da tabela associada a uma entidade.
 * Se nenhum nome for fornecido, o nome da classe será usado por padrão.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tabela {
    String nome() default "";
}
