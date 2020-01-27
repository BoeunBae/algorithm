package STUDY_1;

import java.util.ArrayList;
import java.util.List;

public class my_스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<Character> list = new ArrayList<Character>();
		char[] array = skill.toCharArray();
		for(char v : array) list.add(v); //스킬 리스트에 담기

		for(int i = 0; i<skill_trees.length; i++) {
			int cnt = 0; //스킬순서
			boolean flag = true;
			String tmp = skill_trees[i];
			for(char c : tmp.toCharArray()) {
				if(list.contains(c)) {
					if(list.get(cnt) == c) cnt++;
					else {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) answer++;
			
		}

		
		
		return answer;
	}
	
	public static void main(String[] args) {
    	String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD",skill_trees));
	}
}
