package STUDY_8;

import java.util.*;

public class my_후보키 {
    public int solution(String[][] relation) {
        int answer = 0;
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i<=(1<<m)-1; i++){ //모든 조합의 경우의 수 = (1<<m)-1
            HashSet<String> set = new HashSet<String>();
            for(int j = 0 ; j<n; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k<m; k++){
                    if((i&(1<<k))>0){ //현재 조합에 포함된 컬럼(속성)인지 확인
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size()==n&&isMinimal(list,i)){//유일성 최소성 만족하면 list에 해당 조합 추가
                list.add(i);
            }
        }
        answer=list.size();
        return answer;
    }
    public boolean isMinimal(List<Integer> list, int combi){ //최소성 검사
        for(int i=0; i<list.size(); i++){
            if((list.get(i)&combi)==list.get(i)) return false;
            //후보키들 중 현재 조합을 포함하고 있는 키가 있으면 false 반환
        }
        return true;
    }
}
