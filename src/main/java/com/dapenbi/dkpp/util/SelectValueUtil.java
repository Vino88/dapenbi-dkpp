package com.dapenbi.dkpp.util;

import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.dto.component.Select2Default;

import java.util.ArrayList;
import java.util.List;

public class SelectValueUtil {
    public static List<Select2Default> createGenderSelect() {
        List<Select2Default> gender = new ArrayList<>();
        gender.add(new Select2Default(JenisKelaminEnum.Gender.P.name(), "Pria") );
        gender.add(new Select2Default(JenisKelaminEnum.Gender.W.name(), "Wanita") );

        return gender;
    }
}
