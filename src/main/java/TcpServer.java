import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Random random = new Random();
        ServerSocket serverSock = new ServerSocket(3000);
        System.out.println("Start Server");
        Socket sock = serverSock.accept();

        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));

        OutputStream outputStream = sock.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        InputStream inputStream = sock.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String receiveMessage;
        String sendMessage;

        //TcpListener listener = new TcpListener(bufferedReader);
        //new Thread(listener).start();

        /*TcpSender sender = new TcpSender(printWriter);
        new Thread(sender).start();*/

        /*for (int i = 0; i < 10; i++) {
            sender.getCommands().add("1111");
        }

        System.out.println("Before Sleep");

        Thread.sleep(5000);

        System.out.println("After Sleep");*/

        while (true) {
            Thread.sleep(1000);
            //sender.getCommands().add("T" + random.nextInt(10) + random.nextInt(1000));
            printWriter.println("T" + random.nextInt(10) + random.nextInt(1000));
            printWriter.flush();
            printWriter.println("S" + random.nextInt(2));
            printWriter.flush();
            printWriter.println("F" + random.nextInt(2));
            printWriter.flush();
            printWriter.println("D" + random.nextInt(2));
            printWriter.flush();
            printWriter.println("E" + random.nextInt(2));
            printWriter.flush();
            printWriter.println("C" + random.nextInt(2));
            printWriter.flush();
            printWriter.println("N" + random.nextInt(2));
            printWriter.flush();
        }

    }

}
