package STUDY_8;

import java.util.LinkedList;
import java.util.Queue;

public class my_캐시 {
  public int solution(int cacheSize, String[] cities) {
      int answer = 0;
      if(cacheSize==0) return cities.length*5;
      Queue<String> q = new LinkedList<String>();
      for(int i = 0; i<cities.length; i++)cities[i] = cities[i].toLowerCase(); //대소문자 통일
      
      for(int i = 0; i<cities.length; i++){
          if(q.contains(cities[i])){ //캐시 hit일 때 실행시간 1초 증가
              answer+=1;
              q.remove(cities[i]);
              q.add(cities[i]);
          }else{ 
              answer+=5; //캐시 miss일 때 실행시간 5초 증가
              if(q.size()>=cacheSize){ //캐시 사이즈가 다 찼을 때
                  q.poll();
                  q.add(cities[i]);
              }else{
                  q.add(cities[i]);
              }
          }
      }
      return answer;
  }
}
