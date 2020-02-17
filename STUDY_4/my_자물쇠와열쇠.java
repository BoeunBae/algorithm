package STUDY_4;

import java.util.Arrays;

public class my_자물쇠와열쇠 {
	static int N,M,S;
    public static boolean solution(int[][] key, int[][] lock) {

    	int cnt = 0;
    	while(cnt<4) {
    		key=rotate(key);
    		if(tryToUnLock(key,lock)) return true;
    		cnt++;
    	}
    	return false;
    }

    public static boolean tryToUnLock(int[][] key, int[][] lock) {
    	N = lock.length;
    	M = key.length;
    	S = N+2*(N-1);
    	int[][] copyLock = null;
    	int[][] copyKey = copyKey(key);
    	
    	for(int i = 0; i<=S-N; i++) {
    		int[][] copyKeyForDown=Arrays.copyOf(copyKey, copyKey.length);
    		for(int j = 0; j<=S-N; j++) {
    			copyLock = copyLock(lock);
    			for(int k = 0; k<copyLock.length; k++) {
    				for(int r = 0; r<copyLock[k].length; r++) {
    					copyLock[k][r] += copyKeyForDown[k][r];
    				}
    			}
    			
    			if(unLock(copyLock)) return true;
    			copyKeyForDown = moveToDown(copyKeyForDown);
    		}
    		copyKey=moveToRight(copyKey);
    	}
    	
    	return false;
    }
    
    public static boolean unLock(int[][] copyLock) {
    	for(int i = 0 ; i< N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(copyLock[S-(2*N-1)+i][S-(2*N-1)+j]!=1) return false; 
    		}
    	}
    	return true;
    }
    
    public static int[][] copyLock(int[][] lock){
    	int[][] copyLock = new int[S][S];
    	for(int i = 0 ; i<N; i++) {
    		for(int j = 0; j<N; j++) {
    			copyLock[S-(2*N-1)+i][S-(2*N-1)+j] = lock[i][j]; //확장된 배열의 중앙에 자물쇠 넣기
    		}
    	}
    	return copyLock;
    }
    
    public static int[][] copyKey(int[][] key){
    	int[][] copyKey = new int[S][S];    	
    	for(int i = 0 ; i<M; i++) {
    		for(int j = 0; j <M; j++) {
    			copyKey[i][j] = key[i][j]; //확장된 배열의 왼쪽 상단에 키 넣기
    		}
    	}
    	return copyKey;
    }
    
    public static int[][] rotate(int[][] key){
    	int[][] newKey = new int[key.length][key.length];
    	for(int i = 0; i<newKey.length; i++) {
        	for(int j = 0; j<newKey.length; j++) {
        		newKey[j][newKey.length-1-i] = key[i][j];
        	}
        }
   	 return newKey;
    }
    
    public static int[][] moveToDown(int[][] copyKey){
    	int[][] newCopyKey = new int[S][S];
    	for(int i = 0; i<S; i++) {
    		for(int j = 0; j<S; j++) {
    			if(i!=S-1&&copyKey[i][j]==1) newCopyKey[i+1][j]=1;
    		}
    	}
    	return newCopyKey;
    }
    
    public static int[][] moveToRight(int[][] copyKey){
    	int[][] newCopyKey = new int[S][S];
    	for(int i = 0; i<S; i++) {
    		for(int j = 0; j<S; j++) {
    			if(j!=S-1&&copyKey[i][j]==1) newCopyKey[i][j+1]=1;
    		}
    	}
    	return newCopyKey;
    }
     
    public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}
}
