package STUDY_8;
import java.util.Arrays;

public class my_정수삼각형 {
    public int solution(int[][] triangle) {
//        int answer = 0;
        for(int i = 1; i<triangle.length; i++){
            for(int j = 0; j<triangle[i].length; j++){
                if(j==0)triangle[i][j] += triangle[i-1][j];
                else if(i==j) triangle[i][j] += triangle[i-1][j-1];
                else triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);    
                
            }
        }
//        Arrays.sort(triangle[triangle.length-1]);
//        answer = triangle[triangle.length-1][triangle.length-1];
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
