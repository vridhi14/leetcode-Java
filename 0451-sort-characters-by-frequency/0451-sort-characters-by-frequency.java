class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }

        return sb.toString();
    }
}
