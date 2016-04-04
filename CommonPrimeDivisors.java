/*
	Solution to Codility's Euclidean Algorithm Lesson: Common Prime Divisors Task
	Run Time O(Z*log(max(A)+max(B))^2)
*/

class Solution
{
    public int solution(int [] A, int [] B)
    {
        int Z = A.length; //Length of Array
        int cpd = 0; //Count of Common Prime Divisors
        
        for (int K=0; K<Z; K++) //Loop Through Elements of Array
			if (samePD(A[K], B[K])) cpd++; //If Numbers Contain Same Prime Divisors, Increment Count
        
        return cpd; //Return Count of Common Prime Divisors
    }
    
    int gcd(int a, int b, int res) //Get Greatest Common Denominator Using Binary Euclidean Algorithm
    {
        if (a==b) return res*a; //a=b, a Now Equals b, Product of res and a is GCD
        else if ((a&1)==0 && (b&1)==0) return gcd(a>>1, b>>1, res<<1); //a and b are Even, Get Next CD By Halving Them, and Doubling res 
        else if ((a&1)==0) return gcd(a>>1, b, res); //Only a is Even, Get Next CD by Halving a
        else if ((b&1)==0) return gcd(a, b>>1, res); //Only b is Even, Get Next CD by Halving b
        else if (a>b) return gcd(a-b, b, res); //a is Greater, Get Next CD by Subtraction
        else return gcd(a, b-a, res); //b is Greater, Get Next CD by Subtraction
    }
	
	boolean samePD(int N, int M) //Do Integers Contain Same Prime Divisors
	{
		int cd = gcd(N, M, 1); //Get GCD of Integers
		N = leastCPD(N, cd); //Find Least CPD of N and GCD
		if (N!=1) return false; //If Not 1, Not Same Prime Divisors
		M = leastCPD(M, cd); //Find Least CPD of = N and GCD
 
		return (M==1); //If 1, Same Prime Divisors, Else Not
	}
	
	int leastCPD(int x, int y) //Get Least Common Prime Divisor
	{
		int cd = gcd(x, y, 1); //Get GCD of Integers
		
		while (x>1 && cd>1) //Loop Till At Least CPD
		{
			x /= cd; //Divide Integer By GCD
			cd = gcd(x, y, 1); //Get GCD of Integers
		}
		
		return x; //Return Least Common Prime Divisor
	}
}