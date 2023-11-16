import java.io.PrintWriter;

public class BitTreeExpt {
  public static void main(String[] arg) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    BitTree test = new BitTree(6);
    // test.set("100000", "A");
    test.set("110000", "B");
    test.dump(pen);
    pen.println(test.get("110000"));
    

  }
}
