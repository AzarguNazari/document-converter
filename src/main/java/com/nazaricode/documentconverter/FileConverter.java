package com.nazaricode.documentconverter;

/**
 * File Converter Interface
 */
public interface FileConverter<T> {

    /**
     * Converts from jpg to Pdf
     * @param from the array byte code of source file
     * @return converted byte array
     */
    T jpgToPdf(byte[] from);

    /**
     * Converts from pdf to Jpg
     * @param from the array byte code of source file
     * @return converted byte array
     */
    T pdfToJpg(byte[] from);

}
