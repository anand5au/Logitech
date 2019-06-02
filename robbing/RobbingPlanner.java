import lombok.val;

import java.util.Vector;

public class RobbingPlanner {

    // Assumption: The max robbed amount will not exceed Long.MAX_VALUE (2^63 -1).
    public long getMaxRobbedAmount(final Vector<Integer> moneyStashed) {

        val inputSize = moneyStashed == null ? 0 : moneyStashed.size();

        if (inputSize <= 0) {
            return 0;
        }
        if (inputSize == 1) {
            return moneyStashed.get(0);
        }
        if (inputSize == 2) {
            return Math.max(moneyStashed.get(0), moneyStashed.get(1));
        }

        /*
         * maxRobbedValues array stores maximum money that can be robbed until the house at any index.
         * At any house 'i' the max money robbed until that house can be determined by finding the
         * maximum of following 2 values.
         *  moneyStashed.get(i) + maxRobbedValues[i-2] (if I choose to rob current house)
         *  maxRobbedValues(i-1)) (if I choose not to rob current house)
         */
        val maxRobbedValues = new long[inputSize];
        maxRobbedValues[0] = moneyStashed.get(0);
        maxRobbedValues[1] = Math.max(moneyStashed.get(0), moneyStashed.get(1));

        for (int index = 2; index < inputSize; index++) {
            maxRobbedValues[index] = Math.max(moneyStashed.get(index) + maxRobbedValues[index - 2], maxRobbedValues[index - 1]);
        }

        // return the maximum amount that can be robbed until the last house
        return maxRobbedValues[inputSize-1];
    }

}
