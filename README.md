# Document Converter


```java

FileConverter fileConverter = FilConverter.
    source(sourceByteArray)
    .from(FileType.JPG)
    .to(FileType.PDF)
    .convert();

record FileConverter(
    FileType type,
    byte[] fileData,
    int size
){}

FileType {
    PDF, JPG, PNG, ....
}

```



