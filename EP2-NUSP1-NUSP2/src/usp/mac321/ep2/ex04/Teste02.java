package usp.mac321.ep2.ex04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.*;
public class Teste02 {

    public final boolean R = false;
    public final boolean D = true;

    private String user = "src\\usp\\mac321\\ep2\\ex04\\constantInputs\\usuarios.csv";
    private String lancamentos = "src\\usp\\mac321\\ep2\\ex04\\constantInputs\\lancamentos.csv";
    private String despesas = "src\\usp\\mac321\\ep2\\ex04\\teste02\\inputs\\tiposDespesas02.csv";
    private String receitas = "src\\usp\\mac321\\ep2\\ex04\\teste02\\inputs\\tiposReceitas02.csv";
    private Gerenciador gerenciador;

    @BeforeEach
    public void setUp() {
        gerenciador = new Gerenciador(user, despesas, receitas, lancamentos);

    }

    @AfterEach
    public void tearDown() {
        gerenciador = null;
    }

    @Test
    public void testaRelatorioCompleto() throws IOException{
        gerenciador.printRelatorio("01/05/24", "06/05/24", "src\\usp\\mac321\\ep2\\ex04\\teste02\\outputs\\relatorioCompleto02.txt", true);
        
        File output = new File("src\\usp\\mac321\\ep2\\ex04\\teste02\\outputs\\relatorioCompleto02.txt");
        File expected = new File("src\\usp\\mac321\\ep2\\ex04\\teste02\\expected\\relatorioCompletoExpected02.txt");

        BufferedReader outputReader = new BufferedReader(new FileReader(output));
        BufferedReader expectedReader = new BufferedReader(new FileReader(expected));

        String outputLine;
        String expectedLine;

        while((outputLine = outputReader.readLine()) != null && (expectedLine = expectedReader.readLine()) != null){
            assertEquals(outputLine, expectedLine);
        }

        outputReader.close();
        expectedReader.close();
    }

    @Test
    public void testaRelatorioSimples() throws IOException{
        gerenciador.printRelatorio("01/05/24", "06/05/24", "src\\usp\\mac321\\ep2\\ex04\\teste02\\outputs\\relatorioSimples02.txt", false);
        
        File output = new File("src\\usp\\mac321\\ep2\\ex04\\teste02\\outputs\\relatorioSimples02.txt");
        File expected = new File("src\\usp\\mac321\\ep2\\ex04\\teste02\\expected\\relatorioSimplesExpected02.txt");

        BufferedReader outputReader = new BufferedReader(new FileReader(output));
        BufferedReader expectedReader = new BufferedReader(new FileReader(expected));

        String outputLine;
        String expectedLine;

        while((outputLine = outputReader.readLine()) != null && (expectedLine = expectedReader.readLine()) != null){
            assertEquals(outputLine, expectedLine);
        }

        outputReader.close();
        expectedReader.close();
    }
}
