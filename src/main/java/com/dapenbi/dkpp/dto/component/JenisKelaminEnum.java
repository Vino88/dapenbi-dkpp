package com.dapenbi.dkpp.dto.component;
/**
 * @author amatmiftakhudin
 * P = Laki-Laki
 * W = Perempuan
 * */
public class JenisKelaminEnum {
    public static enum Gender {
        P,
        W
    }

    public static String getText(String gender) {
        return gender.equals("P") ? "Pria" : "Wanita";
    }
}
