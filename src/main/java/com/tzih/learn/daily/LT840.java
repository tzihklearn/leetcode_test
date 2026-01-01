package com.tzih.learn.daily;

public class LT840 {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                if (grid[r + 1][c + 1] != 5) {
                    continue;
                }
                if (isMagicSquare(
                        grid[r][c], grid[r][c + 1], grid[r][c + 2],
                        grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                        grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]
                )) {
                    count++;
                }
            }
        }

        return count;
    }


    private boolean isMagicSquare(int... vals) {
        int[] frequency = new int[16];
        for (int value : vals) {
            if (value < 1 || value > 9) {
                return false;
            }
            frequency[value]++;
        }
        for (int num = 1; num <= 9; num++) {
            if (frequency[num] != 1) {
                return false;
            }
        }

        return (vals[0] + vals[1] + vals[2] == 15 && // 第一行
                vals[3] + vals[4] + vals[5] == 15 && // 第二行
                vals[6] + vals[7] + vals[8] == 15 && // 第三行
                vals[0] + vals[3] + vals[6] == 15 && // 第一列
                vals[1] + vals[4] + vals[7] == 15 && // 第二列
                vals[2] + vals[5] + vals[8] == 15 && // 第三列
                vals[0] + vals[4] + vals[8] == 15 && // 主对角线
                vals[2] + vals[4] + vals[6] == 15);  // 副对角线
    }
}
