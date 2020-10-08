package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.SuskelDto;
import com.dapenbi.dkpp.form.KeluargaPesertaFormDto;
import com.dapenbi.dkpp.form.PesertaFormDto;
import com.dapenbi.dkpp.model.Suskel;

import java.util.List;

public interface SuskelDao extends BaseDao<Suskel, SuskelDto, Long> {
    Suskel generateSuskel(PesertaFormDto pesertaFormDto, List<KeluargaPesertaFormDto> keluargaPesertaDtoList) throws Exception;
    Suskel generateSuskel(PesertaFormDto pesertaFormDto, List<KeluargaPesertaFormDto> keluargaPesertaDtoList, String jenisMutasi) throws Exception;
}
