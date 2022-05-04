package ssu.daniil_orlov.java.lesson_5.DiskAnalyzer;

import java.io.IOException;

public class Task5_Main {
    public static void main(String[] args) throws IOException {
        Task5_Main main = new Task5_Main();
        main.startApplication();
    }

    private void startApplication() throws IOException {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer("D:\\Test2");

        diskAnalyzer.findFileWithMaxLetterS();
        System.out.println();

        System.out.println(diskAnalyzer.findByFileName("temp1.txt"));
        System.out.println();

        diskAnalyzer.findTopFiveMaxSizesFiles();
        System.out.println();

        diskAnalyzer.getCountFilesAndFolders("test");
        System.out.println();
    }
}
