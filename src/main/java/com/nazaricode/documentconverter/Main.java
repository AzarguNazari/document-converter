package com.nazaricode.documentconverter;

public class Main {
    public static void main(String[] args) {
        byte[] source = new byte[]{1,2,3,4,5};
        ConvertedFile builder = FileConverterBuilder.source(source)
            .from(FileType.JPG)
            .to(FileType.PDF)
            .convert();
        System.out.println(builder);
    }
}