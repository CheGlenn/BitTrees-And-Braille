import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BrailleASCIITables{
// +--------+------------------------------------------------------
// | Fields |
// +--------+

BitTree brailleTree;

BitTree asciiTree;

BitTree unicodeTree;

// +--------------+------------------------------------------------
// | Constructors |
// +--------------+

public BrailleASCIITables(){
  //Create BitTrees of appropriate depth
  this.brailleTree = new BitTree(6);
  this.asciiTree = new BitTree(8);
  this.unicodeTree = new BitTree(8);
  //Paths of files
  String brailleFile = "src/BrailleTestFile";
  String asciiFile = "src/ASCIITestFile";
  String unicodeFile = "src/UnicodeTestFile";
  /**
   * Try to load each file, and create a bit tree
   */
  try{
  InputStream brailleInput = new FileInputStream(brailleFile);
  } catch (FileNotFoundException e){
    System.err.println("Error: Could not locate file");
  }

  try{
  InputStream asciiInput = new FileInputStream(asciiFile);
  } catch (FileNotFoundException e){
    System.err.println("Error: Could not locate file");
  }

  try{
  InputStream unicodeInput = new FileInputStream(unicodeFile);
  } catch(FileNotFoundException e){
    System.err.println("Error: Could not locate file");
  }

  

}

// +---------+-----------------------------------------------------
// | Methods |
// +---------+

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille character.
   * @param letter
   * @return
   */
  public static String toBraille(char letter){
    int asciiVal = (int) letter;
    String binary = Integer.toBinaryString(asciiVal);
    //asciiTree.get()
    return null;
    
  }

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character.
   * @param bits
   * @return
   */
  public static String toASCII(String bits){
    //STUB
    return null;
  }
  
  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits.
   * @param bits
   * @return
   */
  public static String toUnicode(String bits){
    //STUB
    return null;
  }
  
}
