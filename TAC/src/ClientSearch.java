import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSearch implements Runnable{
    public ClientSearch() throws IOException {
        System.out.println("Searching clients");
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(61337);
            for(int i = 0; i < 3; i++) {
                Socket socket = serverSocket.accept();
                new Thread(new TAC_SERVER(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
