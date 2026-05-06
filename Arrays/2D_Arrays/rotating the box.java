class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] result = new char[m][n];

        //Transpose the matrix

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                result[i][j] = boxGrid[j][i];
            }
        }

        //Reverse each row in the matrix
        
        for(int i = 0;i < m;i++){
            int p1 = 0;
            int p2 = n-1;
            while(p1 < p2){
                char temp = result[i][p1];
                result[i][p1] = result[i][p2];
                result[i][p2] = temp;
                p1++;
                p2--; 
            }
        }

        for(int j = 0;j < n;j++){
            for(int i = m-1;i >= 0;i--){
                if(result[i][j] == '.'){
                    int stoneRow = -1;
                    for(int k = i-1;k >= 0;k--){
                        if(result[k][j] == '*'){
                            break;
                        }else if(result[k][j] == '#'){
                            stoneRow = k;
                            break;
                        }
                    }
                    if(stoneRow != -1){
                        result[i][j] = '#';
                        result[stoneRow][j] = '.';
                    }
                }
            }
        }
        return result;
    }
}