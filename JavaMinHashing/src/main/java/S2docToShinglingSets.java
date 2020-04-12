import jdk.internal.util.xml.impl.Pair;

import java.util.*;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class S2docToShinglingSets {
    HashMap<String, Set<Long>> docsAsShingleSets = new HashMap<String, Set<Long>>();
    List<String> docNames = new ArrayList<String>();
    Integer totalShingles = 0;
    Integer shingleNo = 0;

    public List<String> hasNext (Scanner docs){
        return new ArrayList<String>(Arrays.asList(docs.nextLine().split("\\s")));
    }
    public static long crc32(String input) {
        byte[] bytes = input.getBytes();
        Checksum checksum = new CRC32(); // java.util.zip.CRC32
        checksum.update(bytes, 0, bytes.length);

        return checksum.getValue();
    }
    public HashMap<String, Set<Long>> DocsAsShingleSets (Integer numDocs, Scanner documents){
        for (int i = 0; i < numDocs; i++){
            //read all the words (they are all on one line) and splot then vt white space
            List<String>  words = hasNext(documents);
            String docID = words.get(0);
            docNames.add(docID);
            words.remove(0);

            /* 'shinglesInDoc' will hold all of the unique shingles
            IDS present in the current document. If a shingle ID
            occurs multiple times in the document, it will only appear
            once in the set -->  in pythonx
             */
            Set<Long> shinglesInDoc = new HashSet<Long>();

            //for each word in the document
            for (int index = 0; index<words.size()-2;index++){
                //construct the shingle text by combining three words together
                String shingle = words.get(index) + " " + words.get(index+1) + " " + words.get(index+2);

                //hash the shingle to 32-bit integer
                // Cyclic redundancy check crc32
                long crc = crc32(shingle);

                //add the hash value to the list of shingles for the current document.
                //Note that set object will add the value to the set if it doesnt contain it
                shinglesInDoc.add(crc);
                //after this step we will have a set of hash values of a unique word containing in each document
            }
            //store the completed list of shingles for this document in the dictionary
            docsAsShingleSets.put(docID,shinglesInDoc);

            //count the number of shingles across all documents
            totalShingles =  totalShingles + words.size()-2;
            System.out.println(docsAsShingleSets);
        }
        return docsAsShingleSets;
    }
}
