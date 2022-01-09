package AddPDF;

@FunctionalInterface
interface Calculat {
    int aplay(int firsNumb, int secondNub);
}

public class Culculator {
    public static void main(String[] args) throws Exception {

        Calculat sum = ((firsNumb, secondNub) -> firsNumb + secondNub);
        Calculat min = ((firsNumb, secondNub) -> firsNumb - secondNub);
        Calculat div = ((firsNumb, secondNub) -> {
            try {
                return firsNumb / secondNub;
            } catch (ArithmeticException e) {
                e.printStackTrace();
                return -1;
            }
        });
        Calculat mult = ((firsNumb, secondNub) -> firsNumb * secondNub);

        System.out.println(sum.aplay(10, 0));
        System.out.println(min.aplay(10, 0));
        System.out.println(div.aplay(10, 0));
        System.out.println(mult.aplay(10, 0));
    }
}
