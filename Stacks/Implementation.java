import java.util.Scanner;

public class Implementation {

    public int[] stackArr;
    public int capacity;
    public int top;

    public Implementation(int size) {
            capacity = size;
            stackArr = new int[capacity];
            top = -1;
        }

    public void push(int StackElement) {
        if (top >= capacity - 1) {
            System.out.println("Overflow!");
            return;
        }
        stackArr[top++] = StackElement;
    }

    public int pop(int StackElement) {
        if (top == -1) {
            System.out.println("Underflow!");
            return -1;
        }
        return stackArr[top];
    }

    public int topElementOfStack() {
        if (top == -1) {
            System.out.println("Stack is Empty!!");
        }
        return stackArr[top];
    }

    public void MethodSet(int x) {
        System.out.println(topElementOfStack());
        System.out.println(pop(x));
        push(x);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        int x = s.nextInt();
        Implementation i = new Implementation(x);
        i.MethodSet(x);

        s.close();
    }
}