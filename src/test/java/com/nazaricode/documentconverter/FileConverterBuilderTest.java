package com.nazaricode.documentconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import org.junit.Test;

public class FileConverterBuilderTest {

    @Test
    public void testJpgToPdfConversion() throws IOException {
        byte[] bytes = Objects.requireNonNull(FileConverterBuilderTest.class.getResourceAsStream("/test-example.jpg")).readAllBytes();
        ConvertedFile convert = FileConverterBuilder.source(bytes)
            .from(FileType.JPG)
            .to(FileType.PDF)
            .convert();
        assertEquals(FileType.PDF, convert.type());
        assertNotEquals(0, convert.size());
        assertEquals(convert.fileData().getClass(), byte[].class);
        try (OutputStream outputStream = new FileOutputStream("test.pdf")) {
            outputStream.write(convert.fileData());
        }
    }
}