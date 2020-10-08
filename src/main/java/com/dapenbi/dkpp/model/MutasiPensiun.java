package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.MutasiPensiunDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_T_MUTASI_PENSIUN")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.processMutasiPensiun",
                procedureName = "CUSP_MUTASI_PENSIUN_BARU",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_KELAMIN_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_KERJA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_DPTHT_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HENTI_KERJA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_MENINGGAL_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MENINGGAL_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_LAHIR_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_GOLONGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_GOLONGAN_PANGKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_AGAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_AGAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PREDIKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PREDIKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_HENTI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN_HENTI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SP_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SP_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SK_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SK_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_PHDP_LAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_UPAH_VETERAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_JENIS_MPS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_MPS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_USIA_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_USIA_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_STATUS_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_STATUS_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_STATUS_KAWIN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_STATUS_KAWIN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_TUNDA_JATUH_TEMPO"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_AWAL_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MP_BULAN_KE13"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HENTI_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_KELAMIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SK_DAPENBI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SK_DAPENBI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_USIA25T_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Boolean.class, name = "PAR_ALAMAT_IS_DALAM_NEGERI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PROVINSI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PROVINSI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KOTA_KAB"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KOTA_KAB"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KECAMATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KECAMATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KELURAHAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KELURAHAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_POS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ALAMAT_LENGKAP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RW"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_NEGARA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_NEGARA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_HP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_TLP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_EMAIL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_STAMP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_MUTASI_VAL"),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.processMutasiPensiunTunda",
                procedureName = "CUSP_MUTASI_PENSIUN_TUNDA",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_KELAMIN_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_KERJA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_DPTHT_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HENTI_KERJA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_MENINGGAL_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MENINGGAL_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_LAHIR_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_GOLONGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_GOLONGAN_PANGKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_AGAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_AGAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PREDIKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PREDIKAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_HENTI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN_HENTI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SP_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SP_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SK_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SK_BI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_PHDP_LAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_UPAH_VETERAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_JENIS_MPS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_MPS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_USIA_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_USIA_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_STATUS_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_STATUS_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_STATUS_KAWIN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_STATUS_KAWIN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_TUNDA_JATUH_TEMPO"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_AWAL_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MP_BULAN_KE13"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HENTI_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_KELAMIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SK_DAPENBI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SK_DAPENBI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_USIA25T_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Boolean.class, name = "PAR_ALAMAT_IS_DALAM_NEGERI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PROVINSI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PROVINSI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KOTA_KAB"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KOTA_KAB"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KECAMATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KECAMATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KELURAHAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KELURAHAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_POS"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ALAMAT_LENGKAP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RW"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_NEGARA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_NEGARA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_HP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_TLP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_EMAIL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_STAMP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_ALASAN_MPS100"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_ALASAN_MPS100"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_MUTASI_VAL")
                }
        ),
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.processMutasiPerubahanNamaPenerimaMp",
                procedureName = "CUSP_MUTASI_PER_NAMA_PEN_MP",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATERGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JENIS_KELAMIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KTGORI_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NM_KTGORI_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_JK_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_MUTASI_VAL"),
                }

        ),
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.processMutasiKantorBayar",
                procedureName = "CUSP_MUTASI_KANTOR_BAYAR",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KATEGORI_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KANTOR_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KANTOR_BAYAR_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KANTOR_BAYAR_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_MUTASI_VAL")
                }
        ),
        @NamedStoredProcedureQuery(
                name = "MutasiPensiun.cuspMutasiMpMeninggal",
                procedureName = "CUSP_MUTASI_PENERIMAMP_WAFAT",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_AGAMA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_AGAMA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_GOLONGAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_GOLONGAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_PHDP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KANTOR_BAYAR_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KANTOR_BAYAR_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SP_BI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SP_BI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_SK_BI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_SK_BI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_ALMT_IS_DALAMNEGERI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_PROVINSI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PROVINSI_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KOTA_KAB_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KOTA_KAB_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KECAMATAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KECAMATAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KELURAHAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KELURAHAN_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KODE_POS_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ALAMAT_LENGKAP_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_HP_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NO_TLP_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_EMAIL_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RT_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_RW_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_NEGARA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_NEGARA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMAMP_LAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMAMPLAMA_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KAT_PENERIMAMP_LAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_WFT_PENERIMAMPLAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_INFWFT_PENERIMAMPLAMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KAT_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KAT_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_JK_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LHR_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KAWIN_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KAWIN_PENERIMAMP_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_SUSKEL_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_SUSKEL_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_BULAN13"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_LEBIH_BAYAR_NOMINAL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_LEBIH_BAYAR_JML_BULAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_LEBIH_BAYAR_NOMINAL_13"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_LEBIH_BAYAR_JML_BULAN_13"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_NOMINAL_TERBAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_SALDO_AKHIR_LEBIH_BAYAR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_STATUS_BAYAR_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_STATUS_BAYAR_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_HENTI_BAYAR_UPDATE"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                }
        ),
		@NamedStoredProcedureQuery(
			    name = "MutasiPensiun.cuspMutasiPerubahanPhdp",
			    procedureName = "CUSP_MUTASI_PERUBAHAN_PHDP",
			    parameters = {
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ROLE_ID"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "COMP_NAME"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "USER_NAME"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = BigDecimal.class, name = "PAR_PHDP_BARU"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_BERLAKU_PHDP"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "KETERANGAN_OTOMATIS_UPDATE"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_VALIDASI"),
			        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),  
			        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
			        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
			    }
			),
        @NamedStoredProcedureQuery(
                name = "mutasisuskel.cuspMutasiSuskel",
                procedureName = "CUSP_MUTASI_SUSKEL",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ROLE_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_PERIODE_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MUTASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PESERTA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_SUSKEL"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_SUSKEL_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_SUSKEL_BARU"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_CATATAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_KETERANGAN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_VALIDASI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Character.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "PAR_ID_MUTASI_PENSIUN_VAL"),


                }
        ),
        @NamedStoredProcedureQuery(
                name = "mutasisuskel.cuspMutasiSuskelUpd",
                procedureName = "CUSP_MUTASI_SUSKEL_UPD ",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_COMP_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_USER_NAME"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_MUTASI_PENSIUN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_ID_KELUARGA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NIP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KELUARGA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_KATEGORI_PENERIMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_KATEGORI_PENERIMA"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_JENIS_KELAMIN"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_LAHIR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_LAHIR"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_MENIKAH"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_CERAI"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_USIA25"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "PAR_TGL_WAFAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_MENIKAH"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_TEMPAT_WAFAT"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Character.class, name = "PAR_IS_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "PAR_ID_ST_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "PAR_NAMA_ST_KAWIN_PENERIMA_MP"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_STATUS_EKSEKUSI"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "PAR_MSG"),

                }
        )

})
public class MutasiPensiun extends BaseModel<MutasiPensiunDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUTASI_PENSIUN_SEQ")
    @SequenceGenerator(sequenceName = "mutasiPensiun_seq", allocationSize = 1, name = "MUTASI_PENSIUN_SEQ")
    @Column(name = "id_mutasi_pensiun")
    private Long id;

    @Column(name = "kode_mutasi", length = 5)
    private String kodeMutasi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_mutasi")
    private KategoriMutasi kategoriMutasi;

    @Column(name = "periode_mutasi", length = 6)
    private String periodeMutasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mutasi")
    private Date tglMutasi;

    @Column(length = 10)
    private String nip;

    @Column(name = "nama_peserta", length = 50)
    private String namaPeserta;

    @Column(name = "jenis_kelamin_peserta")
    private Character jenisKelaminPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_peserta")
    private Date tglLahirPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_kerja_peserta")
    private Date tglKerjaPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_dptht_peserta")
    private Date tglDPHTPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_henti_kerja_peserta")
    private Date tglHentiKerjaPeserta;

    @Column(name = "tempat_meninggal_peserta", length = 50)
    private String tempatMeniggalPeserta;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_meninggal_peserta")
    private Date tglMeniggalPeserta;

    @Column(name = "tempat_lahir_peserta", length = 50)
    private String tempatLahirPeserta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_golongan")
    private Golongan golongan;

    @Column(name = "golongan_pangkat", length = 100)
    private String golonganPangkat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agama")
    private Agama agama;

    @Column(name = "nama_agama", length = 20)
    private String namaAgama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kantor_bayar")
    private KantorBayar kantorBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kantor_bayar_baru")
    private KantorBayar kantorBayarBaru;

    @Column(name = "nama_kantor_bayar", length = 50)
    private String namaKantorBayar;

    @Column(name = "nama_kantor_bayar_baru", length = 50)
    private String namaKantorBayarBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predikat")
    private PredikatPemberhentian predikatPemberhentian;

    @Column(name = "nama_predikat", length = 50)
    private String namaPredikat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_henti")
    private AlasanHenti alasanHenti;

    @Column(name = "keterangan_henti", length = 50)
    private String keteranganHenti;

    @Column(name = "no_sp_bi",  length = 50)
    private String noSPBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sp_bi")
    private Date tglSPBI;

    @Column(name = "no_sk_bi",  length = 50)
    private String noSKBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sk_bi")
    private Date tglSKBI;

    @Column(name = "phdp_lama", precision = 20,  scale = 6)
    private BigDecimal phdpLama;

    @Column(name = "upah_veteran", precision = 20,  scale = 2)
    private BigDecimal upahVeteran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jenis_mps")
    private JenisMps jenisMps;

    @Column(name = "nama_mps", length = 50)
    private String namaMPS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_pensiun")
    private KategoriPensiun kategoriPensiun;

    @Column(name = "nama_kategori_pensiun", length = 50)
    private String namaKategoriPensiun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usia_bayar")
    private UsiaBayar usiaBayar;

    @Column(name = "nama_usia_bayar", length = 50)
    private String namaUsiaBayar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_bayar")
    private StatusBayar statusBayar;

    @Column(name = "status_bayar", length = 50)
    private String namaStatusBayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_tunda_jatuh_tempo")
    private Date tglTundaJatuhTempo;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_awal_bayar")
    private Date tglAwalBayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mp_bulan_ke13")
    private Date tglMpBulanKe13;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_henti_bayar")
    private Date tglHentiBayar;

    @Column(name = "id_penerima_mp")
    private String penerimaMP;

    @Column(name = "nama_penerima_mp", length = 50)
    private String namaPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_penerima_mp")
    private Date tglLahirPenerimaMP;

    @Column(name = "jenis_kelamin_penerima_mp")
    private Character jenisKelaminPenerimaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_penerima_mp")
    private KategoriPenerima kategoriPenerima;

    @Column(name = "nama_kategori_penerima_mp", length = 50)
    private String namaKategoriPenerimaMP;

    @Column(name = "no_sk_dapenbi",  length = 50)
    private String noSKDAPENBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_sk_dapenbi")
    private Date tglSKDAPENBI;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_meninggal_penerima_mp")
    private Date tglMeniggalPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_menikahlagi_penerima_mp")
    private Date tglMenikahLagiPenerimaMP;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_usia_25t_penerima_mp")
    private Date tglUsia25PenerimaMP;

    @Column(name = "alamat_is_dalam_negeri")
    private Boolean alamatIsDalamNegeri;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provinsi")
    private Provinsi provinsi;

    @Column(name = "nama_provinsi",  length = 50)
    private String namaProvinsi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kota_kab")
    private Kota kota;

    @Column(name = "nama_kota_kab",  length = 50)
    private String namaKota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kecamatan")
    private Kecamatan kecamatan;

    @Column(name = "nama_kecamatan",  length = 50)
    private String namaKecamatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelurahan")
    private Kelurahan kelurahan;

    @Column(name = "nama_kelurahan",  length = 50)
    private String namaKelurahan;

    @Column(name = "kode_pos",  length = 10)
    private String kodePos;

    @Column(name = "alamat_lengkap",  length = 500)
    private String alamatLengkap;

    @Column(name = "rt",  length = 5)
    private String rt;

    @Column(name = "rw",  length = 5)
    private String rw;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_negara")
    private Negara negara;

    @Column(name = "nama_negara",  length = 50)
    private String namaNegara;

    @Column(name = "usia_saat_henti" , length = 6)
    private String usiaSaatHenti;

    @Column(name = "usia_saat_henti_bulat" , length = 4)
    private String usiaSaatHentiBulat;

    @Column(name = "usia_penerima_bayar" , length = 6)
    private String usiaPenerimaBayar;

    @Column(name = "usia_penerima_bayar_bulat" , length = 4)
    private String usiaPenerimaBayarBulat;

    @Column(name = "masa_kerja_henti" , length = 6)
    private String masaKerjaHenti;

    @Column(name = "masa_kerja_henti_bulat" , length = 4)
    private String masaKerjaHentiBulat;

    @Column(name = "masa_kerja_tambahan" , length = 6)
    private String masaKerjaTambahan;

    @Column(name = "masa_kerja_tambahan_bulat" , length = 4)
    private String masaKerjaTambahanBulat;

    @Column(name = "masa_kerja_veteran" , length = 6)
    private String masaKerjaVeteran;

    @Column(name = "masa_kerja_veteran_bulat" , length = 4)
    private String masaKerjaVeteranBulat;

    @Column(name = "total_masa_kerja" , length = 6)
    private String totalMasaKerja;

    @Column(name = "total_masa_kerja_bulat" , length = 4)
    private String totalMasaKerjaBulat;

    @Column(name = "masa_kerja_mp" , length = 4)
    private String masaKerjaMP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faktor_fpr")
    private FaktorFPR faktorFPR;

    @Column(name = "nama_faktor_fpr" , length = 10)
    private String namaFaktorFPR;

    @Column(name = "nilai_fpr" , precision = 10, scale = 8)
    private BigDecimal nilaiFPR;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faktor_fs")
    private FaktorFs faktorFS;

    @Column(name = "nama_faktor_fs" , length = 10)
    private String namaFaktorFS;

    @Column(name = "faktor_fs" , length = 20)
    private String faktorFs;

    @Column(name = "nilai_fs" , precision = 10, scale = 8)
    private BigDecimal nilaiFS;

    @Column(name = "mps_20persen_lama" , precision = 20, scale = 6)
    private BigDecimal mps20PersenLama;

    @Column(name = "mps_10juta_lama" , precision = 20, scale = 6)
    private BigDecimal mps10JutaLama;

    @Column(name = "mps_100persen_lama" , precision = 15, scale = 6)
    private BigDecimal mps100PersenLama;

    @Column(name = "mp_perbulan_rumus_lama" , precision = 15, scale = 6)
    private BigDecimal mpPerbulanRumusLama;

    @Column(name = "mp_perbulan_20persen_lama" , precision = 15, scale = 6)
    private BigDecimal mpPerbulan20PersenLama;

    @Column(name = "mp_perbulan_10juta_lama" , precision = 15, scale = 6)
    private Long mpPerbulan10JutaLama;

    @Column(name = "mpyd_lama" , precision = 15, scale = 6)
    private BigDecimal mpydLama;

    @Column(name = "mp_bulan13" , precision = 15, scale = 6)
    private BigDecimal mpBulan13;

    @Column(name = "mps_100persen_bulat_lama" , precision = 20, scale = 6)
    private BigDecimal mps100PersenBulatLama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_suskel")
    private Suskel suskel;

    @Column(name = "nama_suskel" , length = 50)
    private String namaSuskel;

    @Column(name = "phdp_baru" , precision = 15, scale = 6)
    private BigDecimal phdpBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_mulai_berlaku_phdp_baru")
    private Date tglMulaiBerlakuPHDPBaru;

    @Column(name = "kurang_bayar_mpyd" , precision = 15, scale = 6)
    private BigDecimal kurangBayarMPYD;

    @Column(name = "mps_20persen_baru" , precision = 20, scale = 6)
    private BigDecimal mps20PersenBaru;

    @Column(name = "mps_10juta_baru" , precision = 20, scale = 6)
    private BigDecimal mps10JutaBaru;

    @Column(name = "mps_100persen_baru" , precision = 15, scale = 6)
    private BigDecimal mps100PersenBaru;

    @Column(name = "mp_perbulan_rumus_baru" , precision = 15, scale = 6)
    private BigDecimal mpPerbulanRumusBaru;

    @Column(name = "mp_perbulan_20persen_baru" , precision = 15, scale = 6)
    private BigDecimal mpPerbulan20PersenBaru;

    @Column(name = "mp_perbulan_10juta_baru" , precision = 20, scale = 6)
    private BigDecimal mpPerbulan10JutaBaru;

    @Column(name = "mps_100persen_bulat_baru" , precision = 15, scale = 6)
    private BigDecimal mps100PersenBulatBaru;

    @Column(name = "mpyd_baru" , precision = 15, scale = 6)
    private BigDecimal mpydBaru;

    @Column(name = "kurang_bayar_mps20persen", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS20Persen;

    @Column(name = "kurang_bayar_mps10juta", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS10Juta;

    @Column(name = "kurang_bayar_mps100persen", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPS100Persen;

    @Column(name = "kurang_bayar_mp_rumus", precision = 15, scale = 6)
    private BigDecimal kurangBayarMPRumus;

    @Column(name = "is_jadi_hutang")
    private Boolean isJadiHutang;

    @Column(name = "lebih_bayar_mps20persen", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS20Persen;

    @Column(name = "lebih_bayar_mps10juta", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS10Juta;

    @Column(name = "lebih_bayar_mps100persen", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPS100Persen;

    @Column(name = "lebih_bayar_mp_rumus", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPRumus;

    @Column(name = "lebih_bayar_mpyd", precision = 15, scale = 6)
    private BigDecimal lebihBayarMPYD;

    @Column(name = "is_jadi_piutang")
    private Boolean isJadiPiutang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_catatan")
    private KategoriCatatan kategoryCatatan;

    @Column(name = "keterangan" , length = 500)
    private String keterangan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_kawin_penerima_mp")
    private StatusKawin statusKawin;

    @Column(name = "nama_status_kawin_penerima_mp" , length = 50)
    private String namaStatusKawinPenerimaMP;

    @Column(name = "is_rekening_dapenbi")
    private Boolean isRekeningDAPENBI;

    @Column(name = "id_bank")
    private Long bank;

    @Column(name = "jenis_bank" , length = 20)
    private String jenisBank;

    @Column(name = "nama_cabang_bank" , length = 50)
    private String namaCabangBank;

    @Column(name = "nama_pada_rek_bank" , length = 50)
    private String namaPadaRekBank;

    @Column(name = "nomor_rekening" , length = 50)
    private String nomorRekening;

    @Column(name = "no_hp" , length = 50)
    private String noHP;

    @Column(name = "email" , length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_validasi")
    private StatusValidasi statusValidasi;

    @Column(name = "keterangan_otomatis" , length = 500)
    private String keteranganOtomatis;

    @Column(name = "user_validasi" , length = 100)
    private String userValidasi;

    @Column(name = "nama_validasi" , length = 50)
    private String namaValidasi;

    @Column(name = "total_masa_kerja_adj" , length = 6)
    private String totalMasaKerjaAdj;

    @Column(name = "total_masa_kerja_bulat_adj" , length = 4)
    private String totalMasaKerjaBulatAdj;

    @Column(name = "mp_bulan13_baru", precision = 20, scale = 2)
    private BigDecimal mpBulan13Baru;

    @Column(name = "rapel_mpyd_kurang", precision = 20, scale = 2)
    private BigDecimal rapelMPYDKurang;

    @Column(name = "rapel_mpyd_lebih", precision = 20, scale = 2)
    private BigDecimal rapelMPYDLebih;

    @Column(name = "no_tlp" , length = 20)
    private String noTlp;

    @Column(name = "id_penerima_mp_baru")
    private String penerimaMPBaru;

    @Column(name = "nama_penerima_mp_baru", length = 50)
    private String namaPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori_penerima_mp_baru")
    private KategoriPenerima kategoriPenerimaBaru;

    @Column(name = "nama_kategori_penerima_mp_baru", length = 50)
    private String namaKategoriPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_suskel_baru")
    private Suskel suskelBaru;

    @Column(name = "nama_suskel_baru" , length = 50)
    private String namaSuskelBaru;

    @Column(name = "lebih_bayar_jml_bulan", precision = 15, scale = 6)
    private BigDecimal lebihBayarJmlBulan;

    @Column(name = "lebih_bayar_nominal", precision = 15, scale = 6)
    private BigDecimal lebihBayarNominal;

    @Column(name = "nominal_terbayar", precision = 15, scale = 6)
    private BigDecimal nominalTerbayar;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_INF_WFT_PENERIMAMP_LAMA")
    private Date tglInfWftPenerimaMpLama;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_LAHIR_PENERIMA_MP_BARU")
    private Date tglLahirPenerimaMpBaru;

    @Column(name = "jenis_kelamin_penerima_mp_baru")
    private Character jenisKelaminPenerimaMPBaru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KAWIN_PENERIMAMP_BARU")
    private StatusKawin statusKawinBaru;

    @Column(name = "NAMA_KAWIN_PENERIMAMP_BARU" , length = 50)
    private String namaStatusKawinPenerimaMPBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_INF_NIKAH_PENERIMAMP_LAMA")
    private Date tglInfNikahPenerimaMpLama;

    @Column(name = "lebih_bayar_jml_bln_13", precision = 15, scale = 6)
    private BigDecimal lebihBayarJmlBln13;

    @Column(name = "LEBIH_BAYAR_NOMINAL_13", precision = 15, scale = 6)
    private BigDecimal lebihBayarNominal13;


    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_USIA_25T_PENERIMA_MP_BARU")
    private Date tglUsia25PenerimaMPBaru;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_PERMOHONAN_MPS100")
    private Date tglPermohonanMps100;

    @Column(name = "ID_ALASAN_MPS_100")
    private Long idAlasanMps100;

    @Column(name = "NAMA_ALASAN_MPS_100")
    private String namaAlasanMps100;

    @OneToMany(mappedBy = "mutasiPensiun", fetch = FetchType.LAZY)
    private List<MutasiKeluargaPensiun> mutasiKeluargaPensiun;

    public MutasiPensiun() {
    }

    public MutasiPensiun(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeMutasi() {
        return kodeMutasi;
    }

    public void setKodeMutasi(String kodeMutasi) {
        this.kodeMutasi = kodeMutasi;
    }

    public KategoriMutasi getKategoriMutasi() {
        return kategoriMutasi;
    }

    public void setKategoriMutasi(KategoriMutasi kategoriMutasi) {
        this.kategoriMutasi = kategoriMutasi;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public Date getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(Date tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public Character getJenisKelaminPeserta() {
        return jenisKelaminPeserta;
    }

    public void setJenisKelaminPeserta(Character jenisKelaminPeserta) {
        this.jenisKelaminPeserta = jenisKelaminPeserta;
    }

    public Date getTglLahirPeserta() {
        return tglLahirPeserta;
    }

    public void setTglLahirPeserta(Date tglLahirPeserta) {
        this.tglLahirPeserta = tglLahirPeserta;
    }

    public Date getTglKerjaPeserta() {
        return tglKerjaPeserta;
    }

    public void setTglKerjaPeserta(Date tglKerjaPeserta) {
        this.tglKerjaPeserta = tglKerjaPeserta;
    }

    public Date getTglDPHTPeserta() {
        return tglDPHTPeserta;
    }

    public void setTglDPHTPeserta(Date tglDPHTPeserta) {
        this.tglDPHTPeserta = tglDPHTPeserta;
    }

    public Date getTglHentiKerjaPeserta() {
        return tglHentiKerjaPeserta;
    }

    public void setTglHentiKerjaPeserta(Date tglHentiKerjaPeserta) {
        this.tglHentiKerjaPeserta = tglHentiKerjaPeserta;
    }

    public String getTempatMeniggalPeserta() {
        return tempatMeniggalPeserta;
    }

    public void setTempatMeniggalPeserta(String tempatMeniggalPeserta) {
        this.tempatMeniggalPeserta = tempatMeniggalPeserta;
    }

    public Date getTglMeniggalPeserta() {
        return tglMeniggalPeserta;
    }

    public void setTglMeniggalPeserta(Date tglMeniggalPeserta) {
        this.tglMeniggalPeserta = tglMeniggalPeserta;
    }

    public String getTempatLahirPeserta() {
        return tempatLahirPeserta;
    }

    public void setTempatLahirPeserta(String tempatLahirPeserta) {
        this.tempatLahirPeserta = tempatLahirPeserta;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public KantorBayar getKantorBayar() {
        return kantorBayar;
    }

    public void setKantorBayar(KantorBayar kantorBayar) {
        this.kantorBayar = kantorBayar;
    }

    public String getNamaKantorBayar() {
        return namaKantorBayar;
    }

    public void setNamaKantorBayar(String namaKantorBayar) {
        this.namaKantorBayar = namaKantorBayar;
    }

    public PredikatPemberhentian getPredikatPemberhentian() {
        return predikatPemberhentian;
    }

    public void setPredikatPemberhentian(PredikatPemberhentian predikatPemberhentian) {
        this.predikatPemberhentian = predikatPemberhentian;
    }

    public String getNamaPredikat() {
        return namaPredikat;
    }

    public void setNamaPredikat(String namaPredikat) {
        this.namaPredikat = namaPredikat;
    }

    public AlasanHenti getAlasanHenti() {
        return alasanHenti;
    }

    public void setAlasanHenti(AlasanHenti alasanHenti) {
        this.alasanHenti = alasanHenti;
    }

    public String getKeteranganHenti() {
        return keteranganHenti;
    }

    public void setKeteranganHenti(String keteranganHenti) {
        this.keteranganHenti = keteranganHenti;
    }

    public String getNoSPBI() {
        return noSPBI;
    }

    public void setNoSPBI(String noSPBI) {
        this.noSPBI = noSPBI;
    }

    public Date getTglSPBI() {
        return tglSPBI;
    }

    public void setTglSPBI(Date tglSPBI) {
        this.tglSPBI = tglSPBI;
    }

    public String getNoSKBI() {
        return noSKBI;
    }

    public void setNoSKBI(String noSKBI) {
        this.noSKBI = noSKBI;
    }

    public Date getTglSKBI() {
        return tglSKBI;
    }

    public void setTglSKBI(Date tglSKBI) {
        this.tglSKBI = tglSKBI;
    }

    public BigDecimal getPhdpLama() {
        return phdpLama;
    }

    public void setPhdpLama(BigDecimal phdpLama) {
        this.phdpLama = phdpLama;
    }

    public BigDecimal getUpahVeteran() {
        return upahVeteran;
    }

    public void setUpahVeteran(BigDecimal upahVeteran) {
        this.upahVeteran = upahVeteran;
    }

    public JenisMps getJenisMps() {
        return jenisMps;
    }

    public void setJenisMps(JenisMps jenisMps) {
        this.jenisMps = jenisMps;
    }

    public String getNamaMPS() {
        return namaMPS;
    }

    public void setNamaMPS(String namaMPS) {
        this.namaMPS = namaMPS;
    }

    public KategoriPensiun getKategoriPensiun() {
        return kategoriPensiun;
    }

    public void setKategoriPensiun(KategoriPensiun kategoriPensiun) {
        this.kategoriPensiun = kategoriPensiun;
    }

    public String getNamaKategoriPensiun() {
        return namaKategoriPensiun;
    }

    public void setNamaKategoriPensiun(String namaKategoriPensiun) {
        this.namaKategoriPensiun = namaKategoriPensiun;
    }

    public UsiaBayar getUsiaBayar() {
        return usiaBayar;
    }

    public void setUsiaBayar(UsiaBayar usiaBayar) {
        this.usiaBayar = usiaBayar;
    }

    public String getNamaUsiaBayar() {
        return namaUsiaBayar;
    }

    public void setNamaUsiaBayar(String namaUsiaBayar) {
        this.namaUsiaBayar = namaUsiaBayar;
    }

    public StatusBayar getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(StatusBayar statusBayar) {
        this.statusBayar = statusBayar;
    }

    public String getNamaStatusBayar() {
        return namaStatusBayar;
    }

    public void setNamaStatusBayar(String namaStatusBayar) {
        this.namaStatusBayar = namaStatusBayar;
    }

    public Date getTglTundaJatuhTempo() {
        return tglTundaJatuhTempo;
    }

    public void setTglTundaJatuhTempo(Date tglTundaJatuhTempo) {
        this.tglTundaJatuhTempo = tglTundaJatuhTempo;
    }


    public Date getTglAwalBayar() {
        return tglAwalBayar;
    }

    public void setTglAwalBayar(Date tglAwalBayar) {
        this.tglAwalBayar = tglAwalBayar;
    }

    public Date getTglMpBulanKe13() {
        return tglMpBulanKe13;
    }

    public void setTglMpBulanKe13(Date tglMpBulanKe13) {
        this.tglMpBulanKe13 = tglMpBulanKe13;
    }

    public Date getTglHentiBayar() {
        return tglHentiBayar;
    }

    public void setTglHentiBayar(Date tglHentiBayar) {
        this.tglHentiBayar = tglHentiBayar;
    }

    public String getPenerimaMP() {
        return penerimaMP;
    }

    public void setPenerimaMP(String penerimaMP) {
        this.penerimaMP = penerimaMP;
    }

    public String getNamaPenerimaMP() {
        return namaPenerimaMP;
    }

    public void setNamaPenerimaMP(String namaPenerimaMP) {
        this.namaPenerimaMP = namaPenerimaMP;
    }

    public Date getTglLahirPenerimaMP() {
        return tglLahirPenerimaMP;
    }

    public void setTglLahirPenerimaMP(Date tglLahirPenerimaMP) {
        this.tglLahirPenerimaMP = tglLahirPenerimaMP;
    }

    public Character getJenisKelaminPenerimaMP() {
        return jenisKelaminPenerimaMP;
    }

    public void setJenisKelaminPenerimaMP(Character jenisKelaminPenerimaMP) {
        this.jenisKelaminPenerimaMP = jenisKelaminPenerimaMP;
    }

    public KategoriPenerima getKategoriPenerima() {
        return kategoriPenerima;
    }

    public void setKategoriPenerima(KategoriPenerima kategoriPenerima) {
        this.kategoriPenerima = kategoriPenerima;
    }

    public String getNamaKategoriPenerimaMP() {
        return namaKategoriPenerimaMP;
    }

    public void setNamaKategoriPenerimaMP(String namaKategoriPenerimaMP) {
        this.namaKategoriPenerimaMP = namaKategoriPenerimaMP;
    }

    public String getNoSKDAPENBI() {
        return noSKDAPENBI;
    }

    public void setNoSKDAPENBI(String noSKDAPENBI) {
        this.noSKDAPENBI = noSKDAPENBI;
    }

    public Date getTglSKDAPENBI() {
        return tglSKDAPENBI;
    }

    public void setTglSKDAPENBI(Date tglSKDAPENBI) {
        this.tglSKDAPENBI = tglSKDAPENBI;
    }

    public Date getTglMeniggalPenerimaMP() {
        return tglMeniggalPenerimaMP;
    }

    public void setTglMeniggalPenerimaMP(Date tglMeniggalPenerimaMP) {
        this.tglMeniggalPenerimaMP = tglMeniggalPenerimaMP;
    }

    public Date getTglMenikahLagiPenerimaMP() {
        return tglMenikahLagiPenerimaMP;
    }

    public void setTglMenikahLagiPenerimaMP(Date tglMenikahLagiPenerimaMP) {
        this.tglMenikahLagiPenerimaMP = tglMenikahLagiPenerimaMP;
    }

    public Date getTglUsia25PenerimaMP() {
        return tglUsia25PenerimaMP;
    }

    public void setTglUsia25PenerimaMP(Date tglUsia25PenerimaMP) {
        this.tglUsia25PenerimaMP = tglUsia25PenerimaMP;
    }

    public Boolean isAlamatIsDalamNegeri() {
        return alamatIsDalamNegeri;
    }

    public void setAlamatIsDalamNegeri(Boolean alamatIsDalamNegeri) {
        this.alamatIsDalamNegeri = alamatIsDalamNegeri;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public Kelurahan getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(Kelurahan kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public Negara getNegara() {
        return negara;
    }

    public void setNegara(Negara negara) {
        this.negara = negara;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getUsiaSaatHenti() {
        return usiaSaatHenti;
    }

    public void setUsiaSaatHenti(String usiaSaatHenti) {
        this.usiaSaatHenti = usiaSaatHenti;
    }

    public String getUsiaSaatHentiBulat() {
        return usiaSaatHentiBulat;
    }

    public void setUsiaSaatHentiBulat(String usiaSaatHentiBulat) {
        this.usiaSaatHentiBulat = usiaSaatHentiBulat;
    }

    public String getUsiaPenerimaBayar() {
        return usiaPenerimaBayar;
    }

    public void setUsiaPenerimaBayar(String usiaPenerimaBayar) {
        this.usiaPenerimaBayar = usiaPenerimaBayar;
    }

    public String getUsiaPenerimaBayarBulat() {
        return usiaPenerimaBayarBulat;
    }

    public void setUsiaPenerimaBayarBulat(String usiaPenerimaBayarBulat) {
        this.usiaPenerimaBayarBulat = usiaPenerimaBayarBulat;
    }

    public String getMasaKerjaHenti() {
        return masaKerjaHenti;
    }

    public void setMasaKerjaHenti(String masaKerjaHenti) {
        this.masaKerjaHenti = masaKerjaHenti;
    }

    public String getMasaKerjaHentiBulat() {
        return masaKerjaHentiBulat;
    }

    public void setMasaKerjaHentiBulat(String masaKerjaHentiBulat) {
        this.masaKerjaHentiBulat = masaKerjaHentiBulat;
    }

    public String getMasaKerjaTambahan() {
        return masaKerjaTambahan;
    }

    public void setMasaKerjaTambahan(String masaKerjaTambahan) {
        this.masaKerjaTambahan = masaKerjaTambahan;
    }

    public String getMasaKerjaTambahanBulat() {
        return masaKerjaTambahanBulat;
    }

    public void setMasaKerjaTambahanBulat(String masaKerjaTambahanBulat) {
        this.masaKerjaTambahanBulat = masaKerjaTambahanBulat;
    }

    public String getMasaKerjaVeteran() {
        return masaKerjaVeteran;
    }

    public void setMasaKerjaVeteran(String masaKerjaVeteran) {
        this.masaKerjaVeteran = masaKerjaVeteran;
    }

    public String getMasaKerjaVeteranBulat() {
        return masaKerjaVeteranBulat;
    }

    public void setMasaKerjaVeteranBulat(String masaKerjaVeteranBulat) {
        this.masaKerjaVeteranBulat = masaKerjaVeteranBulat;
    }

    public String getTotalMasaKerja() {
        return totalMasaKerja;
    }

    public void setTotalMasaKerja(String totalMasaKerja) {
        this.totalMasaKerja = totalMasaKerja;
    }

    public String getTotalMasaKerjaBulat() {
        return totalMasaKerjaBulat;
    }

    public void setTotalMasaKerjaBulat(String totalMasaKerjaBulat) {
        this.totalMasaKerjaBulat = totalMasaKerjaBulat;
    }

    public String getMasaKerjaMP() {
        return masaKerjaMP;
    }

    public void setMasaKerjaMP(String masaKerjaMP) {
        this.masaKerjaMP = masaKerjaMP;
    }

    public FaktorFPR getFaktorFPR() {
        return faktorFPR;
    }

    public void setFaktorFPR(FaktorFPR faktorFPR) {
        this.faktorFPR = faktorFPR;
    }

    public String getNamaFaktorFPR() {
        return namaFaktorFPR;
    }

    public void setNamaFaktorFPR(String namaFaktorFPR) {
        this.namaFaktorFPR = namaFaktorFPR;
    }

    public BigDecimal getNilaiFPR() {
        return nilaiFPR;
    }

    public void setNilaiFPR(BigDecimal nilaiFPR) {
        this.nilaiFPR = nilaiFPR;
    }

    public FaktorFs getFaktorFS() {
        return faktorFS;
    }

    public void setFaktorFS(FaktorFs faktorFS) {
        this.faktorFS = faktorFS;
    }

    public String getNamaFaktorFS() {
        return namaFaktorFS;
    }

    public void setNamaFaktorFS(String namaFaktorFS) {
        this.namaFaktorFS = namaFaktorFS;
    }

    public String getFaktorFs() {
        return faktorFs;
    }

    public void setFaktorFs(String faktorFs) {
        this.faktorFs = faktorFs;
    }

    public BigDecimal getNilaiFS() {
        return nilaiFS;
    }

    public void setNilaiFS(BigDecimal nilaiFS) {
        this.nilaiFS = nilaiFS;
    }

    public BigDecimal getMps20PersenLama() {
        return mps20PersenLama;
    }

    public void setMps20PersenLama(BigDecimal mps20PersenLama) {
        this.mps20PersenLama = mps20PersenLama;
    }

    public BigDecimal getMps10JutaLama() {
        return mps10JutaLama;
    }

    public void setMps10JutaLama(BigDecimal mps10JutaLama) {
        this.mps10JutaLama = mps10JutaLama;
    }

    public BigDecimal getMps100PersenLama() {
        return mps100PersenLama;
    }

    public void setMps100PersenLama(BigDecimal mps100PersenLama) {
        this.mps100PersenLama = mps100PersenLama;
    }

    public BigDecimal getMpPerbulanRumusLama() {
        return mpPerbulanRumusLama;
    }

    public void setMpPerbulanRumusLama(BigDecimal mpPerbulanRumusLama) {
        this.mpPerbulanRumusLama = mpPerbulanRumusLama;
    }

    public BigDecimal getMpPerbulan20PersenLama() {
        return mpPerbulan20PersenLama;
    }

    public void setMpPerbulan20PersenLama(BigDecimal mpPerbulan20PersenLama) {
        this.mpPerbulan20PersenLama = mpPerbulan20PersenLama;
    }

    public Long getMpPerbulan10JutaLama() {
        return mpPerbulan10JutaLama;
    }

    public void setMpPerbulan10JutaLama(Long mpPerbulan10JutaLama) {
        this.mpPerbulan10JutaLama = mpPerbulan10JutaLama;
    }

    public BigDecimal getMpydLama() {
        return mpydLama;
    }

    public void setMpydLama(BigDecimal mpydLama) {
        this.mpydLama = mpydLama;
    }

    public BigDecimal getMpBulan13() {
        return mpBulan13;
    }

    public void setMpBulan13(BigDecimal mpBulan13) {
        this.mpBulan13 = mpBulan13;
    }

    public BigDecimal getMps100PersenBulatLama() {
        return mps100PersenBulatLama;
    }

    public void setMps100PersenBulatLama(BigDecimal mps100PersenBulatLama) {
        this.mps100PersenBulatLama = mps100PersenBulatLama;
    }

    public Suskel getSuskel() {
        return suskel;
    }

    public void setSuskel(Suskel suskel) {
        this.suskel = suskel;
    }

    public String getNamaSuskel() {
        return namaSuskel;
    }

    public void setNamaSuskel(String namaSuskel) {
        this.namaSuskel = namaSuskel;
    }

    public BigDecimal getPhdpBaru() {
        return phdpBaru;
    }

    public void setPhdpBaru(BigDecimal phdpBaru) {
        this.phdpBaru = phdpBaru;
    }

    public Date getTglMulaiBerlakuPHDPBaru() {
        return tglMulaiBerlakuPHDPBaru;
    }

    public void setTglMulaiBerlakuPHDPBaru(Date tglMulaiBerlakuPHDPBaru) {
        this.tglMulaiBerlakuPHDPBaru = tglMulaiBerlakuPHDPBaru;
    }

    public BigDecimal getKurangBayarMPYD() {
        return kurangBayarMPYD;
    }

    public void setKurangBayarMPYD(BigDecimal kurangBayarMPYD) {
        this.kurangBayarMPYD = kurangBayarMPYD;
    }

    public BigDecimal getMps20PersenBaru() {
        return mps20PersenBaru;
    }

    public void setMps20PersenBaru(BigDecimal mps20PersenBaru) {
        this.mps20PersenBaru = mps20PersenBaru;
    }

    public BigDecimal getMps10JutaBaru() {
        return mps10JutaBaru;
    }

    public void setMps10JutaBaru(BigDecimal mps10JutaBaru) {
        this.mps10JutaBaru = mps10JutaBaru;
    }

    public BigDecimal getMps100PersenBaru() {
        return mps100PersenBaru;
    }

    public void setMps100PersenBaru(BigDecimal mps100PersenBaru) {
        this.mps100PersenBaru = mps100PersenBaru;
    }

    public BigDecimal getMpPerbulanRumusBaru() {
        return mpPerbulanRumusBaru;
    }

    public void setMpPerbulanRumusBaru(BigDecimal mpPerbulanRumusBaru) {
        this.mpPerbulanRumusBaru = mpPerbulanRumusBaru;
    }

    public BigDecimal getMpPerbulan20PersenBaru() {
        return mpPerbulan20PersenBaru;
    }

    public void setMpPerbulan20PersenBaru(BigDecimal mpPerbulan20PersenBaru) {
        this.mpPerbulan20PersenBaru = mpPerbulan20PersenBaru;
    }

    public BigDecimal getMpPerbulan10JutaBaru() {
        return mpPerbulan10JutaBaru;
    }

    public void setMpPerbulan10JutaBaru(BigDecimal mpPerbulan10JutaBaru) {
        this.mpPerbulan10JutaBaru = mpPerbulan10JutaBaru;
    }

    public BigDecimal getMps100PersenBulatBaru() {
        return mps100PersenBulatBaru;
    }

    public void setMps100PersenBulatBaru(BigDecimal mps100PersenBulatBaru) {
        this.mps100PersenBulatBaru = mps100PersenBulatBaru;
    }

    public BigDecimal getMpydBaru() {
        return mpydBaru;
    }

    public void setMpydBaru(BigDecimal mpydBaru) {
        this.mpydBaru = mpydBaru;
    }

    public BigDecimal getKurangBayarMPS20Persen() {
        return kurangBayarMPS20Persen;
    }

    public void setKurangBayarMPS20Persen(BigDecimal kurangBayarMPS20Persen) {
        this.kurangBayarMPS20Persen = kurangBayarMPS20Persen;
    }

    public BigDecimal getKurangBayarMPS10Juta() {
        return kurangBayarMPS10Juta;
    }

    public void setKurangBayarMPS10Juta(BigDecimal kurangBayarMPS10Juta) {
        this.kurangBayarMPS10Juta = kurangBayarMPS10Juta;
    }

    public BigDecimal getKurangBayarMPS100Persen() {
        return kurangBayarMPS100Persen;
    }

    public void setKurangBayarMPS100Persen(BigDecimal kurangBayarMPS100Persen) {
        this.kurangBayarMPS100Persen = kurangBayarMPS100Persen;
    }

    public BigDecimal getKurangBayarMPRumus() {
        return kurangBayarMPRumus;
    }

    public void setKurangBayarMPRumus(BigDecimal kurangBayarMPRumus) {
        this.kurangBayarMPRumus = kurangBayarMPRumus;
    }

    public Boolean getJadiHutang() {
        return isJadiHutang;
    }

    public void setJadiHutang(Boolean jadiHutang) {
        isJadiHutang = jadiHutang;
    }

    public BigDecimal getLebihBayarMPS20Persen() {
        return lebihBayarMPS20Persen;
    }

    public void setLebihBayarMPS20Persen(BigDecimal lebihBayarMPS20Persen) {
        this.lebihBayarMPS20Persen = lebihBayarMPS20Persen;
    }

    public BigDecimal getLebihBayarMPS10Juta() {
        return lebihBayarMPS10Juta;
    }

    public void setLebihBayarMPS10Juta(BigDecimal lebihBayarMPS10Juta) {
        this.lebihBayarMPS10Juta = lebihBayarMPS10Juta;
    }

    public BigDecimal getLebihBayarMPS100Persen() {
        return lebihBayarMPS100Persen;
    }

    public void setLebihBayarMPS100Persen(BigDecimal lebihBayarMPS100Persen) {
        this.lebihBayarMPS100Persen = lebihBayarMPS100Persen;
    }

    public BigDecimal getLebihBayarMPRumus() {
        return lebihBayarMPRumus;
    }

    public void setLebihBayarMPRumus(BigDecimal lebihBayarMPRumus) {
        this.lebihBayarMPRumus = lebihBayarMPRumus;
    }

    public BigDecimal getLebihBayarMPYD() {
        return lebihBayarMPYD;
    }

    public void setLebihBayarMPYD(BigDecimal lebihBayarMPYD) {
        this.lebihBayarMPYD = lebihBayarMPYD;
    }

    public Boolean getJadiPiutang() {
        return isJadiPiutang;
    }

    public void setJadiPiutang(Boolean jadiPiutang) {
        isJadiPiutang = jadiPiutang;
    }

    public KategoriCatatan getKategoryCatatan() {
        return kategoryCatatan;
    }

    public void setKategoryCatatan(KategoriCatatan kategoryCatatan) {
        this.kategoryCatatan = kategoryCatatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public String getNamaStatusKawinPenerimaMP() {
        return namaStatusKawinPenerimaMP;
    }

    public void setNamaStatusKawinPenerimaMP(String namaStatusKawinPenerimaMP) {
        this.namaStatusKawinPenerimaMP = namaStatusKawinPenerimaMP;
    }

    public Boolean getRekeningDAPENBI() {
        return isRekeningDAPENBI;
    }

    public void setRekeningDAPENBI(Boolean rekeningDAPENBI) {
        isRekeningDAPENBI = rekeningDAPENBI;
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
        this.bank = bank;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public String getNamaCabangBank() {
        return namaCabangBank;
    }

    public void setNamaCabangBank(String namaCabangBank) {
        this.namaCabangBank = namaCabangBank;
    }

    public String getNamaPadaRekBank() {
        return namaPadaRekBank;
    }

    public void setNamaPadaRekBank(String namaPadaRekBank) {
        this.namaPadaRekBank = namaPadaRekBank;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusValidasi getStatusValidasi() {
        return statusValidasi;
    }

    public void setStatusValidasi(StatusValidasi statusValidasi) {
        this.statusValidasi = statusValidasi;
    }

    public String getKeteranganOtomatis() {
        return keteranganOtomatis;
    }

    public void setKeteranganOtomatis(String keteranganOtomatis) {
        this.keteranganOtomatis = keteranganOtomatis;
    }

    public String getUserValidasi() {
        return userValidasi;
    }

    public void setUserValidasi(String userValidasi) {
        this.userValidasi = userValidasi;
    }

    public String getNamaValidasi() {
        return namaValidasi;
    }

    public void setNamaValidasi(String namaValidasi) {
        this.namaValidasi = namaValidasi;
    }

    public String getTotalMasaKerjaAdj() {
        return totalMasaKerjaAdj;
    }

    public void setTotalMasaKerjaAdj(String totalMasaKerjaAdj) {
        this.totalMasaKerjaAdj = totalMasaKerjaAdj;
    }

    public String getTotalMasaKerjaBulatAdj() {
        return totalMasaKerjaBulatAdj;
    }

    public void setTotalMasaKerjaBulatAdj(String totalMasaKerjaBulatAdj) {
        this.totalMasaKerjaBulatAdj = totalMasaKerjaBulatAdj;
    }

    public BigDecimal getMpBulan13Baru() {
        return mpBulan13Baru;
    }

    public void setMpBulan13Baru(BigDecimal mpBulan13Baru) {
        this.mpBulan13Baru = mpBulan13Baru;
    }

    public BigDecimal getRapelMPYDKurang() {
        return rapelMPYDKurang;
    }

    public void setRapelMPYDKurang(BigDecimal rapelMPYDKurang) {
        this.rapelMPYDKurang = rapelMPYDKurang;
    }

    public BigDecimal getRapelMPYDLebih() {
        return rapelMPYDLebih;
    }

    public void setRapelMPYDLebih(BigDecimal rapelMPYDLebih) {
        this.rapelMPYDLebih = rapelMPYDLebih;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public List<MutasiKeluargaPensiun> getMutasiKeluargaPensiun() {
        return mutasiKeluargaPensiun;
    }

    public void setMutasiKeluargaPensiun(List<MutasiKeluargaPensiun> mutasiKeluargaPensiun) {
        this.mutasiKeluargaPensiun = mutasiKeluargaPensiun;
    }

    public String getPenerimaMPBaru() {
        return penerimaMPBaru;
    }

    public void setPenerimaMPBaru(String penerimaMPBaru) {
        this.penerimaMPBaru = penerimaMPBaru;
    }

    public String getNamaPenerimaMPBaru() {
        return namaPenerimaMPBaru;
    }

    public void setNamaPenerimaMPBaru(String namaPenerimaMPBaru) {
        this.namaPenerimaMPBaru = namaPenerimaMPBaru;
    }

    public KategoriPenerima getKategoriPenerimaBaru() {
        return kategoriPenerimaBaru;
    }

    public void setKategoriPenerimaBaru(KategoriPenerima kategoriPenerimaBaru) {
        this.kategoriPenerimaBaru = kategoriPenerimaBaru;
    }

    public String getNamaKategoriPenerimaMPBaru() {
        return namaKategoriPenerimaMPBaru;
    }

    public void setNamaKategoriPenerimaMPBaru(String namaKategoriPenerimaMPBaru) {
        this.namaKategoriPenerimaMPBaru = namaKategoriPenerimaMPBaru;
    }

    public Suskel getSuskelBaru() {
        return suskelBaru;
    }

    public void setSuskelBaru(Suskel suskelBaru) {
        this.suskelBaru = suskelBaru;
    }

    public String getNamaSuskelBaru() {
        return namaSuskelBaru;
    }

    public void setNamaSuskelBaru(String namaSuskelBaru) {
        this.namaSuskelBaru = namaSuskelBaru;
    }

    public BigDecimal getLebihBayarJmlBulan() {
        return lebihBayarJmlBulan;
    }

    public void setLebihBayarJmlBulan(BigDecimal lebihBayarJmlBulan) {
        this.lebihBayarJmlBulan = lebihBayarJmlBulan;
    }

    public BigDecimal getLebihBayarNominal() {
        return lebihBayarNominal;
    }

    public void setLebihBayarNominal(BigDecimal lebihBayarNominal) {
        this.lebihBayarNominal = lebihBayarNominal;
    }

    public BigDecimal getNominalTerbayar() {
        return nominalTerbayar;
    }

    public void setNominalTerbayar(BigDecimal nominalTerbayar) {
        this.nominalTerbayar = nominalTerbayar;
    }

    public Date getTglInfWftPenerimaMpLama() {
        return tglInfWftPenerimaMpLama;
    }

    public void setTglInfWftPenerimaMpLama(Date tglInfWftPenerimaMpLama) {
        this.tglInfWftPenerimaMpLama = tglInfWftPenerimaMpLama;
    }

    public Date getTglLahirPenerimaMpBaru() {
        return tglLahirPenerimaMpBaru;
    }

    public void setTglLahirPenerimaMpBaru(Date tglLahirPenerimaMpBaru) {
        this.tglLahirPenerimaMpBaru = tglLahirPenerimaMpBaru;
    }

    public Character getJenisKelaminPenerimaMPBaru() {
        return jenisKelaminPenerimaMPBaru;
    }

    public void setJenisKelaminPenerimaMPBaru(Character jenisKelaminPenerimaMPBaru) {
        this.jenisKelaminPenerimaMPBaru = jenisKelaminPenerimaMPBaru;
    }

    public StatusKawin getStatusKawinBaru() {
        return statusKawinBaru;
    }

    public void setStatusKawinBaru(StatusKawin statusKawinBaru) {
        this.statusKawinBaru = statusKawinBaru;
    }

    public String getNamaStatusKawinPenerimaMPBaru() {
        return namaStatusKawinPenerimaMPBaru;
    }

    public void setNamaStatusKawinPenerimaMPBaru(String namaStatusKawinPenerimaMPBaru) {
        this.namaStatusKawinPenerimaMPBaru = namaStatusKawinPenerimaMPBaru;
    }

    public Date getTglInfNikahPenerimaMpLama() {
        return tglInfNikahPenerimaMpLama;
    }

    public void setTglInfNikahPenerimaMpLama(Date tglInfNikahPenerimaMpLama) {
        this.tglInfNikahPenerimaMpLama = tglInfNikahPenerimaMpLama;
    }

    public BigDecimal getLebihBayarJmlBln13() {
        return lebihBayarJmlBln13;
    }

    public void setLebihBayarJmlBln13(BigDecimal lebihBayarJmlBln13) {
        this.lebihBayarJmlBln13 = lebihBayarJmlBln13;
    }

    public BigDecimal getLebihBayarNominal13() {
        return lebihBayarNominal13;
    }

    public void setLebihBayarNominal13(BigDecimal lebihBayarNominal13) {
        this.lebihBayarNominal13 = lebihBayarNominal13;
    }

    public KantorBayar getKantorBayarBaru() {
        return kantorBayarBaru;
    }

    public void setKantorBayarBaru(KantorBayar kantorBayarBaru) {
        this.kantorBayarBaru = kantorBayarBaru;
    }

    public String getNamaKantorBayarBaru() {
        return namaKantorBayarBaru;
    }

    public void setNamaKantorBayarBaru(String namaKantorBayarBaru) {
        this.namaKantorBayarBaru = namaKantorBayarBaru;
    }

    public Date getTglUsia25PenerimaMPBaru() {
        return tglUsia25PenerimaMPBaru;
    }

    public void setTglUsia25PenerimaMPBaru(Date tglUsia25PenerimaMPBaru) {
        this.tglUsia25PenerimaMPBaru = tglUsia25PenerimaMPBaru;
    }

    public Date getTglPermohonanMps100() {
        return tglPermohonanMps100;
    }

    public void setTglPermohonanMps100(Date tglPermohonanMps100) {
        this.tglPermohonanMps100 = tglPermohonanMps100;
    }

    public Long getIdAlasanMps100() {
        return idAlasanMps100;
    }

    public void setIdAlasanMps100(Long idAlasanMps100) {
        this.idAlasanMps100 = idAlasanMps100;
    }

    public String getNamaAlasanMps100() {
        return namaAlasanMps100;
    }

    public void setNamaAlasanMps100(String namaAlasanMps100) {
        this.namaAlasanMps100 = namaAlasanMps100;
    }

    @Override
    public void fromDto(MutasiPensiunDto dto) {
        this.setId(dto.getId());
        this.setKodeMutasi(dto.getKodeMutasi());
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglMutasi(dto.getTglMutasi());
        this.setNip(dto.getNip());
        this.setNamaPeserta(dto.getNamaPeserta());
        this.setJenisKelaminPeserta(dto.getJenisKelaminPeserta());
        this.setTglLahirPeserta(dto.getTglLahirPeserta());
        this.setTglKerjaPeserta(dto.getTglKerjaPeserta());
        this.setTglDPHTPeserta(dto.getTglDPHTPeserta());
        this.setTglHentiKerjaPeserta(dto.getTglHentiKerjaPeserta());
        this.setTempatMeniggalPeserta(dto.getTempatMeniggalPeserta());
        this.setTglMeniggalPeserta(dto.getTglMeniggalPeserta());
        this.setTempatLahirPeserta(dto.getTempatLahirPeserta());
        this.setGolonganPangkat(dto.getGolonganPangkat());
        this.setNamaAgama(dto.getNamaAgama());
        this.setNamaKantorBayar(dto.getNamaKantorBayar());
        this.setNamaPredikat(dto.getNamaPredikat());
        this.setKeteranganHenti(dto.getKeteranganHenti());
        this.setNoSPBI(dto.getNoSPBI());
        this.setTglSPBI(dto.getTglSPBI());
        this.setNoSKBI(dto.getNoSKBI());
        this.setTglSKBI(dto.getTglSKBI());
        this.setPhdpLama(dto.getPhdpLama());
        this.setUpahVeteran(dto.getUpahVeteran());
        this.setNamaMPS(dto.getNamaMPS());
        this.setNamaKategoriPensiun(dto.getNamaKategoriPensiun());
        this.setNamaUsiaBayar(dto.getNamaUsiaBayar());
        this.setNamaStatusBayar(dto.getNamaStatusBayar());
        this.setTglTundaJatuhTempo(dto.getTglTundaJatuhTempo());
        this.setTglAwalBayar(dto.getTglAwalBayar());
        this.setTglMpBulanKe13(dto.getTglMpBulanKe13());
        this.setTglHentiBayar(dto.getTglHentiBayar());
        this.setPenerimaMP(dto.getPenerimaMP());
        this.setNamaPenerimaMP(dto.getNamaPenerimaMP());
        this.setTglLahirPenerimaMP(dto.getTglLahirPenerimaMP());
        this.setJenisKelaminPenerimaMP(dto.getJenisKelaminPenerimaMP());
        this.setNamaKategoriPenerimaMP(dto.getNamaKategoriPenerimaMP());
        this.setNoSKDAPENBI(dto.getNoSKDAPENBI());
        this.setTglSKDAPENBI(dto.getTglSKDAPENBI());
        this.setTglMenikahLagiPenerimaMP(dto.getTglMenikahLagiPenerimaMP());
        this.setAlamatIsDalamNegeri(dto.isAlamatIsDalamNegeri());
        this.setNamaProvinsi(dto.getNamaProvinsi());
        this.setNamaKota(dto.getNamaKota());
        this.setNamaKecamatan(dto.getNamaKecamatan());
        this.setNamaKelurahan(dto.getNamaKelurahan());
        this.setKodePos(dto.getKodePos());
        this.setRt(dto.getRt());
        this.setRw(dto.getRw());
        this.setAlamatLengkap(dto.getAlamatLengkap());
        this.setNamaNegara(dto.getNamaNegara());
        this.setUsiaSaatHenti(dto.getUsiaSaatHenti());
        this.setUsiaSaatHentiBulat(dto.getUsiaSaatHentiBulat());
        this.setUsiaPenerimaBayar(dto.getUsiaPenerimaBayar());
        this.setUsiaPenerimaBayarBulat(dto.getUsiaPenerimaBayarBulat());
        this.setMasaKerjaHenti(dto.getMasaKerjaHenti());
        this.setMasaKerjaHentiBulat(dto.getMasaKerjaHentiBulat());
        this.setMasaKerjaTambahan(dto.getMasaKerjaTambahan());
        this.setMasaKerjaTambahanBulat(dto.getMasaKerjaTambahanBulat());
        this.setMasaKerjaVeteran(dto.getMasaKerjaVeteran());
        this.setMasaKerjaVeteranBulat(dto.getMasaKerjaVeteranBulat());
        this.setTotalMasaKerja(dto.getTotalMasaKerja());
        this.setNamaFaktorFPR(dto.getNamaFaktorFPR());
        this.setNilaiFPR(dto.getNilaiFPR());
        this.setNamaFaktorFS(dto.getNamaFaktorFS());
        this.setNilaiFS(dto.getNilaiFS());
        this.setMps20PersenLama(dto.getMps20PersenLama());
        this.setMps10JutaLama(dto.getMps10JutaLama());
        this.setMps100PersenLama(dto.getMps100PersenLama());
        this.setMpPerbulanRumusLama(dto.getMpPerbulanRumusLama());
        this.setMpPerbulan20PersenLama(dto.getMpPerbulan20PersenLama());
        this.setMpPerbulan10JutaLama(dto.getMpPerbulan10JutaLama());
        this.setMpydLama(dto.getMpydLama());
        this.setMpBulan13(dto.getMpBulan13());
        this.setMps100PersenBulatLama(dto.getMps100PersenBulatLama());
        this.setNamaSuskel(dto.getNamaSuskel());
        this.setPhdpBaru(dto.getPhdpBaru());
        this.setTglMulaiBerlakuPHDPBaru(dto.getTglMulaiBerlakuPHDPBaru());
        this.setKurangBayarMPYD(dto.getKurangBayarMPYD());
        this.setMps20PersenBaru(dto.getMps20PersenBaru());
        this.setMps10JutaBaru(dto.getMps10JutaBaru());
        this.setMpPerbulanRumusBaru(dto.getMpPerbulanRumusBaru());
        this.setMpPerbulan20PersenBaru(dto.getMpPerbulan20PersenBaru());
        this.setMpPerbulan10JutaBaru(dto.getMpPerbulan10JutaBaru());
        this.setMps100PersenBaru(dto.getMps100PersenBaru());
        this.setMpydBaru(dto.getMpydBaru());
        this.setKurangBayarMPS20Persen(dto.getKurangBayarMPS20Persen());
        this.setKurangBayarMPS10Juta(dto.getKurangBayarMPS10Juta());
        this.setKurangBayarMPS100Persen(dto.getKurangBayarMPS100Persen());
        this.setKurangBayarMPRumus(dto.getKurangBayarMPRumus());
        this.setJadiHutang(dto.getJadiHutang());
        this.setLebihBayarMPS20Persen(dto.getLebihBayarMPS20Persen());
        this.setLebihBayarMPS10Juta(dto.getLebihBayarMPS10Juta());
        this.setLebihBayarMPS100Persen(dto.getLebihBayarMPS100Persen());
        this.setLebihBayarMPRumus(dto.getLebihBayarMPRumus());
        this.setLebihBayarMPYD(dto.getLebihBayarMPYD());
        this.setJadiPiutang(dto.getJadiPiutang());
        this.setKeterangan(dto.getKeterangan());
        this.setNamaStatusKawinPenerimaMP(dto.getNamaStatusKawinPenerimaMP());
        this.setRekeningDAPENBI(dto.getRekeningDAPENBI());
        this.setBank(dto.getBank());
        this.setJenisBank(dto.getJenisBank());
        this.setNamaCabangBank(dto.getNamaCabangBank());
        this.setNamaPadaRekBank(dto.getNamaPadaRekBank());
        this.setNomorRekening(dto.getNomorRekening());
        this.setNoHP(dto.getNoHP());
        this.setEmail(dto.getEmail());
        this.setKeteranganOtomatis(dto.getKeteranganOtomatis());
        this.setUserValidasi(dto.getUserValidasi());
        this.setNamaValidasi(dto.getNamaValidasi());
        this.setTotalMasaKerjaAdj(dto.getTotalMasaKerjaAdj());
        this.setTotalMasaKerjaBulatAdj(dto.getTotalMasaKerjaBulatAdj());
        this.setMpBulan13Baru(dto.getMpBulan13Baru());
        this.setRapelMPYDKurang(dto.getRapelMPYDKurang());
        this.setRapelMPYDLebih(dto.getRapelMPYDLebih());
        this.setNoTlp(dto.getNoTlp());
        this.setActive(dto.getActive());
        this.setUserStamp(dto.getUserStamp());

        this.setPenerimaMPBaru(dto.getPenerimaMPBaru());
        this.setNamaPenerimaMPBaru(dto.getNamaPenerimaMPBaru());
        this.setNamaKategoriPenerimaMPBaru(dto.getNamaKategoriPenerimaMPBaru());
        this.setNamaSuskelBaru(dto.getNamaSuskelBaru());
        this.setLebihBayarJmlBulan(dto.getLebihBayarJmlBulan());
        this.setLebihBayarNominal(dto.getLebihBayarNominal());
        this.setNominalTerbayar(dto.getNominalTerbayar());
        this.setTglInfWftPenerimaMpLama(dto.getTglInfWftPenerimaMpLama());
        this.setTglLahirPenerimaMpBaru(dto.getTglLahirPenerimaMpBaru());
        this.setJenisKelaminPenerimaMPBaru(dto.getJenisKelaminPenerimaMPBaru());
        this.setNamaStatusKawinPenerimaMPBaru(dto.getNamaStatusKawinPenerimaMPBaru());
        this.setTglInfNikahPenerimaMpLama(dto.getTglInfNikahPenerimaMpLama());
        this.setLebihBayarJmlBln13(dto.getLebihBayarJmlBln13());
        this.setLebihBayarNominal13(dto.getLebihBayarNominal13());
        this.setNamaKantorBayarBaru(dto.getNamaKantorBayarBaru());
        this.setTglUsia25PenerimaMPBaru(dto.getTglUsia25PenerimaMPBaru());
        this.setTglPermohonanMps100(dto.getTglPermohonanMps100());
        this.setIdAlasanMps100(dto.getIdAlasanMps100());
        this.setNamaAlasanMps100(dto.getNamaAlasanMps100());

    }

    @Override
    public MutasiPensiunDto toDto() {
        MutasiPensiunDto dto  = new MutasiPensiunDto();
        dto.setId(this.getId());
        dto.setKodeMutasi(this.getKodeMutasi());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglMutasi(this.getTglMutasi());
        dto.setNip(this.getNip());
        dto.setNamaPeserta(this.getNamaPeserta());
        dto.setJenisKelaminPeserta(this.getJenisKelaminPeserta());
        dto.setTglLahirPeserta(this.getTglLahirPeserta());
        dto.setTglKerjaPeserta(this.getTglKerjaPeserta());
        dto.setTglDPHTPeserta(this.getTglDPHTPeserta());
        dto.setTglHentiKerjaPeserta(this.getTglHentiKerjaPeserta());
        dto.setTempatMeniggalPeserta(this.getTempatMeniggalPeserta());
        dto.setTglMeniggalPeserta(this.getTglMeniggalPeserta());
        dto.setTempatLahirPeserta(this.getTempatLahirPeserta());
        dto.setGolonganPangkat(this.getGolonganPangkat());
        dto.setNamaAgama(this.getNamaAgama());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setNamaPredikat(this.getNamaPredikat());
        dto.setKeteranganHenti(this.getKeteranganHenti());
        dto.setNoSPBI(this.getNoSPBI());
        dto.setTglSPBI(this.getTglSPBI());
        dto.setNoSKBI(this.getNoSKBI());
        dto.setTglSKBI(this.getTglSKBI());
        dto.setPhdpLama(this.getPhdpLama());
        dto.setUpahVeteran(this.getUpahVeteran());
        dto.setNamaMPS(this.getNamaMPS());
        dto.setNamaKategoriPensiun(this.getNamaKategoriPensiun());
        dto.setNamaUsiaBayar(this.getNamaUsiaBayar());
        dto.setNamaStatusBayar(this.getNamaStatusBayar());
        dto.setTglTundaJatuhTempo(this.getTglTundaJatuhTempo());
        dto.setTglAwalBayar(this.getTglAwalBayar());
        dto.setTglMpBulanKe13(this.getTglMpBulanKe13());
        dto.setTglHentiBayar(this.getTglHentiBayar());
        dto.setPenerimaMP(this.getPenerimaMP());
        dto.setNamaPenerimaMP(this.getNamaPenerimaMP());
        dto.setTglLahirPenerimaMP(this.getTglLahirPenerimaMP());
        dto.setJenisKelaminPenerimaMP(this.getJenisKelaminPenerimaMP());
        dto.setNamaKategoriPenerimaMP(this.getNamaKategoriPenerimaMP());
        dto.setNoSKDAPENBI(this.getNoSKDAPENBI());
        dto.setTglSKDAPENBI(this.getTglSKDAPENBI());
        dto.setTglMenikahLagiPenerimaMP(this.getTglMenikahLagiPenerimaMP());
        dto.setAlamatIsDalamNegeri(this.isAlamatIsDalamNegeri() == null?false:true);
        dto.setNamaProvinsi(this.getNamaProvinsi());
        dto.setNamaKota(this.getNamaKota());
        dto.setNamaKecamatan(this.getNamaKecamatan());
        dto.setNamaKelurahan(this.getNamaKelurahan());
        dto.setKodePos(this.getKodePos());
        dto.setRt(this.getRt());
        dto.setRw(this.getRw());
        dto.setAlamatLengkap(this.getAlamatLengkap());
        dto.setNamaNegara(this.getNamaNegara());
        dto.setUsiaSaatHenti(this.getUsiaSaatHenti());
        dto.setUsiaSaatHentiBulat(this.getUsiaSaatHentiBulat());
        dto.setUsiaPenerimaBayar(this.getUsiaPenerimaBayar());
        dto.setUsiaPenerimaBayarBulat(this.getUsiaPenerimaBayarBulat());
        dto.setMasaKerjaHenti(this.getMasaKerjaHenti());
        dto.setMasaKerjaHentiBulat(this.getMasaKerjaHentiBulat());
        dto.setMasaKerjaTambahan(this.getMasaKerjaTambahan());
        dto.setMasaKerjaTambahanBulat(this.getMasaKerjaTambahanBulat());
        dto.setMasaKerjaVeteran(this.getMasaKerjaVeteran());
        dto.setMasaKerjaVeteranBulat(this.getMasaKerjaVeteranBulat());
        dto.setTotalMasaKerja(this.getTotalMasaKerja());
        dto.setNamaFaktorFPR(this.getNamaFaktorFPR());
        dto.setNilaiFPR(this.getNilaiFPR());
        dto.setNamaFaktorFS(this.getNamaFaktorFS());
        dto.setNilaiFS(this.getNilaiFS());
        dto.setMps20PersenLama(this.getMps20PersenLama());
        dto.setMps10JutaLama(this.getMps10JutaLama());
        dto.setMps100PersenLama(this.getMps100PersenLama());
        dto.setMpPerbulanRumusLama(this.getMpPerbulanRumusLama());
        dto.setMpPerbulan20PersenLama(this.getMpPerbulan20PersenLama());
        dto.setMpPerbulan10JutaLama(this.getMpPerbulan10JutaLama());
        dto.setMpydLama(this.getMpydLama());
        dto.setMpBulan13(this.getMpBulan13());
        dto.setMps100PersenBulatLama(this.getMps100PersenBulatLama());
        dto.setNamaSuskel(this.getNamaSuskel());
        dto.setPhdpBaru(this.getPhdpBaru());
        dto.setTglMulaiBerlakuPHDPBaru(this.getTglMulaiBerlakuPHDPBaru());
        dto.setKurangBayarMPYD(this.getKurangBayarMPYD());
        dto.setMps20PersenBaru(this.getMps20PersenBaru());
        dto.setMps10JutaBaru(this.getMps10JutaBaru());
        dto.setMpPerbulanRumusBaru(this.getMpPerbulanRumusBaru());
        dto.setMpPerbulan20PersenBaru(this.getMpPerbulan20PersenBaru());
        dto.setMpPerbulan10JutaBaru(this.getMpPerbulan10JutaBaru());
        dto.setMps100PersenBaru(this.getMps100PersenBaru());
        dto.setMpydBaru(this.getMpydBaru());
        dto.setKurangBayarMPS20Persen(this.getKurangBayarMPS20Persen());
        dto.setKurangBayarMPS10Juta(this.getKurangBayarMPS10Juta());
        dto.setKurangBayarMPS100Persen(this.getKurangBayarMPS100Persen());
        dto.setKurangBayarMPRumus(this.getKurangBayarMPRumus());
        dto.setJadiHutang(this.getJadiHutang());
        dto.setLebihBayarMPS20Persen(this.getLebihBayarMPS20Persen());
        dto.setLebihBayarMPS10Juta(this.getLebihBayarMPS10Juta());
        dto.setLebihBayarMPS100Persen(this.getLebihBayarMPS100Persen());
        dto.setLebihBayarMPRumus(this.getLebihBayarMPRumus());
        dto.setLebihBayarMPYD(this.getLebihBayarMPYD());
        dto.setJadiPiutang(this.getJadiPiutang());
        dto.setKeterangan(this.getKeterangan());
        dto.setNamaStatusKawinPenerimaMP(this.getNamaStatusKawinPenerimaMP());
        dto.setRekeningDAPENBI(this.getRekeningDAPENBI());
        dto.setBank(this.getBank());
        dto.setJenisBank(this.getJenisBank());
        dto.setNamaCabangBank(this.getNamaCabangBank());
        dto.setNamaPadaRekBank(this.getNamaPadaRekBank());
        dto.setNomorRekening(this.getNomorRekening());
        dto.setNoHP(this.getNoHP());
        dto.setEmail(this.getEmail());
        dto.setKeteranganOtomatis(this.getKeteranganOtomatis());
        dto.setUserValidasi(this.getUserValidasi());
        dto.setNamaValidasi(this.getNamaValidasi());
        dto.setTotalMasaKerjaAdj(this.getTotalMasaKerjaAdj());
        dto.setTotalMasaKerjaBulatAdj(this.getTotalMasaKerjaBulatAdj());
        dto.setMpBulan13Baru(this.getMpBulan13Baru());
        dto.setRapelMPYDKurang(this.getRapelMPYDKurang());
        dto.setRapelMPYDLebih(this.getRapelMPYDLebih());
        dto.setNoTlp(this.getNoTlp());
        dto.setActive(this.isActive);
        dto.setUserStamp(this.getUserStamp());

        dto.setPenerimaMPBaru(this.getPenerimaMPBaru());
        dto.setNamaPenerimaMPBaru(this.getNamaPenerimaMPBaru());
        dto.setNamaKategoriPenerimaMPBaru(this.getNamaKategoriPenerimaMPBaru());
        dto.setNamaSuskelBaru(this.getNamaSuskelBaru());
        dto.setLebihBayarJmlBulan(this.getLebihBayarJmlBulan());
        dto.setLebihBayarNominal(this.getLebihBayarNominal());
        dto.setNominalTerbayar(this.getNominalTerbayar());
        dto.setTglInfWftPenerimaMpLama(this.getTglInfWftPenerimaMpLama());
        dto.setTglLahirPenerimaMpBaru(this.getTglLahirPenerimaMpBaru());
        dto.setJenisKelaminPenerimaMPBaru(this.getJenisKelaminPenerimaMPBaru());
        dto.setNamaStatusKawinPenerimaMPBaru(this.getNamaStatusKawinPenerimaMPBaru());
        dto.setTglInfNikahPenerimaMpLama(this.getTglInfNikahPenerimaMpLama());
        dto.setLebihBayarJmlBln13(this.getLebihBayarJmlBln13());
        dto.setLebihBayarNominal13(this.getLebihBayarNominal13());
        dto.setNamaKantorBayarBaru(this.getNamaKantorBayarBaru());
        dto.setTglUsia25PenerimaMPBaru(this.getTglUsia25PenerimaMPBaru());
        dto.setTglPermohonanMps100(this.getTglPermohonanMps100());
        dto.setIdAlasanMps100(this.getIdAlasanMps100());
        dto.setNamaAlasanMps100(this.getNamaAlasanMps100());
        dto.setNamaKantorBayar(this.getNamaKantorBayar());
        dto.setNamaKantorBayarBaru(this.getNamaKantorBayarBaru());
        dto.setIdPenerimaMP(this.getPenerimaMP());

        return dto;
    }
}