package be.mil.logchain.util;

import java.security.MessageDigest;

/**
 * A class with a hashing method.
 * 
 * @author stevenbeeckman
 *
 */
public class HashUtil {
	
	/**
	 * Returns the SHA-256 hash of a given input String
	 * 
	 * @param input String
	 * @return SHA-256 hash of input
	 */
	public static String hashSha256(String input) {
	
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexHash = new StringBuffer();
			for(int i = 0; i < hashBytes.length; i++) {
				String hex = Integer.toHexString(0xff & hashBytes[i]);
				if(hex.length() == 1) {
					hexHash.append('0');
				}
				hexHash.append(hex);
			}
			return hexHash.toString();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
