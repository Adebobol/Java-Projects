package MessagingSystem;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;
    private ServerSocket ssocket = null;
    // private BufferedReader input = null;
    // private InputStreamReader input = null;
    private DataInputStream input = null;
    public void LinkServer(int port, int backlog){
        try {
            ssocket = new ServerSocket(port,backlog);
            System.out.println("server initialized.");
            System.out.println("waiting for incoming clients.");
            socket = ssocket.accept();
            System.out.println("client connected");
            // input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input = new DataInputStream(socket.getInputStream());
            while(true){
                String message = input.readUTF();
                System.out.println("Message from Client: " + message);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally{
        
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.LinkServer(4000,1);
    }
   
}
