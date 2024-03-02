package DAY_26;
import java.util.Scanner;
// Define the Nodes class
class Nodes
{
    // Define instance variables for left, right, next pointers, and value
    Nodes left, right, next;
    int val;

    // Constructor for Nodes class
    public Nodes(int val)
    {
        // Initialize left, right, and next pointers to null and assign the value
        this.left = this.right = this.next = null;
        this.val = val;
    }

    // Override toString() method to print meaningful information
    @Override
    public String toString() {
        if (next != null) {
            return "Node(" + next.val + ")";
        } else {
            return "Node(null)";
        }
    }
}

// Define the populating_Next_Right class
class populating_Next_Right
{
    // Method to connect next pointers in the binary tree
    public Nodes connect(Nodes root)
    {
        // Start with the root node
        Nodes node = root;

        // Iterate through the tree until reaching a leaf node or a node with no left child
        while (node != null && node.left != null)
        {
            // Initialize a reference to the current node
            Nodes n = node;

            // Traverse the current level of the tree
            while (n != null)
            {
                // Set the next pointer of the left child to the right child
                n.left.next = n.right;

                // If the current node has a next node, set the next pointer of the right child
                // to the left child of the next node
                if (n.next != null)
                {
                    n.right.next = n.next.left;
                }

                // Move to the next node in the current level
                n = n.next;
            }

            // Move to the leftmost node in the next level
            node = node.left;
        }

        // Return the root node
        return node;
    }
}

// Define the Q2_Populating_Next_Right class
public class Q2
{
    // Main method
    public static void main(String[] args)
    {
        // Create the binary tree
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        // Create an instance of populating_Next_Right class
        populating_Next_Right obj = new populating_Next_Right();

        // Populate the next pointers in the binary tree
        obj.connect(root);

        // Print the values of the next pointers of specific nodes
        System.out.println(root.left.next.val);
        System.out.println(root.left.left.next);
    }
}
