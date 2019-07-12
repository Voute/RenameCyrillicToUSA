import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final ArrayList<FileRenamed> renamedFiles = new ArrayList<>();
        final ArrayList<String> fileIncludePatterns = new ArrayList<>();

        String executionPathString = Paths.get("").toAbsolutePath().toString();
        Path executionPath = Paths.get("").toAbsolutePath();
        System.out.println(executionPathString);

        fileIncludePatterns.addAll(Arrays.asList(args));

        try {
            Files.walkFileTree(executionPath, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString();
                    if (checkFileByPatterns(fileName, fileIncludePatterns)) {
                        FileRenamed fileRenamed = new FileRenamed(fileName);
                        renamedFiles.add(fileRenamed);
                        System.out.println(fileRenamed.getName() + " will be renamed to " + fileRenamed.newFile.getName());
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

        if (renamedFiles.size() > 0) {

            try {
                if (getUserInput("Press 'y' to rename files or 'exit' to exit:").matches("y"))

                    for (FileRenamed fileRenamed : renamedFiles) {

                        fileRenamed.renameTo(fileRenamed.newFile);
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nothing to rename");
        }

        System.out.println("done");
    }

    static boolean checkFileByPatterns(String fileName, ArrayList<String> patterns) {
        for (String pattern : patterns) {
            if (fileName.contains(pattern)) return true;
        }
        return false;
    }

    static String getUserInput(String message) throws IOException {
        String input = null;
        while (input == null || input.matches("")) {
            System.out.println(message);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
        }
        return input;
    }
}
