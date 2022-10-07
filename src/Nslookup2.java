import java.io.IOException;
import java.util.Scanner;

public class Nslookup2 {
    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println("Mete DNS o IP");
        ProcessBuilder builder5=new ProcessBuilder().command("cmd","/C","nslookup");
        builder5.inheritIO();
        Process process5 = builder5.start();
        process5.waitFor();


//                       builder5.redirectError(ProcessBuilder.Redirect.INHERIT);
//                       builder5.redirectInput(ProcessBuilder.Redirect.INHERIT);
//                       builder5.redirectOutput(ProcessBuilder.Redirect.INHERIT);


        System.out.println("Empezamos el proceso");

    }
}
