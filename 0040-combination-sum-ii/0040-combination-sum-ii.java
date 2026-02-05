class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            if (i > index && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            path.add(arr[i]);

            backtrack(i + 1, arr, target - arr[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}
