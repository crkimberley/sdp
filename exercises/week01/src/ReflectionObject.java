import java.util.Scanner;

/**
 * @author Chris Kimberley
 */
public class ReflectionObject {
    public static void main(String[] args) {
        new ReflectionObject().launch();
    }

    private void launch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a class name: ");
        String classname = input.nextLine();
        System.out.print("Enter a list of arguments for the constructor: ");
    }
}


