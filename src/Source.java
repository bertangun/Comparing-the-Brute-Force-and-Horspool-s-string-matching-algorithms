package projectAnalysis;

import java.util.ArrayList;

public class Source {
	
	int count=0;
	int countt=0;
	 
	 
	public int bruteForceStringMatcher(String pattern ,String text)   
    {
		int m = pattern.length();
        int n = text.length();
        int j;
        
			for(int i = 0 ; i<n-m+1 ; i++) {
				 j=0;
				while(j<m && pattern.toCharArray()[j]==text.toCharArray()[i+j]) {
					j=j+1;
					count++;
				}
					
			    if(j==m)
				return i;
			    
		   }
		   return -1; // pattern bulunamadý.
    }
	
	int table[] = new int[256];
	int size = table.length ;
				
	public int[] shifttable(char [] pattern) {
		
					
		int m=pattern.length ;
		
		for(int i = 0 ; i < size; i++)
			table[i] = m ;
		for(int j = 0 ; j < m-1; j++)
			table[pattern[j]]=m-1-j;
		return table;
		
	}
	
	public int horspoolMatching(char [] pattern , char [] text) {
		
		int m = pattern.length;
		int n = text.length;
		
		
		shifttable(pattern);
		
		int i = m-1;
		while(i <= n-1) {
			int k = 0;
			while(k <=m-1 && pattern[m-1-k]==text[i-k]){
				k = k+1 ;
				countt++;
				
			}
			if(k == m){
				return i-m+1 ;
				
				
			}
			else{
				i = i+table[text[i]];
				
			}
		}
		return -1;
		
			
	}
	
	
	
		
		
		
	
}