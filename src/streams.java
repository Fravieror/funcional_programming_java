import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
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
        System.out.println(sum);
        sortingStringsFunctional(courses);
        sortingByCategory();
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

        System.out.println(courses.stream().
                sorted(comparingByNoOfstudentsDecreasing).
                limit(5).
                collect(Collectors.toList()));

        System.out.println(courses.stream().
                sorted(comparingByNoOfstudentsDecreasing).
                skip(3). // skip the first tree results
                collect(Collectors.toList()));


        System.out.println(courses.stream().
                sorted(comparingByNoOfstudentsDecreasing).
                takeWhile(o -> courses.equals("java")). // It prints elements indicated
                        collect(Collectors.toList()));

        System.out.println(courses.stream().
                sorted(comparingByNoOfstudentsDecreasing).
                dropWhile(o -> courses.equals("java")). // It not prints elements indicated
                        collect(Collectors.toList()));

        System.out.println(courses.stream()
                .filter(s -> s == "Java")
                .min(comparingByNoOfstudentsDecreasing)
                .orElse("other value")); // in case of it does not find some element this will be printed.

        System.out.println(courses.stream()
                .filter(s -> s == "Java")
                .mapToInt(value -> value.length())
                .sum());

        System.out.println(courses.stream()
                .filter(s -> s == "Java")
                .mapToInt(value -> value.length())
                .average());

        System.out.println(courses.stream()
                .filter(s -> s == "Java")
                .mapToInt(value -> value.length())
                .count());
    }

    private static void sortingByCategory(){
        List<Game> games = new ArrayList<>();
        games.add(new Game(200, "call of duty", "shooter"));
        games.add(new Game(180, "fortnite", "shooter"));
        games.add(new Game(200, "fifa21", "sports"));
        games.add(new Game(50, "for honor", "fighting"));
        games.add(new Game(150, "F1", "sports"));
        games.add(new Game(170, "UFC", "sports"));
        games.add(new Game(190, "Red redemption 2", "RPG"));



        System.out.println(games
                .stream()
                .collect(Collectors
                        .groupingBy(Game::getCategory)));

        System.out.println(games
                .stream()
                .collect(Collectors
                        .groupingBy(Game::getCategory, Collectors
                                .mapping(Game::getName, Collectors.toList())))); // It brings the name of each game ordered.

        System.out.println(games
                .stream()
                .collect(Collectors
                        .groupingBy(Game::getCategory, Collectors.counting()))); // It says the number of game in each category

        System.out.println(games
                .stream()
                .collect(Collectors
                        .groupingBy(Game::getCategory, Collectors
                                .maxBy(Comparator.comparing(Game::getCost))))); // It get the mos value game for each category
                                       // If various games have the same cost it brings the first


    }
}
