package 정하;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class B13549 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        int max = 100000;
//        int[] dis = new int[max + 1];
//        Arrays.fill(dis, -1);
//
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.offer(n);
//        dis[n] = 0;
//
//        while (!dq.isEmpty()) {
//            int current = dq.poll();
//
//            if (current == k) {
//                break;
//            }
//            if (current * 2 <= max && dis[current * 2] == -1) {
//                dis[current * 2] = dis[current];
//                dq.offerFirst(current * 2);
//            }
//            if (current + 1 <= max && dis[current + 1] == -1) {
//                dis[current + 1] = dis[current] + 1;
//                dq.offer(current + 1);
//            }
//            if (current - 1 >= 0 && dis[current - 1] == -1) {
//                dis[current - 1] = dis[current] + 1;
//                dq.offer(current - 1);
//            }
//        }
//
//        System.out.println(dis[k]);
//    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();

            int max = 100000;
            int[] dis = new int[max + 1];
            Arrays.fill(dis, Integer.MAX_VALUE);

            Deque<Integer> dq = new ArrayDeque<>();
            dq.offer(n);
            dis[n] = 0;

            while (!dq.isEmpty()) {
                int now = dq.poll();

                if (now == k) {
                    break;
                }
                if (now * 2 <= max && dis[now * 2] > dis[now]) {
                    dis[now * 2] = dis[now];
                    dq.offerFirst(now * 2);
                }
                if (now + 1 <= max && dis[now + 1] > dis[now] + 1) {
                    dis[now + 1] = dis[now] + 1;
                    dq.offer(now + 1);
                }
                if (now - 1 >= 0 && dis[now - 1] > dis[now] + 1) {
                    dis[now - 1] = dis[now] + 1;
                    dq.offer(now - 1);
                }
            }
            System.out.println(dis[k]);
        }
}