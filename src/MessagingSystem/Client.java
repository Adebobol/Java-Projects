package MessagingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket = null;
    private BufferedReader reader = null;
    private DataOutputStream writer = null;
    public void LinkClient(String Ip, int Port){
        try {
            socket = new Socket(Ip,Port);
            System.out.println("Trying to send message to server.");
            // writer = new PrintWriter(socket.getOutputStream());
            writer =  new DataOutputStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String msg = reader.readLine();
                writer.writeUTF(msg);
                writer.flush();
            }
        } catch (IOException e) {
            // TODO: handle exception
        } finally{
            try {
               if(writer != null) {
                    writer.close();
                } 
                if(reader != null) {
                    reader.close();
                } 
            } catch (IOException e) {
                // TODO: handle exception
            }
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.LinkClient("127.0.0.1", 4000);
    }
}
