class MyCalendarTwo {
    List<int[]> events;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        
        for(int[] o : overlaps){
            if(startTime < o[1] && o[0] < endTime){
                return false;
            }
        }

        for(int[] e : events){
            if(startTime < e[1] && e[0] < endTime){
                int s = Math.max(startTime, e[0]);
                int t = Math.min(endTime, e[1]);

                overlaps.add(new int[] {s,t});
            }
        }
        events.add(new int[] {startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */