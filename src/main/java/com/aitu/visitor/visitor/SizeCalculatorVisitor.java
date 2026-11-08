package com.aitu.visitor.visitor;

import com.aitu.visitor.model.DirectoryElement;
import com.aitu.visitor.model.FileElement;
import com.aitu.visitor.model.FileSystemElement;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSize = 0;

    @Override
    public void visitFile(FileElement file) {
        totalSize += file.getSizeInBytes();
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public long getTotalSize() {
        return totalSize;
    }
}