import sistemaEleitoral.*;
import org.junit.*;
import org.junit.Assert;

import static org.junit.Assert.*;


public class SistemaEleitoralTest {
    @BeforeClass
    public static void setUp(){

    }


    @Test
    public void testCadastro(){
        SistemaEleitoralInterface testCad = new SistemaEleitoralMap();
        assertTrue(testCad.cadastraEleitor("herbert","123"));
        assertTrue(testCad.cadastraCandidato("devertu",123,Partido.PARTIDO1));
        assertFalse(testCad.cadastraEleitor("herbert","123"));
        assertFalse(testCad.cadastraCandidato("devertu",123,Partido.PARTIDO1));
    }

    @Test
    public void testContarVotos(){
        SistemaEleitoralInterface testVot = new SistemaEleitoralMap();
        testVot.cadastraEleitor("herbert","123");
        assertThrows(TituloInexistenteException.class, () -> {
            testVot.votar("321",123);
        });
        try{
            testVot.votar("123",123);
            testVot.votar("123",123);
        }catch (TituloInexistenteException e){fail("não deveria lançar está exeção");}
        assertEquals(2,testVot.contarVotosParaCandidato(123));
    }

    @Test
    public void testDadosCand(){
        SistemaEleitoralInterface testDadoCand = new SistemaEleitoralMap();
        testDadoCand.cadastraCandidato("herbert",123,Partido.PARTIDO1);
        assertThrows(CandidatoInexistenteException.class, () -> {
            testDadoCand.obterDadosDoCandidato("devertu");
        });
        try{
            Candidato candtest = testDadoCand.obterDadosDoCandidato("herbert");
            assertEquals(123,candtest.getNumero());

        }catch(CandidatoInexistenteException e){
            fail("não deveria lançar está exeção");
        }
    }
}
