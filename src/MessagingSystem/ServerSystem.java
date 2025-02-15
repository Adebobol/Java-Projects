package MessagingSystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerSystem {
    String Ip = "127.0.0.1";
    int Port = 4000;
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream input = null;
    private int id;
    ArrayList<Socket> clients = new ArrayList<>();

    public void LinkServer(){
        
            try {
                server = new ServerSocket(Port, 2);
                System.out.println("waiting for client to connect.");
                while(true){ 
                    socket=server.accept();
                    clients.add(socket);
                    id++;
                    System.out.printf("client %d connected.   ",id);
                    System.out.println();
                    if(socket.isConnected())
                    new Thread(()->{
                        ClientConnected client = new ClientConnected(socket,id);
                        client.readMessages();
                    }).start();
                    if(!socket.isConnected()) break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                close();
            }
        
    }

    public void close(){
        try {
            if(server!=null) server.close();
            if(input!= null) input.close();
            for(Socket client: clients) {
                if(client != null) client.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // private void readMessage() throws IOException{
    //     String line = "";
    //     while(!line.equals("cancel")){
    //         line = input.readUTF();
    //         System.out.println(line);
    //     }
    // }
    public static void main(String[] args) {
        ServerSystem serverSys = new ServerSystem();   
        serverSys.LinkServer();
    }
}
