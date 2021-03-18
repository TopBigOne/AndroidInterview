package stack.leet_code_85;

import com.sun.org.glassfish.external.amx.AMX;

/**
 * @author : dev
 * @version :
 * @Date :  3/18/21 9:20 PM
 * @Desc :
 */
public class MaximalRectangle3 {
    public int maximalRectangle(char [][] matrix){
        int rows ;
        if(matrix==null||(rows= matrix.length)==0){
            return 0;
        }
        int cols = matrix[0].length;
        int [][] grid = new int[rows][cols];
        buildHistogram(matrix,grid);
        int max = 0;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max,maxRec(grid,i));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {

        int cols = matrix[0].length;
        for (int j = 0; j <cols; j++) {
            grid[0][j]  = matrix[0][j]=='1'? 1:0;
        }
        int rows = matrix.length;
        for(int i = 0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                
            }
        }


    }
}
