import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MinHashing {
    static Integer numDocs = 1000;
    static String dataFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".train";
    static String truthFile = "/../MinHash/data/articles_" + String.valueOf(numDocs) + ".truth";
    static String current_Directory = System.getProperty("user.dir");

    public static void main(String[] args){
        //File Truth
        readAndHash truthF = new readAndHash();
        Scanner dataTruth = truthF.openFile(current_Directory+truthFile);
        HashMap<String,String> a = truthF.hashToDict(dataTruth);
//        System.out.println(a);

        readAndHash dataF = new readAndHash();
        Scanner documents  = dataF.openFile(current_Directory+dataFile);
//        dataF.showFile(documents);
        docToShinglingSets objshingles = new docToShinglingSets();
        HashMap<String, Set<Long>> singlesSets = objshingles.DocsAsShingleSets(numDocs,documents);
        writelog wl = new writelog();
        wl.writeToAFile("log.txt",singlesSets.toString());

    }
}
