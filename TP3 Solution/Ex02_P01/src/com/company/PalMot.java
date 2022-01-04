package com.company;

public class PalMot {
    public String inverse(String mot) {
        char[] mt = mot.toCharArray();
        String im = "";

        /* Premiére méthode avec String */
        for (int i = mt.length - 1; i >= 0; i--) {
            im += mt[i];
        }

        /* Deuxiéme méthode avec StringBuffer */
        StringBuffer imt = new StringBuffer();
        imt.append(mot);
        im = imt.reverse().toString();

        return im;
    }

    public boolean testpalidrome(String mot) {
        boolean bool = false;

        String inv = inverse(mot);
        if (inv.equals(mot)) {
            bool = true;
        }
        return bool;
    }


}
