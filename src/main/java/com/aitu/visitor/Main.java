package com.aitu.visitor;

import com.aitu.visitor.model.DirectoryElement;
import com.aitu.visitor.model.FileElement;
import com.aitu.visitor.visitor.SearchVisitor;
import com.aitu.visitor.visitor.SizeCalculatorVisitor;

public class Main {
    public static void main(String[] args) {

        DirectoryElement rootDir = new DirectoryElement("root");
        rootDir.addElement(new FileElement("document.pdf", 1200));
        rootDir.addElement(new FileElement("notes.txt", 450));

        DirectoryElement subDir = new DirectoryElement("images");
        subDir.addElement(new FileElement("logo.png", 3400));
        subDir.addElement(new FileElement("banner.png", 5100));

        rootDir.addElement(subDir);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        rootDir.accept(sizeVisitor);
        System.out.println("=== VISITOR 1: Total Size Calculator ===");
        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " bytes\n");

        SearchVisitor pngSearchVisitor = new SearchVisitor(".png");
        rootDir.accept(pngSearchVisitor);
        System.out.println("=== VISITOR 2: File Search Visitor (*.png) ===");
        System.out.println("Found Files: " + pngSearchVisitor.getMatchingFiles());
    }
}