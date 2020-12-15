import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TAC_SERVER implements Runnable{
    private Socket clientSocket;

    public TAC_SERVER(Socket socket) {
        clientSocket = socket;
    }

    @Override
    public void run() {
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
                ) {

//            TAC_GUI.user2Name = in.readLine();
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
