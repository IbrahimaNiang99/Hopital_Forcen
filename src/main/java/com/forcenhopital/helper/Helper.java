package com.forcenhopital.helper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Helper {

    // CONTROLE TELEPHONE
    public static boolean isValidSenegalPhoneNumber(String phoneNumber) {
        // Formats valides : +221 suivi de 9 chiffres, ou le format local
        String regex1 = "(7[0678]|77|76|78|75)\\d{7}";
        String regex2 = "(77|78|76|70|75) \\d{3} \\d{2} \\d{2}";

        // Créer le pattern et le matcher pour la regex
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        return matcher1.matches() || matcher2.matches();
    }

    // CONTROLE EMAIL
    public static boolean isValidEmail(String email) {
        // Expression régulière pour vérifier le format de l'e-mail
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Créer le pattern et le matcher pour la regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Tester control teplephone
        /*String msg = " est un numéro de téléphone du Sénégal valide : ";

        String phoneNumber1 = "777865394"; // Exemple de numéro sénégalais valide
        String phoneNumber2 = "783254760"; // Exemple de numéro sénégalais valide
        String phoneNumber3 = "70 325 47 60";      // Exemple de numéro sénégalais valide
        String phoneNumber4 = "301234567";      // Exemple de numéro sénégalais invalide
        String phoneNumber5 = "753254760";      // Exemple de numéro sénégalais invalide

        System.out.println(phoneNumber1 + msg + isValidSenegalPhoneNumber(phoneNumber1));
        System.out.println(phoneNumber2 + msg + isValidSenegalPhoneNumber(phoneNumber2));
        System.out.println(phoneNumber3 + msg + isValidSenegalPhoneNumber(phoneNumber3));
        System.out.println(phoneNumber4 + msg + isValidSenegalPhoneNumber(phoneNumber4));
        System.out.println(phoneNumber5 + msg + isValidSenegalPhoneNumber(phoneNumber5));*/

        // tester control email
        /*String email1 = "john@example.com";     // Exemple d'e-mail valide
        String email2 = "invalid_email";       // Exemple d'e-mail invalide

        System.out.println(email1 + " est un e-mail valide : " + isValidEmail(email1));
        System.out.println(email2 + " est un e-mail valide : " + isValidEmail(email2));*/
    }

}
