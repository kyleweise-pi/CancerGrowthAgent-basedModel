package cancerModel;
import java.util.Random;

public class Setup {
	
	public double m = .05; //mutation rate
	public double e = 1; //survival rate (1 - e = death rate)
	public double p_c = .8; //growth rate for cancerous cells
	public double p_n = .7; //growth rate for normal/mutated cells

	
	public void printGrid(char[][] grid)
	{
		
		for (int i = 0; i < 25; i++) System.out.print("-");
		System.out.println();
		for(int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 25; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < 25; i++) System.out.print("-");
		System.out.println();
	}
	public void addCellToGrid(char[][] grid, int x, int y, char type)
	{
		//System.out.println("adding type = " + type);
		grid[x][y] = type;		
	}
	public boolean checkGrid(char[][] grid, int x, int y)
	{
		//System.out.println("in checkGrid " + x + "," + y);
		if(grid[x][y] == 'N' || grid[x][y] == 'M' || grid[x][y] == 'C')
		{
			//System.out.println("return false");
			return false; //space occupied
		}
		else {
			//System.out.println("return true");
			return true; //space free
		}
	}
	public boolean checkAnySpace4(char[][] grid, int x, int y)
	{
		if((x == 0) && (y == 0))//top left 
		{
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x == 0) && (y == 24))//top right corner
		{
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}	
		}
		if((x == 24) && (y == 0))//bottom left corner
		{
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x == 24) && (y == 24))//bottom right corner
		{
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
		}
		
		
		
		if((x == 0) && (y >1 && y < 24))//cells in first row(not including corners)
		{
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
		}
	
		if((x >1 && x < 24) && (y == 0))//cells in first column(not including corners)
		{
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}	
		}
		
		if((x == 24) && (y >1 && y < 24))//cells in last row(not including corners)
		{
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}	
		}
		if((x >1 && x < 24) && (y == 24))//cells in last column(not including corners)
		{
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}	
		}
		else if((x >1 && x < 24)&& (y >1 && y < 24))//any other cell
		{
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y] == 'N' || grid[x-1][y] == 'M'|| grid[x-1][y] == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			
		}
		return true;	   
	}
	public boolean checkAnySpace8(char[][] grid, int x, int y)
	{
		
		if((x == 0)&&(y==0))//top left 
		{
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y+1]  == 'N' || grid[x-1][y+1]  == 'M'|| grid[x-1][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x == 0)&&(y==24))//top right
		{
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y-1]  == 'N' || grid[x-1][y-1]  == 'M'|| grid[x-1][y-1]  == 'C')
			{
				return false;
			}
		}
		if((x == 24)&&(y==0))//bottom left
		{
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y+1]  == 'N' || grid[x-1][y+1]  == 'M'|| grid[x-1][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x == 24)&&(y==24))//bottom right
		{
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y-1]  == 'N' || grid[x-1][y-1]  == 'M'|| grid[x-1][y-1]  == 'C')
			{
				return false;
			}
		}
		if((x == 0)&&(y >1 && y <24))//first row(not including corners)
		{
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y-1]  == 'N' || grid[x+1][y-1]  == 'M'|| grid[x+1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y+1]  == 'N' || grid[x+1][y+1]  == 'M'|| grid[x+1][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x == 24)&&(y >1 && y <24))//last row(not including corners)
		{
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y-1]  == 'N' || grid[x+1][y-1]  == 'M'|| grid[x+1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y+1]  == 'N' || grid[x-1][y+1]  == 'M'|| grid[x-1][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
		}
		if((x > 1 && x < 24)&&(y ==0))//first column(not including corners)
		{
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y+1]  == 'N' || grid[x-1][y+1]  == 'M'|| grid[x-1][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y+1]  == 'N' || grid[x+1][y+1]  == 'M'|| grid[x+1][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
		}
		if((x > 1 && x < 24)&&(y ==24))//last column
		{
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y-1]  == 'N' || grid[x-1][y-1]  == 'M'|| grid[x-1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y-1]  == 'N' || grid[x+1][y-1]  == 'M'|| grid[x+1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
		}
		else if((x >1 && x < 24)&& (y >1 && y < 24))
		{
			if(grid[x-1][y]  == 'N' || grid[x-1][y]  == 'M'|| grid[x-1][y]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y-1]  == 'N' || grid[x-1][y-1]  == 'M'|| grid[x-1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x][y-1]  == 'N' || grid[x][y-1]  == 'M'|| grid[x][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y]  == 'N' || grid[x+1][y]  == 'M'|| grid[x+1][y]  == 'C')
			{
				return false;
			}
			if(grid[x][y+1]  == 'N' || grid[x][y+1]  == 'M'|| grid[x][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y+1]  == 'N' || grid[x+1][y+1]  == 'M'|| grid[x+1][y+1]  == 'C')
			{
				return false;
			}
			if(grid[x+1][y-1]  == 'N' || grid[x+1][y-1]  == 'M'|| grid[x+1][y-1]  == 'C')
			{
				return false;
			}
			if(grid[x-1][y+1]  == 'N' || grid[x-1][y+1]  == 'M'|| grid[x-1][y+1]  == 'C')
			{
				return false;
			}
		}
		return true;
	}
	
	
	void assignGrid(char [][] grid, int x, int y, char a) {
		if (grid[x][y] == ' ') grid[x][y] = a;
	}
	
	int updateXY(int x) {
		if (x < 0) return 0;
		if (x > 24) return 24;
		return x;
	}

	public void divide(char[][] grid, char [][] updateGrid, int x, int y)
	{	
		char c = grid[x][y];
			
		int x1 = updateXY(x-1);
		int x2 = updateXY(x+1);
		
		int y1 = updateXY(y-1);
		int y2 = updateXY(y+1);
		
		assignGrid(updateGrid,x1,y, c);
		assignGrid(updateGrid,x2,y, c);
		
		assignGrid(updateGrid,x,y1, c);
		assignGrid(updateGrid,x,y2, c);
			
		if (grid[x][y] == 'C') {
		
			assignGrid(updateGrid,x1,y1, c);
			assignGrid(updateGrid,x2,y2, c);
			
			assignGrid(updateGrid,x1,y2, c);
			assignGrid(updateGrid,x2,y1, c);
			
		}
	}
	public void die(char[][] updateGrid, int x, int y)
	{
		updateGrid[x][y]  = 'D';
	}
	public void mutate(char [][] grid, char[][] updateGrid, int x, int y)
	{
		
		//System.out.println("mutating from " + type);
		if(grid[x][y]== 'N')
		{
			updateGrid[x][y]  = 'M';
		}
		else if (grid[x][y] == 'M')
		{
			updateGrid[x][y]  = 'C';
		}
	}
	
	
	void copyGrid (char[][] gridFrom, char[][] gridTo) {		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				gridTo[i][j] = gridFrom[i][j];
			}
		}
	}

	public void start(int steps)
	{
		char [][] grid = new char[25][25];
		char [][] updateGrid = new char[25][25];
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25;j++) {
				grid[i][j] = ' ';
				updateGrid[i][j] = ' ';
			}
		}
		
	
		int numCells = 0;
		while (numCells < 10) {
		
			//System.out.println("step = " + i);
			int random = (int)   Math.floor((Math.random() * 24));
			int random2 = (int)  Math.floor((Math.random() * 24));
			
			if(checkGrid(grid, random, random2) == true) //if current cell is empty
			{
				addCellToGrid(grid, random, random2, 'N');//add cell with different coordinates
				numCells++;
			}
		}
		
		printGrid(grid);
		
	   // System.out.print("exiting before steps");
		//System.exit(-1);
	    
	    copyGrid(grid, updateGrid);
		
		for(int i = 0; i < steps; i++)//populate array
		{						
		    for(int j = 0; j < 25; j++)
		    {
		    	for(int k = 0; k < 25; k++)
		    	{
		    		if(new Random().nextDouble() <= (1-e)) //probability that cell dies
					{
						die(updateGrid, j, k);
						continue;
					}
					
				    else ////if not dead, mutate with prob p_n for N,M cells, p_c for C cells
				    {
				  
				   		if(new Random().nextDouble() <= m) //mutate with prob m
				  		{
							mutate(grid, updateGrid, j,k);//mutate cell
				  		}
					
				   		else if(grid[j][k] == 'N' || grid[j][k] == 'M')//if cell is type N or M
						{
								if(new Random().nextDouble() <= p_n)//divide with probability p_n
								{
										divide(grid, updateGrid, j, k);//divide cell
								}
								else
								{
									continue; //cell does not divide, do nothing
								}
				   		}
				   		else if(grid[j][k] == 'C')//C grid[j][k]s cannot mutate
							{
								if(new Random().nextDouble() <= p_c)//divide with probability p_c
								{
									divide(grid, updateGrid, j, k);//divide cell
								}
							}	
					}    
				}	    	
		    }
		    copyGrid(updateGrid, grid);
		} // end steps    
		    
	printGrid(grid);
	
	
	int numC = 0;
	int numM = 0;
	int numN = 0;
	int numD = 0;
	
	for(int i = 0; i < 25; i++)
	{
		for(int j = 0; j < 25; j++)
		{
			if(grid[i][j] == 'N')
			{
				numN++;
			}
			else if(grid[i][j] == 'M')
			{
				numM++;
			}
			else if(grid[i][j] == 'C')
			{
				numC++;
			}
			else if(grid[i][j] == 'D')
			{
				numD++;
			}
		}
	}
	System.out.println("Number of C cells:"+numC);
	System.out.println("Number of M cells:"+numM);
	System.out.println("Number of N cells:"+numN);
	System.out.println("Number of D cells:"+numD);
	
	}
	public static void main(String[] args)
	{
		Setup e = new Setup();
		e.start(25);
	}
}
