package STUDY_8;
import java.util.*;

public class my_방금그곡 {
	public String solution(String m, String[] musicinfos) {
	    String answer = "";
	    m=change(m); //# 처리하기
	    ArrayList<String> list = new ArrayList<String>(); //조건 일치하는 음악들 담을 리스트
	    HashMap<String,Integer> map = new HashMap<String,Integer>();//라디오음악 idx+음악제목을 key로, 재생시간을 value로 갖는 맵
	    
	    for(int i = 0; i<musicinfos.length; i++){
	        String[] music = musicinfos[i].split(",");
	        music[3]=change(music[3]); //# 처리하기
	        int start = Integer.parseInt(music[0].split(":")[0])*60+
	              Integer.parseInt(music[0].split(":")[1]);
	        int end = Integer.parseInt(music[1].split(":")[0])*60+
	              Integer.parseInt(music[1].split(":")[1]);
	        int playing = end-start; //재생시간
	        int time = music[3].length(); //음악시간 
	        StringBuilder note = new StringBuilder(); //재생시간동안 재생된 악보 담을 변수
	        int k = 0;
	        for(int j = 0; j<playing; j++){
	            if(k==time)k=0;
	            note.append(music[3].charAt(k));
	            k++;   
	        }
	        if(note.toString().contains(m)){
	            list.add(music[2]);
	            int idx = i+1;
	            map.put(idx+"/"+music[2],playing);//음악순서가 key의 맨앞글자에 있는 형태로 담으면 재생시간순으로 정렬할 때 재생시간이 같으면 key를 기준으로 정렬된다.
	        }
	    }
	    if(list.size()==0) answer="(None)";
	    else if(list.size()==1) answer=list.get(0);
	    else{ //value 기준으로 map에 있는 key 정렬하기
	        ArrayList<Object> playingList = new ArrayList<Object>(); 
	        playingList.addAll(map.keySet());
	        Collections.sort(playingList, new Comparator<Object>(){
	            public int compare(Object o1, Object o2){
	               Object v1 = map.get(o1);
	               Object v2 = map.get(o2); 
	               return ((Comparable)v2).compareTo(v1);
	            } 
	        });
	        answer=playingList.get(0).toString().split("/")[1];
	    }
	    return answer;
	}
	public String change(String s){
	    String result = "";
	    for(int i = 0; i<s.length(); i++){
	        if(i!=s.length()-1&&s.charAt(i+1)=='#'){
	            result+=Character.toLowerCase(s.charAt(i));
	            i++;
	        }else result+=s.charAt(i);
	    }
	    return result;
	}
}
