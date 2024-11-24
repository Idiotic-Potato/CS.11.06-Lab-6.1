import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class AdventureTime {



    public static void main(String[] args) throws IOException {

        String fileName = "testInputThreeFour.txt";
        int result = challengeThree(fileName);
        System.out.println("Number of measurements larger than the previous measurement: " + result);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
//        int[] data = readFile(fileName);
//        int count = 0;
//        for(int i = 1; i<data.length;i++){
//            if(data[i]>data[i-1]){
//                count++;}}
//        return count;
    return 0;}



            /** TODO 2
             *
             * Challenge 2
             *
             * @param fileName
             * @return Answer to Challenge 2
             * @throws FileNotFoundException
             */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] data = readFile(fileName);
        int count1 = 0;
        for (int i = 0; i < data.length - 3; i++) {
            int compare = data[i] + data[i + 1] + data[i + 2];
            int compare1 = data[i + 1] + data[i + 2] + data[i + 3];
            if (compare < compare1) {
                count1++;
            }
        }
        return count1;
    }







    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        char[][] data = readFileToCharArrays(fileName);
        int depth = 0;
        int horizontal = 0;
        for (int i = 0; i < data.length; i++) {
            char value = data[i][0];
            if (value == 'f') {
             horizontal = horizontal + data[i][8];
            }
            if (value == 'u'){
              depth = depth - data[i][3];
            }
            if(value=='d'){
                depth = depth + data[i][5];
            }
}
           return depth*horizontal;

        }






    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        return 0;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /**
     * This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
    public static char[][] readFileToCharArrays(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        char[][] data = new char[numberOfLinesInFile][];
        int index = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data[index++] = line.toCharArray();
            }
        }

        return data;
    }

}
