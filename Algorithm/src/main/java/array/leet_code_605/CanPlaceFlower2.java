package array.leet_code_605;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/18 23:20
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : 贪心，当前位置能种 就种；
 */
public class CanPlaceFlower2 {
    public static void main(String[] args) {
        CanPlaceFlower2 canPlaceFlower = new CanPlaceFlower2();
      //  canPlaceFlower.canPlaceFlowers()

    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;

        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            //判断当前位置能否种花
            //能种 ❀ 的情况
            int currValue = flowerbed[i];
            int nextPos = i + 1;
            int prePos = i - 1;

            if (currValue == 0
                    && (i + 1 == len || flowerbed[nextPos] == 0)
                    && (i == 0 || flowerbed[prePos] == 0)) {
                // 种上
                flowerbed[i] = 1;
                ans++;
            }
        }
        return ans >= n;

    }

}
