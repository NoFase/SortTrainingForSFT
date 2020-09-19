import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreReader {

    public <T> List<T> optimalReading(String[] fileNames) {
            List<T> array1;
            List<T> array2;
            List<T> sumArrayes;

        Merge merge = new Merge();
        int mid = fileNames.length / 2;
        if (fileNames.length == 0) {
            return null;
        }

        if (fileNames.length <= 2){

            CreatorOfList creatorOfListArray1 = new CreatorOfList(fileNames[0]);
            creatorOfListArray1.readFromFile();
            array1 = (List<T>) creatorOfListArray1.getList();
            if (fileNames.length != 1) {
                CreatorOfList creatorOfListArray2 = new CreatorOfList(fileNames[1]);
                creatorOfListArray2.readFromFile();
                array2 = (List<T>) creatorOfListArray2.getList();
                sumArrayes = new ArrayList<T>(array1.size()+array2.size());
                sumArrayes.addAll(array1);
                sumArrayes.addAll(array2);
            } else {
                sumArrayes = new ArrayList<T>(array1.size());
                sumArrayes.addAll(array1);
            }
            return merge.mergesort(sumArrayes);
        }

        String[] left = Arrays.copyOfRange(fileNames, 0, mid);
        String[] right = Arrays.copyOfRange(fileNames, mid, fileNames.length );

        array1 = new ArrayList<T>();
        array1.addAll(optimalReading(left));
        array2 = new ArrayList<T>();
        array2.addAll(optimalReading(right));

        if (array2 != null) {
            sumArrayes = new ArrayList<T>(array1.size() + array2.size());
            sumArrayes.addAll(array1);
            sumArrayes.addAll(array2);
        } else {
            sumArrayes = new ArrayList<T>(array1.size());
            sumArrayes.addAll(array1);
        }
        return merge.mergesort(sumArrayes);
    }
}
