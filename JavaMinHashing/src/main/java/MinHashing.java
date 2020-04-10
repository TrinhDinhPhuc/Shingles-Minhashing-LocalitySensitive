
import java.util.HashMap;

public class MinHashing {
    static Integer numDocs = 1000;
    static String dataFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".train";
    static String truthFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".truth";
    static String current_Directory = System.getProperty("user.dir");

    public static void main(String[] args){
        //File Truth
        readAndHash truthF = new readAndHash();
        truthF.openFile(current_Directory+truthFile);
//        truthF.showFile();
        HashMap<String,String> a = truthF.hashToDict();
        System.out.println(a);

        //File data
//        read_file dataF = new read_file();
//        dataF.openFile(current_Directory+dataFile);
//        dataF.showFile();
    }
}
