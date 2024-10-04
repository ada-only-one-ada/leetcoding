class Solution {
    public long dividePlayers(int[] skill) {
        // Divide the players into n / 2 teams of size 2 
      
        Arrays.sort(skill);
        long chemistry = 0;
       
        int i = 0;
        int j = skill.length - 1;

        int teamSkill = 0;
        while (i < j) {
            if (teamSkill == 0) {
                teamSkill += skill[i] + skill[j];
            }

            if (skill[i] + skill[j] != teamSkill) {
                return -1;
            }

            chemistry += skill[i] * skill[j];
            i++;
            j--;
        }

        return chemistry;
    }
}