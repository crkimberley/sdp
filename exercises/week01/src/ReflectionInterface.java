import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.Class.*;

/**
 * @author Chris Kimberley
 */
public class ReflectionInterface {
    public static void main(String[] args) {
        new ReflectionInterface().launch(args.length >=1 ? args[0] : "ReflectionInterface");
    }

    private void launch(String classname) {
        Class aClass;
        try {
            aClass = forName(classname);
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