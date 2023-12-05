import java.io.*;
import java.util.Scanner;

public class AdventureTime {
    public static int numberOfLines(String nameOfFile) throws FileNotFoundException {
        File openfile = new File(nameOfFile);
        Scanner readFile = new Scanner(openfile);
        int numOfLines = 0;
        while(readFile.hasNextLine()){
            numOfLines++;
            readFile.nextLine();
        }
        return numOfLines;
    }
    public static int[] readFileIntoArray (String nameOfFile) throws FileNotFoundException{
        int numOfLines = numberOfLines(nameOfFile);
        int[] fileToArray = new int[numOfLines];
        int count = 0;
        File openfile = new File(nameOfFile);
        Scanner readFile = new Scanner(openfile);
        while(readFile.hasNextLine()){
            fileToArray[count++] = readFile.nextInt();
        }
        return fileToArray;
    }

    public static String[] readFileIntoArrayStr (String nameOfFile) throws FileNotFoundException{
        int numOfLines = numberOfLines(nameOfFile);
        String[] fileToArray = new String[numOfLines];
        int count = 0;
        File openfile = new File(nameOfFile);
        Scanner readFile = new Scanner(openfile);
        while(readFile.hasNextLine()){
            fileToArray[count++] = readFile.nextLine();
        }
        return fileToArray;
    }
    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeFour("InputThreeFour.txt"));
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
        int[] fileArray = readFileIntoArray(fileName);
        int count = 0;
        for(int i = 1; i < fileArray.length; i++){
            if(fileArray[i] > fileArray[i-1]){
                count = count + 1;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] fileArray = readFileIntoArray(fileName);
        int count = 0;
        for(int i = 1; i < fileArray.length-2; i++){
            int sumOfLastThree = fileArray[i] + fileArray[i+1] + fileArray[i+2];
            int sumOfPreviousThree = fileArray[i-1] + fileArray[i] + fileArray[i+1];
            if(sumOfLastThree > sumOfPreviousThree){
                count = count + 1;
            }
        }
        return count;
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
        String[] fileArray = readFileIntoArrayStr(fileName);
        int horizontalPosition = 0;
        int horizontalDepth = 0;
        for (String s : fileArray) {
            if (s.contains("forward")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                horizontalPosition = horizontalPosition + castToInt;
            }
            if (s.contains("up")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                horizontalDepth = horizontalDepth - castToInt;
            }
            if (s.contains("down")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                horizontalDepth = horizontalDepth + castToInt;
            }
        }
        return horizontalDepth*horizontalPosition;
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
        String[] fileArray = readFileIntoArrayStr(filename);
        int horizontalPosition = 0;
        int horizontalDepth = 0;
        int aim = 0;
        for (String s : fileArray) {
            if (s.contains("forward")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                horizontalPosition = horizontalPosition + castToInt;
                horizontalDepth = horizontalDepth + aim * castToInt;
            }
            if (s.contains("up")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                aim = aim - castToInt;
            }
            if (s.contains("down")) {
                int castToInt = Integer.parseInt(s.substring(s.length() - 1));
                aim = aim + castToInt;
            }
        }
        return horizontalDepth*horizontalPosition;
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

    /** This method will read the values in inputFilename into an array of integers, which it will return.
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

}