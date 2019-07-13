import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by egto1016 on 11.07.2019.
 */
public class FileRenamed extends File{

    static final HashMap<String, String> charMappings = new HashMap<String,String>() {{
        //lowercase
        put("а","a");
        put("б","b");
        put("в","v");
        put("г","g");
        put("д","d");
        put("е","ye");
        put("ж","zsh");
        put("з","z");
        put("и","i");
        put("к","k");
        put("л","l");
        put("м","m");
        put("н","n");
        put("о","o");
        put("п","p");
        put("р","r");
        put("с","s");
        put("т","t");
        put("у","u");
        put("ф","f");
        put("х","h");
        put("ц","ts");
        put("ч","ch");
        put("ш","sh");
        put("щ","sh");
        put("э","e");
        put("ю","yu");
        put("ь","'");
        put("ъ","");
        put("я","ya");
        // uppercase
        put("А","A");
        put("Б","B");
        put("В","V");
        put("Г","G");
        put("Д","D");
        put("Е","Ye");
        put("Ж","Zsh");
        put("З","Z");
        put("И","I");
        put("К","K");
        put("Л","L");
        put("М","M");
        put("Н","N");
        put("О","O");
        put("П","P");
        put("Р","R");
        put("С","S");
        put("Т","T");
        put("У","U");
        put("Ф","F");
        put("Х","H");
        put("Ц","Ts");
        put("Ч","Ch");
        put("Ш","Sh");
        put("Щ","Sh");
        put("Э","E");
        put("Ю","Yu");
        put("Я","Ya");
    }};

    File newFile;

    FileRenamed(String fileToRename) {
        super(fileToRename);
        ArrayList<Character> charsToReplace = new ArrayList<>();
        String newFileName = fileToRename;

        for (Character charr : fileToRename.toCharArray()) {
            if (!charsToReplace.contains(charr)) charsToReplace.add(charr);
        }
        for (Character charr: charsToReplace) {
            newFileName = newFileName.replaceAll(charr.toString(), charMappings.get(charr.toString()));
        }
        newFile = new File(newFileName);
    }
}
