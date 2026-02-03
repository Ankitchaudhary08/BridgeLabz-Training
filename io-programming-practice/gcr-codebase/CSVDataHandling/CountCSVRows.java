import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class CountCSVRows {
    public static void main(String[] args){
          int count=0;
        String filePath = "C:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\CSVDataHandling\\Student.csv";
        try(BufferedReader br=new BufferedReader(new FileReader((filePath)))){
            br.readLine();

            while(br.readLine()!=null){
               count++;
            }
            System.out.println(count);


        }
        catch(IOException e){
            e.printStackTrace();

        }
        
    }
    
}
