package com.aitu.visitor.visitor;

import com.aitu.visitor.model.DirectoryElement;
import com.aitu.visitor.model.FileElement;
import com.aitu.visitor.model.FileSystemElement;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String extensionCriterion;
    private final List<String> matchingFiles = new ArrayList<>();

    public SearchVisitor(String extensionCriterion) {
        this.extensionCriterion = extensionCriterion.toLowerCase();
    }

    @Override
    public void visitFile(FileElement file) {
        if (file.getName().toLowerCase().endsWith(extensionCriterion)) {
            matchingFiles.add(file.getName());
        }
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public List<String> getMatchingFiles() {
        return matchingFiles;
    }
}