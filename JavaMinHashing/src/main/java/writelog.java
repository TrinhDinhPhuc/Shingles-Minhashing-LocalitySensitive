import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writelog {
    public void create(String filename , String data){
        try {
            File obj = new File(filename);
            if (obj.createNewFile()){
                System.out.println("File created");
            }
            else {
                System.out.println("File already exist");
            }
        }
        catch (IOException e){
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

    public void writeToAFile(String filename, String data){
        try {
            FileWriter fr  = new FileWriter(filename);
            fr.write(data);
            fr.close();
            System.out.println("Successfully wrote to "+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
