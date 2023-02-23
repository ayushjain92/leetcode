public class CircularSubarraySum {

    static int N = 8;
    public static int kadane(int[] arr) {
        int maxSoFar = 0, maxEndingHere = 0;

        for(int i = 0; i < arr.length; i++) {
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            maxEndingHere = maxEndingHere + arr[i];
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void maxSubArraySum(int arr[]) {
        System.out.println(kadane(arr));
    }

    public static void circularSubArraySum(int arr[]) {
        int case1 = kadane(arr);

        int total = 0;
        for (int i=0; i<arr.length; i++) {
            total = total+arr[i];
            arr[i] = -arr[i];
        }

        int case2 = total + kadane(arr);

        System.out.println(Math.max(case1, case2));
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        //maxSubArraySum(arr);
        circularSubArraySum(arr);
    }
}
