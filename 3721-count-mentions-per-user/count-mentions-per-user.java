class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers;
        int m = events.size();
        int[] ans = new int[n];
        // onlineUntil[i] = time until which user i is offline.
        // user i is online at time t iff t >= onlineUntil[i].
        int[] onlineUntil = new int[n]; // initially 0 => all online for any t >= 0

        // Convert to array for easier sorting
        List<String[]> ev = new ArrayList<>();
        for (List<String> e : events) {
            ev.add(new String[]{e.get(0), e.get(1), e.get(2)});
        }

        // Sort by timestamp; OFFLINE before MESSAGE if same timestamp
        Collections.sort(ev, (a, b) -> {
            int ta = Integer.parseInt(a[1]);
            int tb = Integer.parseInt(b[1]);
            if (ta != tb) return ta - tb;
            // "OFFLINE" needs to be before "MESSAGE"
            // a[0]: "OFFLINE" or "MESSAGE"
            if (a[0].equals(b[0])) return 0;
            return a[0].equals("OFFLINE") ? -1 : 1;
        });

        for (String[] e : ev) {
            String type = e[0];
            int t = Integer.parseInt(e[1]);
            String s = e[2];

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(s);
                onlineUntil[id] = t + 60; // offline until this time
            } else { // MESSAGE
                if (s.startsWith("ALL")) {
                    // ALL mentions everyone, including offline
                    for (int i = 0; i < n; i++) {
                        ans[i]++;
                    }
                } else if (s.startsWith("HERE")) {
                    // HERE mentions only online users at time t
                    for (int i = 0; i < n; i++) {
                        if (t >= onlineUntil[i]) {
                            ans[i]++;
                        }
                    }
                } else {
                    // Explicit id list like "id1 id0 id1"
                    String[] parts = s.split(" ");
                    for (String p : parts) {
                        if (p.length() >= 3 && p.startsWith("id")) {
                            int id = Integer.parseInt(p.substring(2));
                            ans[id]++; // duplicates count multiple times
                        }
                    }
                }
            }
        }

        return ans;
    }
}
