/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //全部人除了ta自己都认识ta
        //ta不认识任何人
        //[0, n-1]

        int[] beingKnown = new int[n];
        int[] knowOthers = new int[n];

        for (int people = 0; people < n; people++) {
            for (int other = 0; other < n; other++) {
                if (people == other) continue;

                if (knows(people, other)) {
                    knowOthers[people]++;
                    beingKnown[other]++;
                }
            }
        }

        for (int people = 0; people < n; people++) {
            if (knowOthers[people] == 0 && beingKnown[people] == n - 1) {
                return people;
            }
        }

        return -1;
    }
}