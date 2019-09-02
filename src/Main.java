
package projectAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) throws IOException {
             		 
		Text textReader = new Text("the_truman_show_script.txt");              // text class'ýnýn contructor'ý çaðrýldý.
		ArrayList<String> text = textReader.getArrayList();
		int d,tt;
	        
        
        Source source = new Source();
                        
        int userChoice;
        Scanner input = new Scanner(System.in);
   
        userChoice = menu();
        
     while(userChoice==1){
        	
        	System.out.println("Enter a pattern : ");
        	
        	
        	Scanner scanner = new Scanner(System.in);
        	
        	
        	String pattern = scanner.nextLine();
        	
        	
        	int n = pattern.length();
        	int m = text.toString().length();
        	
        	
        	long systemStartTimeString = System.nanoTime();
        	
         	d=source.bruteForceStringMatcher(pattern, text.toString()) ;
       	             	
        	long stringMatchingTime = System.nanoTime() - systemStartTimeString;
        	
        	if(d==-1) {
        		System.out.println("The pattern is not found!!" );
        		System.out.println("");
        	}        	
        	else {   	
        	System.out.println("Time for brute-force string matching : " + (float)stringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed : " + source.count);
    	    
        	break;	
        	}
        }
     
     
        
        while(userChoice==2){
        	
        	System.out.println("Enter a pattern : ");
        	
        	Scanner scanner = new Scanner(System.in);
        	
        	String pattern = scanner.nextLine();
        	
        	int n = pattern.length();
        	int m = text.toString().length();
        	
        	long systemStartTimeHorspool = System.nanoTime();
        	
        	tt=source.horspoolMatching(pattern.toCharArray(), text.toString().toCharArray());
        	
        	if(tt==-1) {
        		System.out.println("The pattern is not found!!" );
        		System.out.println("");
        	}
        	
        	else {
        
        	
        	long horlpoolstringMatchingTime = System.nanoTime() - systemStartTimeHorspool;
        	       	       	
        	System.out.println("Time for Harspool's string matching : " + (float)horlpoolstringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed : " + source.countt);
        	break;
        	}
        }
        
        while(userChoice==3){
        	
        	System.out.println("Enter a pattern : ");
        	
        	Scanner scanner = new Scanner(System.in);
        	
        	String pattern = scanner.nextLine();
        	
        	int n = pattern.length();
        	int m = text.toString().length();
        	
        	long systemStartTimeString = System.nanoTime();
        	
        	source.bruteForceStringMatcher(pattern, text.toString()) ;
        	
        	long stringMatchingTime = System.nanoTime() - systemStartTimeString;
        	
        	
            long systemStartTimeHorspool = System.nanoTime();
        	
        	source.horspoolMatching(pattern.toCharArray(), text.toString().toCharArray());
        	
        
        	
        	long horlpoolstringMatchingTime = System.nanoTime() - systemStartTimeHorspool;     	        	
        	
        	
        	       	       	
        	System.out.println("Time for brute-force string matching : " + (float)stringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed : " + source.count );
    	    System.out.println("");   	
        	System.out.println("Time for Harspool's string matching : " + (float)horlpoolstringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed : " + source.countt );
        	System.out.println("");
        	if(stringMatchingTime<horlpoolstringMatchingTime){
        		System.out.println("The execution time for brute-force string matching is smaller than the execution time for  Harspool's string matching");
        	}
        	else if(stringMatchingTime>horlpoolstringMatchingTime) {
        		System.out.println("The execution time for brute-force string matching is bigger than the execution time for  Harspool's string matching");        		
        	}
        	else{
        		System.out.println("The execution time for brute-force string matching is equal to the execution time for  Harspool's string matching");
        	}
        	System.out.println("");
        	break;	
        	
        }
        
        
        
        while(userChoice==4){
        	
        	long horlpoolstringMatchingTime=0;
        	long stringMatchingTime=0;
        	long sum1=0;
        	long sum2=0;
        	
        	for(int t=0 ; t<5; t++) {
        		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz?!,.";
            	String randomStr=generateRandom(chars);
            	System.out.println(randomStr);
        		
            	long systemStartTimeString = System.nanoTime();
            	
            	source.bruteForceStringMatcher(randomStr, text.toString()) ;
            	
            	stringMatchingTime = System.nanoTime() - systemStartTimeString;
            	
            	
                long systemStartTimeHorspool = System.nanoTime();
            	
            	source.horspoolMatching(randomStr.toCharArray(), text.toString().toCharArray());
            	
            
            	
            	horlpoolstringMatchingTime = System.nanoTime() - systemStartTimeHorspool; 
        	
        	int n = randomStr.length();
        	int m = text.toString().length();
        	
        	System.out.println("Time for brute-force string matching : " + (float)stringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed in avg case: " + source.count );
    	       	
        	System.out.println("Time for Harspool's string matching : " + (float)horlpoolstringMatchingTime / 1000000  + " ms");
        	System.out.println("Basic operation has been executed in avg case: " + source.countt );
        	
        	if(stringMatchingTime<horlpoolstringMatchingTime){
        		System.out.println("The execution time for brute-force string matching is smaller than the execution time for  Harspool's string matching");
        	}
        	else if(stringMatchingTime>horlpoolstringMatchingTime) {
        		System.out.println("The execution time for brute-force string matching is bigger than the execution time for  Harspool's string matching");        		
        	}
        	else{
        		System.out.println("The execution time for brute-force string matching is equal to the execution time for  Harspool's string matching");
        	}
        	sum1 += stringMatchingTime;
        	sum2 += horlpoolstringMatchingTime;
        	System.out.println("");
            
        	}
        	
        	
        	System.out.println("Average brute force string matching execution time : " + (float)sum1/100000000 + " ms");
        	System.out.println("Average Horlpool's string matching execution time : " + (float)sum2/100000000 + " ms");
        	
        	
        	if(sum1/3000000<sum2/3000000){
        		System.out.println("The average execution time for brute-force string matching is smaller than the average execution time for  Harspool's string matching");
        	}
        	else if(sum1/3000000>sum2/3000000) {
        		System.out.println("The average execution time for brute-force string matching is bigger than the average execution time for  Harspool's string matching");        		
        	}
        	else{
        		System.out.println("The average execution time for brute-force string matching is equal to the average execution time for  Harspool's string matching");
        	}
        	
        	


        	break;
        }
        
        while(userChoice==0){
        	System.exit(0);
        }
    }
	public static String generateRandom(String chars) throws IOException{
	    Random rand=new Random();
	    StringBuilder res=new StringBuilder();
	    
	    
	    int randomLen = 3+rand.nextInt(5);
	    for (int i = 0; i <randomLen; i++) {
	    	
	       int randIndex=rand.nextInt(chars.length()); 
	       res.append(chars.charAt(randIndex));            
	       
	    }
	    return res.toString();
	}
	
	public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);
        
        System.out.println("(1) Brute Force String Matching");
        System.out.println("(2) Harspool's String Matching");
        System.out.println("(3) Compare brute-force and Harspool's string matching algorithms");
        System.out.println("(4) Analyse the avg-case efficiencies of Brute-Force and Harspool's Algorithms");
        System.out.println("(0) Exit");

        selection = input.nextInt();
        return selection;
	}
}	
	
	



		
		
