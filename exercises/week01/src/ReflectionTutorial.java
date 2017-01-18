import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author Chris Kimberley
 */
public class ReflectionTutorial {
    public static void main(String[] args) {
        new ReflectionTutorial().launch();
    }

    private void launch() {
        Class myClass = Integer.class;
        System.out.println("getName() " + myClass.getName() + " getSimpleName() " + myClass.getSimpleName());
        int modifiers = myClass.getModifiers();
        System.out.println("getModifiers(): " + modifiers);
        System.out.println("Modifier.isPublic(modifiers): " + Modifier.isPublic(modifiers));
        Method[] methods = myClass.getMethods();
        System.out.println("getMethods()...");
        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }
        System.out.println("getPackage(): " + myClass.getPackage());
        System.out.println("myClass.getSuperclass(): " + myClass.getSuperclass());
        System.out.println("myClass.getSuperclass().getSuperclass(): " + myClass.getSuperclass().getSuperclass());
        Constructor[] constructors = myClass.getConstructors();
        System.out.println("getConstructors(): " + Arrays.asList(constructors));
        try {
            Constructor intConstructor = myClass.getConstructor(new Class[]{int.class});
            System.out.println("getConstructor(new Class[]{int.class}): " + intConstructor);
            Constructor intConstructor2 = myClass.getConstructor(int.class);
            System.out.println("getConstructor(int.class): " + intConstructor2);
            Class[] parameterTypes = intConstructor.getParameterTypes();
            System.out.println("getParameterTypes(): " + Arrays.asList(parameterTypes));
            Integer myInteger = (Integer) intConstructor.newInstance(13);
            System.out.println("(Integer) intConstructor.newInstance(13): " + myInteger);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Field[] fields = myClass.getFields();
        System.out.println("getFields(): " + Arrays.asList(fields));
        Annotation[] annotations = myClass.getAnnotations();
        System.out.println("getAnnotations(): " + Arrays.asList(annotations));
    }
}
