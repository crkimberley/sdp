/**
 * @author Chris Kimberley
 */
public class ReflectionTestObject {
    private String name;
    private Integer number1;
    private Integer number2;
    private Boolean truth;

    public ReflectionTestObject(String name, Integer number1, Integer number2, Boolean truth) {
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.truth = truth;
    }

    String getName() {
        return name;
    }

    int getNumber1() {
        return number1;
    }

    int getNumber2() {
        return number2;
    }

    boolean isTruth() {
        return truth;
    }

    int product() {
        return number1 * number2;
    }

    public static void main(String[] args) {
        ReflectionTestObject reflectionTestObject =
                new ReflectionTestObject("derek", 11, 22, false);
        System.out.println("\nname: " + reflectionTestObject.getName() +
                            "\nnumber1 = " + reflectionTestObject.getNumber1() +
                            "\nnumber2 = " + reflectionTestObject.getNumber2() +
                            "\ntruth: " + reflectionTestObject.isTruth());
    }
}