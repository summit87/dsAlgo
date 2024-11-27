package leetCode;

import java.util.*;

public class LeetCode630CourseSchedulingAlgo {
    public static void main(String[] args) {
        int[][] schedule = { { 3, 2 },{4,3} };
        List<Course> list = new ArrayList<>();
        for (int i = 0; i < schedule.length; i++) {
            Course c = new Course();
            c.st = schedule[i][0];
            c.end = schedule[i][1];
            list.add(c);
        }

        PriorityQueue<Course> pq = new PriorityQueue<>(Comparator.comparing((Course c) -> c.end).reversed());

        list.sort(Comparator.comparing(c -> c.st));
        int sum = 0;
        for(Course c : list){
            sum+=c.st;
            pq.add(c);
            if(sum > c.end){
                sum-=c.st;
                pq.poll();
            }
        }
        System.out.println(pq.size());
    }
}

class Course {
    int st;
    int end;

}
