package com.tzih.learn.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LT2054 {
    public int maxTwoEvents(int[][] events) {
        List<Event> array = new ArrayList<>();
        for (int[] event : events) {
            array.add(new Event(event[0], 0,  event[2]));
            array.add(new Event(event[1], 1, event[2]));
        }
        Collections.sort(array);
        int ans = 0;
        int bestFirst = 0;
        for (Event event : array) {
            if (event.op == 0) {
                ans = Math.max(ans, bestFirst + event.val);
            } else {
                bestFirst = Math.max(bestFirst, event.val);
            }
        }
        return ans;
    }

    class Event implements Comparable<Event> {
        int time;
        int op;
        int val;

        Event(int time, int op, int val) {
            this.time = time;
            this.op = op;
            this.val = val;
        }

        @Override
        public int compareTo(Event event) {
            if (this.time != event.time) {
                return Integer.compare(this.time, event.time);
            }
            return Integer.compare(this.op, event.op);
        }
    }
}
