import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreatorOfList <T> {
    private String fileName;
    private List<T> list;
    private List<String> rawList;

    public CreatorOfList(String fileName) {
        this.fileName = fileName;
    }

    public void readFromFile() {
        ReaderFromFile reader = new ReaderFromFile(fileName);
        rawList = reader.reading();
        initCollection();
    }

    private void initCollection() {
        list = new ArrayList<>();
        if ((Sort.typeOfData.equals("-s"))) {
            list.addAll((Collection<? extends T>) rawList);
        }
        else{
            list.addAll((Collection<? extends T>) parsing());
        }
    }

    private List<Long> parsing() {
        List<Long> longList = new ArrayList<>();
        int n = 0;
        try {
            for (int i = 0; i < rawList.size(); i++) {
                n = i;
                longList.add(Long.parseLong(rawList.get(i)));
            }
        } catch (NumberFormatException e) {
            System.out.printf("In the %s file, the %d line has an invalid value - \"%s\"\n",
                    fileName, n, rawList.get(n));
            rawList.remove(n);
            e.printStackTrace();
            initCollection();
        }
        return longList;
    }

    public List<T> getList() {
        return list;
    }
}
