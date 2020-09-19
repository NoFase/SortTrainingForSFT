import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReaderFromFile {

    private String fileName;

    public ReaderFromFile(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> reading() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(Paths.get("").toAbsolutePath().toString() +"\\" + fileName))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%s The specified file cannot be found.\n", (Paths.get("")
                    .toAbsolutePath().toString() +"\\" + fileName));
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}