import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutput = new FileOutputStream("received_file.txt");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
            }

            System.out.println("File received successfully!");

            fileOutput.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
