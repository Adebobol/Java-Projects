package ChatSystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    Socket socket = null;
    ServerSocket server = null;
    DataInputStream input = null;

    public ChatServer(int Port){
        try {
            server = new ServerSocket(Port);
            System.out.println("server started.");
            System.out.println("waiting for a client to connect ...");
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void main(String[] args) {
        
    }
}
