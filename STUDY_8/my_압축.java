package STUDY_8;

import java.util.ArrayList;
import java.util.HashMap;

public class my_압축 {

	  public int[] solution(String msg) {
	      int[] answer = {};
	      HashMap<String,Integer> dic = new HashMap<String,Integer>();
	      for(int i = 0; i<26; i++) dic.put(String.valueOf((char)('A'+i)),i+1);
	      ArrayList<Integer> answerList = new ArrayList<Integer>();
	      int add=26;
	      String tmp = "";
	      for(int i = 0; i<msg.length(); i+=tmp.length()){
	          tmp = "";
	          for(String v : dic.keySet()){
	              if(msg.substring(i).indexOf(v)==0){
	                  tmp = tmp.length()>v.length()?tmp:v;
	              }
	          }
	          answerList.add(dic.get(tmp));
	          if(i+tmp.length()<msg.length()){
	              dic.put(tmp+msg.substring(i+tmp.length(),i+tmp.length()+1),++add);
	          }
	      }
	      
	      answer=new int[answerList.size()];
	      for(int k = 0; k<answer.length; k++) answer[k]=answerList.get(k);
	      return answer;
	  }
	
}
