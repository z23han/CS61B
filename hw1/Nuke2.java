/* 
 *  reads a string from the keyboard and prints the same string, with 
 *  its second character removed
 * */
import java.io.*;


public class Nuke2 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));
        inputLine = keyboard.readLine();
        
        if (inputLine.length() <= 2) {
            System.out.println(inputLine);
            
        } else {
            
            String newString = inputLine.substring(0, 1) + inputLine.substring(2);
            System.out.println(newString);
        }
    }
}
