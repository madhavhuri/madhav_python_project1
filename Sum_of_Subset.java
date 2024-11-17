
import java.util.*;

public class Sum_of_Subset {
    
    public static void findSubsets(int[] nums, int index, List<Integer> currentSubset, int currentSum, int targetSum) {
        
        if (currentSum == targetSum) {
            System.out.println(currentSubset);
            return;
        }

        
        for (int i = index; i < nums.length; i++) {
        
            if (currentSum + nums[i] <= targetSum) {
                currentSubset.add(nums[i]);
                findSubsets(nums, i + 1, currentSubset, currentSum + nums[i], targetSum);
                
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 5, 18, 12, 20, 15};
        int targetSum = 35;

        Arrays.sort(nums); 
        System.out.println("Subsets with sum equal to " + targetSum + " are:");
        findSubsets(nums, 0, new ArrayList<>(), 0, targetSum);
    }
}
