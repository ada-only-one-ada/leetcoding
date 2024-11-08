class Solution {
    int res = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[][] scores = new int[students.length][mentors.length];

        // Calculate the compatibility score for each student-mentor pair.
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < mentors.length; j++) {
                int[] student = students[i];
                int[] mentor = mentors[j];

                int score = 0;
                for (int k = 0; k < student.length; k++) {
                    if (student[k] == mentor[k]) {
                        score++;
                    }
                }

                scores[i][j] = score;
            }
        }
        /* 
          students = [[1, 1, 0],
                      [1, 0, 1],
                      [0, 0, 1]],
                       
           mentors = [[1, 0, 0],
                      [0, 0, 1],
                      [1, 1, 0]]

             scores = [2, 0, 3],
                      [2, 2, 1],
                      [1, 3, 0],
        */

        dfs(scores, new boolean[mentors.length], 0, 0);
        return res;
    }

    // Try every permutation of students with the original mentors array.
    public void dfs(int[][] scores, boolean[] mentorsAssigned, int row, int score) {
        if (row == scores.length) {
            res = Math.max(res, score);
            return;
        }

        for (int col = 0; col < scores.length; col++) {
            if (!mentorsAssigned[col]) {
                mentorsAssigned[col] = true;
                dfs(scores, mentorsAssigned, row + 1, score + scores[row][col]);
                mentorsAssigned[col] = false;
            }
        }
    }
}