import java.util.List;

public class FunctionalProgramming01 {
    public static void main(String[] args){
        printAllNumbersInListStructure(List.of(12,9,13,4,6,2,4,12,15));
        printAllNumbersInFunctionalApproach(List.of(12,9,13,4,6,2,4,12,15));
        printAllNumbersInFunctionalApproachSimplified(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInFunctionalApproachSimplified(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInFunctionalApproachLambda(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInFunctionalApproachLambdaWithMapping(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListStructure(List<Integer> numbers) {
        //How to loop the numbers?
        // For loop, classic approach
        for(int number:numbers){
            System.out.println(number);
        }
    }

    private static void printAllNumbersInFunctionalApproach(List<Integer> numbers) {
        //What to do?
        numbers.stream().
                forEach(FunctionalProgramming01::print); // this is called a method reference
    }

    private static void print(int number){
        System.out.println(number);
    }

    private static void printAllNumbersInFunctionalApproachSimplified(List<Integer> numbers) {
        numbers.stream().
                forEach(System.out::println); // this is called a method reference
    }

    private static void printEvenNumbersInFunctionalApproachSimplified(List<Integer> numbers) {
        numbers.stream().
                filter(FunctionalProgramming01::isEven). // add filter
                forEach(System.out::println); // this is called a method reference
    }

    private static boolean isEven(int number){
        return number%2 == 0;
    }

    private static void printEvenNumbersInFunctionalApproachLambda(List<Integer> numbers) {
        numbers.stream().
                filter(x -> x%2 == 0). // Lambda expression
                forEach(System.out::println); // this is called a method reference
    }

    private static void printEvenNumbersInFunctionalApproachLambdaWithMapping(List<Integer> numbers) {
        numbers.stream().
                map(x -> x*x). // mapping expression to apply some logic for every value.
                filter(x -> x%2 == 0). // Lambda expression
                forEach(System.out::println); // this is called a method reference
    }
}
