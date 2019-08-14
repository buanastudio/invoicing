/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipaymentdua;

/**
 *
 * @author iozyo
 */
public class Session {
    private static String username;
    private static String hakakses;
    private static String app_number;
    
    public static void setUserLogin(String username){
        Session.username = username;
    }
    
    public static String getUserLogin(){
        return username;
    }
    
    public static void setHakAkses(String hakakses){
        Session.hakakses = hakakses;
    }
    
    public static String getHakAkses(){
        return hakakses;
    }

    public static String getApp_number() {
        return app_number;
    }

    public static void setApp_number(String app_number) {
        Session.app_number = app_number;
    }
    
    
}
