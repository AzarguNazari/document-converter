package com.nazaricode.documentconverter;

/**
 * Implementation of FileConverter
 */
public class FileConverterImpl implements FileConverter<ConvertedFile> {
    @Override
    public ConvertedFile jpgToPdf(byte[] from) {
        return new ConvertedFile(FileType.PDF, from, 11);
    }

    @Override
    public ConvertedFile pdfToJpg(byte[] from) {
        return new ConvertedFile(FileType.JPG, from, 11);
    }
}
