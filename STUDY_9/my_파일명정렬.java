package STUDY_9;

import java.util.Arrays;
import java.util.Comparator;

public class my_파일명정렬 {

	  public String[] solution(String[] files) {
	      Arrays.sort(files, new Comparator<String>(){
	          public int compare(String s1, String s2){
	              String head1 = s1.split("[0-9]")[0];
	              s1 = s1.replace(head1,"");
	              head1=head1.toUpperCase();
	              String tmp = "";
	              for(int i = 0; i<s1.length(); i++){
	                  if(Character.isDigit(s1.charAt(i)))tmp+=s1.charAt(i);
	                  else break;
	              }
	              int num1 = Integer.parseInt(tmp);
	              
	              String head2 = s2.split("[0-9]")[0];
	              s2 = s2.replace(head2,"");
	              head2 = head2.toUpperCase();
	              tmp = "";
	              for(int i = 0; i<s2.length(); i++){
	                  if(Character.isDigit(s2.charAt(i)))tmp+=s2.charAt(i);
	                  else break;
	              }
	              int num2 = Integer.parseInt(tmp);
	              
	              return head1.equals(head2)?num1-num2:head1.compareTo(head2);
	          }
	      });
	      return files;
	  }
}
