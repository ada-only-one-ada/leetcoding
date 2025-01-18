class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // iden + content
        // 先根据 content 排序，然后根据 iden

        List<Pair<String, String>> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log: logs) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digitLogs.add(log);
            } else {
                int space = 0;
                while (space < log.length() && log.charAt(space) != ' ') space++;

                String iden = log.substring(0, space);
                String content = log.substring(space + 1);

                Pair<String, String> pair = new Pair(iden, content);
                letterLogs.add(pair);
            }
        }

        Collections.sort(letterLogs, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue().compareTo(b.getValue());
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        List<String> res = new ArrayList<>();
        for (Pair<String, String> pair: letterLogs) {
            res.add(pair.getKey() + " " + pair.getValue());
        }
        res.addAll(digitLogs);
        
        String[] resArray = new String[res.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}