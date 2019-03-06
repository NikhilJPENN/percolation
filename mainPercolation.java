// Name: JAMDADE NIKHIL KAILAS    PENN ID: 56849791

package percolation;

    
    
public class mainPercolation {

	public static void main(String[] args) {
		
		   percolation obj;

	        obj = new percolation();
		
		
			double p1,p2,p3;
			
			p1=obj.findProbability(50);
			System.out.println("Probability for 50x50 grid"+" "+(1-p1));    
			
			System.out.println("\n");    
			
			
			p2=obj.findProbability(100);
			System.out.println("Probability for 100x100 grid"+" "+(1-p2));  
			
			System.out.println("\n"); 
			
			p3=obj.findProbability(200);
			System.out.println("Probability for 200x200 grid"+" "+(1-p3));  
		
			System.out.println("\n\n"); 
			System.out.println("Probability for 50x50 grid"+" "+(1-p1));    
			System.out.println("Probability for 100x100 grid"+" "+(1-p2));  
			System.out.println("Probability for 200x200 grid"+" "+(1-p3));
			
		
	}

}
