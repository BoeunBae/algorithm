package STUDY_5;

import java.util.Arrays;
import java.util.Comparator;

//prim알고리즘 사용하기
public class other_섬연결하기 {
	static int[] parent;
	public static int solution(int n , int[][] costs) {
		int answer = 0;
		parent=new int[n];
		
		for(int i = 0; i<n; i++) { //각 정점의 부모를 자기 자신으로 랭크를 1로 초기화
			parent[i]=i;
		}
		
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				return ((Comparable)arr1[2]).compareTo(arr2[2]);
			}
		}); //비용 기준으로 오름차순 정렬
		
		for(int i = 0; i<costs.length; i++) {
			int cost = costs[i][2];
			int start = costs[i][0];
			int end = costs[i][1];
			
			if(start==end)continue;
			if(FindParent(start)==FindParent(end))continue;
			Merge(start, end);
			answer+=cost;
		}
		return answer;
	}
	
	public static int FindParent(int u) { //부모찾는 함수
		if(parent[u]==u) return u;
		return parent[u]=FindParent(parent[u]);
	}
	
	public static void Merge(int u, int v) {
		u=FindParent(u);
		v=FindParent(v);
		if(u==v) return;
		parent[u]=v;
	}
	
	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		solution(4,costs);
	}
}
