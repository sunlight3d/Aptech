import models.CodeLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    private ArrayList<CodeLine> codeLines = new ArrayList<>();
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void removeComments() {
        fetchAllLinesFromFile();

    }
    private boolean isLongComment = false;
    private void fetchAllLinesFromFile() {
        try {
            Stream<String> stream = Files.lines(Paths.get(this.filePath));
            this.codeLines.clear();

            stream.forEach((String line) -> {
                boolean isSet = false;
                CodeLine codeLine = new CodeLine(line, false);
                if(checkBeginComment(line) == true) {
                    isLongComment = true;
                } else {
                    if(checkEndComment(line) == true) {
                        codeLine.setComment(true);
                        isLongComment = false;
                        isSet = true;
                    } else {
                        isLongComment = isLongComment == true ? true : isLongComment;
                    }
                }
                boolean isComment = checkContainDoubleSlash(line) || isLongComment;
                if(isSet == false){
                    codeLine.setComment(isComment);
                }
                this.codeLines.add(codeLine);
            });
            ArrayList<CodeLine> filteredCodeLines =
                    (ArrayList<CodeLine>)this.codeLines.stream()
                            .filter(item -> item.isComment() == false).collect(Collectors.toList());
            for (CodeLine codeline:filteredCodeLines) {
                System.out.println(codeline.getContent());
            }
        }catch (Exception e){

        }
    }

    private boolean checkContainDoubleSlash(String string) {
        Pattern pattern = Pattern.compile("^[\s]*//", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
    private boolean checkBeginComment(String string) {
        Pattern pattern = Pattern.compile("^[\s]*/\\*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
    private boolean checkEndComment(String string) {
        Pattern pattern = Pattern.compile("\\*/[\s]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

}
