package STUDY_4;


public class my_자물쇠와열쇠 {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
    	int sizeOfKey = key.length;
        int[][] arr = copyLock(sizeOfKey, lock);    
      	int turnCnt = 1;
        while(turnCnt<=4) {
        	
//        	int cnt = 0;
//            for(int i = 0; i<arr.length; i++) {
//            	for(int j = 0; j<arr.length; j++) {
//            		arr[i][j] += key[cnt][cnt];
//            		cnt++;
//            		if(cnt==sizeOfKey-1) {
//            	    	if(unLock(arr,sizeOfKey)) {
//            	    		return true;
//            	    	}else {
//            	    		arr=copyLock(sizeOfKey, lock);
//            	    		cnt=0;
//            	    	}
//            		}
//            	}
//            }
            
            key=turn(key);
            turnCnt++;
        }
        
        
        return answer;
        
    }
    public static int[][] copyLock(int sizeOfKey, int[][] lock) {
    	
    	int size = sizeOfKey+2*(sizeOfKey-1);
        int[][] arr = new int[size][size]; 
      	int idx1 = 0;
      	for(int i = sizeOfKey-1; i<=2*(sizeOfKey-1); i++) {
      		int idx2 = 0;
      		for(int j = sizeOfKey-1; j<=2*(sizeOfKey-1); j++) {
      			arr[i][j] = lock[idx1][idx2];
      			idx2++;
      		}
      		idx1++;
      	}
      	
      	return arr;
    }
    
    public static int[][] turn(int[][] key) { //회전시키는 함수
    	int[][] newKey = new int[key.length][key[0].length];
    	 for(int i = 0; i<key.length; i++) {
         	for(int j = 0; j<key.length; j++) {
         		newKey[j][key.length-1-i] = key[i][j];
         	}
         }
    	 return newKey;
    }
    
    public static boolean unLock(int[][] arr, int sizeOfKey) { //lock배열이 모두 1로 이뤄져있는지 확인
    	boolean result = true;
    	for(int i = sizeOfKey-1; i<=2*(sizeOfKey-1); i++) {
    		for(int j = sizeOfKey-1; j<=2*(sizeOfKey-1); j++) {
    			if(arr[i][j]==0) {
    				result=false;
    				break;
    			}
    		}
    	}
    	return result;
    }
    

    public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}
}
