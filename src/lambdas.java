import java.util.List;

public class lambdas {
    public static void main(String[] args){
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        numbers.stream()
                .filter(x -> x%2==0) // This is a lambda expression
                .map(x -> x*x)
                .forEach(x -> System.out.println(x));
    }

}
