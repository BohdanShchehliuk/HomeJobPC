package Deamon;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) throws NoSuchMethodException {
        BlackDemon blackDemon = new BlackDemon("Demon");
        blackDemon.setPriority(10);
        blackDemon.setDaemon(true);

        System.out.println(Arrays.toString(blackDemon.getClass().getDeclaredFields()));
        System.out.println(Arrays.toString(blackDemon.getClass().getConstructors()));
        System.out.println(Arrays.toString(blackDemon.getClass().getDeclaredMethods()));

        blackDemon.run();

        blackDemon.setDaemon(false);
        blackDemon.run();
    }
}

class BlackDemon extends Thread {
    String name;
    int number;

    public BlackDemon(String name) {
        this.name = "Black";
        this.number = 9;
    }

    @Override
    public void run() {
        if (isDaemon()) {
            System.out.println("Tread is Demon");
        } else {
            System.out.println("Tread is not Demon");
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
