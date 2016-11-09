package br.inf.ufg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;

import br.inf.ufg.*;

import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class AlgoritmosTest {
    Calcula calcula;

    @Before
    public void executaAntes() {
        calcula = new Calcula();
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void CheckExit0CodeTest() {
        String[] expr = new String[1]; 
        expr[0] = "5+5";
        exit.expectSystemExitWithStatus(0);
        calcula.main(expr);
    }

    @Test
    public void CheckExit1CodeTest() {
        String[] expr = new String[1]; 
        expr[0] =  "/zz.";
        exit.expectSystemExitWithStatus(1);
        calcula.main(expr);
    }
    
    
}
