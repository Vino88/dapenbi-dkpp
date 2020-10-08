package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.ProyeksiDto;
import com.dapenbi.dkpp.model.Proyeksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Map;

public interface ProyeksiDao extends BaseDao<Proyeksi, ProyeksiDto, Long> {

    Map processMasterProyeksi(
            String parCompName,
            String parUserName,
            Long parIdProyeksi,
            Date parTglInput,
            Long parJmlThnProyeksi,
            String parBatasGolIIV,
            String parBatasGolVII,
            Long parJmlSimulasi,
            Long parIdJenisKenaikanMp,
            Long parPersentaseKenaikanMp1,
            Long parPersentaseKenaikanMp2,
            Long parPersentaseKenaikanMp3,
            Long parMinimalKenaikanMp1,
            Long parMinimalKenaikanMp2,
            Long parMinimalKenaikanMp3,
            Long parPersentaseKenaikanPhdp,
            Long parPersentaseKenaikanPhdp2,
            Long parPersentaseKenaikanPhdp3,
            Character parAction,
            String parUserStamp
    );

    Map processProyeksiPensiunBaru(
            String parCompName,
            String parUserName,
            String parTahunProyeksi,
            Character parUntukProyeksi,
            String parUserStamp
    );

}