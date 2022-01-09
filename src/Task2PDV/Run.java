package Task2PDV;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Run {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Optional<Integer> sum = list
                .stream()
                .map(x -> x * x)
                .reduce((left, right) -> left + right);

        System.out.println(sum);
    }
}
