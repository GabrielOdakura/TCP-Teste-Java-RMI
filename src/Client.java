import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("======== Sending message to Server ========");
        Socket socket = new Socket("SERVER_IP", 5000); // coloque o IP do servidor local aqui

        // Create object to send
        System.out.println("Creating object");
        Operation op = new Operation(10, 5, '+');

        // Send object
        System.out.println("Sending object...");
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(op);

        // Receive result
        System.out.println("Receiving result...");
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        int result = (int) input.readObject();

        System.out.println("Result from server: " + result);

        socket.close();
    }
}