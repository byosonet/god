package com.rest.services.test;

/**
 *
 * @author User
 */
public class TestCase {
    
    
    
    public static void main (String args[]){
        fortest();
        
    }
    
    public static void fortest(){
    for(int i=0; i<20; methodFor(i++)){
 }
}
    
    public static void methodFor(int i){
         System.err.println(" -- Valor del Case: ");
        switch(i){
            case 1:
                System.err.println(" -- Case 1, sin break");
            case 2:
                System.err.println(" -- Case 2, sin break");
            case 3:
                System.err.println(" -- Case 3 con break");
                break;
            case 4:
                System.err.println(" -- Case 4 sin break");
            default:
                System.err.println(" -- No Aplica: "+i);
        }
    }
    
}
