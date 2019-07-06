import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class Main {

    ArrayList

    public static void main(String[] args) {
        Arra
        System.out.println("Hello World!");
        String executionPathString = Paths.get("").toAbsolutePath().toString();
        Path executionPath = Paths.get("").toAbsolutePath();
        System.out.println(executionPathString);

        try {
            Files.walkFileTree(executionPath, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString();
                    if (!fileName.contains(".java")) {

                        System.out.println(fileName + " will be renamed to ");
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FileRenamer {
        HashMap<String, String> charMap = new HashMap() {{
            put("а","a"),
                    put("б","b"),
                    put("в","v"),
                    put("г","g"),
                    put("д","d"),
                    put("е","ye"),
                    put("ж","zsh"),
                    put("з","z"),
                    put("и","i"),
                    put("к","k"),
                    put("л","l"),
                    put("м","m"),
                    put("н","n"),
                    put("о","o"),
                    put("п","p"),
                    put("р","r"),
                    put("с","s"),
                    put("т","t"),
                    put("у","u"),
                    put("ф","f"),
                    put("х","h"),
                    put("ш","sh"),
                    put("щ","sh"),
                    put("э","e"),
                    put("ю","yu"),
                    put("ь","'"),
                    put("ъ",""),
                    put("я","ya")
        }};

        String fileToRename;
        String newFileName;


    }
}
