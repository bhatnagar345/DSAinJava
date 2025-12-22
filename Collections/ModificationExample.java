package Collections;
import java.util.*;

public class ModificationExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");

        System.out.println("Original list: " + list);
        Collections.sort(list); // Sorts alphabetically
        System.out.println("Sorted list: " + list);

        int index = Collections.binarySearch(list, "Banana");
        System.out.println("Index of 'Banana' is: " + index);

        String min = Collections.min(list);
        System.out.println("Minimum element: " + min);

        String max = Collections.max(list);
        System.out.println("Maximum element: " + max);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Original list: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed list: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled list: " + numbers);

        Collections.swap(numbers, 0, 4);
        System.out.println("Swapped first and last: " + numbers);

        List<Integer> destination = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        Collections.copy(destination, numbers);
        System.out.println("Copied list: " + destination);

        Collections.fill(numbers, 99);
        System.out.println("Filled list: " + numbers);

        List<String> fruits = new ArrayList<>();
        Collections.addAll(fruits, "Apple", "Banana", "Cherry");
        System.out.println("Added all: " + fruits);

        List<String> emptyList = Collections.emptyList();
        System.out.println("Empty list: " + emptyList);

        Set<String> singletonSet = Collections.singleton("Hello");
        System.out.println("Singleton set: " + singletonSet);

        List<Integer> multiCopies = Collections.nCopies(3, 100);
        System.out.println("List with multiple copies: " + multiCopies);

        List<Integer> src = Arrays.asList(1,2,3,4,5,6);
        List<Integer> tgt = Arrays.asList(2,3,4);
        System.out.println(Collections.indexOfSubList(src,tgt));
    }
}

