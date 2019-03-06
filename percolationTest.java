// Name: JAMDADE NIKHIL KAILAS    PENN ID: 56849791

package percolation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class percolationTest {

	percolation Obj= new percolation();

@Test
	void testGround() {

		int cnt0=0;
		int [][] box=Obj.ground(10,0.6);
		boolean testCondition= true; 
		
		int r1=box.length;
		int c1=box[0].length;

		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if (box[i][j]==0)
				{
					cnt0=cnt0+1;
				}
			}
		}
		
		if (cnt0>50 && cnt0<70)                // if water available in between 50 ti 70 percentage then consition is true
		{
			testCondition= true; 
			
		}
		
		assertTrue(testCondition);

	}

	@Test
	void testSeep() {

		int[][] contianer =
			{
					{ 1, 0, 0, 1}, {1, 0, 1, 1}, {1,0,0,0},
					{ 0, 0, 1, 1}
			};  //     initial test grid 

		int[][] grid1 =
			{
					{ 1, 2, 2, 1}, {1, 0, 1, 1}, {1,0,0,0},
					{ 0, 0, 1, 1}
			};
		
		int[][] grid2 =
			{
					{ 1, 2, 2, 1}, {1, 2, 1, 1}, {1,0,0,0},
					{ 0, 0, 1, 1}
			};
		int[][] grid3 =
			{
					{ 1, 2, 2, 1}, {1, 2, 1, 1}, {1,2,2,2},
					{ 0, 0, 1, 1}
			};
		int[][] grid4 =
			{
					{ 1, 2, 2, 1}, {1, 2, 1, 1}, {1,2,2,2},
					{ 2, 2, 1, 1}
			};

		Obj.seep(contianer,0);
		assertArrayEquals(contianer,grid1);

		Obj.seep(contianer,1);
		assertArrayEquals(contianer,grid2);

		Obj.seep(contianer,2);
		assertArrayEquals(contianer,grid3);

		Obj.seep(contianer,3);
		assertArrayEquals(contianer,grid4);     


	}

	@Test
	void testPercolate() {
		int[][] grid0 =
			{
					{ 1, 0, 0, 1}, {1, 0, 1, 1}, {1,0,0,0},
					{ 0, 0, 1, 1}
			}; // Initial grid 


		Obj.seep(grid0,0);
		boolean objTest1=Obj.percolate(grid0);         //   first row
		assertFalse(objTest1);

		Obj.seep(grid0,1);
		boolean objTest2=Obj.percolate(grid0);          // second row 
		assertFalse(objTest2);

		Obj.seep(grid0,2);
		boolean objTest3=Obj.percolate(grid0);          // third row
		assertFalse(objTest3);

		Obj.seep(grid0,3);
		boolean objTest4=Obj.percolate(grid0);     // last fourth row 
		assertTrue(objTest4);


	}


}
