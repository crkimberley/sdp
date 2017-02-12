import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static java.lang.reflect.Modifier.isPrivate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Chris Kimberley
 */
public class StudentSubmissionTest {
    private static Class classUnderTest;
    private static Field[] fields;
    private static Method[] methods;
    private static Constructor[] constructors;


    @BeforeClass
    public static void setupClass() throws ClassNotFoundException {
        String classname = "StudentSubmission";
        classUnderTest = Class.forName(classname);
        fields = classUnderTest.getDeclaredFields();
        methods = classUnderTest.getDeclaredMethods();
        constructors = classUnderTest.getDeclaredConstructors();
    }

    @Test
    public void testNoMoreThan4Fields() {
        assertTrue(fields.length <= 4);
    }

    @Test
    public void testNoNonPrivateFields() {
        boolean privateFieldsExist = false;
        for (Field field : fields) {
            if (privateFieldsExist = !isPrivate(field.getModifiers())) {
                break;
            }
        }
        assertFalse(privateFieldsExist);
    }

    @Test
    public void testNoArrayListFields() {
        boolean arrayListFieldsExist = false;
        for (Field field : fields) {
            if (arrayListFieldsExist = field.getType() == ArrayList.class) {
                break;
            }
        }
        assertFalse(arrayListFieldsExist);
    }

    @Test
    public void testAtLeast2PrivateMethods() {
        int privateMethodCount = 0;
        for (Method method : methods) {
            if (Modifier.isPrivate(method.getModifiers()))
                privateMethodCount++;
        }
        assertTrue(privateMethodCount >= 2);
    }

    @Test
    public void testNoMethodsWithThrowsClauses() {
        boolean methodsWithThrowsClauses = false;
        for (Method method : methods) {
            if (methodsWithThrowsClauses = method.getExceptionTypes().length > 0) {
                break;
            }
        }
        assertFalse(methodsWithThrowsClauses);
    }

    @Test
    public void testNoMethodReturnsInt() {
        boolean methodReturnsInt = false;
        for (Method method : methods) {
            if (methodReturnsInt = method.getReturnType() == int.class) {
                break;
            }
        }
        assertFalse(methodReturnsInt);
    }

    @Test
    public void testHasZeroArgumentConstructor() {
        boolean zeroArgumentConstructorExists = false;
        for (Constructor constructor : constructors) {
            if (zeroArgumentConstructorExists = constructor.getParameterCount() == 0) {
                break;
            }
        }
        assertTrue(zeroArgumentConstructorExists);
    }
}