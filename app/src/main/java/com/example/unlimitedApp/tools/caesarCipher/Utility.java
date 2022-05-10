package com.example.unlimitedApp.tools.caesarCipher;

public class Utility {
    private static String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int index;
    private static int update_index;
    private static int final_index;
    private static int index_p_t_l;
    private static int index_s_t_l;
    private static String plaintxt;
    private static String ciphertxt;
    private static String finaltext;


    public static  String encrypt1(String plaintxt, int encryptionKey){
        reset();
        plaintxt=plaintxt.toUpperCase();
        for (index = 0;index<plaintxt.length();index++){
            if (plaintxt.charAt(index)!=' '){
                index_p_t_l =alphabet.indexOf(plaintxt.charAt(index));
                update_index=encryptionKey+alphabet.indexOf(plaintxt.charAt(index));
                if (update_index>=alphabet.length()){
                    final_index=update_index-alphabet.length();
                }
                else {
                    final_index =update_index;
                }
                ciphertxt =alphabet.substring(final_index,final_index+1);
                finaltext=finaltext+ciphertxt;
            }
        }
        return finaltext;
    }
    public static String decrypt1(String cipherTxt,int decryptionKey){
        reset();
        cipherTxt=cipherTxt.toUpperCase();
        for(index=0;index<cipherTxt.length();index++){
            if (cipherTxt.charAt(index)!=' '){
                index_p_t_l =alphabet.indexOf(cipherTxt.charAt(index));
                index_s_t_l =index_p_t_l;
                update_index=alphabet.indexOf(cipherTxt.charAt(index))-decryptionKey;
                if(update_index<0) {
                    final_index = update_index + alphabet.length();
                }
                else{
                    final_index=update_index;
                }
                plaintxt=alphabet.substring(final_index,final_index+1);
                finaltext+=plaintxt;
            }
        }
        return finaltext;
    }
    private static void reset() {
        finaltext="";
    }
}
