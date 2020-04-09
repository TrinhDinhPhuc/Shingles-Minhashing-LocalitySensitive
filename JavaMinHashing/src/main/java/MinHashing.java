
import java.util.HashMap;

public class MinHashing {
//    String dataFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".train";
//    String truthFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".truth";
//    String current_Directory = System.getProperty("user.dir");

    public static void main(String[] args){
        Integer numDocs = 1000;
        String dataFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".train";
        String truthFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".truth";
        String current_Directory = System.getProperty("user.dir");

        //File Truth
        read_file truthF = new read_file();
        truthF.openFile(current_Directory+truthFile);
//        truthF.showFile();//doi vi tri xuong duoi thi lai ko doc dc
        HashMap<String,String> a = truthF.hashToDict();
        System.out.println(a);

        //File data
        read_file dataF = new read_file();
        dataF.openFile(current_Directory+dataFile);
        dataF.showFile();
    }
}
