import java.util.ArrayList;
import java.util.List;

public class Merge {

    public <T> List<T> mergesort(List<T> array) {
        List<T> buffer1 = new ArrayList<>();
        buffer1.addAll(array);
        List<T> buffer2 = new ArrayList<>();
        buffer2.addAll(array);
        List<T> result = mergesortInner(buffer1, buffer2, 0, array.size());
        return result;
    }

    public <T> List<T> mergesortInner(List<T> buffer1, List<T> buffer2,
                                       int startIndex, int endIndex) {

        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        List<T> sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        List<T> sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        List<T> result = sorted1 == buffer1 ? buffer2 : buffer1;

        while (index1 < middle && index2 < endIndex) {
            if (Sort.typeOfData.equals("-i")) {
                    result.set(destIndex++, (Long) sorted1.get(index1) < (Long) sorted2.get(index2)
                            ? sorted1.get(index1++) : sorted2.get(index2++));

            }
            if (Sort.typeOfData.equals("-s")) {

                String compare1 = (String) sorted1.get(index1);
                String compare2 = (String) sorted2.get(index2);

                result.set(destIndex++, (compare1.compareTo((compare2)) < 0
                        ? sorted1.get(index1++) : sorted2.get(index2++)));
            }
        }
        while (index1 < middle) {
            result.set(destIndex++, sorted1.get(index1++));
        }
        while (index2 < endIndex) {
            result.set(destIndex++, sorted2.get(index2++));
        }
        return result;
    }

}

