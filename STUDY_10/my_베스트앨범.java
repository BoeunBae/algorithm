package STUDY_10;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class my_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,int[]> map = new HashMap<String,int[]>();        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(!map.containsKey(genre)) {
                int[] n_list = new int[10001]; 
                n_list[0]=play; //배열[0]에는 장르가 같은 곡 재생 횟수를 저장 
                n_list[i+1]=play; //각 곡의 idx+1한 배열 위치에 각 곡의 재생 횟수 저장
                map.put(genre,n_list);
            }
            else {
                int[] o_list = map.get(genre);
                o_list[0]+=play;
                o_list[i+1]=play;
                map.put(genre,o_list);
            }
        }
        
        ArrayList<String> genre_list = new ArrayList<String>();
        genre_list.addAll(map.keySet());
        genre_list.sort(new Comparator<Object>(){
            public int compare(Object o1, Object o2){
                int v1 = map.get(o1)[0];
                int v2 = map.get(o2)[0];
                return v2-v1;
            }
        }); //장르별 총 재생 횟수 기준으로 장르 정렬
        
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(int i = 0; i<genre_list.size(); i++){ //정렬된 장르를 조회
            int[] tmpArr = map.get(genre_list.get(i));
            tmpArr[0]=0; //장르의 모든 노래 재생 횟수 저장된 0번째 배열 지우기
            for(int cnt = 0; cnt<2; cnt++){ //두 곡 담기위한 for문
                int max = 0;
                int max_idx = 0;
                for(int j = 0; j<tmpArr.length; j++){
                    if(tmpArr[j]!=0 && max<tmpArr[j]){  //현존하는 재생횟수 중 가장 큰 노래idx찾기
                        max = tmpArr[j];
                        max_idx = j;
                    }
                }
                if(max!=0&&max_idx!=0){ //max값이랑 maxidx가 0이면 현존하는 가장 큰 재생횟수를 가진 노래가 없다는 뜻이므로 반대의 경우에만 answer추가
                    tmpArr[max_idx] = 0;
                    answerList.add(max_idx-1);
                }
            }
        }
        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }
}
