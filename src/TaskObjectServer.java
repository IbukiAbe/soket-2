import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskObjectServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5050)) {

            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {

                    System.out.println("Client connected");

                    TaskObject task = (TaskObject) input.readObject();
                    task.exec();

                    output.writeObject(task);
                    System.out.println("Calculation done and result sent back to client");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

