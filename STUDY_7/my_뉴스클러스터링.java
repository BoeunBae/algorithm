package STUDY_7;

import java.util.ArrayList;

public class my_뉴스클러스터링 {

	  public int solution(String str1, String str2) {
	      int answer = 0;
	      double ja = 1;
	      str1=str1.toUpperCase();
	      str2=str2.toUpperCase();
	      ArrayList<String> list1 = new ArrayList<String>();
	      ArrayList<String> list2 = new ArrayList<String>();
	      
	      for(int i = 0; i<str1.length()-1; i++){
	          if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
	              list1.add(str1.charAt(i)+""+str1.charAt(i+1));
	          }
	      }
	      for(int i = 0; i<str2.length()-1; i++){
	          if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
	              list2.add(str2.charAt(i)+""+str2.charAt(i+1));
	          }
	      }

	      double inter = 0, uni = 0;
	      int s1 = list1.size();
	      int s2 = list2.size();
	      for(int i = 0; i<list1.size(); i++){
	          if(list2.contains(list1.get(i))) {
	              inter++;
	              list2.remove(list1.get(i));//교집합으로 판단된 데이터 삭제해서 중복 막기
	          }
	      }
	      uni = s1+s2-inter;
	      
	      if(uni!=0){
	          ja=inter/uni;
	      }
	     
	      answer = (int)(ja * 65536); 
	      return answer;
	  }
}
