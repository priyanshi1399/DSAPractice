public class NoOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                provinces++;
                dfs(isConnected, i, visited, n);
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, int source, int[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (isConnected[source][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(isConnected, i, visited, n);
            }
        }
    }

    public static void main(String[] args) {
        NoOfProvinces solution = new NoOfProvinces();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result = NoOfProvinces.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }
}
