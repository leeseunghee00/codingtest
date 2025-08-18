import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {

        int min = 0, left = 0, right = people.length - 1;

        Arrays.sort(people);
                
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
            min++;
        }
        
        return min;
    }
}