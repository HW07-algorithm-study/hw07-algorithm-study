package 정하

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val graph = Array(n+1){ mutableListOf<Int>() }

//    신뢰 관계 입력 받음.
//    a가 b를 신뢰하는 경우 b를 해킹하면 a도 해킹
    for (i in 1..m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[b].add(a)
    }
//    주어진 문제의 경우 [],[3],[3],[4,5],[],[]처럼 들어감
    val countArr = IntArray(n + 1)
    var max = 0
//    각 인덱스는 해당 컴퓨터를 해킹했을 때 총 해킹되는 컴퓨터

//    bfs로 돌림
    for(i in 1..n){
        val check = BooleanArray(n + 1)
        val q: Queue<Int> = LinkedList()
        q.add(i)
        check[i] = true
        var count = 0

        while (!q.isEmpty()){
            val now = q.poll()
//            주어진 TestCase의 경우 1번에 저장된 3을 통해
//            4,5번 추가 해킹됨
            for(next in graph[now]){
                if(!check[next]){
                    check[next] = true
                    q.add(next)
                    count++
                }
            }
        }
//        최대 해킹되는 수 저장해놓고
        countArr[i] = count
        max = Math.max(max, count)
    }
//    여기서 출력
    for(i in 1..n){
        if(countArr[i]==max){
            bw.write("$i ")
        }
    }
    bw.flush()
    bw.close()
}

/* JavaCode

*import java.io.*;
import java.util.*;

// 메모제이션으로 풀라는데
public class B1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
//        System.out.println(Arrays.toString(graph));
//        각 인덱스 별 해킹했을 때 추가로 해킹되는 컴퓨터
        int[] countArr = new int[n+1];
        int max = 0;
        for(int i = 1; i <=n; i++){
            boolean[] check = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            check[i] = true;
            int count = 0;

            while (!q.isEmpty()){
                int now = q.poll();
                for(int next: graph[now]){
                    if(!check[next]){
                        check[next] = true;
                        q.add(next);
//                        System.out.println(q);
                        count++;
                    }
                }
            }
            countArr[i] = count;
            max = Math.max(max, count);
//            System.out.println(max);
        }
//        System.out.println(Arrays.toString(countArr));
        for(int i = 1; i <= n; i++){
            if(countArr[i]==max){
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
*/