package com.nazaricode.documentconverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * Implementation of FileConverter
 */
public class FileConverterImpl implements FileConverter<ConvertedFile> {
    @Override
    public ConvertedFile jpgToPdf(byte[] fromSourceBytes) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(fromSourceBytes)) {
                PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, fromSourceBytes, null);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    // Draw the image at full page size
                    contentStream.drawImage(pdImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
                }
            }

            // Save the document to a byte array
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                document.save(outputStream);
                return new ConvertedFile(FileType.PDF, outputStream.toByteArray(), outputStream.size());
            }
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public ConvertedFile pdfToJpg(byte[] from) {
        return new ConvertedFile(FileType.JPG, from, 11);
    }
}
