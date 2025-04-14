import java.util.*;
public class TeamRanking {

    public static String determineTeamRankings(String[] rankings) {
        // Step 1: Count ranks for each team
        Map<Character, int[]> teamScores = new HashMap<>();
        int numTeams = rankings[0].length();

        // Initialize scores for each team
        for (char team : rankings[0].toCharArray()) {
            teamScores.put(team, new int[numTeams]);
        }

        // Count votes for each position
        for (String ranking : rankings) {
            for (int rank = 0; rank < ranking.length(); rank++) {
                char team = ranking.charAt(rank);
                teamScores.get(team)[rank]++;
            }
        }

        // Step 2: Sort teams
        List<Character> teams = new ArrayList<>(teamScores.keySet());
        Collections.sort(teams, (a, b) -> {
            for (int i = 0; i < numTeams; i++) {
                if (teamScores.get(a)[i] != teamScores.get(b)[i]) {
                    int val=teamScores.get(b)[i] - teamScores.get(a)[i];
                    return teamScores.get(b)[i] - teamScores.get(a)[i]; // Higher votes first
                }
            }
            return a - b; // Alphabetical order if tied
        });

        // Step 3: Build result string
        StringBuilder result = new StringBuilder();
        for (char team : teams) {
            result.append(team);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] rankings1 = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(determineTeamRankings(rankings1)); // Output: ACB

//      String[] rankings2 = {"WXYZ", "XYZW"};
//        System.out.println(determineTeamRankings(rankings2)); // Output: XWYZ
//
//        String[] rankings3 =   {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
//        System.out.println(determineTeamRankings(rankings3)); // Output: ZMNAGUEDSJYLBOPHRQICWFXTVK
    }
}
