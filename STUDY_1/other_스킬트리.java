package STUDY_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//내코드보다 오래걸림
public class other_스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<String> list = new ArrayList<String>(Arrays.asList(skill_trees)); //배열을 리스트로 바로 변환하기
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			if(skill.indexOf(it.next().replaceAll("[^"+skill+"]", ""))!=0) it.remove();
			//indexof(String) : 해당 스트링과 일치하는 스트링의 첫 글자의 인덱스 반환
			//skill의 순서와 일치하는 스트링을 가지면 스킬의 순서상 인덱스가 항상 0이 나와야한다
			//스킬트리중 정규식표현으로 [^BCD] (BCD가 아니면) ""으로 대체하면 BCD가 아닌 모든 문자가 ""로 변한다
		}
		answer = list.size();
		return answer;
	}
	
	public static void main(String[] args) {
    	String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD",skill_trees));
	}
}
