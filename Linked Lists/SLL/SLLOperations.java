
import java.util.Scanner;

class SLL {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Insert at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);  //this creates a seperate Node in free space.

        if (head == null) {
            head = tail = newNode;  //newnode --> head, newnode ---> tail.
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }
    // TC: O(1)

    // Insert at End (Optimized using tail)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }
    // TC: O(1)

    // Insert at Position (1-based index)
    public void insertAtPosition(int data, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid Position!");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        if (position == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    // TC: O(n)

    // Delete at Beginning
    public void deleteAtBeginning() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }
    // TC: O(1)

    // Delete at End
    public void deleteAtEnd() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
        size--;
    }
    // TC: O(n)

    // Delete by Value
    public void deleteByValue(int value) {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        if (head.data == value) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found!");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
        size--;
    }
    // TC: O(n)

    // Display
    public void display() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Size: " + size);
    }
    // TC: O(n)
}

public class SLLOperations {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SLL list = new SLL();

        while (true) {

            System.out.println("\n========= SINGLY LINKED LIST MENU =========");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Display List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = s.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int val1 = s.nextInt();
                    list.insertAtBeginning(val1);
                    System.out.println("Inserted successfully!");
                    list.display();
                    break;

                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int val2 = s.nextInt();
                    list.insertAtEnd(val2);
                    System.out.println("Inserted successfully!");
                    list.display();
                    break;

                case 3:
                    System.out.print("Enter value to insert: ");
                    int data = s.nextInt();
                    System.out.print("Enter position (1-based index): ");
                    int pos = s.nextInt();
                    list.insertAtPosition(data, pos);
                    list.display();
                    break;

                case 4:
                    System.out.println("Deleting node from beginning...");
                    list.deleteAtBeginning();
                    list.display();
                    break;

                case 5:
                    System.out.println("Deleting node from end...");
                    list.deleteAtEnd();
                    list.display();
                    break;

                case 6:
                    System.out.print("Enter value to delete: ");
                    int val3 = s.nextInt();
                    list.deleteByValue(val3);
                    list.display();
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    s.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
