package ssu.daniil_orlov.java.lesson_5.DiskAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiskAnalyzer {

    private final File root;
    private final Path path;


    public DiskAnalyzer(String path){
        root = new File(path);
        this.path = Paths.get(path);
    }

    private List<File> getFilesInFolder() throws IOException {
        return Files.walk(this.path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    public void findFileWithMaxLetterS() throws IOException {
        ArrayList<String> nameFiles = new ArrayList<>();
        List<File> files = getFilesInFolder();
        String resFileName = "";
        File resPath = null;
        int maxCntS = 0;
        for (int i = 0; i < files.size(); i++){
            int tempMaxCntS = 0;
            File file = (File) getFilesInFolder().get(i);
            String fileName = file.getName();
            for(int j = 0; j < fileName.length(); j++){
                if(fileName.charAt(j) == 't'){
                    tempMaxCntS++;
                }
            }
            if (tempMaxCntS > maxCntS){
                maxCntS = tempMaxCntS;
                resPath = file;
                resFileName = fileName;
            }
        }
        if(resPath != null){
            System.out.println("Path: " + resPath);
            System.out.println("File name: " +  resFileName);
        }
    }

    public List findByFileName(String fileName) throws IOException {
        try(Stream str = Files.find(this.path, Integer.MAX_VALUE,
                (p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName))) {
           return (List) str.collect(Collectors.toList());
        }
    }

    public void findTopFiveMaxSizesFiles() throws IOException {
        List<File> files = getFilesInFolder();

        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.compare(o1.length(), o2.length());
            }
        };
        files.sort(comparator);

        for(int i = files.size() - 1; i > files.size() - 6; i--){
            System.out.println(files.get(i).getName() + ": " +  files.get(i).length());
        }
    }

    public void getCountFilesAndFolders(String letters){
        Map<String, Integer> filesByChar = new HashMap<>();
        Map<String, Integer> folderByChar = new HashMap<>();

        for(int i = 0; i < letters.length(); i++){
            filesByChar.put(String.valueOf(letters.charAt(i)), 0);
            folderByChar.put(String.valueOf(letters.charAt(i)), 0);
            getCountFilesByFirstLetter(String.valueOf(letters.charAt(i)), filesByChar, folderByChar, root);
            System.out.println(letters.charAt(i) + " Count folders: " + folderByChar.get(String.valueOf(letters.charAt(i))) +
                    ", Count files: " + filesByChar.get(String.valueOf(letters.charAt(i))));
        }
    }

    private void getCountFilesByFirstLetter(String letter, Map<String,
            Integer> filesByChar, Map<String, Integer> folderByChar, File root){
        File[] files = root.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            String fileName = file.getName().toLowerCase();
            if (fileName.indexOf(letter.toLowerCase()) == 0 || fileName.indexOf(letter.toUpperCase()) == 0) {
                if (file.isDirectory()) {
                    folderByChar.put(letter.toLowerCase(), folderByChar.get(letter.toLowerCase()) + 1);
                    getCountFilesByFirstLetter(letter, filesByChar, folderByChar, file);
                } else {
                    filesByChar.put(letter.toLowerCase(), filesByChar.get(letter.toLowerCase()) + 1);
                }
            }
        }
    }
}
