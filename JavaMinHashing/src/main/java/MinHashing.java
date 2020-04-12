import java.util.Collection;
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
        S1readAndHash truthF = new S1readAndHash();
        Scanner dataTruth = truthF.openFile(current_Directory+truthFile);
        HashMap<String,String> TruthFile = truthF.hashToDict(dataTruth);

        S1readAndHash dataF = new S1readAndHash();
        Scanner documents  = dataF.openFile(current_Directory+dataFile);

        S2docToShinglingSets objshingles = new S2docToShinglingSets();
        HashMap<String, Set<Long>> singlesSets = objshingles.DocsAsShingleSets(numDocs,documents);
        System.out.println(singlesSets.get("t963").size());
        System.out.println(singlesSets.get("t964").size());
        System.out.println(singlesSets.keySet().size());

//        System.out.println("Print out all keys");
//        Set<String> keys = singlesSets.keySet();
//        //print all the keys
//        for (String key : keys) {
//            System.out.println(key);
//        }

//        System.out.println("Print out all values");
//        Collection<Set<Long>> values = singlesSets.values();
//        values.forEach(value -> System.out.println(value));

//        writelog wl = new writelog();
//        wl.writeToAFile("log.txt",singlesSets.toString());

    }
}
