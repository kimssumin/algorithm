import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1){
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums, Collections.reverseOrder());
        int plus_cnt = 0;
        for (int i : nums){
            if (i > 0){
                plus_cnt ++;
            }
        }
        Integer[] plus_arr = Arrays.copyOfRange(nums, 0, plus_cnt);
        Integer[] minus_arr = Arrays.copyOfRange(nums, plus_cnt, nums.length);

        int sum1 = sum_lst(plus_arr, plus_arr.length);
        Arrays.sort(minus_arr);
        int sum2 = sum_lst(minus_arr, minus_arr.length);
        System.out.println(sum1 + sum2);
        br.close();
    }

    private static int sum_lst(Integer[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++){
            if( i+1 < n && nums[i]*nums[i+1] > nums[i] + nums[i+1]){
                sum += nums[i]*nums[i+1];
                i++;
            }
            else{
                sum += nums[i];
            }
        }
        return sum;
    }
}


/*


 */