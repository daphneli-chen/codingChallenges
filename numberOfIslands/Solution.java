class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        // you want to do a search from any 1 you find and mark every land connected to it as visited, then continue on
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int number = grid[i][j];
                boolean visit = !visited[i][j];
                if (grid[i][j] == '1' && !visited[i][j]) {
                    //found an island and need to mark everything it touches as visited
                    count++; 
                    visited = this.markLand(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    
    private boolean[][] markLand(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return visited;
        } else if (col < 0 || col >= grid[0].length) {
            return visited;
        }
        if (visited[row][col]) {
            return visited;
        }
        if (grid[row][col] == '1') {
            visited[row][col] = true;
        
            visited = this.markLand(grid, visited, row - 1, col);
            visited = this.markLand(grid, visited, row + 1, col);
            visited = this.markLand(grid, visited, row, col -1);
            visited = this.markLand(grid, visited, row, col + 1);
            return visited;
        } 
        
        return visited;
    }
}