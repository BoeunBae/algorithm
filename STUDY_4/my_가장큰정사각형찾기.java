package STUDY_4;

public class my_가장큰정사각형찾기 {
    public static int solution(int [][]board){
        int answer = 0;
        if(board.length==1&&board[0][0]==1) return 1;
        for(int i = 1; i<board.length; i++){
            for(int j = 1 ; j<board[0].length; j++){
                if(board[i][j]==1){
                    int min = Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1]);
                    board[i][j]+=min;
                    answer = answer > board[i][j] ? answer : board[i][j];
                }
            }
        }
        return answer*answer;
    }
    public static void main(String[] args) {
    	int[][] board = {{0}};
		System.out.println(solution(board));
	}
}
