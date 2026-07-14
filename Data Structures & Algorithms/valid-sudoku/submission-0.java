class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> collection = new HashSet<>();

        // Check Rows.
        for (int i = 0; i < 9; i ++) {
            collection.clear();
            for (int j = 0; j < 9; j ++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (collection.contains(currentChar)) {
                        return false;
                    }
                    collection.add(currentChar);
                }
            }    
        }

        // Check Columns.
        for (int i = 0; i < 9; i ++) {
            collection.clear();
            for (int j = 0; j < 9; j ++) {
                char currentChar = board[j][i];
                if (currentChar != '.') {
                    if (collection.contains(currentChar)) {
                        return false;
                    }
                    collection.add(currentChar);
                }
            }    
        }

        // Check boxes.
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                collection.clear();
                for (int i = 0; i < 3; i ++) {
                    for (int j = 0; j < 3; j ++) {
                        char currentChar = board[i+(x*3)][j+(y*3)];
                        if (currentChar != '.') {
                            if (collection.contains(currentChar)) {
                                return false;
                            }
                            collection.add(currentChar);
                        }
                    }    
                }
            }
        }
        

        return true;
    }
}
