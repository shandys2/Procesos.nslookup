import java.io.*;
import java.util.Scanner;

public class Nslookup {

    static BufferedReader bufferedReader;
    static BufferedReader errorBuffereddReader;
    static ProcessBuilder builder5;
    static Process process5;
    static InputStream inputStream;
    static InputStream errorStream;
    static BufferedWriter bw;
    Scanner sc;
    static String linea;


    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";
    public static final String C = "\u001B[36m";
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc= new Scanner(System.in);

        builder5 = new ProcessBuilder().command("cmd","/C","nslookup");
       // builder5.redirectError(ProcessBuilder.Redirect.INHERIT);
        process5 = builder5.start();

        System.out.println(C+"ARRANCAMOS EL PROCESO");
        inputStream = process5.getInputStream();
        errorStream=process5.getErrorStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        errorBuffereddReader= new BufferedReader(new InputStreamReader(errorStream));
        OutputStream outStream = process5.getOutputStream();
        bw = new BufferedWriter(new OutputStreamWriter(outStream));

      String error=errorBuffereddReader.readLine();

    //  while ((error=errorBuffereddReader.readLine())!=null){
    //      System.out.println(error);
     // }
       // if(error!=null){
         //   System.out.println(error);
        //}
        imprimirCabecera();

       //metiendo un espacio de primeras se bugea
        while (true){

            System.out.println(C+"ALIMENTAR INPUT DEL PROCESO CON IP O DNS...");
            String param = sc.nextLine();
            bw.write(param);
            bw.newLine();
            bw.flush();


            imprimirCabecera(); //primero imprime solo el error y luego la cabecera¿?¿?

            while ((linea=bufferedReader.readLine())!=null){
                System.out.println(Y+"IMPRIMIR RESPUESTA  -> "+ linea);
                if(linea.equals("")){
                 break;
                }
            }
        }
    }

//el mensaje de error no lo estoy imprimiendo yo
    public static void imprimirCabecera() throws IOException {
        for (int i = 0; i < 3; i++) {
            linea = bufferedReader.readLine();
            System.out.println(B+"IMPRIMIR CABECERA   -> "+ linea);
        }
    }
}
