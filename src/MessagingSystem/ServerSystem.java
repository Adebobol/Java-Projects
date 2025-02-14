package MessagingSystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.crypto.Data;

public class ServerSystem {
    String Ip = "127.0.0.1";
    int Port = 4000;
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream input = null;

    public void LinkServer(){
        try {
            server = new ServerSocket(Port);
            System.out.println("waiting for client to connect.");
            server.accept();
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            readMessage();
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }

    private void readMessage() throws IOException{
        String line = "";
        while(!line.equals("cancel")){
            line = input.readUTF();
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        ServerSystem serverSys = new ServerSystem();   
        serverSys.LinkServer();
    }
}
