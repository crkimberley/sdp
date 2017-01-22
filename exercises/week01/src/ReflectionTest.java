import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Chris Kimberley
 */
public class ReflectionTest {
    public static void main(String[] args) {
        new ReflectionTest().launch();
    }

    private void launch() {
        try {
            Class myClass = Class.forName("ReflectionTestObject");
            Constructor[] constructors = myClass.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            String[] argumentStrings = new String[] {"Bill", "1", "2", "true"};
            Object[] arguments = new Object[argumentStrings.length];
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = Class.forName(argumentStrings[i]).
                        getConstructor(String.class).newInstance(argumentStrings[i]);
            }
            Object newObject = constructors[0].newInstance(arguments);
            ReflectionTestObject testObject = (ReflectionTestObject) newObject;

            System.out.println(newObject.getClass().getName());
            System.out.println(testObject.getName());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
