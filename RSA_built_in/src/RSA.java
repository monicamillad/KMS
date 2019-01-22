import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
	
	public static KeyPair buildKeyPair() throws NoSuchAlgorithmException{
		
		final int keySize = 2048 ;
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA") ;
		kpg.initialize(keySize) ;
		
		
		return kpg.generateKeyPair() ;
	}

	public static byte[] encrypte( PublicKey pk , String data ) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		Cipher cipher = Cipher.getInstance("RSA") ;
		cipher.init(Cipher.ENCRYPT_MODE, pk);
		
		return cipher.doFinal(data.getBytes()) ;
	}
	
	public static byte[] decrypte( PrivateKey pk , byte[] encryptedData ) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		Cipher cipher = Cipher.getInstance("RSA") ;
		cipher.init(Cipher.DECRYPT_MODE, pk);
		
		return cipher.doFinal(encryptedData) ;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		
		KeyPair kp = buildKeyPair() ;
		
		PublicKey publick = kp.getPublic() ;
		PrivateKey privatek = kp.getPrivate() ;
		
		String data = "secret data" ;
		
		byte[] encrypted = encrypte(publick, data) ;
		
		System.out.println("Encrypted: " + new String(encrypted));
		
		byte[] decrypted = decrypte(privatek, encrypted) ;
		
		String finalData = new String(decrypted) ;
		
		System.out.println("Decrypted: " + finalData);
	}

}
