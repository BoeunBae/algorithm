package STUDY_8;

import java.util.HashMap;
import java.util.ArrayList;

public class my_오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<String>();
        HashMap<String,String> map = new HashMap<String,String>();
        for(int i = 0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            switch(tmp[0]){
                case "Enter" :
                    map.put(tmp[1],tmp[2]);
                    answerList.add(tmp[1]+"님이 들어왔습니다.");
                    break;
                case "Leave" :
                    answerList.add(tmp[1]+"님이 나갔습니다.");
                    break;
                case "Change" :
                    map.put(tmp[1],tmp[2]);
                    break;
            }
        }
        answer = new String[answerList.size()];
        int i = 0;
        for(String s : answerList){
            String tmp = s.substring(0,s.indexOf("님"));
            answer[i] = s.replace(tmp,map.get(tmp));
            i++;
        }
        return answer;
    }
}
