package com.aitu.visitor.model;

import com.aitu.visitor.visitor.FileSystemVisitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}