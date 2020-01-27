package STUDY_3;

import java.util.Arrays;

public class my_H_index {
	public int solution(int[] citations) {
	    int answer = 0;
	    int n = citations.length;
	    Arrays.sort(citations);
	    for(int i = n; i>0; i--){
	        int h = i; //논문의 개수 이하의 숫자가 h의 후보값
	        if(h<=citations[n-h]){ //h개의 논문이 h보다 크거나 같은 값을 가져야하므로 정렬된 배열의 [전체논문개수-h]에 해당하는 인덱스 값을 비교하여 만족하면 된다.
	            answer=h;
	            break;
	        }
	    }
	    return answer;
	}
}
