package ChatSystem;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    Socket socket = null;
    ServerSocket server = null;
    DataInputStream input = null;

    public void ChatS(int Port){
        try {
            server = new ServerSocket(Port);
            System.out.println("server started.");
            System.out.println("waiting for a client to connect ...");
            // input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // server.accept();
            while(true){
                server.accept();
                System.out.println("client connected.");
                readMessages(socket);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void readMessages(Socket clientSocket) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // reader.read();
        // reader.ready();
        for(int chr = reader.read(); reader.ready(); chr = reader.read()) {
            System.out.println((char) chr);
        }
    }

    public void close() throws IOException{
        if(server !=null) {
            server.close();
        } 
    }

    public static void main(String[] args) {
       ChatServer server = new ChatServer();
       
        server.ChatS(4000);
       
    }
}
