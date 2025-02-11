package ChatSystem;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private Socket socket = null;


    public void ChatC(String Ip, int Port ){
        try {
            socket = new Socket(Ip,Port);
            System.out.println("Connecting to the server...");
        } catch (Exception e) { 
            // TODO: handle exception
        }
    }

    public void sendMessage(String msg) throws IOException{
        System.out.println("sending message to server");
        PrintWriter output = new PrintWriter(socket.getOutputStream());
        output.println(msg);
    }

    
    public void close() throws IOException{
        if(socket !=null) {
            socket.close();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        try {
            client.ChatC("127.0.0.1", 4000);
            client.sendMessage("hello");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
