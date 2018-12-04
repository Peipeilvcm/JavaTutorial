package oj.swordtooffer;

public class STO47_BackTrack {
    // 剑指offer矩阵中的路径

    boolean[][] used;
    int[][] d = {{0,-1},{0,1},{1,0},{-1,0}};
    boolean res;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        res = false;
        used = new boolean[rows][cols];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                used[i][j] = false;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; ++j){
                helper(matrix, rows, cols, i, j, str, 0);
            }
        }

        return res;
    }
    public boolean isInArea(int x, int y, int rows, int cols){
        if((x < rows && x >= 0 && y < cols && y >= 0)){
            return true;
        }else{
            return false;
        }
    }
    public void helper(char[] m, int rows, int cols, int x, int y, char[] str, int index){
        if(res){
            return;
        }

        if(str[index] == m[x*cols+y]){
            if(index + 1 == str.length){
                res = true;
                return;
            }

            used[x][y] = true;
            for(int i = 0; i < 4; ++i){
                int x0 = x + d[i][0];
                int y0 = y + d[i][1];
                if(isInArea(x0,y0,rows,cols) && !used[x0][y0]){
                    helper(m, rows, cols, x0, y0, str, index+1);
                }
            }
            used[x][y] = false;
        }
    }
}
