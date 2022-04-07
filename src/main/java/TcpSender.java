import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TcpSender implements Runnable {

    private LinkedList<String> commands = new LinkedList<>();

    private PrintWriter printWriter;

    public TcpSender(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public LinkedList<String> getCommands() {
        return commands;
    }

    public void setCommands(LinkedList<String> commands) {
        this.commands = commands;
    }

    @Override
    public void run() {

        while (true) {
            //System.out.println("TEST");
            //System.out.println(commands.isEmpty());
            //if (!commands.isEmpty()) {
            try {
                String c = commands.pop();
                System.out.println(c);
                printWriter.println(c);
                printWriter.flush();
            } catch (NoSuchElementException ignored) {}

            //}
        }

    }
}
