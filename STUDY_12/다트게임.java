package STUDY_12;

public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dartArray = dartResult.toCharArray();
        int[] pnt = new int[3]; //점수 담을 배열
        int idx = 0;
        String tmpNum = "";
        for(char v : dartArray){
            if(Character.isDigit(v)) tmpNum+=v;
            else{
                if(!tmpNum.equals("")) {
                    pnt[idx++] = Integer.parseInt(tmpNum);
                    tmpNum="";
                }
                switch(v){
                    case 'S':
                        pnt[idx-1] = (int)Math.pow(pnt[idx-1],1);  
                        break;
                    case 'D':
                        pnt[idx-1] = (int)Math.pow(pnt[idx-1],2);  
                        break;
                    case 'T':
                        pnt[idx-1] = (int)Math.pow(pnt[idx-1],3);  
                        break;
                    case '*':
                        if(idx-1==0) pnt[idx-1] = 2*pnt[idx-1];
                        else{
                            pnt[idx-2] = 2*pnt[idx-2];
                            pnt[idx-1] = 2*pnt[idx-1];
                        }
                        break;
                    case '#':
                        pnt[idx-1] = -1*pnt[idx-1];
                        break;                      
                }
            }           
        }
        for(int v : pnt) answer += v;
        return answer;
    }
}
