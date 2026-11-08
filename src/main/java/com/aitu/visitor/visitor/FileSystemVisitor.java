package com.aitu.visitor.visitor;

import com.aitu.visitor.model.DirectoryElement;
import com.aitu.visitor.model.FileElement;

public interface FileSystemVisitor {
    void visitFile(FileElement file);
    void visitDirectory(DirectoryElement directory);
}
