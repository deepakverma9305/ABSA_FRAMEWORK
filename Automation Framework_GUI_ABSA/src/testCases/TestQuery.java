package testCases;

import java.io.IOException;

public class TestQuery {
	

	
	public static void main(String[] args) throws IOException {
		
		
		
		int s= generalFunctions.Functions.GetRAOFiles();
		
		
		
	    for (int i = 0; i < s; i++)
	    
	    
	    {
	    	String filename= generalFunctions.Functions.FileName[i];
	    	
	    	generalFunctions.Functions.copyRAOFileUsingStream(filename);
	    	
	    	generalFunctions.Functions.Wait(10000);


	    }
}}

   
	
	
	
	
	
	
	
	
	
	
	
	
	

