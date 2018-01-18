package models;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public static String Encrypt(String recipe, String privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        byte[] toEncryptRecipe = recipe.getBytes() ;

        byte[] input = Base64.decodeBase64(privateKey);
        SecretKeySpec keySpec = new SecretKeySpec(input, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return Base64.encodeBase64String(cipher.doFinal(toEncryptRecipe));
    }

    public static String Decrypt(String encryptedRecipe, String privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] toDecryptRecipe = encryptedRecipe.getBytes();
        byte[] input = Base64.decodeBase64(privateKey);
        SecretKeySpec keySpec = new SecretKeySpec(input, "AES");
        toDecryptRecipe = Base64.decodeBase64(encryptedRecipe);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        String decryptedRecipe = new String( cipher.doFinal(toDecryptRecipe));
        return decryptedRecipe;
    }
}
