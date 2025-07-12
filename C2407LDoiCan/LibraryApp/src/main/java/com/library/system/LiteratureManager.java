package com.library.system;

import com.library.literature.LiteraryWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LiteratureManager {
    private List<LiteraryWork> literaryWorks = new ArrayList<>();
    //private ArrayList<LiteraryWork> literaryWorks = new ArrayList<>();
    public void addWord() {
        LiteraryWork newWork = new LiteraryWork();
        try {
            newWork.inputDetails();
            literaryWorks.add(newWork);

        }catch (IOException e) {
            System.err.println("Cannot input parameters. Error: "+e.getMessage());
        }

    }
    public void showAllWorks() {
        for(LiteraryWork literaryWork: literaryWorks) {
            literaryWork.displayDetails();
        }
    }
    public void findLongestWork() {
        LiteraryWork longestWork = null;

        /*
        longestWork = literaryWorks
                .stream()
                .max(Comparator.comparingInt(LiteraryWork::getPageCount))
                .get();
        longestWork.displayDetails();
        */
        if(literaryWorks.isEmpty()) {
            return;
        }
        longestWork = literaryWorks.get(0);
        for(LiteraryWork literaryWork: literaryWorks) {
            if(literaryWork.getPageCount() > longestWork.getPageCount()) {
                longestWork = literaryWork;
            }
        }
        longestWork.displayDetails();
    }
}
