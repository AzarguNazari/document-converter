# Document Converter


Goal is to create something like this:
```java
FileConverter fileConverter = FilConverter.
    source(sourceByteArray)
    .from(FileType.JPG)
    .to(FileType.PDF)
    .convert();
```

*WIP*: the project is currently under progress, but the goal is to support the conversion between the following file types:
```shell
PDF
PNG
JPG
DOCX
.... more types
```



