// Using Hashset - storing the row and column where zero elements are present and converting the elements of entire row or col resp.
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // O ( m * n )
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i: rows){
            for(int j=0;j<matrix[0].length;j++)
                matrix[i][j] = 0;
        }

        if(rows.size() != matrix.length)
            for(int i: cols){
                for(int j=0;j<matrix.length;j++)
                    matrix[j][i] = 0;
            }
    }
}


// Optimal approach - without using any extra space 
// marking the first row and column respectively if any zero element is found. and later on changing the cell values to zero.

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}