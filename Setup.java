package cancerModel;

import java.util.Arrays;
import java.util.Random;

public class Setup {
	
	public double m = .5; //mutation rate
	public double e = 1 ; //survival rate (1 - e = death rate)
	public double p_c = .9; //growth rate for cancerous cells
	public double p_n = .7; //growth rate for normal/mutated cells

	
	public void printGrid(Cell[][] grid)
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println(Arrays.toString(grid[i]));
		}
		
	}public void addCellToGrid(Cell[][] grid, int x, int y, Cell type)
	{
		grid[x][y] = type;		
	}
	public boolean checkGrid(Cell[][] grid, int x, int y)
	{
		if(grid[x][y].type == 'N' || grid[x][y].type == 'M' || grid[x][y].type == 'C')
		{
			return false; //space occupied
		}
		else
			return true; //space free
	}
	public boolean checkAnySpace4(Cell[][] grid, int x, int y)
	{
		if(grid[x-1][y].type == 'N' || grid[x-1][y].type == 'M'|| grid[x-1][y].type == 'C')
		{
			return false;
		}
		if(grid[x-1][y-1].type  == 'N' || grid[x-1][y-1].type  == 'M'|| grid[x][y-1].type  == 'C')
		{
			return false;
		}
		if(grid[x][y-1].type  == 'N' || grid[x][y-1].type  == 'M'|| grid[x][y-1].type  == 'C')
		{
			return false;
		}
		if(grid[x+1][y].type  == 'N' || grid[x+1][y].type  == 'M'|| grid[x+1][y].type  == 'C')
		{
			return false;
		}
		else 
			return true;
	}
	public boolean checkAnySpace8(Cell[][] grid, int x, int y)
	{
		if(grid[x-1][y].type  == 'N' || grid[x-1][y].type  == 'M'|| grid[x-1][y].type  == 'C')
		{
			return false;
		}
		if(grid[x-1][y-1].type  == 'N' || grid[x-1][y-1].type  == 'M'|| grid[x-1][y-1].type  == 'C')
		{
			return false;
		}
		if(grid[x][y-1].type  == 'N' || grid[x][y-1].type  == 'M'|| grid[x][y-1].type  == 'C')
		{
			return false;
		}
		if(grid[x+1][y].type  == 'N' || grid[x+1][y].type  == 'M'|| grid[x+1][y].type  == 'C')
		{
			return false;
		}
		if(grid[x][y+1].type  == 'N' || grid[x][y+1].type  == 'M'|| grid[x][y+1].type  == 'C')
		{
			return false;
		}
		if(grid[x+1][y+1].type  == 'N' || grid[x+1][y+1].type  == 'M'|| grid[x+1][y+1].type  == 'C')
		{
			return false;
		}
		if(grid[x+1][y-1].type  == 'N' || grid[x+1][y-1].type  == 'M'|| grid[x+1][y-1].type  == 'C')
		{
			return false;
		}
		if(grid[x-1][y+1].type  == 'N' || grid[x-1][y+1].type  == 'M'|| grid[x-1][y+1].type  == 'C')
		{
			return false;
		}
		else 
			return true;
	}
	public void divide(Cell[][] grid, char type, int x, int y)
	{
		if(type == 'N')
		{
			grid[x-1][y].type  = 'N';
			grid[x][y-1].type  = 'N';
			grid[x-1][y-1].type  = 'N';
			grid[x+1][y].type  = 'N';
		}
		else if(type == 'M')
		{
			grid[x-1][y].type  = 'M';
			grid[x][y-1].type  = 'M';
			grid[x-1][y-1].type  = 'M';
			grid[x+1][y].type  = 'M';
		}
		else if(type =='C')
		{
			grid[x-1][y].type  = 'C';
			grid[x][y-1].type  = 'C';
			grid[x-1][y-1].type  = 'C';
			grid[x+1][y].type  = 'C';
			grid[x][y+1].type  = 'C';
			grid[x+1][y+1].type  = 'C';
			grid[x+1][y-1].type  = 'C';
			grid[x-1][y+1].type  = 'C';	
		}	
	}
	public void die(Cell[][] grid, int x, int y)
	{
		grid[x][y].type  = 'D';
	}
	public void mutate(Cell[][] grid,char type, int x, int y)
	{
		
		//System.out.println("mutating from " + type);
		if(type == 'N')
		{
			grid[x][y].type  = 'M';
		}
		else if (type == 'M')
		{
			grid[x][y].type  = 'C';
		}
	}

	public void start(int steps)
	{
		Cell[][] grid = new Cell[25][25];
		Cell cell;
	
		for(int i = 0; i < steps; i++)//populate array
		{
			//System.out.println("step = " + i);
			int random = (int)(Math.random() * 24 + 1);
			int random2 = (int)(Math.random() * 24 + 1);
			int random3 = (int)(Math.random() * 24 + 1); //get two new random points for cell
			int random4 = (int)(Math.random() * 24 + 1);
			cell = new Cell(random,random2,'N');

			
		    if(checkGrid(grid, random, random2) == false) //if current cell is already occupied
		    {
		    	cell = new Cell(random3,random4, 'N');//redefine cell
				addCellToGrid(grid, random3, random4, cell);//add cell with different coordinates
		    }
		    else
		    {
		    	addCellToGrid(grid, random, random2, cell);
		    }
		
		    
		    
		   
		    for(int j = 1; j < 25; j++)
		    {
		    	for(int k = 1; k < 25; k++)
		    	{
		    		if(new Random().nextDouble() <= (1-e)) //probability that cell dies
					{
						die(grid,cell.x,cell.y);
						continue;
					}
					
				    else ////if not dead, mutate with prob p_n for N,M cells, p_c for C cells
				    {
				   		if(new Random().nextDouble() <= m) //mutate with prob m
				  		{
							mutate(grid,cell.type, cell.x,cell.y);//mutate cell
					
								if(grid[j][k].type == 'N' || grid[j][k].type == 'M')//if cell is type N or M
								{
									if(checkAnySpace4(grid, cell.x, cell.y))//if cell has space to divide
									{
										if(new Random().nextDouble() <= p_n)//divide with probability p_n
										{
											divide(grid, cell.type, cell.x, cell.y);//divide cell
										}
									}
									else
									{
										continue; //cell does not divide, do nothing
									}
								}
				    		}
							 if(grid[j][k].type == 'C')//C grid[j][k]s cannot mutate
							{
								if(checkAnySpace8(grid, cell.x, cell.y))//if cell has space to divide
								{
									if(new Random().nextDouble() <= p_c)//divide with probability p_c
									{
										divide(grid, cell.type, cell.x, cell.y);//divide cell
									}
								}
							}	
						}    
				}	    	
		    }
		}    
		    
	printGrid(grid);	
	}
	
	public static void main(String[] args)
	{
		Setup e = new Setup();
		e.start(25);
	}
}
