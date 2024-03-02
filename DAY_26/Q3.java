package DAY_26;
import java.util.Scanner;

// Definition of ListNode class
class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node in the list

    // Constructor for ListNode class
    ListNode(int val) {
        this.val = val; // Initialize node value
        this.next = null; // Initialize next pointer to null
    }
}

public class Q3 {

    // Method to merge k sorted lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null; // If the input array is empty, return null
        }
        return mergeLists(lists, 0, lists.length - 1); // Merge lists recursively
    }

    // Recursive method to merge lists
    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start]; // Base case: only one list
        }
        int mid = start + (end - start) / 2; // Calculate the midpoint
        ListNode left = mergeLists(lists, start, mid); // Merge left sublist
        ListNode right = mergeLists(lists, mid + 1, end); // Merge right sublist
        return merge(left, right); // Merge both sublists
    }

    // Method to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0); // node type node to simplify merging
        ListNode curr = node; // Pointer to the current node in the merged list

        while (l1 != null && l2 != null) { // Merge while both lists have nodes
            if (l1.val < l2.val) {
                curr.next = l1; // Connect current node to l1
                l1 = l1.next; // Move to the next node in l1
            } else {
                curr.next = l2; // Connect current node to l2
                l2 = l2.next; // Move to the next node in l2
            }
            curr = curr.next; // Move to the next node in the merged list
        }

        // Connect remaining nodes
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return node.next; // Return the merged list
    }

    // Method to create a linked list from user input
    private ListNode createListFromInput(Scanner scanner) {
        ListNode dummy = new ListNode(0); // Dummy node for simplicity
        ListNode current = dummy; // Pointer to the current node

        System.out.println("Enter the elements of the list separated by space (enter 'done' to finish):");
        while (scanner.hasNextInt()) { // Read integers until 'done' is entered
            int val = scanner.nextInt(); // Read the next integer
            current.next = new ListNode(val); // Create a new node with the value
            current = current.next; // Move to the next node
        }

        return dummy.next; // Return the first node of the created list
    }

    // Main method
    public static void main(String[] args) {
        Q3  solution = new Q3 (); // Create an instance of the solution class
        Scanner scanner = new Scanner(System.in); // Create a scanner object to read user input

        System.out.print("Enter the number of lists: "); // Prompt user for the number of lists
        int k = scanner.nextInt(); // Read the number of lists
        ListNode[] lists = new ListNode[k]; // Create an array to store the lists

        // Prompt user to input each list
        for (int i = 0; i < k; i++) {
            lists[i] = solution.createListFromInput(scanner); // Create each list
        }

        // Merge the lists
        ListNode mergedList = solution.mergeKLists(lists); // Merge the lists

        // Print the merged list
        while (mergedList != null) { // Traverse the merged list
            System.out.print(mergedList.val + " -> "); // Print the value of the current node
            mergedList = mergedList.next; // Move to the next node
        }
        System.out.println("null"); // Print 'null' to indicate the end of the list

        scanner.close(); // Close the scanner
    }
}
