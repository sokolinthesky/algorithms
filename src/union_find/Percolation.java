package union_find;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    final int VIRTUAL_NODES_NUM = 2;
    final int TOP  = 0;
    int size;
    int bottom;
    int gridLength;
    boolean[][] opened;
    int numberOfOpenSites = 0;
    WeightedQuickUnionUF grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        gridLength = n;
        size = n * n;
        opened = new boolean[n][n];
        grid = new WeightedQuickUnionUF(size + VIRTUAL_NODES_NUM);
        bottom = size + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        numberOfOpenSites++;
        opened[row - 1][col - 1] = true;
        var index = findIndex(row, col);

        if (isTop(index)) {
            grid.union(index, TOP);
        } else if (isBottom(index)) {
            grid.union(index, bottom);
        } else { // in the middle
            union(index, row, col);
        }
        System.out.println("OPEN - " + row + "  " + col);
        printArr();
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return opened[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = findIndex(row, col);
        return grid.find(TOP) == grid.find(index);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        var res = grid.find(TOP) == grid.find(bottom);
        System.out.println("PERCOLATES " + res);
        return res;
    }


    private int findIndex(int row, int col) {
        int rowIndex = row - 1;
        return rowIndex * gridLength + col;
    }

    private boolean isTop(int index) {
        return index <= gridLength;
    }

    private boolean isBottom(int index) {
        var startBottomIndex = size - gridLength + 1;
        return index >= startBottomIndex && index <= size;
    }

    private void union(int index, int row, int col) {
        var colEdge = col == 1 || col == gridLength;
        if (!colEdge) {
            unionMiddle(index, row, col);
        } else {
            unionColEdge(index, row, col);
        }
    }

    private void unionMiddle(int index, int row, int col) {
        var rightOpen = isOpen(row, col + 1);
        var leftOpen =  isOpen(row, col - 1);
        var topOpen = isOpen(row - 1, col);
        var bottomOpen = isOpen(row + 1, col);

        if (rightOpen) {
            int rightIndex = index + 1;
            grid.union(index, rightIndex);
        }
        if (leftOpen) {
            int leftIndex = index - 1;
            grid.union(index, leftIndex);
        }
        if (topOpen) {
            int topIndex = findIndex(row - 1, col);
            grid.union(index, topIndex);
        }
        if (bottomOpen) {
            int bottomIndex = findIndex(row + 1, col);
            grid.union(index, bottomIndex);
        }
    }

    private void unionColEdge(int index, int row, int col) {
        var topOpen = isOpen(row - 1, col);
        var bottomOpen = isOpen(row + 1, col);
        if (topOpen) {
            int topIndex = findIndex(row - 1, col);
            grid.union(index, topIndex);
        }
        if (bottomOpen) {
            int bottomIndex = findIndex(row + 1, col);
            grid.union(index, bottomIndex);
        }
        if (col == 1) {
            var rightOpen = isOpen(row, col + 1);
            if (rightOpen) {
                int rightIndex = index + 1;
                grid.union(index, rightIndex);
            }
        }
        if (col == gridLength) {
            var leftOpen =  isOpen(row, col - 1);
            if (leftOpen) {
                int leftIndex = index - 1;
                grid.union(index, leftIndex);
            }
        }
    }

    private void printArr() {
        for(int i=0; i<gridLength; i++){
            for(int j=0; j<gridLength; j++){
                System.out.print(String.format("{%s}", opened[i][j]));
            }
            System.out.println("");
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
