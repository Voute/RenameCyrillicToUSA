import java.io.File;
import java.util.ArrayList;

/**
 * Created by egto1016 on 11.07.2019.
 */
public class FileRenamed extends File{

    static final ArrayList<CharMapping> charMappings = new ArrayList<CharMapping>() {{

        add(new CharMapping("а","a"));
        add(new CharMapping("б","b"));
        add(new CharMapping("в","v"));
        add(new CharMapping("г","g"));
        add(new CharMapping("д","d"));
        add(new CharMapping("е","ye"));
        add(new CharMapping("ж","zsh"));
        add(new CharMapping("з","z"));
        add(new CharMapping("и","i"));
        add(new CharMapping("к","k"));
        add(new CharMapping("л","l"));
        add(new CharMapping("м","m"));
        add(new CharMapping("н","n"));
        add(new CharMapping("о","o"));
        add(new CharMapping("п","p"));
        add(new CharMapping("р","r"));
        add(new CharMapping("с","s"));
        add(new CharMapping("т","t"));
        add(new CharMapping("у","u"));
        add(new CharMapping("ф","f"));
        add(new CharMapping("х","h"));
        add(new CharMapping("ц","ts"));
        add(new CharMapping("ч","ch"));
        add(new CharMapping("ш","sh"));
        add(new CharMapping("щ","sh"));
        add(new CharMapping("э","e"));
        add(new CharMapping("ю","yu"));
        add(new CharMapping("ь","'"));
        add(new CharMapping("ъ",""));
        add(new CharMapping("я","ya"));

    }};

    File newFile;

    FileRenamed(String fileToRename) {
        super(fileToRename);
        String newFileName = fileToRename;
        for (CharMapping mapping: charMappings) {
            newFileName = newFileName.replaceAll(mapping.charToReplace, mapping.replacement);
        }
        newFile = new File(newFileName);
    }
}
