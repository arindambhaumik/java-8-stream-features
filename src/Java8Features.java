import model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Example of Java 8 stream API features
 * Stream api, map/reduce/filter/flatMap/lambda-expression/method-reference/distinct/groupBy/count
 */
public class Java8Features {
    public static void main(String[] args) {
        System.out.println("----------- InStream API for Primitive data types ----------");
        System.out.println("Sum using IntStream::" + IntStream.range(1,10).sum());
        System.out.println("Sum using IntStream including last number::" + IntStream.rangeClosed(1,10).sum());
        System.out.println("Using InStream iterator:" + IntStream.iterate(1, e-> e+2).peek(System.out::println).limit(5).sum());

        System.out.println("boxed operation to collect InStream as a list:" + IntStream.iterate(1, e -> e + 5)
                .limit(5).boxed().toList());

        System.out.println("----------- Stream API ----------");
        String str = "Hello Java world Hello";
        //streamOperations(str);
        //funcProgramme();
        //employeeStream();

        List<String> alist= List.of(str.split(" "));
        System.out.println("Duplicate char using frequency method:" + alist.stream()
                .filter(s -> Collections.frequency(alist, s) > 1)
                .toList());

        //flatMap() example starts...
        List<List<String>> phones = List.of(List.of("1234","567","89","10,11,12"));
        System.out.println("Example 1. After Flattening:"  + phones.stream()
                .flatMap(Collection::stream)
                .toList());

        var list = List.of(5,6,7,8,10);
        System.out.println("Example 2. After flattening: " + list.stream().flatMap(l-> Stream.of(l+2,l+10)).toList());
        System.out.println("Example 3. Max value After flattening: " + list.stream()
                .flatMapToInt(l-> IntStream.of(l+2,l+10))
                .max()
                .getAsInt());
        // flatMap example ends...

        // String Palindrome checks
        System.out.println("is string is palindrome:" + isPalindrome("malayalam"));
    }

    private static boolean isPalindrome(String str) {

        String newStr = str.chars().mapToObj(s -> String.valueOf((char) s))
                .reduce((f, r) -> r + f)
                .orElse("");
        return str.equalsIgnoreCase(newStr);
    }

    private static void streamOperations(String str) {
        // total no of char present
        long totalChar = Arrays.stream(str.split("")).count();
        System.out.println("Total no of char: " + totalChar);

        // frequency of char present
        Map<String, Long> totalCharCount = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Occurrences of char: " + totalCharCount);

        // remove duplicate elements present
        List<String> removeDup = Arrays.stream(str.split(""))
                .distinct().toList();
        System.out.println("Remove duplicate: " + removeDup);

        // show duplicate elements
        List<String> dupChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Duplicate element present: " + dupChar);

    }

    private static void funcProgramme() {
        List<Integer> list = List.of(10,12,20,10,30,5,7);
        list.stream()
                .filter(num-> num % 2 == 0)
                .forEach(System.out::println);

        // sum of all elements
        System.out.println("Sum is: " + list.stream()
                //.reduce(0, (a, b) -> a + b));
                .reduce(0,Integer::sum)); // using Integer class default method reference sum()

        System.out.println("Max number is: " + list.stream()
                .reduce(0, Integer::max));
        System.out.println("Sum of square numbers: " + list.stream()
                .map(el-> el * el)
                .reduce(0,Integer::sum));

        System.out.println("------------------------");
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        courses.stream()
                .map(course-> course + " contains " + course.length() + " characters")
                .forEach(System.out::println);
    }

    private static void employeeStream(){
        List<Employee> employees = List.of(new Employee(1,"Arindam","A1",50000,"IT" ),
                new Employee(2,"Susmita","A2",60000,"IT" ),
                new Employee(3,"Adrian","B1",40000,"HRD" ),
                new Employee(4,"Sridhar","A1",80000,"Marketing" ));

        System.out.println(employees.stream().map(emp-> emp.getEmpId() + ":" + emp.getEmpName()).collect(Collectors.toList()));
        // sorting employees
        System.out.println("Employees in sorting order: " + employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpId)).toList());
        System.out.println("Employees sort by id and name: " + employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpId).thenComparing(Comparator.comparing(Employee::getEmpName))).toList());

    }
}