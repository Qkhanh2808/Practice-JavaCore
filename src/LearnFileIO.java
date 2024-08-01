import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LearnFileIO {
    public static void main(String[] args){
        Path p1= Paths.get("D:\\SQL");
        System.out.println(p1.getRoot());
    }
}
