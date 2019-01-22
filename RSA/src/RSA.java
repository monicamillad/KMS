import java.math.BigInteger;

public class RSA {
	
//	int gcd(int a, int b){
//		
//	    if( b!=0 ){
//	    	return gcd(b, a%b) ;
//	    }
//
//	    return a ;
//	}
//	
	
	BigInteger p = BigInteger.valueOf(53); 
	BigInteger q = BigInteger.valueOf(59);
		
	BigInteger n = p.multiply(q) ;
	
	BigInteger e = BigInteger.valueOf(3);
	
	BigInteger one = BigInteger.valueOf(1) ;
	BigInteger phi = p.subtract(one).multiply(q.subtract(one)) ;
	
	BigInteger k = BigInteger.valueOf(2) ;
	
	BigInteger d = k.multiply(phi).add(one).divide(e) ; //private key 
	
	public BigInteger encryption( BigInteger data ){
		System.out.println("d: " +d);
//		while( e<phi ){
//			
//			if( gcd((int)e,(int)phi)==1 ){
//				break ;
//			}
//			else{
//				e ++ ;
//			}
//		}
//		
//		System.out.println("e: " + e);
		
		BigInteger c = data.modPow(e , n) ;

		
		return c ;
	}
	
	public BigInteger decryption( BigInteger dec ){
		
		BigInteger data = dec.modPow(d , n) ;
		
		return data ;
	}

	public static void main(String[] args) {
		
		BigInteger data = BigInteger.valueOf(28) ;
		
		RSA rsa = new RSA() ;
		
		BigInteger c = rsa.encryption(data) ;
		
		System.out.println(c);
		System.out.println(rsa.decryption(c));

	}

}
