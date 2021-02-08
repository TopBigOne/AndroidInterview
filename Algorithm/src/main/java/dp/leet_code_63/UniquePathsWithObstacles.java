package dp.leet_code_63;

import java.util.Arrays;


/**
 * @author : dev
 * @version :
 * @Date :  1/26/21 11:15 PM
 * @Desc : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 *
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * <p>
 * 输出:2
 */
public class UniquePathsWithObstacles {
    public int uniquePathWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && ints[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    /**
     * @param obstacleGrid
     * @return {
     * {0, 0, 0},
     * {0, 1, 0},
     * {0, 0, 0}
     * };
     */
    public int uniquePathWithObstacles2(int[][] obstacleGrid) {
        // 多少行
        int n = obstacleGrid.length;
        // 多少列
        int m = obstacleGrid[0].length;
        System.out.println("n : " + n + ", m : " + m);
        int[] f = new int[m];
        // 数组的左上角，第一的元素，是 0 吗？
        // 是的话，就赋值为 1，反之就赋值为 0；
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // 开始，数组一行一行的遍历
        for (int[] ints : obstacleGrid) {
            System.out.println("ints-item: " + Arrays.toString(ints));
//            ints-item: [0, 0, 0]
//            ints-item: [0, 1, 0]
//            ints-item: [0, 0, 0]
//            ints-item: [0, 0, 0]
            // 开始遍历列
            for (int j = 0; j < m; j++) {
                // 如果是障碍物
                if (ints[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && ints[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathWithObstacles3(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];
    }

    public int uniquePathWithObstacles4(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            // 按照行遍历时，用的是列的跨度，这有点像 x-y 轴坐标系中，就坐标点，距x，y 轴的距离；
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];
    }

    public int uniquePathWithObstacles5(int[][] raws) {
        int n = raws.length;
        int m = raws[0].length;
        int[] f = new int[m];
        f[0] = raws[0][0] == 0 ? 1 : 0;
        for (int[] raw : raws) {
            for (int i = 0; i < m; i++) {
                if (raw[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && raw[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];
    }

    public int uniquePathWithObstacles6(int[][] raws) {
        int n = raws.length;
        int m = raws[0].length;
        int[] f = new int[m];
        f[0] = raws[0][0] == 0 ? 1 : 0;
        for (int[] raw : raws) {
            for (int i = 0; i < m; i++) {
                if (raw[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && raw[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];
    }


    public int uniquePathWithObstacles8(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];

    }

    public int uniquePathWithObstacles9(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathWithObstacles10(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];
    }


    public int uniqueMathWithObstacles11(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];

    }

    public int uniqueMathObstacles12(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // 遍历行
        for (int[] ints : obstacleGrid) {
            // 遍历每一行的每一列
            for (int i = 0; i < m; i++) {
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[m - 1];


    }

    public int uniquePathWithObstacles13(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // loop row
        for (int[] ints : obstacleGrid) {
            // loop cloumn
            for (int i = 0; i < m; i++) {
                // ints[i]==1 ，表示遇到了障碍物；
                if (ints[i] == 1) {
                    f[i] = 0;
                    continue;
                }
                // i-1>=0 ,也是可以的！
                if (i - 1 >= 0 && ints[i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }

        return f[m - 1];

    }

    public int uniquePathsWithObstacles14(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int []f = new int[m];
        f[0] = obstacleGrid[0][0]==0? 1:0;
        // 遍历二维数组的行
        for(int [] ints :obstacleGrid){
            // 遍历列
            for(int i = 0;i <m;i++){
                // 说明是障碍物
                if(ints[i]==1){
                    f[i] = 0;
                    continue;
                }
                if(i-1>=0&&ints[i-1]==0){
                    // 累加
                    f[i]+=f[i-1];
                }

            }
        }

        return f[m-1];


    }


}
