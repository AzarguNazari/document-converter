package com.nazaricode.documentconverter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FileConverterBuilderTest {

    @Test
    public void testJpgToPdfConversion() {
        byte[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ConvertedFile convert = FileConverterBuilder.source(source)
            .from(FileType.JPG)
            .to(FileType.PDF)
            .convert();
        assertEquals(convert.type(), FileType.PDF);
    }
}