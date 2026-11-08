package com.aitu.visitor.model;

import com.aitu.visitor.visitor.FileSystemVisitor;

public class FileElement implements FileSystemElement {
    private final String name;
    private final long sizeInBytes;

    public FileElement(String name, long sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    public String getName() {
        return name;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}