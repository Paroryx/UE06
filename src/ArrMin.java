import java.util.Arrays;

public class ArrMin {
    public static void main(String[] args) {
        testMin();
    }
    private static void testMin(){
        int[] test1 = new int[]{10, 11, 2, 2};
        int[] test2 = new int[]{2, 2, 10, 11};
        int[] test3 = new int[]{-1, 3, -2, 4, -5};
        int[] test4 = new int[]{-2, 4, -5, -1, 3};
        int[] test5 = new int[]{-5, -1, 3, -2, 4};
        int[] test6 = new int[]{0, 12, 23, 22, 0};
        int[] test7 = new int[]{1, -1, 0, -1, 1};

        testMinWith(test1);
        testMinWith(test2);
        testMinWith(test3);
        testMinWith(test4);
        testMinWith(test5);
        testMinWith(test6);
        testMinWith(test7);
    }
    private static void testMinWith(int... arr){
        Out.println("testing min:");
        Out.println(" arr = %s".formatted(Arrays.toString(arr)));
        Out.println(" Result = %d".formatted(min(arr)));
    }

    

    private static int min(int... arr){
        return min(arr,0, arr.length-1);
    }

    private static int min(int[] arr, int from, int to){
        if(from == to){
            return arr[from];
        }else if(from == to-1){
            return Math.min(arr[from],arr[to]);
        }else{
            int mid = (from + to) / 2;
            int minLowerHalf = min(arr, from, mid);
            int minUpperHalf = min(arr, mid + 1, to);
            return Math.min(minLowerHalf, minUpperHalf);
        }
    }
}
