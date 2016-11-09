/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */
package br.inf.ufg;

import java.util.List;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import com.github.kyriosdata.parser.Lexer;

/**
 * Implementação do algoritmo Calcular.
 *
 * Algoritmo implementado para aula de Construção
 * de software e se utiliza da biblioteca parser.
 *
 */
public class Calcula {
    /**
     * @param expr expressao de calculo
     * @return valor da expressao
     */
     public final float calculaValor(final String expr) {
        Expressao expressao = exprPara(expr);
        return expressao.valor();
     }
    /**
     * @param expressao expressao para calculo
     * @return expressao
     */
     private Expressao exprPara(final String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
     }

     /**
     * @param expr
     * expressao a ser executada
     */
    public final void executa(final String expr) {
       try {
           float valor = calculaValor(expr);
           System.out.println(valor);
           System.exit(0);
       } catch (IllegalArgumentException ex) {
           System.out.print(ex.getMessage());
           System.exit(1);
       }
    }
    /**
     *
     * @param args
     * parametros usados para calculo
     */
    public static void main(final String[]args) {
       if (args.length > 0) {
       String expr = args[0];
       Calcula calcula = new Calcula();
       calcula.executa(expr);
     }
   }
}
