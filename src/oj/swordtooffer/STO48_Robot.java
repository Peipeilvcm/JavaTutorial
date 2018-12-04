package oj.swordtooffer;

public class STO48_Robot {
    int res = 0;
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] used;
    boolean isInArea(int x, int y, int rows, int cols){
        if((x < rows && x >= 0 && y < cols && y >= 0)){
            return true;
        }else{
            return false;
        }
    }
    boolean isOk(int k, int x, int y){
        int sum = 0;
        while(x != 0){
            sum += (x%10);
            x /= 10;
        }
        while(y != 0){
            sum += (y%10);
            y /= 10;
        }
        return sum <= k;
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        used = new boolean[rows][cols];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                used[i][j] = false;
            }
        }
        helper(threshold, 0, 0, rows, cols);
        return res;
    }

    public void helper(int k, int x, int y, int rows, int cols){
        if(isOk(k, x, y)){
            res++;
            used[x][y] = true;
            for(int i = 0; i < 4; ++i){
                int x0 = x + d[i][0];
                int y0 = y + d[i][1];
                if(isInArea(x0,y0,rows,cols) && !used[x0][y0]){
                    helper(k, x0, y0, rows, cols);
                }
            }
        }
    }
}
