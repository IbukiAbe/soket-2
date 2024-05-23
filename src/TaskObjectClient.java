import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskObjectClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5050);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream()) ;
                Scanner scanner = new Scanner(System.in)) {
                    System.out.println("好きな数字を入力しなさい");
                int x = scanner.nextInt();

            TaskObject task = new TaskObject();
            task.setExecNumber(x);

            output.writeObject(task);
            System.out.println("Task sent to server");

            TaskObject resultTask = (TaskObject) input.readObject();
            int result = resultTask.getResult();

            System.out.println("Largest prime less than or equal to " + x +"is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


