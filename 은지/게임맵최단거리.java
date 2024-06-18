import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visit;
    static int[][] maps;


    public int solution(int[][] map) {
        maps = map;
        visit = new boolean[map.length][map[0].length];
        bfs(0,0);
        if (maps[maps.length-1][maps[0].length-1] != 1) {
            return (maps[maps.length-1][maps[0].length-1]);
        }else return (-1);
    }

    void bfs (int x, int y ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while ( !queue.isEmpty() ) {
            int[] temp = queue.poll();
            for(int i=0;i<4;i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if(maps[nx][ny] != 0 && !visit[nx][ny]) {
                        queue.add(new int[] {nx,ny});
                        visit[nx][ny] = true;
                        maps[nx][ny] += maps[temp[0]][temp[1]];
                    }
                }
            }
        }

    }
}