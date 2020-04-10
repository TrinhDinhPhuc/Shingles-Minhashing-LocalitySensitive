import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class readAndHash {
    private Scanner x;
    public void openFile(String fileName){
        try {
            x = new Scanner(new File(fileName));
        }
        catch (Exception e){
            System.out.println("Could not find file");
        }
    }
    public void showFile(){
        while (x.hasNextLine())
            System.out.println(x.nextLine());
    }

    public HashMap<String, String> hashToDict(){
        String temp = "";
        HashMap<String,String> hashMap = new HashMap<String, String>();
        List<String> myList = new ArrayList<String>();
        while (x.hasNextLine())
            myList.add(x.nextLine());
        for (String s : myList) {
            String part1 = String.valueOf(s.split(" ")[0]);
            String part2 = String.valueOf(s.split(" ")[1]);
            hashMap.put(part1, part2);
            hashMap.put(part2, part1);
        }
        return hashMap;
    }
}
