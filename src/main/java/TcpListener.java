import java.io.BufferedReader;
import java.io.IOException;

public class TcpListener implements Runnable{

    private BufferedReader bufferedReader;

    public TcpListener(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {

        String receiveMessage;

        while (true) {
            try {
                receiveMessage = bufferedReader.readLine();
                if (receiveMessage != null) {
                    System.out.println(receiveMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
