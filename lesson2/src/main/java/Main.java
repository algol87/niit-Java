import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        URL file=System.class.getResource("/text.txt");
        try(FileInputStream in=new FileInputStream(new File(file.getFile()))){
            int data=in.read();
            while(data!=-1){
                System.out.print((char)data);
                data=in.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
