package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.SuskelDao;
import com.dapenbi.dkpp.dto.SuskelDto;
import com.dapenbi.dkpp.dto.component.JenisKelaminEnum;
import com.dapenbi.dkpp.form.KeluargaPesertaFormDto;
import com.dapenbi.dkpp.form.PesertaFormDto;
import com.dapenbi.dkpp.model.Suskel;
import com.dapenbi.dkpp.repository.SuskelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuskelDaoImpl extends BaseDaoImpl<Suskel, SuskelDto, Long> implements SuskelDao {
    private SuskelRepository suskelRepository;

    @Autowired
    public SuskelDaoImpl(SuskelRepository suskelRepository) {
        super(suskelRepository);
        this.suskelRepository = suskelRepository;
    }

    @Override
    public Suskel generateSuskel(PesertaFormDto pesertaFormDto, List<KeluargaPesertaFormDto> keluargaPesertaDtoList) throws Exception {
        String searchKriteria = "";
        if (keluargaPesertaDtoList.size() == 0 && pesertaFormDto.getTglWafat() == null) {
            searchKriteria = "SENDIRI";
        } else if (keluargaPesertaDtoList.size() > 0) {
            Boolean haveParent = true;
            List<Long> childCategory = Arrays.asList(
                3L,
                4L,
                5L,
                6L,
                7L,
                8L,
                9L,
                10L,
                12L,
                13L,
                14L
            );
            List<Long> spouseCategory = Arrays.asList(
                2L,
                20L
            );
            List<KeluargaPesertaFormDto> child = keluargaPesertaDtoList.stream().filter(k -> childCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalUsia25().after(new Date()) && k.getTanggalWafat() == null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spouse = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima())&& k.getTanggalCerai() == null && k.getTanggalWafat() == null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spouseDivorced = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalCerai() != null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spousePassed = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalWafat() != null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> heirs = keluargaPesertaDtoList.stream().filter(k -> k.getIdKategoriPenerima().equals(11L)).collect(Collectors.toList());
            String jenisKelamin = pesertaFormDto.getJenisKelamin().toString();

            if (child.size() > 0 && (spouse.size() == 0 && spousePassed.size() == 0 && spouseDivorced.size() == 0)) {
                throw new Exception("Suami/Istri harus ada jika terdapat anak pada data keluarga");
            }

            if (heirs.size() > 0) {
                return null;
            }

            if (pesertaFormDto.getTglWafat() == null) {
                if (spouse.size() > 0) {
                    if (jenisKelamin.equals(JenisKelaminEnum.Gender.P.name())) {
                        searchKriteria = "ISTRI";
                    } else {
                        searchKriteria = "SUAMI";
                    }
                } else {
                    if (spouseDivorced.size() > 0 || spousePassed.size() > 0) {
                        if (jenisKelamin.equals(JenisKelaminEnum.Gender.P.name())) {
                            searchKriteria = "DUDA";
                        } else {
                            searchKriteria = "JANDA";
                        }
                    }
                }
            } else {
                if (spouse.size() > 0) {
                    if (jenisKelamin.equals(JenisKelaminEnum.Gender.P.name())) {
                        searchKriteria = "JANDA";
                    } else {
                        searchKriteria = "DUDA";
                    }
                } else {
                    haveParent = false;
                }
            }

            if (haveParent) {
                searchKriteria = String.format("%s, %d ANAK", searchKriteria, child.size());
            } else {
                if (child.size() == 1) {
                    searchKriteria = "YATIM, SENDIRI";
                } else {
                    searchKriteria = String.format("%s YATIM", child.size());
                }
            }
        } else {
            return null;
        }
        return suskelRepository.findFirstByNamaSuskel(searchKriteria);
    }

    @Override
    public Suskel generateSuskel(PesertaFormDto pesertaFormDto, List<KeluargaPesertaFormDto> keluargaPesertaDtoList, String jenisMutasi) throws Exception {
        String searchKriteria = "";
        if (keluargaPesertaDtoList.size() == 0 && pesertaFormDto.getTglWafat() == null) {
            searchKriteria = "SENDIRI";
        } else if (keluargaPesertaDtoList.size() > 0) {
            Boolean haveParent = true;
            List<Long> childCategory = Arrays.asList(
                    3L,
                    4L,
                    5L,
                    6L,
                    7L,
                    8L,
                    9L,
                    10L,
                    12L,
                    13L,
                    14L
            );
            List<Long> spouseCategory = Arrays.asList(
                    2L,
                    20L
            );
            List<KeluargaPesertaFormDto> child = keluargaPesertaDtoList.stream().filter(k -> childCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalUsia25().after(new Date()) && k.getTanggalWafat() == null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spouse = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima())&& k.getTanggalCerai() == null && k.getTanggalWafat() == null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spouseDivorced = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalCerai() != null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> spousePassed = keluargaPesertaDtoList.stream().filter(k -> spouseCategory.contains(k.getIdKategoriPenerima()) && k.getTanggalWafat() != null).collect(Collectors.toList());
            List<KeluargaPesertaFormDto> heirs = keluargaPesertaDtoList.stream().filter(k -> k.getIdKategoriPenerima().equals(11L)).collect(Collectors.toList());
            String jenisKelamin = pesertaFormDto.getJenisKelamin().toString();

            if (child.size() > 0 && (spouse.size() == 0 && spousePassed.size() == 0 && spouseDivorced.size() == 0)) {
                throw new Exception("Suami/Istri harus ada jika terdapat anak pada data keluarga");
            }

            if (heirs.size() > 0) {
                return null;
            }

            if(jenisMutasi.equals("MENIKAH"))
                haveParent = false;

            if (haveParent) {
                searchKriteria = String.format("%s, %d ANAK", searchKriteria, child.size());
            } else {
                if (child.size() == 1) {
                    searchKriteria = "YATIM, SENDIRI";
                } else {
                    searchKriteria = String.format("%s YATIM", child.size());
                }
            }
        } else {
            return null;
        }
        return suskelRepository.findFirstByNamaSuskel(searchKriteria);
    }
}
