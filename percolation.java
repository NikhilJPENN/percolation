// Name: JAMDADE NIKHIL KAILAS    PENN ID: 56849791

package percolation;


public class percolation {

	int [][] container;
	
	int[][] ground(int n, double p){
		
		container= new int [n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				double tempVar=Math.random();             // creating Random numbers between 0 to 1
				if (tempVar>=p){
					container[i][j]=1;
				}
				else {
						container[i][j]=0;
					}
			  }
		}
		
		return container;                               //  returns the container having initial ground created with sand particles
		
		
	}
	
	
void seep(int[][] ground, int row) {
		
		int n=ground.length;
		// padding with 1 on both vertical sides of container 
		
		int [][] tempGround= new int[n][n+2];
		
		for (int i=0; i<n; i++){
			tempGround[i][0]=1;
			tempGround[i][n+1]=1;	
			for(int j=0;j<n;j++) {
				
				tempGround[i][j+1]=ground[i][j];
			} 
		}
	    
	 
	for(int j=0; j<n+2;j++)                          // for filling the block with water just below the water block
		{
			if (tempGround[row][j]==0 && row==0) {
				tempGround[row][j]=2;				
			}
			else if (tempGround[row][j] == 0 && tempGround[row-1][j] == 2){
			         tempGround[row][j]=2;
			}
		}

	for(int j=1;j<n+1;j++)          // for filling the block with water side by side 
		{
		  if (tempGround[row][j]==0)
		  {
					  
			if(tempGround[row][j-1]==2) {
				
				tempGround[row][j]=2;
			}
				
			else 
			{
				int k=j+1;
				while(tempGround[row][k]==0)
				{
					k++;
				}
				
				if (tempGround[row][k]==1)
				{
					tempGround[row][j]=0;
				}
				else
				{
					tempGround[row][j]=2;
				}
			}
		  }	
		
		}
	
				for (int i=0;i<n;i++)           // removing the padding 
				{
					for (int j=0;j<n;j++)
					{
						ground[i][j]=tempGround[i][j+1];
					}
				}
	
			
}	    
	
	
	
boolean percolate(int[][] ground) {
		
		int n=ground.length;
		for (int i=0;i<n;i++) {
			if (ground[n-1][i] == 2) {
				return true;
			}
		}
		return false;
	}
	
double findProbability(int n) {
		
		double p=0.5;
		//double delta=0.01;
		int [][] grid;
		int count=0;                     
		double ratio=0.00;                  // to get the ratio of how much % of iterations water reaches at the bottom
		int noI=0;                          // Variable for number of iterations 
		
		int cnt=0;
		while(cnt<5)
			{count=0;
			
		for (noI=0;noI<50;noI++)
		{
			grid=ground(n,p);
			for (int row=0;row<n;row++)
			{
				seep(grid,row);                       // seep function call 
			}
			
			boolean test=percolate(grid);
			if (test)
			{
				count=count+1;                          // count if water is at the bottom
			
			}
		}
		
			ratio=(double)(1.0*count/noI);	
		
			
			System.out.println("p="+(1-p)+" "+ "count="+count+" "+"ratio="+ratio);
			
			if(Math.abs(ratio-0.5)>0.05)
			 {
				if (ratio<0.50)
				{
					p=p+0.05*Math.abs(ratio-0.5);
					
				}
				else if(ratio>0.5)
				{
					p=p-0.05*Math.abs(ratio-0.5);
				}
				
			}
			else {
				if (ratio<0.50)
				{
					p=p+0.01*Math.abs(ratio-0.5);
					
				}
				else if(ratio>0.5)
				{
					p=p-0.010*Math.abs(ratio-0.5);
				}
				cnt++;
			}
			}
	
			  
			return p;
	
		}
	
	
	
	
}
