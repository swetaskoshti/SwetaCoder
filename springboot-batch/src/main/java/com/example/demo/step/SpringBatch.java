package com.example.demo.step;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpringBatch {
		
	//to encrypt text
	 public static String encrypt(String text) 
	    { 
	      	int s= 2;
		 	StringBuffer result= new StringBuffer(); 
	        for (int i=0; i<text.length(); i++) 
	        { 
	            if (Character.isUpperCase(text.charAt(i))) 
	            { 
	                char ch = (char)(((int)text.charAt(i) +   s - 65) % 26 + 65); 
	                result.append(ch); 
	            } 
	            else
	            { 
	                char ch = (char)(((int)text.charAt(i) +   s - 97) % 26 + 97); 
	                result.append(ch); 
	            } 
	        } 
	        return result.toString(); 
	      //  int decipher = 26 -s +s; 
	      //  System.out.println("Decipher: " + encrypt(text, decipher
	    } 
		
	public static void main(String[] args) throws IOException {
		//to get user input
		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ins);
		System.out.println("Enter path of Original File : ");
		String path = br.readLine();
		System.out.println("Enter no of threads : ");
		String threads = br.readLine();
		int no_of_threads = Integer.parseInt(threads);
		
		//initializing all the variables to create a filename
		 Path p = Paths.get(path);
	 	 String path1 = p.getFileName().toString();
		 String[] fileName1 = path1.split("[.]");
		 String part1 = fileName1[0];
		 String directory =p.getParent().toString();
		 String line = null;
 		 int line_in_file=0;
		//to get the no of lines in a file
		br = new BufferedReader(new FileReader(path));  
		while((line=br.readLine())!=null)    //Reading Content from the file line by line
		{
			line_in_file++;               //For each line increment linecount by one 
		}
		br.close();
	    int readline = line_in_file/no_of_threads;
		int no_to_read = readline;
		        		String filename = directory+"/"+part1 + "001.txt";
		                try {
							BufferedReader br1 = new BufferedReader(new FileReader(path));//Creation of File Reader object
							List<String> arraylist = new ArrayList<String>();
								Thread[] threads1 = new Thread[no_of_threads];
								for (int i = 0; i < threads1.length; i++) {
									Integer innerReadline = new Integer(readline);
								     threads1[i] = new Thread(new Runnable() {
								     public void run() {
								    	 int numLinesBreak = 1;
								    	 String line1 = null;
								    	 while(numLinesBreak <= innerReadline) {
								    		 try {
								    			 line1 = br1.readLine();
								    		 } catch (IOException e) {
								    			 e.printStackTrace();
								    		 }
								    		 if(line1 !=null) {
								    			// System.out.println(line1);
								    			 arraylist.add(line1);
								    		 }
								    		 numLinesBreak++;
								    	 } 
								    	 }
						         });
						     threads1[i].start();
						     }//for for thread ends	
								for (int i = 0; i < threads1.length; i++) {
									threads1[i].join();
							    }
		    				readline = readline+no_to_read;
		    				FileWriter fw = new FileWriter(filename);
		    				for (int counter = 0; counter < arraylist.size(); counter++) { 
		    					 String str = arraylist.get(counter).toString();
		    					 String encryptStr = encrypt(str);
		    			         fw.write(encryptStr);
		    			         fw.write("\n");
		    			      }  
		    				fw.close();
		    				br.close();
		    				arraylist.clear();
		                }//try ends
		                catch(Exception e) {
		                	e.printStackTrace();
		                }
}//main ends
}//class ends