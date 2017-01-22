import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Chris Kimberley
 */
public class ReflectionObject {
    public static void main(String[] args) {
        new ReflectionObject().launch();
    }

    private void launch() {
        /*String classname = "ReflectionTestObject";
        String argumentString =
                "java.lang.String text java.lang.Integer 42 java.lang.Integer 17 java.lang.Boolean true";*/
        Scanner input = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String classname = input.nextLine();
        System.out.print("Enter arguments (Type Value Type Value...): ");
        String argumentString = input.nextLine();
        String[] argumentStrings = argumentString.split(" ");
        int numberOfArguments = argumentStrings.length/2;
        String[] argumentTypes = new String[numberOfArguments];
        String[] argumentValues = new String[numberOfArguments];
        for (int i = 0; i < argumentStrings.length; i += 2) {
            argumentTypes[i / 2] = argumentStrings[i];
            argumentValues[i / 2] = argumentStrings[i + 1];
        }

        try {
            Class aClass = Class.forName(classname);
            Constructor[] constructors = aClass.getConstructors();
            Constructor matchedConstructor = null;
            for (Constructor constructor : constructors) {
                Class[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == numberOfArguments) {
                    String[] parameterNames = new String[numberOfArguments];
                    for (int i = 0; i < numberOfArguments; i++) {
                        parameterNames[i] = parameterTypes[i].getName();
                    }
                    if (Arrays.equals(parameterNames, argumentTypes)) {
                        matchedConstructor = constructor;
                        break;
                    }
                }
            }
            if (matchedConstructor != null) {
                Object[] arguments = new Object[numberOfArguments];
                for (int i = 0; i < numberOfArguments; i++) {
                    arguments[i] = Class.forName(argumentTypes[i]).
                            getConstructor(String.class).newInstance(argumentValues[i]);
                }
                Object createdObject = matchedConstructor.newInstance(arguments);

                System.out.print("\nReflectively created a new object of > ");
                System.out.println(createdObject.getClass().toGenericString());
                System.out.println("toString: " + createdObject.toString());

                /*System.out.println("\nCast in order to use methods...");
                ReflectionTestObject reflectionTestObject = (ReflectionTestObject) createdObject;
                System.out.println("name: " + reflectionTestObject.getName());
                System.out.println("number1: " + reflectionTestObject.getNumber1());
                System.out.println("number2: " + reflectionTestObject.getNumber2());
                System.out.println("truth: " + reflectionTestObject.isTruth());
                System.out.println("number1 * number2 = " + reflectionTestObject.product());*/
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}