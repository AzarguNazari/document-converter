package com.nazaricode.documentconverter;

/**
 * The converted file
 * @param type {@link FileType}
 * @param fileData {@link byte[]}
 * @param size the size of byte array
 */
public record ConvertedFile(
    FileType type,
    byte[] fileData,
    int size
) {
}
