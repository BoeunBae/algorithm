package STUDY_11;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;

public class my_기둥과보설치 {

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        LinkedList<int[]> list = new LinkedList<int[]>();
        
        for(int i = 0; i<build_frame.length; i++){
            int x = build_frame[i][0], y = build_frame[i][1], type = build_frame[i][2];
            if(build_frame[i][3]==1){ //설치
                list.add(new int[] {x,y,type});
                if(!isOk(list,n)){
                    int size = list.size();
                    for(int j = 0; j<size; j++){
                        int[] arr = list.get(j);
                        if(arr[0]==x && arr[1]==y && arr[2]==type) {
                            list.remove(j);
                            break;
                        }
                    }
                }
            }else if(build_frame[i][3]==0){ //삭제
                int size = list.size();
                for(int j = 0; j<size; j++){
                    int[] arr = list.get(j);
                    if(arr[0]==x && arr[1]==y && arr[2]==type) {
                        list.remove(j);
                        break;
                    }
                }
                if(!isOk(list,n)) list.add(new int[] {x,y,type});
            }     
        }
        list.sort(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]) {
                    if(o1[1]==o2[1]) return o1[2]-o2[2];
                    else return o1[1]-o2[1];
                }
                else return o1[0]-o2[0];
            }
        });
        answer = new int[list.size()][3];
        for(int i = 0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
    
    public boolean isOk(LinkedList<int[]> list, int n){
        boolean[][][] map = new boolean[n+1][n+1][2];
        
        for(int i = 0; i<list.size(); i++){ //설치된 기둥과 보 저장
            int[] arr = list.get(i);
            map[arr[0]][arr[1]][arr[2]] = true;
        }
        
        for(int i = 0; i<map.length; i++){//조건에 맞는지 확인하기
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j][0]){ //기둥일 때
                    if(!(j==0||map[i][j][1]||(i > 0 && map[i-1][j][1])||map[i][j-1][0])) 
                    return false;
                }
                if(map[i][j][1]){ //보일 때
                    if(!((j>0&&map[i][j-1][0])|| (j>0&&map[i+1][j-1][0])||(i>0&&map[i-1][j][1]&&map[i+1][j][1])))
                    return false;
                }
            }
        }        
        return true;
    }
	
}
