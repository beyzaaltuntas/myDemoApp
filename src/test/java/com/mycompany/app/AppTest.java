package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testIndex1NotCorrect() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        	    	Integer[] array2 = new Integer[]{2,3,4};
        	       assertFalse(new App().control(array1, array2, -1 ,2));
        	      }
        	    
        	    public void testIndex2NotCorrect() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        	    	Integer[] array2 = new Integer[]{2,3,4};
        	       assertFalse(new App().control(array1, array2, 1 ,-2));
        	      }
        	    
        	    public void testIndex2LessThanIndex1() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        	    	Integer[] array2 = new Integer[]{2,3,4};
        	       assertFalse(new App().control(array1, array2, 1 ,0));
        	      }
        	    
        	    public void testIndex1GreaterThanArray1Size() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3 ,4));
        	    	Integer[] array2 = new Integer[]{2,3,4,5,6};
        	       assertFalse(new App().control(array1, array2, 3 ,4));
        	      }
        	    
        	    public void testIndex2GreaterThanArray1Size() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3));
        	    	Integer[] array2 = new Integer[]{2,3,4,5};
        	       assertFalse(new App().control(array1, array2, 1 ,3));
        	      }
        	    
        	    public void testIndex1GreaterThanArray2Size() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3,4,5,6,7 ));
        	    	Integer[] array2 = new Integer[]{2,3,5};
        	       assertFalse(new App().control(array1, array2, 3 ,5));
        	      }
        	    
        	    public void testIndex2GreaterThanArray2Size() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3,4,5,6));
        	    	Integer[] array2 = new Integer[]{2,3,4,5};
        	       assertFalse(new App().control(array1, array2, 1 ,4));
        	      }
        	    
        	    public void testFound() {
        	    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        	    	Integer[] array2 = new Integer[]{2,3,4};
        	       assertTrue(new App().control(array1, array2, 1 ,2));
        	      }
        	    
        	      public void testNotFound() {
        	    	  ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        		    	Integer[] array2 = new Integer[]{2,3,4};
        		       assertFalse(new App().control(array1, array2, 1 ,2));
        	      }
        	      
        	      public void testEmptyArray1() {
        	    	  ArrayList<Integer> array1 = new ArrayList<>();
        	    	  Integer[] array2 = new Integer[]{2,3,4};
        	          assertFalse(new App().control(array1, array2, 1 ,2));
        		   }
        	      public void testEmptyArray2() {
        	    	  ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        	    	  Integer[] array2 = new Integer[]{};
        	          assertFalse(new App().control(array1,array2, 1 ,2));
        		        }
        		     
        	      public void testNull1() {
        	    	 Integer[] array2 = new Integer[]{2,3,4};
        	        assertFalse(new App().control(null,array2, 1 ,2));
        	      }
        	      
        	      public void testNull2() {
        		   	 ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        		      assertFalse(new App().control(array1,null,1,2));
        		   }
}
