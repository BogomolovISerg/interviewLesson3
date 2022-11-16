import ru.geekbrains.Counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.CounterStart();
        System.out.println(counter.getValue());
    }
}