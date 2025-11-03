import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server waiting...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Receber Objeto
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Operation op = (Operation) input.readObject();

        System.out.println("Received: " + op.a + " " + op.operator + " " + op.b);

        // Calcula resultado
        int result = switch (op.operator) {
            case '+' -> op.a + op.b;
            case '-' -> op.a - op.b;
            case '*' -> op.a * op.b;
            case '/' -> op.b != 0 ? op.a / op.b : 0;
            default -> 0;
        };

        // Envia resultado de volta
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(result);

        socket.close();
        serverSocket.close();
    }
}