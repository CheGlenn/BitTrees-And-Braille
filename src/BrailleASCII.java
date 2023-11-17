import java.io.PrintWriter;
/**
 * BraillASCII is the main class, and uses BrailleASCIITables to translate from Braille->ASCII, Braille->Unicode, and ASCII->Braille.
 * @author Che Glenn
 */
public class BrailleASCII {
  public static void main(String args[]) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    
    /**
     * Check for correct args
     */
    if(args.length != 2){
      throw new Exception("Incorrect number of arguments");
    }
    
   if(args[0].equals("braille")){
    /*
     * Loop through input for translation, translating each char to Braille as we go
     */
      String input = args[1];
      String target = "";
      for(int i = 0; i < input.length();i++){
       target += BrailleASCIITables.toBraille(input.charAt(i));
      }
      pen.println(target);
    }
    else if(args[0].equals("ascii")){
      /*
       * Loop through input for translation, making sure to split the input into smaller substrings of translatable Braille
       */
      String input = args[1];
      String target = "";
      for(int i = 1; i < input.length()/5; i++){
        if(input.charAt(i) == '0' || input.charAt(i) == '1'){
          target += BrailleASCIITables.toASCII(input.substring((i-1) * 6, i*6));
        } else{
          throw new Exception("Invalid input, input must only contain 0 or 1");
        }
        
      }
      pen.println(target);
    }
    else if(args[0].equals("unicode")){
      /*
       * Loop through input, translating first to Braille. 
       * Then, translate to unicode, making sure to split the input into smaller subtstrings of translatable Braille
       */
      String input = args[1];
      String tempBraille = "";
      String target = " ";
      for(int i = 0; i < input.length(); i++){
        tempBraille += BrailleASCIITables.toBraille(input.charAt(i));
      }
      for(int i = 1; i < tempBraille.length()/5; i++){
        target += BrailleASCIITables.toUnicode(tempBraille.substring((i-1)*6, i*6));
      }

    
      

    }

  }
}
