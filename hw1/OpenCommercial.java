/* OpenCommercial.java */

import java.net.*;
import java.io.*;
import java.util.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    /* Replace this comment with your solution.  */
    int count = 0;
    
    try {
        URL webUrl = new URL("http://www."+inputLine + ".com");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(webUrl.openStream()));
        List<String> inputs = new ArrayList<String>();
        String line;
        while ((line = in.readLine())!= null && count < 5) {
            inputs.add(line);
            count ++;
        }
        if (count == 5) {
            count = 4;
        }
        while (count >= 0) {
            System.out.println(inputs.get(count));
            count --;
        }
        in.close();
    } catch (MalformedURLException me) {
        System.out.println(me);

    } catch (IOException ioe) {
        System.out.println(ioe);
        
    }
    
  }
}
