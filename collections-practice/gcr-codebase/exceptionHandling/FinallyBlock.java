import java.util.*;
public class FinallyBlock {
    public static void main(String[] args){
        try{
            int a=10/0;
            System.out.println("Value of a: "+a);
        }
        catch(ArithmeticException ae){
            System.out.println("Cannot divide by zero"+ae.getMessage());
        }

        finally{
            System.out.println("Finally block executed");
        }

    }
    
}
