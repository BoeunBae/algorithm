package STUDY_6;

public class my_제이든문자열만들기 {
  public String solution(String s) {
      String answer = "";
      for(int i = 0; i<s.length(); i++) {
	 	  if(i==0 || s.charAt(i-1)==' ') {
    		  if(Character.isAlphabetic(s.charAt(i))) answer+=Character.toUpperCase(s.charAt(i));
    		  else answer += s.charAt(i);
    	  }
    	  else if(Character.isAlphabetic(s.charAt(i))) answer+=Character.toLowerCase(s.charAt(i));
    	  else answer+=" ";
      }
      return answer;
  }	

}
