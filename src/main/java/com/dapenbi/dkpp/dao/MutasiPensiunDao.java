package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.KantorBayar;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MutasiPensiunDao extends BaseDao<MutasiPensiun, MutasiPensiunDto, Long> {
    MutasiPensiun findByNip(String nip);

    Map cufnHitungMps100(String nip,
                         String periodeMutasi);

    Map checkMps100PersenBaru(Date tglLahirPeserta, Date tglKerjaPeserta, Date tglHentiPeserta, Date tglAwalBayarMP, Date tglLahirPenerima, String idKategoryPensiun, BigDecimal phdp);

    Map checkMps100PersenTunda(String nip,
                               Date tglMutasi,
                               String periodeMutasi,
                               Date tglAwalBayarMP,
                               String idKategoryPensiun,
                               Boolean isJatuhTempoBayar,
                               Date tglMeninggalPeserta);

    Map mpSimulation(Date tglLahirPeserta,
                     Date tglKerjaPeserta,
                     Date tglHentiPeserta,
                     Date tglDPHTPeserta,
                     Long idKategoriPenerima,
                     Date tglLahirPenerima,
                     Date tglAwalBayarMP,
                     String idKatergoryPensiun,
                     Long idJenisMPS,
                     Long idStatusKawin,
                     Long idUsiaBayar,
                     BigDecimal phdp,
                     Date tglMutasi,
                     String periodeMutasi);

    Map genSukselanakOtomatis(
            String Nip,
            String IdPenerimaMPBaru,
            Date TglAwalBayar,
            Date TglAwalBayarbefore,
            Date tglLahirPenerima,
            Integer TypeSukel,
            Integer TypeMutasiOtomatis);

    Map mpWafatSimulation(String nip, String periodeMutasi, String tglMeninggal, Long idStatusBayar);

    Page <MutasiPensiun> findMutasiPensiunBaru(String searchParam, Pageable pageable);

    Page <MutasiPensiun> findMutasiPensiunBaruBelumValidasi(String searchParam, Pageable pageable);

    Page <MutasiPensiun> findByKategoriMutasi(String idKategoriMutasi, String searchParam, Pageable pageable);

    Page <MutasiPensiun> findByKategoriMutasiAndPeriodeMutasi(String idKategoriMutasi, String periodeMutasi,String searchParam, Pageable pageable);

    Page <MutasiPensiun> findByKategoriMutasiAndPeriodeMutasiBelumValidasi(String idKategoriMutasi, String periodeMutasi,String searchParam, Pageable pageable);

    Map processMutasiPensiunBaru(Long role,
                                 String compName,
                                 String userName,
                                 Long idMutasi,
                                 String kodeMutasi,
                                 String kategoriMutasi,
                                 String periodeMutasi,
                                 Date tglMutasi,
                                 String nip,
                                 String namaPeserta,
                                 Character jenisKelaminPeserta,
                                 Date tglLahirPeserta,
                                 Date tglKerjaPeserta,
                                 Date tglDPHTPeserta,
                                 Date tglHentiPeserta,
                                 String tempatMeninggalPeserta,
                                 Date tglMeninggalPeserta,
                                 String tempatLahirPeserta,
                                 Long golongan,
                                 String golonganPangkat,
                                 Long agama,
                                 String namaAgama,
                                 String kantorBayar,
                                 String namaKantorBayar,
                                 Long predikat,
                                 String namaPredikat,
                                 String alasanHenti,
                                 String keteranganHenti,
                                 Date tglSPBI,
                                 String noSPBI,
                                 Date tglSKBI,
                                 String noSKBI,
                                 BigDecimal phdpLama,
                                 BigDecimal upahVeteran,
                                 Long jenisMPS,
                                 String namaMPS,
                                 String kategoriPensiun,
                                 String namaKategoriPensiun,
                                 Long usiaBayar,
                                 String namaUsiaBayar,
                                 Long statusBayar,
                                 String namaStatusBayar,
                                 Long statusKawin,
                                 String namaStatusKawin,
                                 Date tglTundaJatuhTempo,
                                 Date tglAwalBayar,
                                 Date tglMPBulanKe13,
                                 Date tglHentiBayar,
                                 String idPenerimaMP,
                                 String namaPenerimaMP,
                                 Date tglLahirPenerimaMP,
                                 String jenisKelaminPenerimaMP,
                                 Long kategoriPenerimaMP,
                                 String namaKategoriPenerimaMP,
                                 Date tglSKDapenbi,
                                 String noSKDapenbi,
                                 Date tglUsia25TPenerimaMP,
                                 Boolean alamatIsDalamNegeri,
                                 Long provinsi,
                                 String namaProvinsi,
                                 Long kota,
                                 String namaKota,
                                 Long kecamatan,
                                 String namaKecamatan,
                                 Long kelurahan,
                                 String namaKelurahan,
                                 String kodePos,
                                 String alamaLengkap,
                                 String rt,
                                 String rw,
                                 Long negera,
                                 String namaNegara,
                                 Long suskel,
                                 String namaSuskel,
                                 Long kategoriCatatan,
                                 String namaKategoriCatatan,
                                 Long statusKawinPenerimaMP,
                                 String namaStatusKawinPenerimaMP,
                                 String noHP,
                                 String noTlp,
                                 String email,
                                 Long validasi,
                                 String namaValidasi,
                                 String userStamp,
                                 String userValidasi,
                                 String keterangan);

    Map processMutasiPensiunTunda(Long roleId,
                                  String compName,
                                  String userName,
                                  Long idMutasi,
                                  String kodeMutasi,
                                  String idKategoriMutasi,
                                  String periodeMutasi,
                                  Date tglMutasi,
                                  String nip,
                                  String namaPeserta,
                                  String jenisKelaminPeserta,
                                  Date tglLahirPeserta,
                                  Date tglKerjaPeserta,
                                  Date tglDpthtPeserta,
                                  Date tglHentiKerjaPeserta,
                                  String tempatMeninggalPeserta,
                                  Date tglMeninggalPeserta,
                                  String tempatLahirPeserta,
                                  Long idGolongan,
                                  String golonganPangkat,
                                  Long idAgama,
                                  String namaAgama,
                                  String idKantorBayar,
                                  String namaKantorBayar,
                                  Long idPredikat,
                                  String namaPredikat,
                                  String idHenti,
                                  String keteranganHenti,
                                  Date tglSpBi,
                                  String noSpBi,
                                  Date tglSkBi,
                                  String noSkBi,
                                  BigDecimal phdpLama,
                                  BigDecimal upahVeteran,
                                  Long idJenisMps,
                                  String namaMps,
                                  String idKategoriPensiun,
                                  String namaKategoriPensiun,
                                  Long idUsiaBayar,
                                  String namaUsiaBayar,
                                  Long idStatusBayar,
                                  String statusBayar,
                                  Long idStatusKawin,
                                  String namaStatusKawin,
                                  Date tglTundaJatuhTempo,
                                  Date tglAwalBayar,
                                  Date tglMpBulanKe13,
                                  Date tglHentiBayar,
                                  String idPenerimaMp,
                                  String namaPenerimaMp,
                                  Date tglLahirPenerimaMp,
                                  String jenisKelaminPenerimaMp,
                                  Long idKategoriPenerimaMp,
                                  String namaKategoriPenerimaMp,
                                  Date tglSkDapenbi,
                                  String noSkDapenbi,
                                  Date tglUsia25TPenerimaMp,
                                  Boolean alamatIsDalamNegeri,
                                  Long idProvinsi,
                                  String namaProvinsi,
                                  Long idKotaKab,
                                  String namaKotaKab,
                                  Long idKecamatan,
                                  String namaKecamatan,
                                  Long idKelurahan,
                                  String namaKelurahan,
                                  String kodePos,
                                  String alamatLengkap,
                                  String rt,
                                  String rw,
                                  Long idNegara,
                                  String namaNegara,
                                  Long idSuskel,
                                  String namaSuskel,
                                  Long idKategoriCatatan,
                                  String namaCatatan,
                                  Long idKawinPenerimaMp,
                                  String namaKawinPenerimaMp,
                                  String noHp,
                                  String noTlp,
                                  String email,
                                  Long idValidasi,
                                  String namaValidasi,
                                  String userStamp,
                                  String userValidasi,
                                  String keterangan,
                                  Long idAlasanMps100,
                                  String namaAlasanMps100);

    Map processMutasiMpMeninggalDunia(
            Long roleId,
            String compName,
            String userName,
            Long idMutas,
            String kodeMutasi,
            String periodeMutasi,
            Date tglMutasi,
            String nip,
            String namaPesertaUpdate,
            Long idAgamaUpdate,
            String namaAgamaUpdate,
            Long idGolonganUpdate,
            String namaGolonganUpdate,
            BigDecimal phdp,
            String idKantorBayarUpdate,
            String namaKantorBayarUpdate,
            Date tglSpBI,
            String noSpBI,
            Date tglSkBIUpdate,
            String noSkBIUpdate,
            Boolean alamatIsDalamNegeriUpdate,
            Long idProvinsiUpdate,
            String namaProvinsiUpdate,
            Long idKotaKabUpdate,
            String namaKotaKabUpdate,
            Long idKecamatanUpdate,
            String namaKecamatanUpdate,
            Long idKelurahanUpdate,
            String namaKelurahanUpdate,
            String kodePosUpdate,
            String alamatLengkapUpdate,
            String noHpUpdate,
            String noTlpUpdate,
            String emailUpdate,
            String rtUpdate,
            String rwUpdate,
            Long idNegaraUpdate,
            String namaNegaraUpdate,
            String idPenerimaMpLama,
            String namaPenerimaMpLama,
            Long idKategoriPenerimaMpLama,
            Date tglWftPenerimaMpLama,
            Date tglInfWftPenerimaMpLama,
            String idPenerimaMpBaru,
            String namaPeneirmaMpBaru,
            Long idKategoriPenerimaMpBaru,
            String namaKategoriPenerimaMpBaru,
            Character jkPenerimaMpBaru,
            Date tglLahirPenerimaMpBaru,
            Long idKawinPenerimaMpBaru,
            String namaKawinPenerimaMpbaru,
            Long idSuskelPenerimaMpBaru,
            String namaSuskelBaru,
            Date tglBulan13,
            BigDecimal lebihBayarNominal,
            BigDecimal lebihBayarBulan,
            BigDecimal lebihBayarNominal13,
            BigDecimal lebihBayarJmlBulan13,
            BigDecimal nominalTerbayar,
            BigDecimal saldoAkhirLebihBayar,
            Long idStatusBayarUpdate,
            String namaStatusBayarUpdate,
            Date tglHentiBayarUpdate,
            Long idKategoriCatatan,
            String namaKategoriCatatan,
            String Keterangan,
            Long idValidasi,
            String namaValidasi
    );

    Map processMutasiPerubahanNamaPenerimaMp(
            Long role
            , String compName
            , String userName
            , Long idMutasiPensiun
            , String kodeMutasi
            , String idKategoriMutasi
            , String periodeMutasi
            , Date tglMutasi
            , String nip
            , String namaPeserta
            , String idPenerimaMp
            , String namaPenerimaMp
            , Long idKategoriPenerimaMp
            , String namaKategoriPenerimaMp
            , Date tglLahirPenerimaMp
            , String jenis_kelaminPenerimaMp
            , String idPenerimaMpBaru
            , String namaPenerimaMpBaru
            , Long idKtgoriPenerimaMpBaru
            , String nmKtgoripenerimaMpBaru
            , Date tglLahirPenerimaMpBaru
            , String jkPenerimaMpBaru
            , Long idKategoriCatatan
            , String keterangan
            , String idValidasi
            , String namaValidasi
    );

    Map processMutasiKantorBayar(Long role, String compName, String userName, Long idMutasiPensiun, String kodeMutasi,
                                 String idKategoriMutasi, String periodeMutasi, Date tglMutasi, String nip, String namaPeserta,
                                 String idKantorBayar, String namaKantorBayar, String idKantorBayarBaru, String namaKantorBayarBaru,
                                 Long idKategoriCatatan, String keterangan, String idValidasi, String namaValidasi);

    Map cuspMutasiPerubahanPhdp(
            Long role,
            Long idMutasi,
            String compName,
            String userName,
            String nip,
            BigDecimal phdpBaru,
            Date tglBerlakuPhdpBaru,
            Date tglMutasi,
            String periodeMutasi,
            Long kategoriCatatan,
            String keteranganOtomatisUpdate,
            String keterangan,
            Long validasi,
            String namaValidasi
    );

    Map cuspMiSimulation(
            String nip,
            BigDecimal phDPBaru,
            String tglBerlakuPhDPBaru,
            String tglMutasi,
            String periodeMutasi
    );

    Page<MutasiPensiun> findAllMutasiPensiunTunda(String searchParam, Pageable pageable);

    Page<MutasiPensiun> findAllMutasiPensiunTundaBelumValidasi(String searchParam, Pageable pageable);

    Page<MutasiPensiun> findAllMutasiPensiunTundaDibayar(String searchParam, Pageable pageable);

    //List<MutasiPensiun> getListMutasiPenerimaMPMeninggal(String periodeMutasi);

    //Page<MutasiPensiun> findAllMutasiPensiunMeninggal(String periodeMutasi,String searchParam, Pageable pageable);

    Map cuspMutasiMps100(
            String compName
            , String userName
            , Long role
            , String periodeMutasi
            , Long idMutasi
            , Date tglMutasi
            , String nip
            , Date tglMohonMps100
            , Date tglBayarMps100
            , String usiaPenerimaBayar
            , String usiaPenerimaBayarBlt
            , Date tglHentiBayar
            , BigDecimal mps100
            , BigDecimal mps100Bulat
            , Long idAlasanMps100
            , String namaAlasanMps100
            , String idValidasi
            , String namaValidasi
            , Long idKategoriCatatan
            , String namaCatatan
            , String keterangan
            , Long idFaktorFs
            , String namaFaktorFs
            , String faktorFs
            , BigDecimal nilaiFaktorFs
    );

    Map spMutasiSuskel(MutasiSuskelFormDto mutasiSuskelFormDto);

    Map spMutasiSuskelDataKeluarga(MutasiSuskelDataKeluargaFormDto mutasiSuskelDataKeluargaFormDto);

    Map processMutasiPenerimaMpMeninggal(MutasiMeninggalSPFormDto spDto);
}

