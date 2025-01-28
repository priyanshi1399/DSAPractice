import java.util.*;
public class CountNumberOfUsers {

    public static int[] countMentionsPerUser(int numberOfUsers, String[][] events) {
        // Initialize mentions array and user online status
        int[] mentions = new int[numberOfUsers];
        boolean[] isOnline = new boolean[numberOfUsers];
        Arrays.fill(isOnline, true); // All users start online

        // Process events
        for (String[] event : events) {
            String eventType = event[0];
            int timestamp = Integer.parseInt(event[1]);

            if (eventType.equals("MESSAGE")) {
                String mentionsString = event[2];

                if (mentionsString.equals("ALL")) {
                    // Mention all users regardless of their online status
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (mentionsString.equals("HERE")) {
                    // Mention all online users
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (isOnline[i]) {
                            mentions[i]++;
                        }
                    }
                } else {
                    // Parse individual mentions (id<number>)
                    String[] ids = mentionsString.split(" ");
                    for (String id : ids) {
                        if (id.startsWith("id")) {
                            int userId = Integer.parseInt(id.substring(2)); // Extract user ID
                            mentions[userId]++;
                        }
                    }
                }
            } else if (eventType.equals("OFFLINE")) {
                int userId = Integer.parseInt(event[2]);
                isOnline[userId] = false;

                // Schedule to bring the user back online after 60 units
                int returnOnlineTime = timestamp + 60;

                for (String[] futureEvent : events) {
                    int futureTimestamp = Integer.parseInt(futureEvent[1]);
                    if (futureTimestamp >= returnOnlineTime) {
                        isOnline[userId] = true;
                        break;
                    }
                }
            }
        }

        return mentions;
    }

    public static void main(String[] args) {
        // Example 1
        int numberOfUsers1 = 2;
        String[][] events1 = {
                {"MESSAGE", "10", "id1 id0"},
                {"OFFLINE", "11", "0"},
                {"MESSAGE", "71", "HERE"}
        };
        System.out.println(Arrays.toString(countMentionsPerUser(numberOfUsers1, events1))); // Output: [2, 2]

    }
}