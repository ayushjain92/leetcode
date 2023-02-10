import java.util.Arrays;

class LIS {

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        int answer = lis.lengthOfLIS(nums);
        System.out.println(answer);
    }

    public int[] getLIS(int[] nums) {
        // Input: [10, 22, 9, 33, 21, 50, 41, 60, 80]
        // LIS = 6 ([10, 22, 33, 50, 60, 80])

        //10: s = [0], parent = [-1]
        //22: s= [0, 1], p=  [-1, 0]
        //9: s= [2, 1], p = [-1, 0 ,-1]
        //33: s = [2, 1, 3], p =  [-1, 0, -1, 1], arr = [9, 22, 33]
        //21: s = {2,4,3}, p = {-1, 0, -1, 1, 2}, arr = {9, 21, 33}
        //50: s = {2, 4, 3, 5} , p = {-1, 0, -1, 1, 2, 3}, arr = {9, 21, 33, 50}
        //41: s = {2, 4, 3, 6} , p = {-1, 0, -1, 1, 2, 3, 3}, arr = {9, 21, 33, 41}
        //60: s = {2, 4, 3, 6, 7} , p = {-1, 0, -1, 1, 2, 3, 3, 6}, arr = {9, 21, 33, 41, 60}
        //80: s = {2, 4, 3, 6, 7, 8} , p = {-1, 0, -1, 1, 2, 3, 3, 6, 7}

        // print nums[S[j]]] = 80
        // print nums[parent[j]] = nums[7] = 60
        // print nums[parent[7]] = nums[6] = 50
        // print nums[parent[6]] = nums[3] = 33
        // print nums[parent[3]] = nums[1] = 22
        // print nums[parent[1]] = nums[0] = 10

        int n = nums.length;
        int[] s = new int[n];
        int[] parent = new int[n];
        Arrays.fill(s, -1);
        Arrays.fill(parent, -1);



        return s;
    }

    public int lengthOfLIS(int[] nums) {
        // Input: [10, 22, 9, 33, 21, 50, 41, 60, 80]
        // LIS = 6 ([10, 22, 33, 50, 60, 80])

        //10
        //10, 22
        //9, 22
        //9, 22, 33
        //9, 21, 33
        //9, 21, 33, 50
        //9, 21, 33, 41
        //9, 21, 33, 41, 60
        //9, 21, 33, 41, 60, 80
        // 6


        // [0,1,0,3,2,3]
        //0
        //0, 1
        //0, 1
        //0, 1, 3
        //0, 1, 2
        //0, 1, 2, 3
        int n = nums.length;
        int[] lisArray = new int[n];
        Arrays.fill(lisArray, -1);
        lisArray[0] = nums[0];
        int j = 1;

        for (int i = 1; i < n; i++) {
            //System.out.println(Arrays.toString(lisArray));
            //System.out.println("j:" + j);
            //System.out.println("New value:" + nums[i]);
            if (lisArray[j - 1] < nums[i]) {
                lisArray[j] = nums[i];
                j++;
            } else {
                int index = binSearch(lisArray, nums[i], 0, j - 1);
                lisArray[index] = nums[i];
            }
            //System.out.println("-----");
        }
        return j;
    }

    private int binSearch(int arr[], int value, int l, int h) {
        int index = 0;
        if (l == h) {
            return l;
        }

        while (l <= h) {
            int mid = l + ((h - l) / 2);

            if (l == h) {
                return l;
            }
            if (l+1 == h) {
                if(arr[l] >= value) {
                    return l;
                } else {
                    return h;
                }
            }

            if (arr[mid] == value) {
                index = mid;
                break;
            }

            if (arr[mid] > value && arr[mid - 1] < value) {
                index = mid;
                break;
            } else if (arr[mid] > value) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return index;
    }
}