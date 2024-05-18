package com.nazaricode.documentconverter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File converter builder class
 */
public class FileConverterBuilder {

    private static final Logger logger = Logger.getLogger(FileConverterBuilder.class.getName());

    private byte[] sourceData;
    private FileType sourceType;
    private FileType targetType;
    private final FileConverter<ConvertedFile> fileConverter = new FileConverterImpl();

    public static FileConverterBuilder source(byte[] sourceData) {
        FileConverterBuilder builder = new FileConverterBuilder();
        builder.sourceData = sourceData;
        return builder;
    }

    public FileConverterBuilder from(FileType sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public FileConverterBuilder to(FileType targetType) {
        this.targetType = targetType;
        return this;
    }

    public ConvertedFile convert() {

        try {
            if (sourceData == null || sourceData.length == 0) {
                throw new FileConversionException("Source data is empty");
            }

            return switch (sourceType) {
                case JPG -> switch (targetType) {
                    case PDF -> fileConverter.jpgToPdf(sourceData);
                    case PNG -> throw new FileConversionException("to be implemented");
                    default -> throw new FileConversionException("Unknown file type");
                };
                case PDF -> switch (targetType) {
                    case PDF, JPG -> null;
                    default -> throw new FileConversionException("Unsupported file type: " + targetType);
                };
                default -> throw new FileConversionException("Unsupported file type: " + sourceType);
            };
        } catch (FileConversionException e) {
            logger.log(Level.SEVERE, "Unable to convert file", e);
            e.fillInStackTrace();
        }
        return null;
    }

}