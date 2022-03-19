import java.io.*;
import java.util.*;
import java.math.*;

public class Rev2
{
 
    // Returns true if n is prime
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
        {
            return false;
        }
        if (n <= 3)
        {
            return true;
        }
 
        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
        {
            return false;
        }
 
        for (int i = 5; i * i <= n; i = i + 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
            {
                return false;
            }
        }
 
        return true;
    }
 
    
    // Utility function to store prime factors of a number
    static void findPrimefactors(HashSet<Integer> s, int n)
    {
        // Print the number of 2s that divide n
        while (n % 2 == 0)
        {
            s.add(2);
            n = n / 2;
        }
 
        // n must be odd at this point. So we can skip
        // one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i = i + 2)
        {
            // While i divides n, print i and divide n
            while (n % i == 0)
            {
                s.add(i);
                n = n / i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
        {
            s.add(n);
        }
    }
 
    // Function to find smallest primitive root of n
    static int findPrimitive(int n)
    {
        HashSet<Integer> s = new HashSet<Integer>();
 
        // Check if n is prime or not
        if (isPrime(n) == false)
        {
            return -1;
        }
 
        // Find value of Euler Totient function of n
        // Since n is a prime number, the value of Euler
        // Totient function is n-1 as there are n-1
        // relatively prime numbers.
        int phi = n - 1;
 
        // Find prime factors of phi and store in a set
        findPrimefactors(s, phi);
 
        // Check for every number from 2 to phi
        for (int r = 2; r <= phi; r++)
        {
            // Iterate through all prime factors of phi.
            // and check if we found a power with value 1
            boolean flag = false;
            for (Integer a : s)
            {
 
                // Check if r^((phi)/primefactors) mod n
                // is 1 or not
                if (power(r, phi / (a), n) == 1)
                {
                    flag = true;
                    break;
                }
            }
 
            // If there was no power with value 1.
            if (flag == false)
            {
                return r;
            }
        }
 
        // If no primitive root found
        return -1;
    }
    static int calmodInv(int a, int b) 
    { 
      a = a % b; 
      for (int x = 1; x < b; x++) 
      if ((a * x) % b ==1) 
        return x; 
      return 1; 
    } 
    
 /* Iterative Function to calculate (x^y) in O(log y) */
 static int power(int h1, int h2, int h3)
 {
   int res = 1; // Initialize result

   h1 = h1 % h3; // Update x if it is more than or
   // equal to p

   if (h1 == 0)
     return 0; // In case x is divisible by p;

   while (h2 > 0)
   {

     // If y is odd, multiply x with result
     if ((h2 & 1) != 0)
       res = (res * h1) % h3;

     // y must be even now
     h2 = h2 >> 1; // y = y/2
     h1 = (h1 * h1) % h3;
   }
   return res;
 }
  public static void main(String[]args) {
    System.out.println(" ");
    Scanner sc = new Scanner(System.in);
    System.out.println(" KEY GENERATION:");
    System.out.println(" ");
    System.out.println("---------------------------------------------");
    System.out.println(" Key Generation:");
    System.out.println("---------------------------------------------");
    System.out.println(" ");
    System.out.print("Enter the prime number:");
    int n=sc.nextInt();
    System.out.println("Smallest primitive root of " + n+ " is : " + findPrimitive(n));
    int p=findPrimitive(n);
    System.out.print("Enter the Message :");
    int sh=sc.nextInt();
    System.out.println("Enter the random number X : ");
    int x=sc.nextInt();
    System.out.println("Random Number is:"+x);
    int powerOfNumber = (int) Math.pow(p, x);
    int e=powerOfNumber % n;
    System.out.println("---------------------------------------------");
    System.out.println("BLIND FACTOR :"+e);
    System.out.println(" ");

    System.out.println("---------------------------------------------");
    System.out.println(" ");
    System.out.println("Random R between 0<r>P-1 : ");
    int r=sc.nextInt();
    System.out.println("Random S between 0<s>P-1 : ");
    int s=sc.nextInt();
    int power1=(int) Math.pow(e,r);
    int power2=(int) Math.pow(r,s);
    int bm=power1*power2 % n;
    System.out.println("---------------------------------------------");
    System.out.println(" ");

    System.out.print("BLINDED MESSAGE :"+bm);
    System.out.println(" ");

    System.out.println("---------------------------------------------");
    System.out.println(" ");
    
    int ok=n-1;
   System.out.println("P-1 :"+ok);
   System.out.print("Enter the random k:");
    int k=ok-1;
    System.out.println("K MUST BE GCD (K,P-1 = 1)");
    System.out.println("Random Number K is:"+k);

    System.out.println(" ");
    System.out.println("---------------------------------------------");
    int power3=(int) Math.pow(p,k);
    int sg=power3 % n;
    System.out.println("SIGN GENERATION :"+sg );
    System.out.println(" ");
    System.out.println("---------------------------------------------");
    int l1=power(sh,x*sg,n);

    int l2=power(sh,k*s,n);
  
    int l3=(l1*l2) % n;
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(" ");

    System.out.println("---------------------------------------------");

   System.out.println("SIGN VERIFICATION :"+l3);
   System.out.println(" ");

   System.out.println("---------------------------------------------");


    
  }
}

