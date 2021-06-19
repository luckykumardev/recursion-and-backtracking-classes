package class4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PathOfMiddle {
	  public static void main (String[] args) throws InterruptedException, ExecutionException {
	   /*     int[][] maze = {
	            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
	            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
	            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
	            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
	            
	            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
	            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
	            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
	            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
	            { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
	        };
	         
	        printPath(maze,0,0,"");*/
	
	  
	  
	     ExecutorService service = Executors.newFixedThreadPool(1);
	     Future<List<String>> future = service.submit(new Callable(){
			    public List<String> call() throws Exception {
			        List<String> temp = new ArrayList<>();
			        temp.add("codebix");
			        temp.add("hello");
			    	return temp;
			    }
			});
//
//		   future = service.submit(task);

		  if(future.isDone()){
            List<String> temp2  = (List<String>) future.get();
			temp2.forEach( l->{
				System.out.println(l);
			});
		  }

		  
	  }
	     
	    public static void printPath(int[][] maze, int i, int j, String ans){
	        if (i == maze.length/2 && j==maze.length/2){
	            ans += "("+i+", "+j+") -> MID";
	            System.out.println(ans);
	            return;
	        }
	         
	        if (maze[i][j]==0){
	            return;
	        }
	         
	        int k = maze[i][j];
	         
	        maze[i][j]=0;
	         
	        if (j+k<maze.length){
	            printPath(maze, i, j+k, ans+"("+i+", "+j+") -> ");
	        }
	 
	        if (i+k<maze.length){
	            printPath(maze, i+k, j, ans+"("+i+", "+j+") -> ");
	        }
	 
	        if (j-k>0){
	            printPath(maze, i, j-k, ans+"("+i+", "+j+") -> ");
	        }
	 
	        if (i-k>0){
	            printPath(maze, i-k, j, ans+"("+i+", "+j+") -> ");
	        }
	         
	        maze[i][j] = k;
	    }
}
