import java.util.*;

class Solution {

    Map<Integer, List<Integer>> input = new HashMap<>();
    Map<Integer, List<Integer>> output = new HashMap<>();

    public int[] solution(int[][] edges) {

        Set<Integer> V = new HashSet<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            
            V.add(u);
            V.add(v);

            output.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            input.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

            input.computeIfAbsent(u, k -> new ArrayList<>());
            output.computeIfAbsent(v, k -> new ArrayList<>());
        }

        // 1. 루트
        int root = 0;

        for (int node : V) {
            if (input.get(node).isEmpty() && output.get(node).size() >= 2) {
                root = node;
                break;
            }
        }

        // 2. rod/eight
        int rod = 0, eight = 0;

        for (int node : V) {
            if (node == root) {
                continue;
            }
            
            int out = output.get(node).size();
            int in  = input.get(node).size();

            if (out == 0) {
                rod++;
            } else if (out >= 2 && in >= 2) {
                eight++;
            }
        }

        // 3. donut
        int donut = output.get(root).size() - rod - eight;

        return new int[]{ root, donut, rod, eight };
    }
}
