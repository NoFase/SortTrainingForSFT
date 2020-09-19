import java.util.Arrays;

public class CheckerParameters {
    private String sortMode;
    private String typeOfData;
    private String outFileName;
    private String[] inFileNames;

    public CheckerParameters(String[] inputParameters) {
//      инициализация переменных из вводных данных
        sortMode = findingSortMode(inputParameters[0]);
//      поправка на не обязательный параметр
        int n = (sortMode.equals("a0")) ? 0 : 1;

        typeOfData = inputParameters[0 + n];
        outFileName = inputParameters[1 + n];

        inFileNames = Arrays.copyOfRange(inputParameters, 2 + n, inputParameters.length);
    }

    public Boolean checkingForCorrect(){
        return   ((sortMode.equals("a") || sortMode.equals("d") || sortMode.equals("a0"))
                && (typeOfData.equals("-s") || typeOfData.equals("-i")))
                ? true : false;
    }

    private String findingSortMode(String string) {
        if (string.equals("-d")) return "d";
        else if (string.equals("-a")) return "a";
        else return "a0";
    }

    public String getSortMode() {
        return sortMode;
    }

    public String getTypeOfData() {
        return typeOfData;
    }

    public String getOutFileName() {
        return outFileName;
    }

    public String[] getInFileNames() {
        return inFileNames;
    }
}
