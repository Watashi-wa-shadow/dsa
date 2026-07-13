//861. Score After Flipping Matrix
public class pblmNo861 {
    public int matrixScore(int[][] grid) {
        int countZero = 0;
        int countOne = 0;
        for(int i =0;i<grid.length;i++){
            if(grid[i][0] == 0){
                for(int j = 0;j<grid[0].length;j++){
                    if(grid[i][j] == 1)
                        grid[i][j] = 0;
                    else
                        grid[i][j] = 1;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j = 0;j<grid.length;j++){
                if(grid[j][i] == 1)
                    countOne++;
                else
                    countZero++;
            }
            if(countZero>countOne){
                for(int j=0;j<grid.length;j++){
                    if(grid[j][i] == 1)
                        grid[j][i] = 0;
                    else
                        grid[j][i] = 1;
                    }
            }
            countZero = 0;
            countOne = 0;
        }
           
        int totalSum = 0;

        for(int i = 0; i < grid.length; i++) {
            int decimal = 0;

            for (int j = 0; j < grid[0].length; j++) {
                decimal = decimal * 2 + grid[i][j];
            }
            totalSum += decimal;
        }
        return totalSum;
    }
}

