
import ru.geekbrains.PingPong;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread ping = new Thread(new PingPong(lock, "Ping"));
        Thread pong = new Thread(new PingPong(lock, "Pong"));
        ping.start();
        pong.start();
    }
}