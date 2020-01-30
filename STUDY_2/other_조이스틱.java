package STUDY_2;

public class other_조이스틱 {
	public static int solution(String name) {
	    int answer = 0;
	    int cnt=name.length(), cur_idx=0;
	    boolean[] flag = new boolean[name.length()];
	    for(int i = 0; i<name.length(); i++) {
	    	char c = name.charAt(i);
			if(c!='A' && c >= 'N') answer += 'Z'-c+1;
			else if(c!='A' && c < 'N') answer += c-'A';
			if(c=='A') {
				flag[i]=true;
				cnt--;
			}
			
		}
	    
	    if(!flag[0]) {
	    	flag[0]=true;
	    	cnt--;
	    }
	    while(cnt>0) {
	    	int l_cnt=0,r_cnt=0,l_idx=0, r_idx=0;
	    	
	    	for(int i = cur_idx-1 ; i!=cur_idx ; i--) {
	    		if(i==-1) i=name.length()-1;
	    		l_cnt++;
	    		if(!flag[i]) {
	    			l_idx=i;
	    			break;
	    		}
	    	}
	    	
	    	for(int i = cur_idx+1 ; i!=cur_idx ; i++) {
	    		if(i==name.length()) i=0;
	    		r_cnt++;
	    		if(!flag[i]) {
	    			r_idx=i;
	    			break;
	    		}
	    	}
	    	
	    	if(l_cnt>=r_cnt) {
	    		flag[r_idx]=true;
	    		cur_idx=r_idx;
	    		answer+=r_cnt;
	    	}else {
	    		flag[l_idx]=true;
	    		cur_idx=l_idx;
	    		answer+=l_cnt;
	    	}
	    	
	    	cnt--;
	    	
	    }
	    
	    
	    
	    return answer;
	}
}
