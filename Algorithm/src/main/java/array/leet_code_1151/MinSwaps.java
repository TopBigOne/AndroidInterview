package array.leet_code_1151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/25 23:38
 * @Url :https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together/solution/
 * @Level :    medium
 * @Desc : 最少交换次数，来组合所有的1；
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together/solution/c-yi-ci-chuang-kou-bian-li-by-da-li-wang/
 */
public class MinSwaps {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int[] arr = new int[]{3, 4, 6};
        int a = arr[i++];
        int b = arr[++j];
        System.out.println("a: " + a);
        System.out.println("b: " + b);

    }

    public int minSwaps(int[] data) {
        // 统计1的个数
        int K = 0;
        for (int datum : data) {
            K += datum;
        }
        int onesCount = 0;
        for (int i = 0; i < K; i++) {
            onesCount += data[i];
        }

        int N = onesCount;
        int left = 0;
        int right = K - 1;
        while (right < data.length - 1) {
            onesCount += data[++right] - data[left++];
            N = Math.max(onesCount, N);
        }
        return K - N;

    }

    public int minSwaps2(int[] data) {
        int k = 0;
        for (int datum : data) {
            k += datum;
        }
        int onesCount = 0;
        for (int i = 0; i < k; i++) {
            onesCount += data[i];
        }

        int n = onesCount;
        int left = 0;
        int right = k - 1;
        while (right < data.length - 1) {
            onesCount += data[++right] - data[left++];
            n = Math.max(onesCount, n);
        }
        return k - n;
    }

    public int minSwaps3(int[] data) {
        int k = 0;
        for (int datum : data) {
            k += datum;
        }

        int onesCount = 0;
        for (int i = 0; i < k; i++) {
            onesCount += data[i];
        }
        int n = onesCount;
        int left = 0;
        int right = k - 1;
        while (right < data.length - 1) {
            onesCount += data[++right] - data[left++];
            n = Math.max(onesCount, n);
        }
        return k - n;

    }

    public int minSwaps4(int[] data) {
        int k = 0;
        for (int datum : data) {
            k += datum;
        }
        int onesCount = 0;
        for (int i = 0; i < k; i++) {
            onesCount += data[i];
        }

        int n = onesCount;
        int left = 0;
        int right = k - 1;
        while (right < data.length - 1) {
            onesCount += data[++right] - data[left++];
            n = Math.max(onesCount, n);
        }

        return k - n;
    }

    public int minSwaps5(int[] data) {
        int k = 0;
        for (int datum : data) {
            k += datum;
        }

        int onesCount = 0;
        for (int i = 0; i < k; i++) {
            onesCount += data[i];
        }
        int n = onesCount;
        int left = 0;
        int right = k - 1;
        while (right < data.length - 1) {
            onesCount += data[++right] - data[left++];
            n = Math.max(onesCount, n);
        }

        return k - n;


    }


}
