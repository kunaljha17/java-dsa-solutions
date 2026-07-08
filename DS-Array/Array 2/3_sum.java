import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
                //this greater than 0 bcz if i =0 then nums [-1] give error
            if (i > 0 && nums[i] == nums[i - 1]) {//Hnadling duplicates
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) { // here also handling duplicate after jth element
                        j++; // just increase
                    }

                    while (j < k && nums[k] == nums[k - 1]) { // for handling k th element with k-1 th duplicate element
                        k--; // decrease
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return list;
    }
}




// nums = [-1,0,1,2,-1,-4]
// Sort this array 
// then fix ith element 
// two pointer appraoch j = i+1 k = n -1
// duplicate i then skip using contiue iteration
//totalSum =0 // then save to arraylist and this save to list
// here also handle j th and kth duplicate element
// totalSum is -ve then incre j ++
// if positive then k--;
