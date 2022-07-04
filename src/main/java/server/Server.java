package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            String word = bufferedReader.readLine();
            System.out.println(word);
            bufferedWriter.write("Echo " + word);
            bufferedWriter.flush();
        }
    }
}
