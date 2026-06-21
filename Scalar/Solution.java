package Scalar;

public class Solution {
    public static int solve(int A) {
int count =0;
    for(int i=1;i*i<=A ;i++)
    {

        if(A%i==0){

     if(i==A/i)
     {

         count=count+1;
     }else{

         count=count+2;
     }
        }

    }

    return count;
    }
    
    public static void main(String[] pra) {
    	
    	int result=0;
    	result=Solution.solve(36);
    	
    	System.out.println(result);
    	
    	
    }
    
    
}

