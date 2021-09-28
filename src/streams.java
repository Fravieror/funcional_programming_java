import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streams {
    public static void main(String[] args){

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("C#", "Java", "Python", "Javascript");

        List<Integer> doubleNumbers = doubleList(numbers);

        System.out.println(doubleNumbers);
    //        int sum = addListStructured(numbers);
        int sum = addListFunctional(numbers);
        sortedDistinctListFunctional(numbers);
        sortingStringsFunctional(courses);
        System.out.println(sum);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map( number -> number*number) // returns Stream<R>
                .collect(Collectors.toList());
    }

    private static int addListStructured(List<Integer> numbers) {
        // how to loop?
        // how to store?
        int sum = 0;
        for(int number:numbers){
            sum += number;
        }
        return sum;
    }

    private static int addListFunctional(List<Integer> numbers) {
        // Stream of numbers called reduce operation
        return numbers
                .stream()
                .reduce(0, (x,y) -> x+y); // Lambda expression // returns <T>
//                .reduce(0, streams::sum); // this is called a method reference
        //

    }

    private static int sum(int a, int b){
        System.out.println(a + " " + b);
        return a +b;
    }

    private static void sortedDistinctListFunctional(List<Integer> numbers) {
        // Stream of numbers called reduce operation
        numbers
                .stream()
                .sorted(Comparator.naturalOrder()) // alphabetical order.
                .distinct()
                .forEach(System.out::println);

        numbers
                .stream()
                .sorted(Comparator.reverseOrder()) // alphabetical order. // returns Stream<T>
                .distinct() // returns Stream<T>
                .forEach(System.out::println); // returns void
    }

    private static void sortingStringsFunctional(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
        Comparator comparingByNoOfstudentsIncreasing = Comparator.comparing(o -> o.equals(""));
        Comparator comparingByNoOfstudentsDecreasing = Comparator.comparing(o -> o.equals("")).reversed();

        System.out.println(courses.stream().sorted(comparingByNoOfstudentsDecreasing).collect(Collectors.toList()));


    }
}
