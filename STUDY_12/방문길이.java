package STUDY_12;

public class 방문길이 {

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] map = new boolean[11][11][11][11];
        int x=5,y=5,curX=5, curY=5, cnt=0;
        for(char v : dirs.toCharArray()){
            if(v=='U'){
                if(curX+1<11){
                    if(!map[x][y][curX+1][curY]){
                        cnt++;
                        map[x][y][curX+1][curY]=true;
                        map[curX+1][curY][x][y]=true;
                    }
                    curX++;
                    x=curX;
                    y=curY;
                }
            }else if(v=='D'){
                if(curX-1>=0){
                    if(!map[x][y][curX-1][curY]){
                        cnt++;
                        map[x][y][curX-1][curY]=true;
                        map[curX-1][curY][x][y]=true;
                    }
                    curX--;
                    x=curX;
                    y=curY;
                }
            }else if(v=='R'){
                if(curY+1<11){
                    if(!map[x][y][curX][curY+1]){
                        cnt++;
                        map[x][y][curX][curY+1]=true;
                        map[curX][curY+1][x][y]=true;
                    }     
                    curY++;
                    x=curX;
                    y=curY;
                }
            }else if(v=='L'){
                if(curY-1>=0){
                    if(!map[x][y][curX][curY-1]){
                        cnt++;
                        map[x][y][curX][curY-1]=true;
                        map[curX][curY-1][x][y]=true;
                    }     
                    curY--;
                    x=curX;
                    y=curY;                    
                }
            }
        }        
        return answer=cnt;
    }
	
}
