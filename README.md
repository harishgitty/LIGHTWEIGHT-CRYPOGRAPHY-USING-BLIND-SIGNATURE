# LIGHTWEIGHT-CRYPOGRAPHY-USING-BLIND-SIGNATURE
LIGHTWEIGHT CRYPOGRAPHY USING BLIND SIGNATURE AND AUTHENTICATION

# Architecture
![image](https://user-images.githubusercontent.com/101494813/159125474-206c2854-408a-4005-9316-d4be6557d877.png)

# ALGORITHM

• For each user, there is a key pair, which consists of a secret key x, and a 
public key y where,
P is primitive root of the prime number;
BLIND FACTOR: y = p^ x mod n.</br>
• The public key y is published in a public file and known to everybody 
while the secret key x is kept secret.</br>
• Let m, be a document to be signed, where: 0< m < n -1 and p is a prime.</br>
• The public file consists of the public key y = p^ x mod n for each user.</br>
• To sign a document, a user A uses the secret key X to compute a 
signature for, m so that any user can verify that this message has been 
signed by A, using the public key p together with n and p.</br>

# KEY GENERATION:

• No one can forge a signature without knowing the secret xA.</br>
• The signature for, m is a pair (r, s), where 0 < r, s c>n- 1, chosen such that 
BLINDED MESSAGE: BM = y^ r x r^ s mod n.</br>
• The following three steps are done to compute the signature: </br>
• Choose a random number k, uniformly distributed between 0 and n - 1, 
such that: can be written as gcd (k, n - 1) =1.

## SIGN GENERATION:

Compute SG = p^ k mod n,

## SIGN VERIFICATION:

SV=M^ x*sg x M1^k*s mod n

## NUMERICAL INSTANCE:

• PRIME NUMBER n=19
• MESSAGE=14
• RANDOM X=13
• R=2(0<r<n-1)
• S=3(0<s<n-1)

Primitive root of the prime number(n) 19= p (2)

## BLIND FACTOR:

y = p^ x mod n.
 y=2^13 mod 19
 y=3
 

## Blinded Message:

BM = y^ r x r^ s mod n.
 =3^2 x 2^3 mod 19
 = 15

gcd (k, n - 1) =1
We find gcd(k,n-1)=1
We get 17 as k value.


## Sign Generation:
Compute SG = p^ k mod n, 
=2^17 mod 19
=10


## Sign Verification:

SV1=M^ x*sg mod n =14^13*10 mod 19=17
 Sv2= M1^k*s mod n=14^17*3 mod 19=12
 Sv3= sv1*sv2 mod n
 =17 x 12 mod 19
 =204 mod 19
 =14
 
 ## We get the original message as the sign verification

