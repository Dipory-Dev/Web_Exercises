package com.boot.jdbc.model.dto;

import java.util.*;

public class Solution {
    // 4방향으로 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int n, int[][] water) {
        // 지도 초기화
        int[][] map = new int[n][n];
        for (int[] w : water) {
            map[w[0] - 1][w[1] - 1] = -1; // 물 웅덩이는 -1로 표시
        }

        // 방문한 곳을 추적
        boolean[][] visited = new boolean[n][n];

        // 탐험할 구역의 크기를 리스트에 저장
        List<Integer> areaSizes = new ArrayList<>();

        // BFS를 사용해 각 대원이 탐험할 수 있는 최대 구역 크기 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != -1 && !visited[i][j]) { // 물 웅덩이가 아니고, 아직 방문하지 않은 곳
                    int areaSize = bfs(i, j, map, visited, n);
                    areaSizes.add(areaSize); // 해당 구역 크기 기록
                }
            }
        }

        // 각 대원이 탐험할 수 있는 최대 구역 크기
        Collections.sort(areaSizes, Collections.reverseOrder()); // 큰 구역부터 탐험
        int explorers = 0;
        int coveredArea = 0;

        // 최대 크기부터 하나씩 탐험
        for (int size : areaSizes) {
            coveredArea += size;
            explorers++;
            if (coveredArea >= n * n - water.length) {
                break;
            }
        }

        return explorers;
    }

    // BFS 함수 - 탐험할 수 있는 최대 구역 크기 계산
    private int bfs(int x, int y, int[][] map, boolean[][] visited, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int areaSize = 1; // 탐험할 구역의 크기

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 4방향으로 인접한 칸 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                    areaSize++;
                }
            }
        }
        return areaSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] water = {
                {2, 2},
                {3, 3},
                {4, 1}
        };
        System.out.println(solution.solution(n, water)); // 최소 대원 수
    }
}
