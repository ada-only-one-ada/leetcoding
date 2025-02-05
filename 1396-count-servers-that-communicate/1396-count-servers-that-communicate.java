class Solution {
public int countServers(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[] row = new int[m];
    int[] col = new int[n];
    int unCommu = 0;
    int total = 0;

    // initization
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                // 4 * 4 matrix, row 1: 1 0 0 1, (rowHash set: <1>)
                //               row 2: 0 1 0 0, row situations: [2, 1, 0, 1], col: [2, 1, 0, 1]
                //               row 3: 0 0 0 0
                //               row 4: 1 0 0 0 
                // return 2 
                row[i]++; // the i row has a server: int[] row 
                col[j]++; // the j col has a server: int[] col
                total++;
            }
        }
    }

    // whether i should count the current server? grid[i][j] = 1: find a server
    
    // count: the same row has more than one server, or the same col has more than one server
    // not count: the same row only has one and the same col only has one, which means the server 
    // is the only server in its row and col

    
    for (int i = 0; i < m; i++) {
        // row 1: 1 0 0 0
        if (row[i] == 1) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (col[j] == 1) {
                        unCommu++;
                    }
                }
            }
        }
    }

    return total - unCommu;
}
}