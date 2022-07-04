package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 3000);
             InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(inputStreamReader);
             InputStreamReader inputStreamReaderBySocket = new InputStreamReader(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReaderBySocket);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            System.out.println("Type message to server.Server here:");
            String word = reader.readLine();
            bufferedWriter.write(word + "\n");
            bufferedWriter.flush();
            String serverWord = bufferedReader.readLine();
            System.out.println(serverWord);
        }
    }
}

