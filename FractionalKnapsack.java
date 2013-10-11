
//package line only needed by netbeans
//package fractionalknapsack;
import java.text.*;

/*
 * @author nickcarlson
 */

public class FractionalKnapsack {

    public static void main(String[] args) {
        //these calls initialize test data and feed it into the fillKnapsack method
        testdataA();
        testdataB();
        testdataC();
        testdataD();
        testdataE();
        testdataF();
        
    }
    
    //testdataA: first set of test data
    public static void testdataA(){
        int n = 5;
        int[] cost = {12,1,2,1,4};
        int[] val = {4,3,3,2,10};
        int S = 16;
        
        System.out.println("Test A: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //testdataB: second set of test data
    public static void testdataB(){
        int n = 5;
        int[] cost = {12,1,2,1,4};
        int[] val = {4,3,3,2,10};
        int S = 20;
        
        System.out.println("");
        System.out.println("Test B: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //testdataC: third set of test data
    public static void testdataC(){
        int n = 5;
        int[] cost = {15,3,2,6,4};
        int[] val = {4,5,3,3,10};
        int S = 28;
        
        System.out.println("");
        System.out.println("Test C: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //testdataD: fourth set of test data
    public static void testdataD(){
        int n = 5;
        int[] cost = {15,3,2,6,4};
        int[] val = {4,5,3,3,10};
        int S = 30;
        
        System.out.println("");
        System.out.println("Test D: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //testdataD: fifth set of test data
    public static void testdataE(){
        int n = 10;
        int[] cost = {15,3,2,10,5,20,2,3,3,2};
        int[] val = {4,2,3,1,10,20,5,7,2,8};
        int S = 50;
        
        System.out.println("");
        System.out.println("Test E: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //testdataD: fifth set of test data
    public static void testdataF(){
        int n = 10;
        int[] cost = {15,3,2,6,4,10,2,3,3,2};
        int[] val = {4,2,3,1,10,20,5,7,2,8};
        int S = 50;
        
        System.out.println("");
        System.out.println("Test F: ");
        System.out.println("This knapsack has " + S + " units of space.");
        long startTime = System.nanoTime();
        fillKnapsack(n,cost,val,S);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        System.out.println("The knapsack was filled in " + elapsedTime + " milliseconds.");
    }
    
    //fillKnapsack: accepts number of materials, costs and values of materials, and size of knapsack ;
    //  then calculates the most valuable material based on a ratio of value/cost and
    //  adds materials to the knapsack in descending order of value/cost ratio until the final material
    //  is added either entirely of partially
    public static void fillKnapsack(int n, int[] cost, int[] val, int S){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString;
        int cur_space;
        int max_item;
        double temp;                //used later to hold percent before rounding
        double fractionalPercent;   //used later to hold rounded percent
        int[] inserted = new int[10];   //keeps track of which items have already been inserted
        double total_val = 0.0;
        
        //initialize entire array to zeroes
        //later, use 1's to mark inserted materials
        for(int i=0; i < n; i++){
            inserted[i] = 0;
        }
        
        cur_space = S;
        
        //while bag not full
        while(cur_space > 0){
            //flag best ratio as undetermined
            max_item = -1;
            
            //if current material hasn't been inserted and either val/cost ratio is better than
            //  current best or best is undetermined, then use current material as best ratio
            for(int i=0; i < n; i++){
                if((inserted[i] == 0) && ((max_item == -1) || 
                        ((double)val[i]/cost[i] > (double)val[max_item]/cost[max_item]))){
                    max_item = i;
                }
            }
            
            //mark current best as inserted
            inserted[max_item] = 1;
            //update amount of space remaining in knapsack
            cur_space -= cost[max_item];
            //update total value of materials in knapsack
            total_val += val[max_item];
            
            //if not last material being added to knapsack or knapsack is exactly full
            if(cur_space >= 0){
                System.out.println("Added material " + (max_item + 1) +  " [$" + val[max_item] + ", " + cost[max_item] + " unit(s)] completely. " + cur_space + " units of space left in the knapsack.");
            }else{
                //if last material is being partially added to knapsack
                temp = (1 + (double)cur_space/cost[max_item])*100;
                fractionalPercent = Math.round(temp);
                System.out.println("Added " + fractionalPercent +  "% of material " + (max_item + 1) + " [$" + val[max_item] + ", " + cost[max_item] + " units] to the knapsack.");
                total_val -= val[max_item];
                total_val += (1 + (double)cur_space/cost[max_item])*val[max_item];
            }
            
        }
        //when knapsack is full
        moneyString = formatter.format(total_val);
        System.out.println("Filled the knapsack with materials worth " + moneyString);
        if(cur_space == 0){
            System.out.println("There are no partial materials in this knapsack.");
        }
    }
}
