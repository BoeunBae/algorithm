package STUDY_9;

import java.util.LinkedList;

public class my_여행경로 {

		LinkedList<String> list = new LinkedList<String>();
		
	    public String[] solution(String[][] tickets) {
			String[] answer = {};
			
			for(int i = 0; i<tickets.length; i++) {
				if(tickets[i][0].equals("ICN")) {
	                boolean[] visited = new boolean[tickets.length];
					String dest = tickets[i][1];
					String route="ICN,"+dest+",";
					visited[i]=true;
					DFS(tickets,dest,1,visited,route);
				}
			}
			
			list.sort(null);
			answer = list.get(0).split(",");
			return answer;
		}
		
		public void DFS(String[][] tickets, String dest, int cnt,boolean[] visited, String route) {        
			if(cnt==tickets.length) {
				list.add(route);
				return;
			}
			for(int i = 0; i< tickets.length; i++) {
				if(tickets[i][0].equals(dest)&&!visited[i]) {
					visited[i]=true;
					DFS(tickets,tickets[i][1],cnt+1,visited,route+tickets[i][1]+",");
	                visited[i]=false;
				}
			}
		}

}
