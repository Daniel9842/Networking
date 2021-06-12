package edu.escuelaing.arsw.Networking;

import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.arsw.Networking.Calculator.EchoServerCalculator;
import edu.escuelaing.arsw.Networking.Square.EchoServerSquare;
import edu.escuelaing.arsw.Networking.Url.URLReader;
import edu.escuelaing.arsw.Networking.Url.URLScanner;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for networking.
 */
public class NetworkingTest 
    extends TestCase
{
	/**
	 * this test checks the square of a number
	 */
    public void testSquare() 
    {
    	EchoServerSquare serverSquare = new EchoServerSquare();
        assertEquals(serverSquare.calculateSquare("4"),"16.0");
     
    }
    /**
     * this test verifies the cos of a number
     */
    public void testCalculatorCos() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.makeOperation("fun:cos","0"),"1.0");
    }
    /**
     * this test verifies the function change in the calculator
     */
    public void testCalculatorChangeFunctionSin() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.calculateFunctions("fun:sin"),"Realizando cambio de operación");
    }
    /**
     * this test verifies the sin of a number
     */
    public void testCalculatorsin() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.makeOperation("fun:sin","0"),"0.0");
    }
    /**
     * this test verifies the function change in the calculator
     */
    public void testCalculatorChangeFunctionTan() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.calculateFunctions("fun:tan"),"Realizando cambio de operación");
    }
    /**
     * this test verifies the tan of a number
     */
    public void testCalculatorTan() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
    	double pi = Math.PI;
        assertEquals(serverCalculator.makeOperation("fun:tan","0"),"0.0");
    }
    /**
     * to verify this test you must verify that a result .html is created in the main folder of this project
     * @throws Exception
     */
    public void testURLReader() throws Exception 
    {
    	URLReader urlReader = new URLReader();
    	String[] array = {"http://www.google.com/"};
    	urlReader.main(array);
    }
    
    public void testURLScanner() throws Exception 
    {
    	URLScanner urlScanner = new URLScanner();
    	String[] array = {"http://ldbn.escuelaing.edu.co:80/publicaciones.pdf?val=456r=78#publicaciones"};
    	assertEquals("ref: http"
    	    	+"authority: ldbn.escuelaing.edu.co:80"
    	    	+"host: ldbn.escuelaing.edu.co"
    	    	+"port: 80"
    	    	+"path: /publicaciones.pdf"
    	    	+"query: val=456r=78"
    	    	+"file: /publicaciones.pdf?val=456r=78"
    	    	+"ref: publicaciones",urlScanner.MethodsValue(array[0]));
    	
    }
}
