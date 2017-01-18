import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static java.lang.Class.*;

/**
 * @author Chris Kimberley
 */
public class ReflectionInterface {
    public static void main(String[] args) {
        new ReflectionInterface().launch();
    }

    private void launch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of a class: ");
        String classname = input.nextLine();
           try {
            Class aClass = forName(classname);
            System.out.println("\nName: " + aClass.getName());
            System.out.println("Name without package: " + aClass.getSimpleName());

            System.out.println("\nClass or Interface: "
                    + (aClass.isInterface() ? "Interface" : "Class:"));

            int modifiers = aClass.getModifiers();
            System.out.println("\nModifiers...");
            if (Modifier.isPublic(modifiers)) {System.out.println("public");}
            if (Modifier.isProtected(modifiers)) {System.out.println("protected");}
            if (Modifier.isPrivate(modifiers)) {System.out.println("private");}
            if (Modifier.isAbstract(modifiers)) {System.out.println("abstract");}
            if (Modifier.isFinal(modifiers)) {System.out.println("final");}
            if (Modifier.isInterface(modifiers)) {System.out.println("interface");}
            if (Modifier.isStatic(modifiers)) {System.out.println("static");}

            Constructor[] constructors= aClass.getConstructors();
            System.out.println("\nConstructors...");
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            
            Method[] methods = aClass.getDeclaredMethods();
            System.out.println("\nPublic & Private Methods...");
            for (Method method : methods) {
                System.out.println(method);
            }

            Field[] fields = aClass.getDeclaredFields();
            System.out.println("\nPublic & Private Fields");
            for (Field field : fields) {
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}