//Approach to find total number of refills needs combine of both alice and bob 
//don't think anything imaginary just focus what we need and solve with that way

class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refills = 0;
        int i = 0, j = plants.length - 1;
        int waterA = capacityA, waterB = capacityB;

        while (i < j) {
            if (waterA < plants[i]) {//agr waterA kaam hua toh refil
                refills++;
                waterA = capacityA;
            }
            waterA -= plants[i];
            if (waterB < plants[j]) { //yaha water B refill check by plant require water
                refills++;
                waterB = capacityB;
            }
            waterB -= plants[j];

            i++;
            j--;

        }
        if (i == j) {//finally reach at same plant then also check does any one has suffcient water to watering plant in there cann...
            int remaining = Math.max(waterA, waterB);
            if (remaining < plants[i]) { //not then enough then refill then watering
                refills++;
            }
        }
        return refills;
    }
}
