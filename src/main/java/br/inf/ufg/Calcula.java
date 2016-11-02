package br.inf.ufg;

import java.util.List;

import com.github.kyriosdata.parser.*;
public class Calcula {
    public float calculaValor(String expr){
	    Expressao expressao = exprPara(expr);
		return expressao.valor();
	}
	private Expressao exprPara(String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
	}

    public void executa(String expr){
	  if(expr ==null){
		    System.out.println("Informe a expressão");
	  }
	  try{
	      float valor = calculaValor(expr);
	      System.out.println(valor);
	      System.exit(0);
	  }catch (IllegalArgumentException ex){
	      System.out.print(ex.getMessage());
	      System.exit(1);
	  }
    }
    public static void main(String []args){
       if(args.length>0){
       String expr = args[0];
       Calcula calcula = new Calcula();
       calcula.executa(expr);
       
	}}
	
}
