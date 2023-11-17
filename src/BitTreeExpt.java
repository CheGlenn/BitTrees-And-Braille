import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.InputStream;
/**
 * Test file for BitTree
 * @author Che Glenn
 */
public class BitTreeExpt {
  public static void main(String[] arg) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    BitTree test = new BitTree(6);
    pen.println(BrailleASCIITables.toBraille('B'));
    pen.println(BrailleASCIITables.toASCII("110000"));
    pen.println(BrailleASCIITables.toUnicode("100000"));
    

   
    

  }
}
