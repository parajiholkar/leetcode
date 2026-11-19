class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int len = prerequisites.length;

        if(len==0) return true;

        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            boolean canNotFinishCource = dfs(i, prerequisites, vis, stack);
            if(canNotFinishCource){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course, int[][] prerequisites, boolean[] vis, boolean[] stack){
        vis[course] = true;
        stack[course] = true;

        for(int i=0; i<prerequisites.length; i++){

            if(prerequisites[i][0]==course){
                int des = prerequisites[i][1];

                if(stack[des]){
                    return true;
                }

                if(!vis[des] && dfs(des, prerequisites, vis, stack)){
                    return true;
                }
            }
        }

        stack[course] = false;
        return false;
    }
}