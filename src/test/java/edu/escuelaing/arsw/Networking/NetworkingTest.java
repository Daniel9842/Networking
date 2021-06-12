package edu.escuelaing.arsw.Networking;

import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.arsw.Networking.Calculator.EchoServerCalculator;
import edu.escuelaing.arsw.Networking.Square.EchoServerSquare;
import edu.escuelaing.arsw.Networking.Url.URLReader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for networking.
 */
public class NetworkingTest 
    extends TestCase
{
    public void testSquare() 
    {
    	EchoServerSquare serverSquare = new EchoServerSquare();
        assertEquals(serverSquare.calculateSquare("4"),"16.0");
     
    }
    
    public void testCalculatorCos() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.makeOperation("fun:cos","0"),"1.0");
    }
    
    public void testCalculatorChangeFunctionSin() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.calculateFunctions("fun:sin"),"Realizando cambio de operación");
    }
    
    public void testCalculatorsin() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.makeOperation("fun:sin","0"),"0.0");
    }
    
    public void testCalculatorChangeFunctionTan() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
        assertEquals(serverCalculator.calculateFunctions("fun:tan"),"Realizando cambio de operación");
    }
    
    public void testCalculatorTan() 
    {
    	EchoServerCalculator serverCalculator = new EchoServerCalculator();
    	double pi = Math.PI;
        assertEquals(serverCalculator.makeOperation("fun:tan","0"),"0.0");
    }
    
    public void testURLReader() throws Exception 
    {
    	URLReader urlReader = new URLReader();
    	String[] array = {"http://www.google.com/"};
    	urlReader.main(array);
    }
    
    
}
