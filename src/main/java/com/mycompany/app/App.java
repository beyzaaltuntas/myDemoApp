package com.mycompany.app;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public static boolean control(ArrayList<Integer> array1, Integer[] array2,int index1, int index2) {
        	    	if (array1 == null) return false;
        	    	if (array2 == null) return false;
        	    	
        	    	if(array1.isEmpty() || array2.length==0)
                 			return false;
        	    	
        	    	if( index1<0 || index2<0 ||index2<index1 || index1>=array1.size() || index2>=array1.size() ||  index1>=array2.length ||index2>=array2.length  )
        	    		return false;
        	    	
        	    	for(int i=index1; i<=index2; i++){
        	    		if(array2[i].intValue()!=array1.get(i))
        	    			return false;
        	    	}
        	    	
        	    	return true;
        	      }
    
}
