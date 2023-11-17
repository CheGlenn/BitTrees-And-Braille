import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.InputStream;

public class BitTreeExpt {
  public static void main(String[] arg) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    BitTree test = new BitTree(6);
    pen.println(BrailleASCIITables.toBraille('A'));
    
    // String file = "/home/glennche/csc207/MiniProjects/MiniProj 8/BitTrees-And-Braille/src/TestFile";
    // InputStream input = new FileInputStream(file);

    // test.load(input);
    // test.dump(pen);
   
    

  }
}
