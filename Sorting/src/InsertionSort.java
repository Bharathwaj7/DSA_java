import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {7,8,3,1,2};

        int n = arr.length;
        for(int i=1;i<n;i++){
            int current = arr[i];
            int j = i-1;
            while(j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        System.out.println(Arrays.toString(arr));
    }
}
