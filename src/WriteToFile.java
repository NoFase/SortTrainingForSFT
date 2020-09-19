import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    private String fileName;
    private String sortMode;

    public WriteToFile(String fileName, String sortMode) {
        this.fileName = fileName;
        this.sortMode = sortMode;
    }

    public <T> void resultWriting(List<T> result){
        try {
            FileWriter wr = new FileWriter(fileName);
            if (sortMode.equals("a") || sortMode.equals("a0")){
                for (T l : result){
                    wr.write(l + "\n");
                }
            } else {
                for (int i = result.size() - 1; i >= 0 ; i--) {
                    wr.write(result.get(i) + "\n");
                }
            }
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
