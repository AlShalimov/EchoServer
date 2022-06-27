import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) {
        try {
            try {
                socket = new Socket("localhost", 3000);
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                InputStreamReader inputStreamReaderBySocket = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReaderBySocket);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                System.out.println("Type message to Server here:");
                String word = reader.readLine();
                bufferedWriter.write(word + "\n");
                bufferedWriter.flush();
                String serverWord = bufferedReader.readLine();
                System.out.println(serverWord);
            } finally {
                socket.close();
                bufferedReader.close();
                bufferedWriter.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
    }
}
