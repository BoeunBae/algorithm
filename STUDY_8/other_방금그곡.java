package STUDY_8;

public class other_방금그곡 {
	class Solution {
	    public String solution(String m, String[] musicinfos) {
	        String answer = "(None)";
	        int time = 0;

	        m = edit(m);

	        for (int inx = 0; inx < musicinfos.length; inx++) {

	            String[] info = musicinfos[inx].split(",");

	            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
	            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
	            int t = end - start;

	            if (t > time) { //기존의 재생시간보다 크면 진행, 같을 땐 제일 먼저 들어온 곡이 이미 answer에 들어가 있을 것 
	                info[3] = edit(info[3]);
	                StringBuffer sb = new StringBuffer();
	                for (int jnx = 0; jnx < t; jnx++) {
	                    sb.append(info[3].charAt(jnx % (info[3].length())));
	                }
	                if (sb.toString().indexOf(m) >= 0) {
	                    answer = info[2];
	                    time = t;
	                }
	            }
	        }

	        return answer;
	    }

	    public String edit(String m) {

	        m = m.replaceAll("C#", "V");
	        m = m.replaceAll("D#", "W");
	        m = m.replaceAll("F#", "X");
	        m = m.replaceAll("G#", "Y");
	        m = m.replaceAll("A#", "Z");

	        return m;
	    }
	}
}
