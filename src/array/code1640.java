package array;

import java.util.HashMap;

public class code1640 {
    public boolean judge(int[] arr, int[] piece, int pos){
        for(int j=0; j<piece.length; j++){
            if(arr[pos+j] != piece[j])
                return false;
        }
        return true;
    }
    public boolean dfs(int[] arr, int[][] pieces, boolean[] visited, int pos) {
        if(pos == arr.length)
            return true;
        for(int i=0; i<visited.length; i++) {
            if(visited[i]) continue;
            if(!judge(arr, pieces[i], pos))
                continue;
            visited[i] = true;
            if(dfs(arr, pieces, visited, pos+pieces[i].length))
                return true;
            visited[i] = false;
        }
        return false;
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // dfs O(n2)
//        boolean[] visited = new boolean[pieces.length];
//        return dfs(arr, pieces, visited, 0);
        // HashMap O(n)/)(n)
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<pieces.length; i++){
            map.put(pieces[i][0], pieces[i]);
        }
        int p = 0;
        while(p < arr.length){
            int[] piece = map.getOrDefault(arr[p], null);
            if(piece == null) return false;
            for(int j=0; j<piece.length; j++){
                if(arr[p+j] != piece[j])
                    return false;
            }
            p += piece.length;
        }
        return true;
    }
}
