package STUDY_7;

public class my_프렌즈4블록 {
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] blocks = new char[m][n];
        for(int i = 0; i<m ; i++){
            blocks[i] = board[i].toCharArray();
        }
        
        while(true){
            boolean[][] flag = new boolean[m][n];
            boolean canDel = false;
            
            //지울 수 있는 블록 찾기
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(i+1<m && j+1<n && 
                      blocks[i][j]==blocks[i+1][j]&&
                      blocks[i+1][j]==blocks[i][j+1]&&
                      blocks[i][j+1]==blocks[i+1][j+1] && blocks[i][j]!=' '){
                        canDel=true;
                        flag[i][j]=flag[i+1][j]=flag[i][j+1]=flag[i+1][j+1]=true;
                    }
                }
            }
            
            if(!canDel)break;
            
            //블록 지우기
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(flag[i][j]) {
                        answer++;
                        blocks[i][j]=' ';
                    }
                }
            }
            
             //블록 지워지고 블록 이동하기
             char[][] tmp = new char[m][n];
             int k = m-1;
             for(int i = m-1 ; i>=0 && k>=0 ; i--){
                 for(int j = n-1; j>=0 && i>=0 ; j--){
                     if(blocks[i][j]!=' ') {
                    	 tmp[k][j]=blocks[i][j];
                    	 blocks[i][j]=' ';
                     }
                     else{
                         while(blocks[i][j]==' ' && i>0) i--;
                         tmp[k][j]=blocks[i][j];
                         blocks[i][j]=' ';
                         i=k;
                     }
                 }
                 k--;
             }
     	
            blocks=tmp;
     	
		}
        return answer;
    }    
	public static void main(String[] args) {
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(4,5,board));
	}
}
