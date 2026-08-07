class Solution {
    public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];   // same height -> smaller k first

            return b[0] - a[0];       // taller first
        });
        List<int[]> list = new ArrayList<>(); 
        for (int[] person : people) {
            list.add(person[1], person);   // insert at index = k
        }
        return list.toArray(new int[people.length][]);
    }
}