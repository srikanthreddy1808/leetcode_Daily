class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];

        for(int i = 0; i < n; i++){
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }

        Arrays.sort(robots, (a,b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();
        
        for(int[] robot : robots){
            if(robot[2] == 'R'){
                stack.push(robot);
            }else{
                while(!stack.isEmpty() && stack.peek()[2] == 'R'){
                    if(stack.peek()[1] < robot[1]){
                        stack.pop();
                        robot[1]--;
                    }else if(stack.peek()[1] > robot[1]){
                        stack.peek()[1]--;
                        robot[1] = 0;
                        break;
                    }else{
                        stack.pop();
                        robot[1] = 0;
                        break;
                    }
                }
                if(robot[1] > 0){
                    stack.push(robot);
                }
            }
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int[] r : stack){
            result[r[3]] = r[1];
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(result[i] != -1){
                ans.add(result[i]);
            }
        }
        return ans;
    }
}