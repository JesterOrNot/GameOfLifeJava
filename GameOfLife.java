import java.util.concurrent.TimeUnit;
class GameOfLife {
    public static void main(String[] args) {
        int M = 10, N = 11;
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }
        };
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
        nextGeneration(grid, M, N);

    }
    static void nextGeneration(int[][] grid, int M, int N) {
        int[][] future = new int[M][N];
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                int alive = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        alive += grid[i+l][j+m];
                    }
                }
                alive -= grid[l][m];
                // underpopulated
                if ( (grid[l][m] == 1) && (alive < 2 ) ) {
                    future[l][m] = 0;
                // Over population
                } else if ( (grid[l][m] == 1) && (alive > 3) ) {
                    future[l][m] = 0;
                // reproduction
                } else if ( (grid[l][m] == 0) && (alive == 3) ) {
                    future[l][m] = 1;
                } else {
                    future[l][m] = grid[l][m];
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
        int count = 0;
        while (count!=10) {
            count++;
            nextGeneration(future, M, N);
            if (count == 10) {
                break;
            }
        }
    }
}