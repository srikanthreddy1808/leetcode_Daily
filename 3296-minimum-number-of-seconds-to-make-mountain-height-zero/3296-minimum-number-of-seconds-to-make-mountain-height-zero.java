class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;

        while(left < right){
            long mid = left + (right - left)/2;

            if(canRemoved(mid, mountainHeight, workerTimes)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canRemoved(long time, int mountainHeight, int[] workerTimes){
        long totalRemoved = 0;

        for(long t : workerTimes){

            long currTime = 0;
            int k = 1;

            while(true){
                currTime += t * k;

                if(currTime > time) break;

                totalRemoved++;
                k++;

                if(totalRemoved >= mountainHeight) return true;
            }
        }
        return totalRemoved >= mountainHeight;
    }
}