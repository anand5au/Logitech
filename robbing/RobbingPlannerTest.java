import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class RobbingPlannerTest {

    private final RobbingPlanner robbingPlanner = new RobbingPlanner();
    private Vector<Integer> input;
    private long actualOutput;

    @Test
    public void testCase1() {
        input = new Vector<>(Arrays.asList(1,2,3,1));
        actualOutput = robbingPlanner.getMaxRobbedAmount(input);
        assertEquals(4, actualOutput);
        printTestCase(input, actualOutput,4);
    }

    @Test
    public void testCase2() {
        input = new Vector<>(Arrays.asList(4,5,1,3,6));
        actualOutput = robbingPlanner.getMaxRobbedAmount(input);
        assertEquals(11, actualOutput);
        printTestCase(input, actualOutput,11);
    }

    @Test
    public void testNullInput() {
        input = null;
        actualOutput = robbingPlanner.getMaxRobbedAmount(input);
        assertEquals(0, actualOutput);
        printTestCase(input, actualOutput,0);
    }

    @Test
    public void testEmptyInput() {
        input = new Vector<>();
        actualOutput = robbingPlanner.getMaxRobbedAmount(input);
        assertEquals(0, actualOutput);
        printTestCase(input, actualOutput,0);
    }

    private void printTestCase(final Vector<Integer> input, final long actualOutput, final long expectedOutput) {
        System.out.println("Input           : " + input);
        System.out.println("Actual Output   : " + actualOutput);
        System.out.println("Expected Output : " + expectedOutput);
        System.out.println();
    }
}
