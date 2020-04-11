import java.util.*;

public class docToShinglingSets {
    HashMap<String,String> docsAsShingleSets = new HashMap<String, String>();
    List<String> docNames = new ArrayList<String>();
    Integer totalShingles = 0;
    Integer shingleNo = 0;

    public List<String> hasNext (Scanner docs){
        return new ArrayList<String>(Arrays.asList(docs.nextLine().split("\\s")));
    }

    public HashMap<String,String> DocsAsShingleSets (Integer numDocs, Scanner documents){
        for (int i = 0; i < numDocs; i++){
            //read all the words (they are all on one line) and splot then vt white space
            List<String>  words = hasNext(documents);
            String docID = words.get(0);
            docNames.add(docID);
            words.remove(0);

            
        }
        return docsAsShingleSets;
    }
}
