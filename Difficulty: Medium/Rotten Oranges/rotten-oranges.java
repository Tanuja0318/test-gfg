class Solution {
    public int orangesRotting(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int time=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    fresh++;
                if(mat[i][j]==2)
                    q.offer(new int[]{i, j});
            }
        }
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        while(q.size()>0 && fresh>0){
            int size=q.size();
            time++;
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                int x=curr[0],y=curr[1];
                for (int[] dir : directions) { 
                    int newx = x + dir[0];
                    int newy = y + dir[1];
                    if(newx>=0 && newy>=0 && newx<mat.length && newy<mat[0].length && mat[newx][newy]==1){
                        mat[newx][newy]=2;
                        fresh--;
                        q.offer(new int[]{newx,newy});
                    }
                }
            }
        }
        return fresh==0 ? time:-1;
    }
}