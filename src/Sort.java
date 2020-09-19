import java.util.List;

public class Sort {

    static String typeOfData;

    public static void main(String[] args) {

        CheckerParameters checkerParameters = new CheckerParameters(args);
        if (checkerParameters.checkingForCorrect()) {

            typeOfData = checkerParameters.getTypeOfData();

            PreReader preReader = new PreReader();
            WriteToFile writeToFile = new WriteToFile(checkerParameters.getOutFileName(), checkerParameters.getSortMode());

            if (typeOfData.equals("-i")) {
                List<Long> result = preReader.optimalReading(checkerParameters.getInFileNames());
                writeToFile.resultWriting(result);
            } else {
                List<String> result = preReader.optimalReading(checkerParameters.getInFileNames());
                writeToFile.resultWriting(result);
            }
        } else {
            System.out.println("The parameters entered at the start of the program are incorrect.");
        }

        System.out.println("Program finished!");
    }
}
