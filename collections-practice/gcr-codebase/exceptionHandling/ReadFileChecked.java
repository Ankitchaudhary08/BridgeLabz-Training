import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileChecked {
    public static void main(String[] args) {

        try{
            FileReader fr=new FileReader("data.txt");
            BufferedReader br=new BufferedReader(fr);
            String line;

            while ((line=br.readLine())!=null){
                System.out.println(line);
                
            }
        }
        catch(IOException ie){
            System.out.println("File not found");
        }

        
}
}