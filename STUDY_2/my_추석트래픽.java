package STUDY_2;

public class my_추석트래픽 {

  public static int solution(String[] lines) {
		int answer = 0;
		int[] num_of_t = new int[lines.length];
		for(int i = 0; i<lines.length; i++) {
			//처리량이 변하는 순간은 각 로그의 시작과 끝
		double S_standard = Integer.parseInt(lines[i].split(" ")[1].split(":")[0])*3600 +
				Integer.parseInt(lines[i].split(" ")[1].split(":")[1])*60 +
				Double.parseDouble(lines[i].split(" ")[1].split(":")[2]); //처리량을 비교하기 위해 끝점 기준 잡기
		
			for(int j = i ; j<lines.length; j++) {
				double S = Integer.parseInt(lines[j].split(" ")[1].split(":")[0])*3600 +
						Integer.parseInt(lines[j].split(" ")[1].split(":")[1])*60 +
						Double.parseDouble(lines[j].split(" ")[1].split(":")[2]); //응답완료시간
				double T = Double.parseDouble(lines[j].split(" ")[2].replace("s","")); //처리시간
				double O = S-T+0.001; //응답시작시간
				if(O-S_standard<1) {
					num_of_t[i]++; //각 로그의 시작시간 - 기준이 되는 완료시간의 차가 1초 미만이면 해당 로그의 갯수만큼 카운팅 
				}
			}
		}
		
		for(int i = 0; i<lines.length; i++) answer = answer < num_of_t[i] ? num_of_t[i] : answer; 
		return answer;
  }
  public static void main(String[] args) {
	  
//	  String[] log = {"2016-09-15 20:59:57.421 0.351s",
//			  "2016-09-15 20:59:58.233 1.181s",
//			  "2016-09-15 20:59:58.299 0.8s",
//			  "2016-09-15 20:59:58.688 1.041s",
//			  "2016-09-15 20:59:59.591 1.412s",
//			  "2016-09-15 21:00:00.464 1.466s",
//			  "2016-09-15 21:00:00.741 1.581s",
//			  "2016-09-15 21:00:00.748 2.31s",
//			  "2016-09-15 21:00:00.966 0.381s",
//			  "2016-09-15 21:00:02.066 2.62s"
//			  };
	  
	  String[] log = {"2016-09-15 01:00:04.002 2.0s",
			  "2016-09-15 01:00:07.000 2s"
			  };
	  System.out.println(solution(log));
  }
}
