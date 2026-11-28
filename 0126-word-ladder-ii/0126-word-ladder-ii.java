
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) return result;

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add(beginWord);
        visited.add(beginWord);

        boolean found = false;

        while (!current.isEmpty() && !found) {
            Set<String> next = new HashSet<>();

            for (String word : current) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[i] = c;
                        String neighbor = new String(chars);

                        if (dict.contains(neighbor) && !visited.contains(neighbor)) {
                            next.add(neighbor);

                            parents.computeIfAbsent(neighbor, k -> new ArrayList<>())
                                   .add(word);

                            if (neighbor.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[i] = original;
                }
            }

            visited.addAll(next);
            current = next;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}
