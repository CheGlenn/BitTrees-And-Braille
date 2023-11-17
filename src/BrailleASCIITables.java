import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Creates BitTrees for all Braille-ASCII-Unicode translations, loads txt files for reading and calls get. Main translator.
 * @author Che Glenn
 */

public class BrailleASCIITables{


// +---------+-----------------------------------------------------
// | Methods |
// +---------+

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille character.
   * @param letter
   * @return braille
   */
  static String toBraille(char letter) throws Exception{

      /*
     * Create a new BitTree fit for braille
     */
    BitTree asciiToBraille = new BitTree(8);
    String asciiToBrailleFile = "src/ASCIITestFile";
    

    /*
     * Test to see if file exists, and load file into BitTree
     */

    try{
      InputStream asciiInput = new FileInputStream(asciiToBrailleFile);
      asciiToBraille.load(asciiInput);
      } catch (FileNotFoundException e){
        System.err.println("Error: Could not locate file");
      }
    
      /*
       * First we convert our ASCII into its numeric value
       * Then we use Integer.toBinaryString to convert into a binary value
       * Remember to add "0" to the front, as Integer.toBinaryString automatically deletes the first char
       */
    int asciiVal = (int) letter;
    String binary = Integer.toBinaryString(asciiVal);
    return asciiToBraille.get("0" + binary);
   
  }

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character.
   * @param bits
   * @return ASCII
   */
  public static String toASCII(String bits) throws Exception{
    /*
     * Create a new BitTree fit for braille
     */
    BitTree brailleToAscii = new BitTree(6);
    String brailleToAsciiFile = "src/BrailleTestFile";

    /*
     * Test to see if file exists, and load file into BitTree
     */

    try{
      InputStream brailleInput = new FileInputStream(brailleToAsciiFile);
      brailleToAscii.load(brailleInput);
      } catch (FileNotFoundException e){
        System.err.println("Error: Could not locate file");
      }
    /*
     * get the value assosciated
     */
    return brailleToAscii.get(bits);
  }
  
  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits.
   * @param bits
   * @return unicode
   */
  public static String toUnicode(String bits) throws Exception{
    /*
     * Create a new BitTree fit for braille
     */
    BitTree brailleToUnicode = new BitTree(6);
    String brailleToUnicodeFile = "src/UnicodeTestFile";

    /*
     * check if we can load file, and load file data into BitTree
     */
    try{
      InputStream brailleInput = new FileInputStream(brailleToUnicodeFile);
      brailleToUnicode.load(brailleInput);
    } catch (FileNotFoundException e) {
      System.err.println("Error: Could not locate file");
    }
    /*
     * get the value assosciated with inputted bits
     */
    return brailleToUnicode.get(bits);
  }


}
