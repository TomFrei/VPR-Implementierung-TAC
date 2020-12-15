import java.io.*;
import java.net.Socket;

public class TAC_CLIENT implements Runnable {

    private static String anzeigeName;
    public TAC_CLIENT(String anzeigeName) {
        TAC_CLIENT.anzeigeName = anzeigeName;
    }

    public static void main(String[] args) {
        new Thread(new TAC_CLIENT("test")).start();
    }

    public void run() {

        try {
            Socket socket = new Socket("127.0.0.1", 61337);
            System.out.println("connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );

            out.write("" + anzeigeName);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
