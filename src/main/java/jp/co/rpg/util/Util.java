package jp.co.rpg.util;

import java.security.MessageDigest;

public class Util {


	//文字列がNULLまたは空文字の場合はTrueを返す
    public static boolean isNullOrEmpty(Object object) {
    	if(object instanceof Integer) {
			if(object != null) {
				return false;
			}
		}else if(object instanceof String) {
			if((object != null) && (!("".equals(object)))) {
				return false;
			}
		}
    	return true;
    }

    //文字列がInteger型に変換可能なときはTrueを返す
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    //文字列をInteger型に変換して返す、変換できないときはNULLを返す
    public static Integer checkAndParseInt(String str) {
        if (isNumber(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }


    //ハッシュ化
    public static String hash(String rawPass) {
          byte[] cipher_byte;
          try{
                  MessageDigest md = MessageDigest.getInstance("SHA-256");
                  md.update(rawPass.getBytes());
                  cipher_byte = md.digest();
                  StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
                  for(byte b: cipher_byte) {
                          sb.append(String.format("%02x", b&0xff) );
                  }
                  return sb.toString();
          } catch (Exception e) {
                  e.printStackTrace();
                  return "";
          }
    }
}
