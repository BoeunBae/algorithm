package STUDY_1;

//내 코드보다 절반 정도 시간 짧다	
public class other_쇠막대기 {
	public static int solution(String arrangement) { 
		int answer = 0;
		int pipe = 0;
		
		char[] array = arrangement.toCharArray();
		for(int i = 0; i<array.length; i++) {
			if(array[i]=='(') {
				if(array[i+1]==')') { //레이저
					answer+=pipe;
					i++; // 다음에 오는 ) 건너뛰기 위함
				}else {
					pipe++; //막대기 추가
				}
			}else {
				answer++; //막대기의 끝을 나타내므로 남은 막대기 조각을 더해주는 것
				pipe--; //막대기 하나 끝났으므로 줄이기
			}
		}
		return answer;
	}
	

    public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}
}

