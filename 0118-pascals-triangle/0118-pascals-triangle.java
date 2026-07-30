import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // Base case
        if (numRows == 0) return triangle;
        
        // First row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        // Build subsequent rows
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> currRow = new ArrayList<>();
            // First element is always 1
            currRow.add(1);
            // Middle elements
            for (int j = 1; j < row; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            // Last element is always 1
            currRow.add(1);
            triangle.add(currRow);
        }
        return triangle;
    }
}