
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class StudentScore {
    public static void main(String[] args){
          int count=0;
        String filePath = "C:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\CSVDataHandling\\Student.csv";
        try(BufferedReader br=new BufferedReader(new FileReader((filePath)))){
            br.readLine();
              String line;
            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                int marks=Integer.parseInt(data[3]);
                if(marks>80){
                    System.out.println("ID    : " + data[0]);
                    System.out.println("Name  : " + data[1]);
                    System.out.println("Age   : " + data[2]);
                    System.out.println("Marks : " + data[3]);
                    System.out.println("--------------------");
                }
               
            }
            


        }
        catch(IOException e){
            e.printStackTrace();

        }
        
    }
    
}
