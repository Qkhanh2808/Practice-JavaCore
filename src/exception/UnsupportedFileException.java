package exception;

public class UnsupportedFileException extends Exception{
    public UnsupportedFileException(String extension) {
        super(String.format("File %s does not exist", extension));
    }
}
