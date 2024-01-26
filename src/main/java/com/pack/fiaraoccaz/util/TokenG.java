package com.pack.fiaraoccaz.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import com.pack.fiaraoccaz.entity.User;

import java.security.MessageDigest;

public class TokenG {

    private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}
    
    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-1");
		byte[] sha1hash = new byte[40];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}

    public static String genererToken(User utilisateur) {
		try {
			String difference = "";
			if(utilisateur.getEtat()==10) difference = "admin_fiara_occaz";
			else if(utilisateur.getEtat()==5)difference = "front_office_fiara";
			String token = utilisateur.getIdUser() + utilisateur.getPassword() + utilisateur.getEtat() + LocalDate.now().toString() + difference;
			return SHA1(token);
		} catch (Exception e) {
			return "tsy mety";
		}
	}
}
