import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            parent[pa] = pb;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0;
        int right = 0;

        for(int[] e : edges)
            right = Math.max(right, e[2] * 2);

        int ans = -1;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);

        int used = 0;
        int upgrades = 0;

        List<int[]> optional = new ArrayList<>();

        // process must edges first
        for(int[] e : edges) {

            int u = e[0], v = e[1], s = e[2], must = e[3];

            if(must == 1) {

                if(s < target)
                    return false;

                if(!dsu.union(u,v))
                    return false; // cycle among must edges

                used++;
            }
            else {
                optional.add(e);
            }
        }

        // sort optional edges by strength descending
        optional.sort((a,b) -> b[2] - a[2]);

        for(int[] e : optional) {

            int u = e[0], v = e[1], s = e[2];

            if(dsu.find(u) == dsu.find(v))
                continue;

            if(s >= target) {

                dsu.union(u,v);
                used++;

            }
            else if(s * 2 >= target && upgrades < k) {

                upgrades++;
                dsu.union(u,v);
                used++;
            }

            if(used == n - 1)
                return true;
        }

        return used == n - 1;
    }
}