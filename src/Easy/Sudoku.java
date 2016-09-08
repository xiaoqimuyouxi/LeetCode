package Easy;

import java.util.HashSet;
import java.util.Set;

//36Ìâ	Êı¶À
public class Sudoku {
	//13ms
	public static boolean isValidSudoku(char[][] board) {
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				char number = board[i][j];
				if(number != '.') {
					if(!set.add(number + " in row " + i) ||
							!set.add(number + " in column " + j) ||
							!set.add(number + " in block "+i/3+"-"+j/3)) {
						return false;
					}
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		char[][] re = {
				{'1','2','3','4','5','6','7','8','9'},
				{'9','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'2','.','.','.','.','.','.','.','.'}
		};
		
		System.out.println(isValidSudoku(re));
	}
}
