create table TBL_M_HISTORY_PENSIUN
(
  NIP VARCHAR2(20),
  NAMA_PESERTA VARCHAR2(50),
  JENIS_KELAMIN_PESERTA CHAR,
  TGL_LAHIR_PESERTA DATE,
  TGL_KERJA_PESERTA DATE,
  TGL_DPTHT_PESERTA DATE,
  TGL_HENTI_KERJA_PESERTA DATE,
  TEMPAT_MENINGGAL_PESERTA VARCHAR2(20),
  TGL_MENINGGAL_PESERTA DATE,
  TEMPAT_LAHIR_PESERTA VARCHAR2(20),
  ID_GOLONGAN NUMBER,
  GOLONGAN_PANGKAT VARCHAR2(50),
  ID_AGAMA NUMBER,
  NAMA_AGAMA VARCHAR2(20),
  ID_KANTOR_BAYAR VARCHAR2(10),
  NAMA_KANTOR_BAYAR VARCHAR2(50),
  ID_PREDIKAT NUMBER,
  NAMA_PREDIKAT VARCHAR2(20),
  ID_HENTI NUMBER,
  KETERANGAN_HENTI VARCHAR2(50),
  TGL_SP_BI DATE,
  NO_SP_BI VARCHAR2(50),
  TGL_SK_BI DATE,
  NO_SK_BI VARCHAR2(50),
  PHDP NUMBER(20,2),
  UPAH_VETERAN NUMBER(20,2),
  ID_JENIS_MPS NUMBER,
  NAMA_MPS VARCHAR2(50),
  ID_KATEGORI_PENSIUN VARCHAR2(2),
  NAMA_KATEGORI_PENSIUN VARCHAR2(30),
  ID_USIA_BAYAR NUMBER,
  NAMA_USIA_BAYAR VARCHAR2(50),
  ID_STATUS_BAYAR NUMBER,
  STATUS_BAYAR VARCHAR2(20),
  TGL_TUNDA_JATUH_TEMPO DATE,
  TGL_AWAL_BAYAR DATE,
  TGL_MP_BULAN_KE13 DATE,
  TGL_HENTI_BAYAR DATE,
  ID_PENERIMA_MP VARCHAR2(20),
  NAMA_PENERIMA_MP VARCHAR2(50),
  TGL_LAHIR_PENERIMA_MP DATE,
  JENIS_KELAMIN_PENERIMA_MP CHAR,
  ID_KATEGORI_PENERIMA_MP NUMBER,
  NAMA_KATEGORI_PENERIMA_MP VARCHAR2(20),
  TGL_SK_DAPENBI DATE,
  NO_SK_DAPENBI VARCHAR2(50),
  ALAMAT_IS_DALAM_NEGERI CHAR,
  ID_PROVINSI NUMBER,
  NAMA_PROVINSI VARCHAR2(50),
  ID_KOTA_KAB NUMBER,
  NAMA_KOTA_KAB VARCHAR2(50),
  ID_KECAMATAN NUMBER,
  NAMA_KECAMATAN VARCHAR2(50),
  ID_KELURAHAN NUMBER,
  NAMA_KELURAHAN VARCHAR2(50),
  KODE_POS VARCHAR2(10),
  ALAMAT_LENGKAP VARCHAR2(100),
  RT VARCHAR2(2),
  RW VARCHAR2(2),
  ID_NEGARA VARCHAR2(2),
  NAMA_NEGARA VARCHAR2(50),
  USIA_SAAT_HENTI VARCHAR2(6),
  USIA_SAAT_HENTI_BULAT VARCHAR2(4),
  USIA_PENERIMA_BAYAR VARCHAR2(6),
  USIA_PENERIMA_BAYAR_BULAT VARCHAR2(4),
  MASA_KERJA_TAMBAHAN VARCHAR2(6),
  MASA_KERJA_TAMBAHAN_BULAT VARCHAR2(4),
  MASA_KERJA_VETERAN VARCHAR2(6),
  MASA_KERJA_VETERAN_BULAT VARCHAR2(4),
  TOTAL_MASA_KERJA VARCHAR2(6),
  TOTAL_MASA_KERJA_BULAT VARCHAR2(4),
  MASA_KERJA_MP VARCHAR2(4),
  ID_FAKTOR_FPR NUMBER,
  NAMA_FAKTOR_FPR VARCHAR2(20),
  NILAI_FPR NUMBER(10,8),
  ID_FAKTOR_FS NUMBER,
  NAMA_FAKTOR_FS VARCHAR2(20),
  NILAI_FS NUMBER(10,8),
  MPS_20PERSEN NUMBER(20,2),
  MPS_10JUTA NUMBER(20,2),
  MPS_100PERSEN NUMBER(20,2),
  MP_PERBULAN_RUMUS NUMBER(20,2),
  MP_PERBULAN_20PERSEN NUMBER(20,2),
  MP_PERBULAN_10JUTA NUMBER(20,2),
  MPYD NUMBER(20,2),
  MP_BULAN13 NUMBER(20,2),
  TOTAL_MASA_KERJA_ADJ VARCHAR2(6),
  TOTAL_MASA_KERJA_ADJ_BULAT VARCHAR2(4),
  ID_SUSKEL NUMBER,
  NAMA_SUSKEL VARCHAR2(50),
  ID_STATUS_KAWIN_PENERIMA_MP NUMBER,
  NAMA_STATUS_KAWIN_PENERIMA_MP VARCHAR2(20),
  NO_HP VARCHAR2(20),
  EMAIL VARCHAR2(20),
  KETERANGAN_OTOMATIS VARCHAR2(500),
  IS_ACTIVE CHAR,
  MASA_KERJA_HENTI VARCHAR2(6),
  MASA_KERJA_HENTI_BULAT VARCHAR2(4),
  REF_ID_MUTASI NUMBER,
  REF_HISTORY_BY_ID_MUTASI NUMBER,
  ID_HISTORY_PENSIUN NUMBER not null
    constraint TBL_M_HISTORY_PENSIUN_PK
    primary key,
  TGL_USIA_25T_PENERIMA_MP DATE,
  MPS_100PERSEN_BULAT NUMBER(20,2),
  FAKTOR_FS VARCHAR2(30),
  NO_TLP VARCHAR2(20)
)
/

create trigger TBL_M_HISTORY_PENSIUN_TRG
  before insert
  on TBL_M_HISTORY_PENSIUN
  for each row
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID_HISTORY_PENSIUN IS NULL THEN
        SELECT TBL_M_HISTORY_PENSIUN_SEQ.NEXTVAL INTO :NEW.ID_HISTORY_PENSIUN FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/