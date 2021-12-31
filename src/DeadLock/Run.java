package DeadLock;
import static java.lang.Thread.sleep;
public class Run {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();
        classOne.setClassTwo(classTwo);
        classTwo.setClassOne(classOne);
        classOne.setPriority(10);
        classOne.start();
        classTwo.start();
    }
}
class ClassOne extends Thread {
    Thread t2;
    static int counter;
    public ClassOne() {
        counter++;
        System.out.printf("Class ONE %d times\n",counter);
         }
    @Override
    public synchronized void run() {
        System.out.println("Class ONE start");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try { if (t2.hashCode() > new ClassOne().hashCode()) { // костильне вирішення проблеми DeadLock
            System.out.println("My Class ONE interapred class Two finish");
            t2.join();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class one finish");
    }
    public void setClassTwo(Thread t) {
        this.t2 = t;
    }
}
class ClassTwo extends Thread {
    Thread t1;
static int counter;
    public ClassTwo() {
        counter++;
        System.out.printf("Class TWO %d times\n",counter);
    }

    @Override
    public synchronized void run() {
        System.out.println("Class TWO start");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
           if (t1.hashCode() > new ClassTwo().hashCode()){ // костильне вирішення проблеми DeadLock
            System.out.println("My Class TWO interapred class ONE finish");
            t1.join();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class Two finish");
    }

    public void setClassOne(Thread t) {
        this.t1 = t;
    }
}


