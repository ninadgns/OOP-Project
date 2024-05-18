// import java.util.LinkedHashSet;
// import java.util.Iterator;

// public class Hashset {
//     public static void main(String[] args) {
//         // Create a LinkedHashSet
//         LinkedHashSet<String> set = new LinkedHashSet<>();

//         // Add elements to the LinkedHashSet
//         set.add("Apple");
//         set.add("Banana");
//         set.add("Cherry");
//         set.add("Date");
//         set.add("Apple"); // Duplicate element, will not be added

//         // Display the LinkedHashSet
//         System.out.println("LinkedHashSet: " + set);

//         // Check if an element is present
//         if (set.contains("Banana")) {
//             System.out.println("Banana is present in the set.");
//         }

//         // Remove an element
//         // set.remove("Date");
//         System.out.println("LinkedHashSet after removing Date: " + set);

//         // Iterate through the LinkedHashSet
//         System.out.println("Iterating through LinkedHashSet:");
//         Iterator<String> iterator = set.iterator();
//         while (iterator.hasNext()) {
//             System.out.println(iterator.next());
//         }

//         // Get the size of the LinkedHashSet
//         System.out.println("Size of the LinkedHashSet: " + set.size());
//     }
// }
