create or replace TYPE MPS100_VALID AS OBJECT
( /* TODO enter attribute and method declarations here */
  STATUS char(1),
  REMARKS VARCHAR2(500)
);

/

create or replace TYPE TABLE_SIMULASI_MP
AS TABLE OF SIMULASI_MP;

/

create or replace type simulasi_mp as object
( usia_henti varchar(6),
  usia_henti_bulat varchar(4),
  usia_bayar varchar(6),
  usia_bayar_bulat varchar(4),
  mk_henti varchar(6),
  mk_henti_bulat varchar(4),
  mk_tambahan varchar(6),
  mk_tambahan_bulat varchar(4),
  mk_veteran varchar(6),
  mk_veteran_bulat varchar(4),
  total_mk varchar(6),
  total_mk_bulat varchar(4),
  total_mk_adj varchar(6),
  total_mk_bulat_adj varchar(4),
  mk_mp varchar(4),
  id_fpr number,
  fpr number (14,6),
  fpr_name varchar(20),
  id_fs number,
  fs number (14,6),
  fs_name varchar(20),
  fs_status varchar(20),
  phdp number(15,6),
  mp_perbulan_rumus number(15,6),
  mp_perbulan_mps20persen number(15,6),
  mps_20persen number(15,6),
  mp_perbulan_mps10juta number(15,6),
  mps_10juta number(20,6),
  mpyd number(15,6),
  mp_bulanke13 number(15,6),
  mps_100persen number(20,6),
  mps_100persen_bulat number(20,6),
  kurang_bayar_mp number (15,6)
);

/

create or replace TYPE TABLE_MPS100_VALID
AS TABLE OF MPS100_VALID;

/

create or replace function cufn_count_age
  (
      age_type in varchar2
    , origin_date in date
    , dest_date in date
  ) return varchar2 as
  actual_age varchar(6);
  rounded_age varchar(4);
  result varchar(6);

  begin


    select substr('00' || drv_age.actual_year, -2) ||
           substr('00' || drv_age.actual_month,-2) ||
           substr('00' || drv_age.actual_day, -2) ,
           substr('00' || drv_age.rounded_year, -2) ||
           substr('00' || drv_age.rounded_month,-2)  into actual_age, rounded_age
    from (
         select trunc(months_between(origin_date,dob)/12) actual_year,
                trunc(mod(months_between(origin_date,dob),12))   actual_month,
                trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) actual_day,
                case when  trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) > 1 and  trunc(mod(months_between(origin_date,dob),12))  + 1 =  12 then trunc(months_between(origin_date,dob)/12) + 1
                     else trunc(months_between(origin_date,dob)/12) end as rounded_year,

                case when  trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) > 1 and trunc(mod(months_between(origin_date,dob),12))  + 1 <> 12 then trunc(mod(months_between(origin_date,dob),12))  + 1
                     when trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) > 1 and  trunc(mod(months_between(origin_date,dob),12))  + 1 =  12 then 0 else
                    trunc(mod(months_between(origin_date,dob),12))  end as rounded_month,

                case when      trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) > 1 then 0 else      trunc(origin_date-add_months(dob,trunc(months_between(origin_date,dob)/12)*12+trunc(mod(months_between(origin_date,dob),12)))) end as rounded_day
         from (Select to_date(dest_date,'dd-MM-yyyy') dob from dual))  drv_age;


    IF age_type = 1 THEN
      result := actual_age;

    ELSE
      result := rounded_age;

    END IF;



    RETURN result;
  end
    cufn_count_age;

/

create or replace function cufn_mp_simulation_2
  (
      tgl_lahir_peserta in date
    , tgl_kerja_peserta in date
    , tgl_henti_peserta in date
    , tgl_dptht_peserta in date
    , id_kategori_penerima in number
    , tgl_lahir_penerima in date
    , tgl_awal_bayar_mp in date
    , id_kategori_pensiun in varchar2
    , id_jenis_mps in number
    , id_status_kawin in number
    , id_usia_bayar in number
    , phdp in number
    , tgl_mutasi in date
    , periode_mutasi in varchar2
  )  return TABLE_SIMULASI_MP   is
  usia_henti varchar(6);
  usia_henti_bulat varchar(4);
  usia_bayar varchar(6);
  usia_bayar_bulat varchar(4);
  mk_henti varchar(6);
  mk_henti_bulat varchar(4);
  mk_tambahan varchar(6);
  mk_tambahan_bulat varchar(4);
  mk_veteran varchar(6);
  mk_veteran_bulat varchar(4);
  total_mk varchar(6);
  tahun_mk number;
  total_mk_bulat varchar(4);
  total_mk_adj varchar(6);
  total_mk_bulat_adj varchar(4);
  mk_mp varchar(4);
  id_fpr number := NULL;
  fpr number (14,6) := NULL;
  fpr_name varchar(20) := NULL;
  id_fs number;
  fs number (14,6);
  fs_name varchar(20);
  fs_status varchar(20);
  mp_perbulan_rumus number (15,2) := NULL;
  mp_perbulan_mps20persen number(15,2) := NULL;
  mps_20persen number(15,2) := NULL;
  mp_perbulan_mps10juta number(15,2) := NULL;
  mps_10juta number(20,2) := NULL;
  mpyd number(15,6) := NULL;
  mp_bulanke13 number (15,2) := NULL;
  mps_100persen number(20,2) := NULL;
  mps_100persen_bulat number(20) := NULL;
  tgl_56t date;
  mk_mp_tahun number(15,2) := NULL;
  mk_mp_bulan number(15,2):= NULL;
  kurang_bayar_mp number(15,2);
  kurang_bayar_mp_period number;
  v_ret TABLE_SIMULASI_MP;
  begin
    v_ret  := TABLE_SIMULASI_MP();
    select cufn_count_age(1, tgl_henti_peserta, tgl_lahir_peserta) into usia_henti from dual;
    select cufn_count_age(2, tgl_henti_peserta, tgl_lahir_peserta) into usia_henti_bulat from dual;
    select cufn_count_age(1, tgl_awal_bayar_mp, tgl_lahir_penerima) into usia_bayar from dual;
    select cufn_count_age(2, tgl_awal_bayar_mp, tgl_lahir_penerima) into usia_bayar_bulat from dual;
    select cufn_count_age(1, tgl_henti_peserta, tgl_kerja_peserta) into mk_henti from dual;
    select cufn_count_age(2, tgl_henti_peserta, tgl_kerja_peserta) into mk_henti_bulat from dual;

    if id_kategori_pensiun = 'PC' then
      SELECT add_months( tgl_lahir_peserta, 56*12 ) into tgl_56t FROM DUAL;
      select cufn_count_age(1, tgl_56t, tgl_henti_peserta) into mk_tambahan from dual;
      select cufn_count_age(2, tgl_56t, tgl_henti_peserta) into mk_tambahan_bulat from dual;

      select cufn_count_age(1, tgl_56t, tgl_kerja_peserta) into total_mk from dual;
      select cufn_count_age(2, tgl_56t, tgl_kerja_peserta) into total_mk_bulat from dual;

    else

      select cufn_count_age(1, tgl_henti_peserta, tgl_kerja_peserta) into total_mk from dual;
      select cufn_count_age(2, tgl_henti_peserta, tgl_kerja_peserta) into total_mk_bulat from dual;
      mk_tambahan := '000000';
      mk_tambahan_bulat := '0000';
    end if;
    select to_number(substr(total_mk, 1, 2)) into tahun_mk  from dual;
    if tahun_mk >= 32 then
      total_mk_adj := '320000';
      total_mk_bulat_adj := '3200';
    else
      total_mk_adj := total_mk;
      total_mk_bulat_adj := total_mk_bulat;
    end if;
    --
    mk_veteran := '000000';
    mk_veteran_bulat := '0000';
    mk_mp := total_mk_bulat_adj;

    BEGIN
      select a.id_faktor_fpr, b.nilai_fpr, a.nama_faktor_fpr into id_fpr, fpr, fpr_name from tbl_r_faktor_fpr a inner join TBL_R_AKTUARIA_FPR b
                                                                                                 on b.id_faktor_fpr = a.id_faktor_fpr
      where (tgl_henti_peserta between a.tgl_awal and a.tgl_akhir) and usia_fpr = usia_bayar_bulat;
      EXCEPTION
      WHEN NO_DATA_FOUND THEN
      id_fpr := NULL;
      fpr := NULL;
      fpr_name := NULL;
    END;
    -- LOOK UP FS
    --1	Pria Lajang
    --2	Pria Kawin
    --3	Wanita Lajang
    --4	Wanita Kawin
    --5	Anak Pria
    --6	Anak Wanita

    if id_kategori_penerima <> 11 then --APABILA PENERIMA ADALAH BUKAN AHLI WARIS NS dihitung dari tanggal awal bayar
      begin
        select a.id_faktor_fs, case when id_status_kawin = 1 then  b.fs_prialajang when id_status_kawin = 2 then b.fs_priakawin when id_status_kawin=3 then b.fs_wanitalajang
                                    when id_status_kawin = 4 then b.fs_wanitakawin when id_status_kawin = 5 then b.fs_priaanak else b.fs_wanitaanak end as nilai_fs,
               a.nama_faktor_fs , case when id_status_kawin = 1 then 'PRIA LAJANG' when id_status_kawin = 2 then 'PRIA KAWIN' when id_status_kawin=3 then 'WANITA LAJANG'
                                       when id_status_kawin = 4 then 'WANITA KAWIN' when id_status_kawin = 5 then 'PRIA ANAK' else 'WANITA ANAK' end as fs_status
            into id_fs,  fs, fs_name, fs_status from tbl_r_faktor_fs a inner join TBL_R_AKTUARIA_FS b
                                                         on b.id_faktor_fs = a.id_faktor_fs
        where (tgl_henti_peserta between a.tgl_awal and a.tgl_akhir) and usia_fs = usia_bayar_bulat;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
        id_fs := NULL;
        fs := NULL;
        fs_name := NULL;
        fs_status := NULL;
      END;
    else --APABILA PENERIMA ADALAH AHLI WARIS NS dihitung dari tanggal berhenti/meninggal dunia
      begin
        select a.id_faktor_fs, case when id_status_kawin = 1 then  b.fs_prialajang when id_status_kawin = 2 then b.fs_priakawin when id_status_kawin=3 then b.fs_wanitalajang
                                    when id_status_kawin = 4 then b.fs_wanitakawin when id_status_kawin = 5 then b.fs_priaanak else b.fs_wanitaanak end as nilai_fs,
               a.nama_faktor_fs,  case when id_status_kawin = 1 then 'PRIA LAJANG' when id_status_kawin = 2 then 'PRIA KAWIN' when id_status_kawin=3 then 'WANITA LAJANG'
                                       when id_status_kawin = 4 then 'WANITA KAWIN' when id_status_kawin = 5 then 'PRIA ANAK' else 'WANITA ANAK' end as fs_status
            into id_fs, fs, fs_name, fs_status from tbl_r_faktor_fs a inner join TBL_R_AKTUARIA_FS b
                                                        on b.id_faktor_fs = a.id_faktor_fs
        where (tgl_henti_peserta between a.tgl_awal and a.tgl_akhir) and usia_fs = usia_henti_bulat;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
        id_fs := NULL;
        fS := NULL;
        fs_name := NULL;
        fs_status := NULL;
      END;
    end if;

    -- MPS
    --    1	MPS 20%
    --    2	MPS 10 Juta
    --    3	MPS 100%
    --    4	MPS 20% + MPS 10 Juta
    --    5	Tidak Ambil MPS

    --PN	PENSIUN NORMAL
    --PS	PENSIUN SEKALIGUS
    --PD	PENSIUN DIPERCEPAT
    --PT	PENSIUN TUNDA
    --PC	PENSIUN CACAT/MENINGGAL

    select to_number(substr(mk_mp, 1, 2)) into mk_mp_tahun  from dual;
    select to_number(substr(mk_mp, 3, 2)) into mk_mp_bulan  from dual;
    if (id_kategori_pensiun = 'PN' or (id_kategori_pensiun = 'PC' and id_kategori_penerima=1) OR (id_kategori_pensiun = 'PT'  AND id_usia_bayar = 1)
        OR (id_kategori_pensiun = 'PD' and id_usia_bayar = 1) )then --USIA NORMAL atau PENSIUN CACAT atau PENSIUN TUNDA USIA BAYAR NORMAL ATAU PENSIUN DIPERCEPAT USIA BAYAR NORMAL
      mp_perbulan_rumus := 0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp  ;
      if id_jenis_mps = 1   then
        mps_20persen := 0.2 * (fs*12*mp_perbulan_rumus);
        mp_perbulan_mps20persen := 0.8 * mp_perbulan_rumus;
        mpyd := mp_perbulan_mps20persen;
      ELSIF  id_jenis_mps = 2  then
        mps_10juta := (mp_perbulan_rumus - 10000000)*fs*12;
        mp_perbulan_mps10juta := 10000000;
        mpyd := mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 4  then
        mps_20persen := 0.2 * (fs*12*mp_perbulan_rumus);
        mp_perbulan_mps20persen := 0.8 * mp_perbulan_rumus;
        mps_10juta := (mp_perbulan_mps20persen - 10000000)*fs*12;
        mp_perbulan_mps10juta := 10000000;
        mpyd := mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 5  then
        mp_perbulan_rumus := 0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
        mpyd := mp_perbulan_rumus;
      ELSIF  id_jenis_mps = 3 then
        mps_100persen :=   fs * 12 * mp_perbulan_rumus;
        SELECT ROUND(mps_100persen, -2) into  mps_100persen_bulat FROM DUAL;
        mpyd := null;
      end if;
    ELSIF  ((id_kategori_pensiun = 'PD' and id_usia_bayar = 2) OR (id_kategori_pensiun = 'PT'  AND id_usia_bayar = 2))  THEN --PENSIUN DIPERCEPAT PILIH BAYAR DIPERCEPAT ATAU PENSIUN TUNDA PILIH BAYAR DIPERCEPAT
      mp_perbulan_rumus := fpr*0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
      if id_jenis_mps = 1   then
        mps_20persen := 0.2 * (fs*12*mp_perbulan_rumus);
        mp_perbulan_mps20persen := 0.8 * mp_perbulan_rumus;
        mpyd := mp_perbulan_mps20persen;
      ELSIF  id_jenis_mps = 2  then
        mps_10juta := (mp_perbulan_rumus - 10000000)*fs*12;
        mp_perbulan_mps10juta := 10000000;
        mpyd := mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 4  then
        mps_20persen := 0.2 * (fs*12*mp_perbulan_rumus);
        mp_perbulan_mps20persen := 0.8 *mp_perbulan_rumus;
        mps_10juta := (mp_perbulan_mps20persen - 10000000)*fs*12;
        mp_perbulan_mps10juta := 10000000;
        mpyd := mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 5  then
        mpyd := mp_perbulan_rumus;
      ELSIF  id_jenis_mps = 3 then
        mps_100persen :=   fs * 12 * mp_perbulan_rumus;
        SELECT ROUND(mps_100persen, -2) into  mps_100persen_bulat FROM DUAL;
        mpyd := null;
      end if;
    ELSIF  (id_kategori_pensiun = 'PC' and id_kategori_penerima <> 1)  then -- PENSIUN MENINGGAL PENERIMA JANDA/DUDA
      mp_perbulan_rumus := 0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
      mp_bulanke13 := 0.8 * mp_perbulan_rumus;
      if (id_jenis_mps = 1)   then
        mps_20persen := 0.2 * ((0.2 * 1 * 12 * mp_perbulan_rumus) + (0.8 * fs * 12 * mp_perbulan_rumus));
        mp_perbulan_mps20persen := 0.8 * mp_perbulan_rumus;
        mpyd := mp_perbulan_mps20persen;
        mp_bulanke13 := 0.8 * mp_bulanke13;
      ELSIF  id_jenis_mps = 2  then
        mps_10juta := 0.2 * ((0.2 * 1 * 12 * (mp_perbulan_rumus-10000000)) + (0.8 * fs * 12 * (mp_perbulan_rumus-10000000)));
        mp_perbulan_mps10juta := 10000000;
        mpyd:= mp_perbulan_mps10juta;
        mp_bulanke13 := 0.8 * mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 4  then
        mps_20persen := 0.2 * ((0.2 * 1 * 12 * mp_perbulan_rumus) + (0.8 * fs * 12 * mp_perbulan_rumus));
        mp_perbulan_mps20persen := 0.8 * mp_perbulan_rumus;
        mps_10juta := 0.2 * ((0.2 * 1 * 12 * (mp_perbulan_mps20persen-10000000)) + (0.8 * fs * 12 * (mp_perbulan_mps20persen-10000000)));
        mp_perbulan_mps10juta := 10000000;
        mpyd:= mp_perbulan_mps10juta;
        mp_bulanke13 := 0.8 * mp_perbulan_mps10juta;
      ELSIF  id_jenis_mps = 5  then
        mpyd:= mp_perbulan_rumus;
      ELSIF  id_jenis_mps = 3 then
        mps_100persen :=   fs * 12 * mp_perbulan_rumus;
        SELECT ROUND(mps_100persen, -2) into  mps_100persen_bulat FROM DUAL;
        mpyd:= null;
      end if;
    ELSIF  (id_kategori_pensiun = 'PS' and  id_kategori_penerima = 11) then --PENSIUN SEKALIGUS and PENERIMA ADALAH AHLI WARIS
      mp_perbulan_rumus := 0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
      if id_jenis_mps = 3 then
        mps_100persen :=   fs * 12 * mp_perbulan_rumus;
        SELECT ROUND(mps_100persen, -2) into  mps_100persen_bulat FROM DUAL;
        mpyd:= null;
      end if;
    ELSIF  (id_kategori_pensiun = 'PS' and  id_kategori_penerima <> 11) THEN --PENSIUN SEKALIGUS and PENERIMA BUKAN AHLI WARIS
      mp_perbulan_rumus := fpr*0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
      if (id_jenis_mps = 3) then
        mps_100persen :=   fs * 12 * mp_perbulan_rumus;
        SELECT ROUND(mps_100persen, -2) into  mps_100persen_bulat FROM DUAL;
        mpyd:= null;
      end if;
    end if;

    -- HITUNG KURANG BAYAR MP
    if (id_jenis_mps <> 3) or ( (id_kategori_pensiun <> 'PD' and id_usia_bayar <> 2) and (id_kategori_pensiun <> 'PT')) then
      select count(*) into kurang_bayar_mp_period from tbl_t_setup_parameter  where    ( to_date(tbl_t_setup_parameter.tgl_awal_bayar) >= tgl_awal_bayar_mp)
                                                                                and (to_date(tbl_t_setup_parameter.periode, 'mmyyyy') <  to_date(periode_mutasi, 'mmyyyy')) ;

      kurang_bayar_mp := kurang_bayar_mp_period * mpyd;
    end if;

    v_ret.extend; v_ret(v_ret.count) := SIMULASI_MP(usia_henti, usia_henti_bulat, usia_bayar, usia_bayar_bulat, mk_henti, mk_henti_bulat, mk_tambahan, mk_tambahan_bulat, mk_veteran, mk_veteran_bulat,
                                                    total_mk, total_mk_bulat, total_mk_adj, total_mk_bulat_adj, mk_mp, id_fpr, fpr, fpr_name, id_fs, fs, fs_name, fs_status, phdp, mp_perbulan_rumus, mp_perbulan_mps20persen, mps_20persen, mp_perbulan_mps10juta,
                                                    mps_10juta, mpyd, mp_bulanke13, mps_100persen, mps_100persen_bulat, kurang_bayar_mp);

    --return  SIMULASI_MP('000000', '0000');
    return v_ret;


  end
    cufn_mp_simulation_2;

create or replace FUNCTION CUFN_CEK_MPS100PERSEN_VALID
(
tgl_lahir_peserta IN DATE,
tgl_kerja_peserta IN DATE,
tgl_henti_peserta IN DATE,
tgl_awal_bayar_mp in date,
tgl_lahir_penerima in date,
ID_KATEGORI_PENSIUN IN VARCHAR2,
phdp in number
) RETURN TABLE_MPS100_VALID is
usia_henti varchar(6);
usia_henti_bulat varchar(4);
usia_bayar varchar(6);
usia_bayar_bulat varchar(4);
mk_henti varchar(6);
mk_henti_bulat varchar(4);
mk_tambahan varchar(6);
mk_tambahan_bulat varchar(4);
mk_veteran varchar(6);
mk_veteran_bulat varchar(4);
total_mk varchar(6);
tahun_mk number;
total_mk_bulat varchar(4);
total_mk_adj varchar(6);
total_mk_bulat_adj varchar(4);
mk_mp varchar(4);
tgl_56t date;
status char(1);
remarks varchar(500);
mk_mp_tahun number(15,2);
mk_mp_bulan number(15,2);
fpr number (14,6);
mp_perbulan_rumus number (20,2);
batas_nominal_mps100 number(20,2);
v_ret TABLE_MPS100_VALID;

BEGIN
  v_ret  := TABLE_MPS100_VALID();
  select to_number(nilai_config) into batas_nominal_mps100 from TBL_R_APP_CONFIG WHERE ID_CONFIG = 3;
  select cufn_count_age(1, tgl_henti_peserta, tgl_lahir_peserta) into usia_henti from dual;
  select cufn_count_age(2, tgl_henti_peserta, tgl_lahir_peserta) into usia_henti_bulat from dual;
  select cufn_count_age(1, tgl_henti_peserta, tgl_kerja_peserta) into mk_henti from dual;
  select cufn_count_age(2, tgl_henti_peserta, tgl_kerja_peserta) into mk_henti_bulat from dual;
  select cufn_count_age(1, tgl_awal_bayar_mp, tgl_lahir_penerima) into usia_bayar from dual;
  select cufn_count_age(2, tgl_awal_bayar_mp, tgl_lahir_penerima) into usia_bayar_bulat from dual;

  if id_kategori_pensiun = 'PC' then
    SELECT add_months( tgl_lahir_peserta, 56*12 ) into tgl_56t FROM DUAL;
    select cufn_count_age(1, tgl_56t, tgl_henti_peserta) into mk_tambahan from dual;
    select cufn_count_age(2, tgl_56t, tgl_henti_peserta) into mk_tambahan_bulat from dual;

    select cufn_count_age(1, tgl_56t, tgl_kerja_peserta) into total_mk from dual;
    select cufn_count_age(2, tgl_56t, tgl_kerja_peserta) into total_mk_bulat from dual;

  else

    select cufn_count_age(1, tgl_henti_peserta, tgl_kerja_peserta) into total_mk from dual;
    select cufn_count_age(2, tgl_henti_peserta, tgl_kerja_peserta) into total_mk_bulat from dual;
    mk_tambahan := '000000';
    mk_tambahan_bulat := '0000';
  end if;
  select to_number(substr(total_mk, 1, 2)) into tahun_mk  from dual;
  if tahun_mk >= 32 then
    total_mk_adj := '320000';
    total_mk_bulat_adj := '3200';
  else
    total_mk_adj := total_mk;
    total_mk_bulat_adj := total_mk_bulat;
  end if;
  --
  mk_veteran := '000000';
  mk_veteran_bulat := '0000';
  mk_mp := total_mk_bulat_adj;
  select to_number(substr(mk_mp, 1, 2)) into mk_mp_tahun  from dual;
  select to_number(substr(mk_mp, 3, 2)) into mk_mp_bulan  from dual;



  BEGIN
    select  b.nilai_fpr into  fpr from tbl_r_faktor_fpr a inner join TBL_R_AKTUARIA_FPR b
                                           on b.id_faktor_fpr = a.id_faktor_fpr
    where (tgl_henti_peserta between a.tgl_awal and a.tgl_akhir) and usia_fpr = usia_bayar_bulat;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
    fpr := NULL;
  END;

  if ( fpr is null) then
    STATUS := '0';
    SELECT CONCAT('Nilai FPR tidak ditemukan pada USIA BAYAR ', usia_bayar_bulat) INTO REMARKS FROM DUAL;
  else
    mp_perbulan_rumus := fpr*0.025*(mk_mp_tahun + mk_mp_bulan /12)*phdp;
    if (mp_perbulan_rumus < batas_nominal_mps100)then
      STATUS := '1';
      SELECT CONCAT('Berhak Mengambil MPS 100% Karena MP Bulanannya sebesar : ', to_char(mp_perbulan_rumus)) INTO REMARKS FROM DUAL;
    else
      STATUS := '0';
      SELECT CONCAT('Tidak Berhak Mengambil MPS 100% Karena MP Bulanannya sebesar : ', to_char(mp_perbulan_rumus)) INTO REMARKS FROM DUAL;
    end if;
  end if;

  v_ret.extend; v_ret(v_ret.count) := MPS100_VALID(STATUS, REMARKS  );

  RETURN v_ret;
END CUFN_CEK_MPS100PERSEN_VALID;

/

create or replace PROCEDURE CUSP_MUTASI_PENSIUN_BARU
  (
      ROLE_ID IN NUMBER
    , COMP_NAME  IN VARCHAR2
    , USER_NAME IN VARCHAR2
    , PAR_ID_MUTASI IN NUMBER
    , PAR_KODE_MUTASI IN VARCHAR2
    , PAR_ID_KATEGORI_MUTASI IN VARCHAR2
    , PAR_PERIODE_MUTASI IN VARCHAR2
    , PAR_TGL_MUTASI IN date
    , PAR_NIP IN VARCHAR2
    , PAR_NAMA_PESERTA IN VARCHAR2
    , PAR_JENIS_KELAMIN_PESERTA IN VARCHAR2
    , PAR_TGL_LAHIR_PESERTA IN DATE
    , PAR_TGL_KERJA_PESERTA IN DATE
    , PAR_TGL_DPTHT_PESERTA IN DATE
    , PAR_TGL_HENTI_KERJA_PESERTA IN DATE
    , PAR_TEMPAT_MENINGGAL_PESERTA IN VARCHAR2
    , PAR_TGL_MENINGGAL_PESERTA IN DATE
    , PAR_TEMPAT_LAHIR_PESERTA IN VARCHAR2
    , PAR_ID_GOLONGAN IN NUMBER
    , PAR_GOLONGAN_PANGKAT IN VARCHAR2
    , PAR_ID_AGAMA IN NUMBER
    , PAR_NAMA_AGAMA IN VARCHAR2
    , PAR_ID_KANTOR_BAYAR IN VARCHAR2
    , PAR_NAMA_KANTOR_BAYAR IN VARCHAR2
    , PAR_ID_PREDIKAT IN NUMBER
    , PAR_NAMA_PREDIKAT IN VARCHAR2
    , PAR_ID_HENTI IN VARCHAR2
    , PAR_KETERANGAN_HENTI IN VARCHAR2
    , PAR_TGL_SP_BI IN DATE
    , PAR_NO_SP_BI IN VARCHAR2
    , PAR_TGL_SK_BI IN DATE
    , PAR_NO_SK_BI IN VARCHAR2
    , PAR_PHDP_LAMA IN NUMBER
    , PAR_UPAH_VETERAN IN NUMBER
    , PAR_ID_JENIS_MPS IN NUMBER
    , PAR_NAMA_MPS IN VARCHAR2
    , PAR_ID_KATEGORI_PENSIUN IN VARCHAR2
    , PAR_NAMA_KATEGORI_PENSIUN IN VARCHAR2
    , PAR_ID_USIA_BAYAR IN NUMBER
    , PAR_NAMA_USIA_BAYAR IN VARCHAR2
    , PAR_ID_STATUS_BAYAR IN NUMBER
    , PAR_STATUS_BAYAR IN VARCHAR2
    , PAR_ID_STATUS_KAWIN IN NUMBER
    , PAR_NAMA_STATUS_KAWIN IN VARCHAR2
    , PAR_TGL_TUNDA_JATUH_TEMPO IN DATE
    , PAR_TGL_AWAL_BAYAR IN DATE
    , PAR_TGL_MP_BULAN_KE13 IN DATE
    , PAR_TGL_HENTI_BAYAR IN DATE
    , PAR_ID_PENERIMA_MP IN varchar2
    , PAR_NAMA_PENERIMA_MP IN VARCHAR2
    , PAR_TGL_LAHIR_PENERIMA_MP IN DATE
    , PAR_JENIS_KELAMIN_PENERIMA_MP IN VARCHAR2
    , PAR_ID_KATEGORI_PENERIMA_MP IN NUMBER
    , PAR_NAMA_KATEGORI_PENERIMA_MP IN VARCHAR2
    , PAR_TGL_SK_DAPENBI IN DATE
    , PAR_NO_SK_DAPENBI IN VARCHAR2
    , PAR_TGL_USIA25T_PENERIMA_MP IN DATE
    , PAR_ALAMAT_IS_DALAM_NEGERI IN CHAR
    , PAR_ID_PROVINSI IN NUMBER
    , PAR_NAMA_PROVINSI IN VARCHAR2
    , PAR_ID_KOTA_KAB IN NUMBER
    , PAR_NAMA_KOTA_KAB IN VARCHAR2
    , PAR_ID_KECAMATAN IN NUMBER
    , PAR_NAMA_KECAMATAN IN VARCHAR2
    , PAR_ID_KELURAHAN IN NUMBER
    , PAR_NAMA_KELURAHAN IN VARCHAR2
    , PAR_KODE_POS IN VARCHAR2
    , PAR_ALAMAT_LENGKAP IN VARCHAR2
    , PAR_RT IN VARCHAR2
    , PAR_RW IN VARCHAR2
    , PAR_ID_NEGARA IN NUMBER
    , PAR_NAMA_NEGARA IN VARCHAR2
    , PAR_ID_SUSKEL IN NUMBER
    , PAR_NAMA_SUSKEL IN VARCHAR2
    , PAR_ID_KATEGORI_CATATAN IN NUMBER
    , PAR_NAMA_CATATAN IN VARCHAR2
    , PAR_ID_KAWIN_PENERIMA_MP IN NUMBER
    , PAR_NAMA_KAWIN_PENERIMA_MP IN VARCHAR2
    --, PAR_IS_REKENING_DAPENBI IN CHAR
    --, PAR_ID_BANK IN NUMBER
    --, PAR_JENIS_BANK IN VARCHAR2
    --, PAR_NAMA_CABANG_BANK IN VARCHAR2
    --, PAR_NAMA_PADA_REK_BANK IN VARCHAR2
    --, PAR_NOMOR_REKENING IN VARCHAR2
    , PAR_NO_HP IN VARCHAR2
    , PAR_NO_TLP IN VARCHAR2
    , PAR_EMAIL IN VARCHAR2
    , PAR_ID_VALIDASI IN NUMBER
    , PAR_NAMA_VALIDASI IN VARCHAR2
    , PAR_USER_STAMP IN VARCHAR2
    , PAR_USER_VALIDASI IN VARCHAR2
    , PAR_KETERANGAN IN VARCHAR2
    , PAR_STATUS_EKSEKUSI OUT CHAR
    , PAR_MSG OUT VARCHAR2
    , PAR_ID_MUTASI_VAL OUT NUMBER

  ) IS

  PAR_USIA_SAAT_HENTI  VARCHAR2(6);
  PAR_USIA_SAAT_HENTI_BULAT VARCHAR2(4);
  PAR_USIA_PENERIMA_BAYAR  VARCHAR2(6);
  PAR_USIA_PENERIMA_BAYAR_BULAT varchar(4);
  PAR_MASA_KERJA_HENTI  VARCHAR2(6);
  PAR_MASA_KERJA_HENTI_BULAT varchar(4);
  PAR_MASA_KERJA_TAMBAHAN VARCHAR2(6);
  PAR_MASA_KERJA_TAMBAHAN_BULAT varchar(4);
  PAR_MASA_KERJA_VETERAN VARCHAR2(6);
  PAR_MASA_KERJA_VETERAN_BULAT VARCHAR2(4);
  PAR_TOTAL_MASA_KERJA VARCHAR2(6);
  PAR_TOTAL_MASA_KERJA_BULAT VARCHAR2(4);
  PAR_TOTAL_MASA_KERJA_ADJ VARCHAR2(6);
  PAR_TOTAL_MASA_KERJA_BULAT_ADJ VARCHAR2(4);
  PAR_MASA_KERJA_MP VARCHAR2(4);
  PAR_ID_FAKTOR_FPR  NUMBER;
  PAR_NAMA_FAKTOR_FPR  VARCHAR2(20);
  PAR_NILAI_FPR NUMBER(10, 8);
  PAR_ID_FAKTOR_FS NUMBER;
  PAR_NAMA_FAKTOR_FS  VARCHAR2(20);
  PAR_NILAI_FS  NUMBER(10,8);
  PAR_STATUS_FS VARCHAR2(20);
  PAR_MPS_20PERSEN_LAMA  NUMBER(20,2);
  PAR_MPS_10JUTA_LAMA  NUMBER(20,2);
  PAR_MPS_100PERSEN_LAMA  NUMBER(20,2);
  PAR_MP_PERBULAN_RUMUS_LAMA  NUMBER(20,2);
  PAR_MP_PERBULAN_20PERSEN_LAMA  NUMBER(20,2);
  PAR_MP_PERBULAN_10JUTA_LAMA  NUMBER(20,2);
  PAR_MPYD_LAMA  NUMBER(20,2);
  PAR_MP_BULAN13  NUMBER(20,2);
  PAR_MPS_100PERSEN_BULAT_LAMA  NUMBER(20);
  PAR_KURANG_BAYAR_MPYD  NUMBER(20,2);

  USER_STAMP_NEW  VARCHAR2(100);
  USER_VALIDASI_NEW VARCHAR2(100);
  OTOMATIS_STAMP VARCHAR2(100);
  OTOMATIS_VALIDASI VARCHAR(100);
  TIMESTAMP VARCHAR(20);
  NEW_ID_MUTASI NUMBER;
  --NEW_ID_HUTANG NUMBER;
  --IS_JADI_HUTANG_UPDATE CHAR(1);
  --ID_BANK_UPDATE NUMBER;
  --JENIS_BANK_UPDATE VARCHAR(50);
  --NAMA_CABANG_BANK_UPDATE VARCHAR(50);
  --NAMA_PADA_REK_BANK_UPDATE VARCHAR(50);
  --NOMOR_REKENING_UPDATE VARCHAR(50);
  KETERANGAN_OTOMATIS_UPDATE VARCHAR(500);
  MASTER_EXISTS NUMBER;
  MASTER_KURANG_BAYAR_EXISTS CHAR(1);
  --MASTER_HUTANG_EXISTS CHAR(1);
  --MASTER_REKENING_EXISTS CHAR(1);
  SALDO_AKHIR_KURANG_BAYAR NUMBER(20,2);
  --SALDO_AKHIR_HUTANG NUMBER(20,2);
  ERR_MSG VARCHAR(500);
  BEGIN
    SAVEPOINT sp_mutasi_pensiun_baru;
    --    IF (PAR_IS_REKENING_DAPENBI = 1) THEN
    --        SELECT NILAI_CONFIG INTO NOMOR_REKENING_UPDATE FROM TBL_R_APP_CONFIG WHERE ID_CONFIG=1;
    --        ID_BANK_UPDATE := 4;
    --        JENIS_BANK_UPDATE := 'DAPENBI';
    --        NAMA_CABANG_BANK_UPDATE := 'BANK MANDIRI CAB. BIDAKARA';
    --        NAMA_PADA_REK_BANK_UPDATE := 'DAPENBI';
    --        IS_JADI_HUTANG_UPDATE := 1;
    --    ELSE
    --        ID_BANK_UPDATE := PAR_ID_BANK;
    --        JENIS_BANK_UPDATE := PAR_JENIS_BANK;
    --        NAMA_CABANG_BANK_UPDATE := PAR_NAMA_CABANG_BANK;
    --        NAMA_PADA_REK_BANK_UPDATE := PAR_NAMA_PADA_REK_BANK;
    --        NOMOR_REKENING_UPDATE := PAR_NOMOR_REKENING;
    --        IS_JADI_HUTANG_UPDATE := 0;
    --    END IF;
    SELECT TO_CHAR(cURRENT_TIMESTAMP,'DD-MM-YYYY HH24:MI:SS')  INTO TIMESTAMP FROM DUAL;

    select x.usia_henti, x.usia_henti_bulat, x.usia_bayar, x.usia_bayar_bulat, x.mk_henti, x.mk_henti_bulat,x.mk_TAMBAHAN, x.mk_TAMBAHAN_bulat,  x.mk_veteran, x.mk_veteran_bulat,
           x.total_mk, x.total_mk_bulat, x.total_mk_adj, x.total_mk_bulat_adj, x.mk_mp, x.id_fpr, x.fpr, x.fpr_name, x.id_fs,  x.fs,  x.fs_name, x.fs_status,
           x.mp_perbulan_rumus, x.mp_perbulan_mps20persen, x.mps_20persen, x.mp_perbulan_mps10juta, x.mps_10juta, x.mpyd, x.mp_bulanke13,
           x.mps_100persen, x.mps_100persen_bulat, x.kurang_bayar_mp
        INTO par_usia_saat_henti, par_usia_saat_henti_bulat, par_usia_penerima_bayar, par_usia_penerima_bayar_bulat, par_masa_kerja_henti, par_masa_kerja_henti_bulat,
          par_masa_kerja_tambahan, par_masa_kerja_tambahan_bulat, par_masa_kerja_veteran, par_masa_kerja_veteran_bulat, par_total_masa_kerja, par_total_masa_kerja_bulat,
          par_total_masa_kerja_adj, par_total_masa_kerja_bulat_adj, par_masa_kerja_mp, par_id_faktor_fpr, par_nilai_fpr ,par_nama_faktor_fpr, par_id_faktor_fs, par_nilai_fs, par_nama_faktor_fs, par_status_fs,
          par_mp_perbulan_rumus_lama, PAR_MP_PERBULAN_20PERSEN_LAMA, par_mps_20persen_lama, PAR_MP_PERBULAN_10JUTA_LAMA, par_mps_10juta_lama, par_mpyd_lama, par_mp_bulan13,
          PAR_MPS_100PERSEN_LAMA, PAR_MPS_100PERSEN_BULAT_LAMA, par_kurang_bayar_mpyd
    from
         (select * FROM TABLE(cufn_mp_simulation_2(to_date(par_tgl_lahir_peserta),  to_date(par_tgl_kerja_peserta),to_date(par_tgl_henti_KERJA_peserta), to_date(PAR_TGL_DPTHT_PESERTA), PAR_ID_KATEGORI_PENERIMA_MP, to_date(PAR_TGL_LAHIR_PENERIMA_MP), to_date(PAR_TGL_AWAL_BAYAR),
                                                   PAR_ID_KATEGORI_PENSIUN, PAR_ID_JENIS_MPS, PAR_ID_KAWIN_PENERIMA_MP,PAR_ID_USIA_BAYAR,PAR_PHDP_LAMA,  to_date(PAR_TGL_MUTASI),
                                                   PAR_PERIODE_MUTASI)))x;


    --    select a.id_faktor_fpr, b.nilai_fpr, a.nama_faktor_fpr into id_fpr, fpr, fpr_name from tbl_r_faktor_fpr a inner join TBL_R_AKTUARIA_FPR b
    --    on b.id_faktor_fpr = a.id_faktor_fpr
    --    where (tgl_henti_peserta between a.tgl_awal and a.tgl_akhir) and usia_fpr = usia_bayar_bulat;



    IF ROLE_ID = 43 then -- staff
      IF (PAR_ID_MUTASI IS NULL) THEN --DATA BARU MODE INSERT

        USER_STAMP_NEW := 'BARU : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;

        SELECT CASE WHEN MAX(ID_MUTASI_PENSIUN) IS NULL THEN 1 ELSE MAX(ID_MUTASI_PENSIUN) + 1 END INTO NEW_ID_MUTASI FROM TBL_T_MUTASI_PENSIUN;
        INSERT INTO TBL_T_MUTASI_PENSIUN (ID_MUTASI_PENSIUN, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
                                          TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
                                          ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
                                          ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
                                          TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
                                          TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
                                          KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT, MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
                                          TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS, FAKTOR_FS, NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
                                          MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD,
                                          ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP, NO_HP, NO_TLP, EMAIL,
                                          ID_VALIDASI, NAMA_VALIDASI, IS_ACTIVE, USER_STAMP)

        VALUES (NEW_ID_MUTASI, '01', '01', PAR_PERIODE_MUTASI, PAR_TGL_MUTASI, PAR_NIP, PAR_NAMA_PESERTA, PAR_JENIS_KELAMIN_PESERTA, PAR_TGL_LAHIR_PESERTA,
                PAR_TGL_KERJA_PESERTA, PAR_TGL_DPTHT_PESERTA, PAR_TGL_HENTI_KERJA_PESERTA, PAR_TEMPAT_MENINGGAL_PESERTA, PAR_TGL_MENINGGAL_PESERTA, PAR_TEMPAT_LAHIR_PESERTA, PAR_ID_GOLONGAN, PAR_GOLONGAN_PANGKAT,
                PAR_ID_AGAMA, PAR_NAMA_AGAMA, PAR_ID_KANTOR_BAYAR, PAR_NAMA_KANTOR_BAYAR, PAR_ID_PREDIKAT, PAR_NAMA_PREDIKAT, PAR_ID_HENTI, PAR_KETERANGAN_HENTI, PAR_TGL_SP_BI, PAR_NO_SP_BI, PAR_TGL_SK_BI, PAR_NO_SK_BI, PAR_PHDP_LAMA, PAR_UPAH_VETERAN,
                PAR_ID_JENIS_MPS, PAR_NAMA_MPS, PAR_ID_KATEGORI_PENSIUN, PAR_NAMA_KATEGORI_PENSIUN, PAR_ID_USIA_BAYAR,PAR_NAMA_USIA_BAYAR, PAR_ID_STATUS_BAYAR, PAR_STATUS_BAYAR, PAR_TGL_TUNDA_JATUH_TEMPO, PAR_TGL_AWAL_BAYAR,
                PAR_TGL_MP_BULAN_KE13, PAR_TGL_HENTI_BAYAR, PAR_ID_PENERIMA_MP, PAR_NAMA_PENERIMA_MP, PAR_TGL_LAHIR_PENERIMA_MP, PAR_JENIS_KELAMIN_PENERIMA_MP, PAR_ID_KATEGORI_PENERIMA_MP, PAR_NAMA_KATEGORI_PENERIMA_MP,
                PAR_TGL_SK_DAPENBI, PAR_NO_SK_DAPENBI, PAR_TGL_USIA25T_PENERIMA_MP, PAR_ALAMAT_IS_DALAM_NEGERI, PAR_ID_PROVINSI, PAR_NAMA_PROVINSI, PAR_ID_KOTA_KAB,PAR_NAMA_KOTA_KAB,PAR_ID_KECAMATAN, PAR_NAMA_KECAMATAN, PAR_ID_KELURAHAN, PAR_NAMA_KELURAHAN,
                PAR_KODE_POS, PAR_ALAMAT_LENGKAP, PAR_RT, PAR_RW, PAR_ID_NEGARA, PAR_NAMA_NEGARA, PAR_USIA_SAAT_HENTI, PAR_USIA_SAAT_HENTI_BULAT, PAR_USIA_PENERIMA_BAYAR, PAR_USIA_PENERIMA_BAYAR_BULAT, PAR_MASA_KERJA_HENTI, PAR_MASA_KERJA_HENTI_BULAT, PAR_MASA_KERJA_TAMBAHAN, PAR_MASA_KERJA_TAMBAHAN_BULAT, PAR_MASA_KERJA_VETERAN, PAR_MASA_KERJA_VETERAN_BULAT,
                PAR_TOTAL_MASA_KERJA, PAR_TOTAL_MASA_KERJA_BULAT,PAR_TOTAL_MASA_KERJA_ADJ, PAR_TOTAL_MASA_KERJA_BULAT_ADJ, PAR_MASA_KERJA_MP, PAR_ID_FAKTOR_FPR, PAR_NAMA_FAKTOR_FPR, PAR_NILAI_FPR, PAR_ID_FAKTOR_FS, PAR_NAMA_FAKTOR_FS, PAR_STATUS_FS,  PAR_NILAI_FS, PAR_MPS_20PERSEN_LAMA, PAR_MPS_10JUTA_LAMA,
                PAR_MPS_100PERSEN_LAMA, PAR_MP_PERBULAN_RUMUS_LAMA, PAR_MP_PERBULAN_20PERSEN_LAMA, PAR_MP_PERBULAN_10JUTA_LAMA, PAR_MPYD_LAMA, PAR_MP_BULAN13, PAR_MPS_100PERSEN_BULAT_LAMA, PAR_ID_SUSKEL, PAR_NAMA_SUSKEL, PAR_KURANG_BAYAR_MPYD,
                PAR_ID_KATEGORI_CATATAN, PAR_KETERANGAN, KETERANGAN_OTOMATIS_UPDATE, PAR_ID_KAWIN_PENERIMA_MP, PAR_NAMA_KAWIN_PENERIMA_MP,  PAR_NO_HP, PAR_NO_TLP, PAR_EMAIL,
                PAR_ID_VALIDASI, PAR_NAMA_VALIDASI, 1, USER_STAMP_NEW);

        --            -- INSERT HISTORY STATUS MUTASI
        INSERT INTO tbl_t_history_status_mutasi
            (id_mutasi_pensiun, id_validasi, nama_validasi, user_stamp, user_validasi, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
             TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
             ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
             ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
             TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
             TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
             KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
             TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS, FAKTOR_FS,  NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
             MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD,
             ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP, NO_HP, NO_TLP, EMAIL,
             IS_ACTIVE)
        SELECT ID_MUTASI_PENSIUN, ID_VALIDASI, NAMA_VALIDASI, USER_STAMP, USER_VALIDASI, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
               TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
               ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
               ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
               TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
               TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
               KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
               TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS,  FAKTOR_FS, NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
               MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD,
               ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP, NO_HP, NO_TLP, EMAIL,
               IS_ACTIVE FROM TBL_T_MUTASI_PENSIUN WHERE ID_MUTASI_PENSIUN = NEW_ID_MUTASI;

        PAR_ID_MUTASI_VAL := NEW_ID_MUTASI;

      ELSE -- DATA LAMA MODE EDIT
        if (PAR_id_validasi = 4) then
          USER_STAMP_NEW := 'BATAL DATA : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
        ELSE
          USER_STAMP_NEW := 'EDIT : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
        end if;

        UPDATE TBL_T_MUTASI_PENSIUN
        SET  NAMA_PESERTA = par_NAMA_PESERTA, JENIS_KELAMIN_PESERTA = PAR_JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA = PAR_TGL_LAHIR_PESERTA,
             TGL_KERJA_PESERTA = par_TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA = PAR_TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA = PAR_TGL_HENTI_KERJA_PESERTA,
             TEMPAT_MENINGGAL_PESERTA = PAR_TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA=PAR_TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA=PAR_TEMPAT_LAHIR_PESERTA,
             ID_GOLONGAN=PAR_ID_GOLONGAN, GOLONGAN_PANGKAT=PAR_GOLONGAN_PANGKAT,
             ID_AGAMA= PAR_ID_AGAMA, NAMA_AGAMA= PAR_NAMA_AGAMA, ID_KANTOR_BAYAR=PAR_ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR=PAR_NAMA_KANTOR_BAYAR, ID_PREDIKAT=PAR_ID_PREDIKAT,
             NAMA_PREDIKAT=PAR_NAMA_PREDIKAT, ID_HENTI=PAR_ID_HENTI, KETERANGAN_HENTI=PAR_KETERANGAN_HENTI, TGL_SP_BI=PAR_TGL_SP_BI, NO_SP_BI=PAR_NO_SP_BI, TGL_SK_BI=PAR_TGL_SK_BI, NO_SK_BI=PAR_NO_SK_BI, PHDP_LAMA=PAR_PHDP_LAMA, UPAH_VETERAN=PAR_UPAH_VETERAN,
             ID_JENIS_MPS=PAR_ID_JENIS_MPS, NAMA_MPS=PAR_NAMA_MPS, ID_KATEGORI_PENSIUN=PAR_ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN=PAR_NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR=PAR_ID_USIA_BAYAR,
             NAMA_USIA_BAYAR=PAR_NAMA_USIA_BAYAR, ID_STATUS_BAYAR=PAR_ID_STATUS_BAYAR, STATUS_BAYAR=PAR_STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO=PAR_TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR=PAR_TGL_AWAL_BAYAR,
             TGL_MP_BULAN_KE13=PAR_TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR=PAR_TGL_HENTI_BAYAR, ID_PENERIMA_MP=PAR_ID_PENERIMA_MP, NAMA_PENERIMA_MP=PAR_NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP=PAR_TGL_LAHIR_PENERIMA_MP,
             JENIS_KELAMIN_PENERIMA_MP=PAR_JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP=PAR_ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP=PAR_NAMA_KATEGORI_PENERIMA_MP,
             TGL_SK_DAPENBI=PAR_TGL_SK_DAPENBI, NO_SK_DAPENBI=PAR_NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP=PAR_TGL_USIA25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI=PAR_ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI=PAR_ID_PROVINSI,
             NAMA_PROVINSI=PAR_NAMA_PROVINSI, ID_KOTA_KAB=PAR_ID_KOTA_KAB, NAMA_KOTA_KAB=PAR_NAMA_KOTA_KAB,ID_KECAMATAN=PAR_ID_KECAMATAN, NAMA_KECAMATAN=PAR_NAMA_KECAMATAN, ID_KELURAHAN=PAR_ID_KELURAHAN, NAMA_KELURAHAN=PAR_NAMA_KELURAHAN,
             KODE_POS=PAR_KODE_POS, ALAMAT_LENGKAP=PAR_ALAMAT_LENGKAP, RT=PAR_RT, RW=PAR_RW, ID_NEGARA=PAR_ID_NEGARA, NAMA_NEGARA=PAR_NAMA_NEGARA, USIA_SAAT_HENTI=PAR_USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT=PAR_USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR=PAR_USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT=PAR_USIA_PENERIMA_BAYAR_BULAT,
             MASA_KERJA_HENTI = PAR_MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT=PAR_MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN=PAR_MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT=PAR_MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN=PAR_MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT=PAR_MASA_KERJA_VETERAN_BULAT,
             TOTAL_MASA_KERJA=PAR_TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT=PAR_TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ=PAR_TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ=PAR_TOTAL_MASA_KERJA_BULAT_ADJ,
             MASA_KERJA_MP=PAR_MASA_KERJA_MP, ID_FAKTOR_FPR=PAR_ID_FAKTOR_FPR, NAMA_FAKTOR_FPR=PAR_NAMA_FAKTOR_FPR, NILAI_FPR=PAR_NILAI_FPR, ID_FAKTOR_FS=PAR_ID_FAKTOR_FS, NAMA_FAKTOR_FS=PAR_NAMA_FAKTOR_FS,FAKTOR_FS=PAR_STATUS_FS,  NILAI_FS=PAR_NILAI_FS, MPS_20PERSEN_LAMA=PAR_MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA=PAR_MPS_10JUTA_LAMA,
             MPS_100PERSEN_LAMA=PAR_MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA=PAR_MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA=PAR_MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA=PAR_MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA=PAR_MPYD_LAMA, MP_BULAN13=PAR_MP_BULAN13, MPS_100PERSEN_BULAT_LAMA=PAR_MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL=PAR_ID_SUSKEL, NAMA_SUSKEL=PAR_NAMA_SUSKEL, KURANG_BAYAR_MPYD=PAR_KURANG_BAYAR_MPYD,
             ID_KATEGORI_CATATAN=PAR_ID_KATEGORI_CATATAN, KETERANGAN=PAR_KETERANGAN, KETERANGAN_OTOMATIS=KETERANGAN_OTOMATIS_UPDATE, ID_STATUS_KAWIN_PENERIMA_MP=PAR_ID_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP=PAR_NAMA_KAWIN_PENERIMA_MP,
             NO_HP=PAR_NO_HP, NO_TLP=PAR_NO_TLP, EMAIL=PAR_EMAIL,
             ID_VALIDASI=PAR_ID_VALIDASI, NAMA_VALIDASI=PAR_NAMA_VALIDASI, IS_ACTIVE=1, USER_STAMP=USER_STAMP_NEW, USER_VALIDASI = PAR_USER_VALIDASI
        WHERE ID_MUTASI_PENSIUN = PAR_ID_MUTASI;
        --
        --            -- INSERT HISTORY STATUS MUTASI
        INSERT INTO tbl_t_history_status_mutasi
            (id_mutasi_pensiun, id_validasi, nama_validasi, user_stamp, user_validasi, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
             TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
             ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
             ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
             TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
             TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
             KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
             TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS,FAKTOR_FS,  NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
             MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD, IS_JADI_HUTANG,
             ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP,  NO_HP, NO_TLP, EMAIL,
             IS_ACTIVE)
        SELECT ID_MUTASI_PENSIUN, ID_VALIDASI, NAMA_VALIDASI, USER_STAMP, USER_VALIDASI, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
               TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
               ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
               ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
               TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
               TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
               KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
               TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS, FAKTOR_FS, NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
               MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD, IS_JADI_HUTANG,
               ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP, NO_HP, NO_TLP, EMAIL,
               IS_ACTIVE FROM TBL_T_MUTASI_PENSIUN WHERE ID_MUTASI_PENSIUN = PAR_ID_MUTASI;

        PAR_ID_MUTASI_VAL := PAR_ID_MUTASI;
      END IF;

    ELSE     -- ROLE PEJABAT, DATA LAMA MODE EDIT
      if (PAR_id_validasi = 2) then
        USER_VALIDASI_NEW := 'VALID : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
      elsif (PAR_id_validasi = 3) then
        USER_VALIDASI_NEW := 'KOREKSI : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
      elsif (PAR_id_validasi = 4) then
        USER_VALIDASI_NEW := 'BATAL DATA : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
      end if;
      UPDATE TBL_T_MUTASI_PENSIUN
      SET  NAMA_PESERTA = par_NAMA_PESERTA, JENIS_KELAMIN_PESERTA = PAR_JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA = PAR_TGL_LAHIR_PESERTA,
           TGL_KERJA_PESERTA = par_TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA = PAR_TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA = PAR_TGL_HENTI_KERJA_PESERTA,
           TEMPAT_MENINGGAL_PESERTA = PAR_TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA=PAR_TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA=PAR_TEMPAT_LAHIR_PESERTA,
           ID_GOLONGAN=PAR_ID_GOLONGAN, GOLONGAN_PANGKAT=PAR_GOLONGAN_PANGKAT,
           ID_AGAMA= PAR_ID_AGAMA, NAMA_AGAMA= PAR_NAMA_AGAMA, ID_KANTOR_BAYAR=PAR_ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR=PAR_NAMA_KANTOR_BAYAR, ID_PREDIKAT=PAR_ID_PREDIKAT,
           NAMA_PREDIKAT=PAR_NAMA_PREDIKAT, ID_HENTI=PAR_ID_HENTI, KETERANGAN_HENTI=PAR_KETERANGAN_HENTI, TGL_SP_BI=PAR_TGL_SP_BI, NO_SP_BI=PAR_NO_SP_BI, TGL_SK_BI=PAR_TGL_SK_BI, NO_SK_BI=PAR_NO_SK_BI, PHDP_LAMA=PAR_PHDP_LAMA, UPAH_VETERAN=PAR_UPAH_VETERAN,
           ID_JENIS_MPS=PAR_ID_JENIS_MPS, NAMA_MPS=PAR_NAMA_MPS, ID_KATEGORI_PENSIUN=PAR_ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN=PAR_NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR=PAR_ID_USIA_BAYAR,
           NAMA_USIA_BAYAR=PAR_NAMA_USIA_BAYAR, ID_STATUS_BAYAR=PAR_ID_STATUS_BAYAR, STATUS_BAYAR=PAR_STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO=PAR_TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR=PAR_TGL_AWAL_BAYAR,
           TGL_MP_BULAN_KE13=PAR_TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR=PAR_TGL_HENTI_BAYAR, ID_PENERIMA_MP=PAR_ID_PENERIMA_MP, NAMA_PENERIMA_MP=PAR_NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP=PAR_TGL_LAHIR_PENERIMA_MP,
           JENIS_KELAMIN_PENERIMA_MP=PAR_JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP=PAR_ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP=PAR_NAMA_KATEGORI_PENERIMA_MP,
           TGL_SK_DAPENBI=PAR_TGL_SK_DAPENBI, NO_SK_DAPENBI=PAR_NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP=PAR_TGL_USIA25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI=PAR_ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI=PAR_ID_PROVINSI,
           NAMA_PROVINSI=PAR_NAMA_PROVINSI, ID_KOTA_KAB=PAR_ID_KOTA_KAB, NAMA_KOTA_KAB=PAR_NAMA_KOTA_KAB,ID_KECAMATAN=PAR_ID_KECAMATAN, NAMA_KECAMATAN=PAR_NAMA_KECAMATAN, ID_KELURAHAN=PAR_ID_KELURAHAN, NAMA_KELURAHAN=PAR_NAMA_KELURAHAN,
           KODE_POS=PAR_KODE_POS, ALAMAT_LENGKAP=PAR_ALAMAT_LENGKAP, RT=PAR_RT, RW=PAR_RW, ID_NEGARA=PAR_ID_NEGARA, NAMA_NEGARA=PAR_NAMA_NEGARA, USIA_SAAT_HENTI=PAR_USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT=PAR_USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR=PAR_USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT=PAR_USIA_PENERIMA_BAYAR_BULAT,
           MASA_KERJA_HENTI = PAR_MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT=PAR_MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN=PAR_MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT=PAR_MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN=PAR_MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT=PAR_MASA_KERJA_VETERAN_BULAT,
           TOTAL_MASA_KERJA=PAR_TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT=PAR_TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ=PAR_TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ=PAR_TOTAL_MASA_KERJA_BULAT_ADJ,
           MASA_KERJA_MP=PAR_MASA_KERJA_MP, ID_FAKTOR_FPR=PAR_ID_FAKTOR_FPR, NAMA_FAKTOR_FPR=PAR_NAMA_FAKTOR_FPR, NILAI_FPR=PAR_NILAI_FPR, ID_FAKTOR_FS=PAR_ID_FAKTOR_FS, NAMA_FAKTOR_FS=PAR_NAMA_FAKTOR_FS, FAKTOR_FS=PAR_STATUS_FS,  NILAI_FS=PAR_NILAI_FS, MPS_20PERSEN_LAMA=PAR_MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA=PAR_MPS_10JUTA_LAMA,
           MPS_100PERSEN_LAMA=PAR_MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA=PAR_MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA=PAR_MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA=PAR_MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA=PAR_MPYD_LAMA, MP_BULAN13=PAR_MP_BULAN13, MPS_100PERSEN_BULAT_LAMA=PAR_MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL=PAR_ID_SUSKEL, NAMA_SUSKEL=PAR_NAMA_SUSKEL, KURANG_BAYAR_MPYD=PAR_KURANG_BAYAR_MPYD,
           ID_KATEGORI_CATATAN=PAR_ID_KATEGORI_CATATAN, KETERANGAN=PAR_KETERANGAN, KETERANGAN_OTOMATIS=KETERANGAN_OTOMATIS_UPDATE, ID_STATUS_KAWIN_PENERIMA_MP=PAR_ID_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP=PAR_NAMA_KAWIN_PENERIMA_MP, NO_HP=PAR_NO_HP, NO_TLP=PAR_NO_TLP,  EMAIL=PAR_EMAIL,
           ID_VALIDASI=PAR_ID_VALIDASI, NAMA_VALIDASI=PAR_NAMA_VALIDASI, IS_ACTIVE=1, USER_VALIDASI = USER_VALIDASI_NEW
      WHERE ID_MUTASI_PENSIUN = PAR_ID_MUTASI;
      --          -- INSERT HISTORY STATUS MUTASI
      INSERT INTO tbl_t_history_status_mutasi
          (id_mutasi_pensiun, id_validasi, nama_validasi, user_stamp, user_validasi, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
           TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
           ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
           ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
           TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
           TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
           KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
           TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS,FAKTOR_FS,  NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
           MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD,
           ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP, NO_HP, NO_TLP, EMAIL,
           IS_ACTIVE)
      SELECT ID_MUTASI_PENSIUN, ID_VALIDASI, NAMA_VALIDASI, USER_STAMP, USER_VALIDASI, KODE_MUTASI, ID_KATEGORI_MUTASI, PERIODE_MUTASI, TGL_MUTASI, NIP, NAMA_PESERTA, JENIS_KELAMIN_PESERTA, TGL_LAHIR_PESERTA,
             TGL_KERJA_PESERTA, TGL_DPTHT_PESERTA, TGL_HENTI_KERJA_PESERTA, TEMPAT_MENINGGAL_PESERTA, TGL_MENINGGAL_PESERTA, TEMPAT_LAHIR_PESERTA, ID_GOLONGAN, GOLONGAN_PANGKAT,
             ID_AGAMA, NAMA_AGAMA, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, ID_PREDIKAT, NAMA_PREDIKAT, ID_HENTI, KETERANGAN_HENTI, TGL_SP_BI, NO_SP_BI, TGL_SK_BI, NO_SK_BI, PHDP_LAMA, UPAH_VETERAN,
             ID_JENIS_MPS, NAMA_MPS, ID_KATEGORI_PENSIUN, NAMA_KATEGORI_PENSIUN, ID_USIA_BAYAR, NAMA_USIA_BAYAR, ID_STATUS_BAYAR, STATUS_BAYAR, TGL_TUNDA_JATUH_TEMPO, TGL_AWAL_BAYAR,
             TGL_MP_BULAN_KE13, TGL_HENTI_BAYAR, ID_PENERIMA_MP, NAMA_PENERIMA_MP, TGL_LAHIR_PENERIMA_MP, JENIS_KELAMIN_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
             TGL_SK_DAPENBI, NO_SK_DAPENBI, TGL_USIA_25T_PENERIMA_MP, ALAMAT_IS_DALAM_NEGERI, ID_PROVINSI, NAMA_PROVINSI, ID_KOTA_KAB, NAMA_KOTA_KAB,ID_KECAMATAN, NAMA_KECAMATAN, ID_KELURAHAN, NAMA_KELURAHAN,
             KODE_POS, ALAMAT_LENGKAP, RT, RW, ID_NEGARA, NAMA_NEGARA, USIA_SAAT_HENTI, USIA_SAAT_HENTI_BULAT, USIA_PENERIMA_BAYAR, USIA_PENERIMA_BAYAR_BULAT,MASA_KERJA_HENTI, MASA_KERJA_HENTI_BULAT, MASA_KERJA_TAMBAHAN, MASA_KERJA_TAMBAHAN_BULAT, MASA_KERJA_VETERAN, MASA_KERJA_VETERAN_BULAT,
             TOTAL_MASA_KERJA, TOTAL_MASA_KERJA_BULAT,TOTAL_MASA_KERJA_ADJ, TOTAL_MASA_KERJA_BULAT_ADJ, MASA_KERJA_MP, ID_FAKTOR_FPR, NAMA_FAKTOR_FPR, NILAI_FPR, ID_FAKTOR_FS, NAMA_FAKTOR_FS, FAKTOR_FS, NILAI_FS, MPS_20PERSEN_LAMA, MPS_10JUTA_LAMA,
             MPS_100PERSEN_LAMA, MP_PERBULAN_RUMUS_LAMA, MP_PERBULAN_20PERSEN_LAMA, MP_PERBULAN_10JUTA_LAMA, MPYD_LAMA, MP_BULAN13, MPS_100PERSEN_BULAT_LAMA, ID_SUSKEL, NAMA_SUSKEL, KURANG_BAYAR_MPYD,
             ID_KATEGORI_CATATAN,  KETERANGAN, KETERANGAN_OTOMATIS, ID_STATUS_KAWIN_PENERIMA_MP, NAMA_STATUS_KAWIN_PENERIMA_MP,NO_HP, NO_TLP, EMAIL,
             IS_ACTIVE FROM TBL_T_MUTASI_PENSIUN WHERE ID_MUTASI_PENSIUN = PAR_ID_MUTASI;
      --
      SELECT COUNT(*) INTO MASTER_EXISTS FROM TBL_M_PENSIUN WHERE NIP = PAR_NIP;
      --INSERT KE MASTER JIKA STATUS_VALIDASI ADALAH 'SUDAH VALIDASI (ID = 2)
      if (PAR_id_validasi = 2 AND MASTER_EXISTS = 0) then -- mode insert
        INSERT INTO tbl_m_pensiun (nip,nama_peserta,jenis_kelamin_peserta,tgl_lahir_peserta,tgl_kerja_peserta,tgl_dptht_peserta,tgl_henti_kerja_peserta,tempat_meninggal_peserta,
                                   tgl_meninggal_peserta,tempat_lahir_peserta,id_golongan,golongan_pangkat,id_agama,nama_agama,id_kantor_bayar,nama_kantor_bayar,id_predikat,nama_predikat,
                                   id_henti,keterangan_henti,tgl_sp_bi,no_sp_bi,tgl_sk_bi,no_sk_bi,phdp,upah_veteran,id_jenis_mps,nama_mps,id_kategori_pensiun,nama_kategori_pensiun,id_usia_bayar,
                                   nama_usia_bayar,id_status_bayar,status_bayar,tgl_tunda_jatuh_tempo,tgl_awal_bayar,tgl_mp_bulan_ke13,tgl_henti_bayar,id_penerima_mp,nama_penerima_mp,
                                   tgl_lahir_penerima_mp,jenis_kelamin_penerima_mp,id_kategori_penerima_mp,nama_kategori_penerima_mp,tgl_sk_dapenbi, no_sk_dapenbi,alamat_is_dalam_negeri,id_provinsi,nama_provinsi,id_kota_kab,
                                   nama_kota_kab,id_kecamatan,nama_kecamatan,id_kelurahan,nama_kelurahan,kode_pos,alamat_lengkap, rt,rw,id_negara,nama_negara,usia_saat_henti,
                                   usia_saat_henti_bulat,usia_penerima_bayar,usia_penerima_bayar_bulat,masa_kerja_tambahan,masa_kerja_tambahan_bulat,masa_kerja_veteran,masa_kerja_veteran_bulat,
                                   total_masa_kerja,total_masa_kerja_bulat,masa_kerja_mp,id_faktor_fpr,nama_faktor_fpr,nilai_fpr,id_faktor_fs,nama_faktor_fs, FAKTOR_FS, nilai_fs,mps_20persen,
                                   mps_10juta, mps_100persen, mp_perbulan_rumus, mp_perbulan_20persen, mp_perbulan_10juta,mpyd,mp_bulan13,
                                   total_masa_kerja_adj,total_masa_kerja_adj_bulat, id_suskel,nama_suskel,id_status_kawin_penerima_mp,nama_status_kawin_penerima_mp,no_hp, no_tlp,
                                   email,keterangan_otomatis,is_active, masa_kerja_henti, masa_kerja_henti_bulat, REF_ID_MUTASI)
        select nip,nama_peserta,jenis_kelamin_peserta,tgl_lahir_peserta,tgl_kerja_peserta,tgl_dptht_peserta,tgl_henti_kerja_peserta,tempat_meninggal_peserta,
               tgl_meninggal_peserta,tempat_lahir_peserta,id_golongan,golongan_pangkat,id_agama,nama_agama,id_kantor_bayar,nama_kantor_bayar,id_predikat,nama_predikat,
               id_henti,keterangan_henti,tgl_sp_bi,no_sp_bi,tgl_sk_bi,no_sk_bi,phdp_lama,upah_veteran,id_jenis_mps,nama_mps,id_kategori_pensiun,nama_kategori_pensiun,id_usia_bayar,
               nama_usia_bayar,id_status_bayar,status_bayar,tgl_tunda_jatuh_tempo,tgl_awal_bayar,tgl_mp_bulan_ke13,tgl_henti_bayar,id_penerima_mp,nama_penerima_mp,
               tgl_lahir_penerima_mp,jenis_kelamin_penerima_mp,id_kategori_penerima_mp,nama_kategori_penerima_mp,tgl_sk_dapenbi, no_sk_dapenbi,alamat_is_dalam_negeri,id_provinsi,nama_provinsi,id_kota_kab,
               nama_kota_kab,id_kecamatan,nama_kecamatan,id_kelurahan,nama_kelurahan,kode_pos,alamat_lengkap, rt,rw,id_negara,nama_negara,usia_saat_henti,
               usia_saat_henti_bulat,usia_penerima_bayar,usia_penerima_bayar_bulat,masa_kerja_tambahan,masa_kerja_tambahan_bulat,masa_kerja_veteran,masa_kerja_veteran_bulat,
               total_masa_kerja,total_masa_kerja_bulat,masa_kerja_mp,id_faktor_fpr,nama_faktor_fpr,nilai_fpr,id_faktor_fs,nama_faktor_fs, FAKTOR_FS, nilai_fs,mps_20persen_lama,
               mps_10juta_lama, mps_100persen_lama, mp_perbulan_rumus_lama, mp_perbulan_20persen_lama, mp_perbulan_10juta_lama,mpyd_lama,mp_bulan13,
               total_masa_kerja_adj,total_masa_kerja_bulat_adj, id_suskel,nama_suskel,id_status_kawin_penerima_mp,nama_status_kawin_penerima_mp,no_hp,no_tlp,
               email,keterangan_otomatis,is_active, masa_kerja_henti, masa_kerja_henti_bulat, PAR_ID_MUTASI from TBL_T_MUTASI_PENSIUN WHERE ID_MUTASI_PENSIUN = PAR_ID_MUTASI;

        -- MUTASI OTOMATIS KURANG BAYAR MP
        OTOMATIS_STAMP := 'BARU-OTOMATIS : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
        OTOMATIS_VALIDASI := 'VALID-OTOMATIS : ' || COMP_NAME || ' # ' || USER_NAME ||  ' # ' || TIMESTAMP ;
        IF  PAR_KURANG_BAYAR_MPYD  > 0 THEN
          INSERT INTO TBL_T_KURANG_BAYAR_DETAIL (REF_ID_MUTASI, TGL_MUTASI, PERIODE_MUTASI, NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP,
                                                 NAMA_KATEGORI_PENERIMA_MP, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, KURANG_BAYAR_MP, ID_KATEGORI_CATATAN, NAMA_KATEGORI_CATATAN, KETERANGAN, ID_VALIDASI, NAMA_VALIDASI, USER_STAMP, USER_VALIDASI, IS_ACTIVE,
                                                 ID_ALASAN_KURANGLEBIH_BAYAR)
          SELECT PAR_ID_MUTASI, PAR_TGL_MUTASI, PAR_PERIODE_MUTASI, NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP,
                 NAMA_KATEGORI_PENERIMA_MP, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, PAR_KURANG_BAYAR_MPYD, 17, 'MUTASI OTOMATIS', 'KURANG BAYAR MP KARENA TERLAMBAT MUTASI', 6, 'Otomatis Validasi', OTOMATIS_STAMP, OTOMATIS_VALIDASI, IS_ACTIVE, 4
          FROM TBL_M_PENSIUN WHERE NIP=PAR_NIP;

          SELECT COUNT(*) INTO MASTER_KURANG_BAYAR_EXISTS FROM TBL_T_KURANG_BAYAR WHERE NIP=PAR_NIP AND PERIODE_MUTASI = PAR_PERIODE_MUTASI;
          IF (MASTER_KURANG_BAYAR_EXISTS = 0) THEN  -- INSERT MASTER KURANG BAYAR BARU
            INSERT INTO TBL_T_KURANG_BAYAR (PERIODE_MUTASI, NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP,
                                            NAMA_KATEGORI_PENERIMA_MP, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, SALDO_AKHIR_KURANG_BAYAR, USER_STAMP,  IS_ACTIVE)
            SELECT PERIODE_MUTASI, NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP,
                   NAMA_KATEGORI_PENERIMA_MP, ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR, KURANG_BAYAR_MP, USER_STAMP,  IS_ACTIVE FROM TBL_T_KURANG_BAYAR_DETAIL WHERE NIP = PAR_NIP AND
                                                                                                                                                               ID_VALIDASI = 6;
          END IF;



          PAR_ID_MUTASI_VAL := PAR_ID_MUTASI;
        -- MUTASI OTOMATIS HUTANG MP (TERJADI APABILA BELUM ADA REKENING/REKENING DAPENBI, KURANG BAYAR MP MASUK KE HUTANG, MPS dan MP Bulanan Masuk Ke Hutang)
        --             ELSIF (PAR_KURANG_BAYAR_MPYD > 0 AND IS_JADI_HUTANG_UPDATE = 1) OR IS_JADI_HUTANG_UPDATE = 1  THEN
        --                -- HUTANG KURANG BAYAR MP
        --                IF PAR_KURANG_BAYAR_MPYD > 0 THEN
        --                    SELECT CASE WHEN MAX(ID_HUTANG) IS NULL THEN 1 ELSE MAX(ID_HUTANG) + 1 END INTO NEW_ID_HUTANG FROM TBL_T_HUTANG_DETAIL;
        --
        --                    BEGIN
        --                        SELECT CASE WHEN TBL_T_HUTANG.SISA_HUTANG IS NULL THEN 0 ELSE TBL_T_HUTANG.SISA_HUTANG END INTO SALDO_AKHIR_HUTANG FROM (SELECT  MAX(TIME_STAMP) AS TIME_STAMP, NIP FROM TBL_T_HUTANG
        --                        WHERE NIP=PAR_NIP GROUP BY NIP) MAX_DATA INNER JOIN TBL_T_HUTANG ON MAX_DATA.NIP= TBL_T_HUTANG.NIP AND TBL_T_HUTANG.TIME_STAMP = MAX_DATA.TIME_STAMP;
        --                        EXCEPTION
        --                    WHEN NO_DATA_FOUND THEN
        --                         SALDO_AKHIR_HUTANG:= 0;
        --                    END;
        --
        --                    INSERT INTO TBL_T_HUTANG_DETAIL (ID_HUTANG, TGL_MUTASI, PERIODE_MUTASI, NIP, NAMA_PESERTA, TGL_TRANSAKSI, JUMLAH_HUTANG, ID_KATEGORI_CATATAN, NAMA_KATEGORI_CATATAN,
        --                    KETERANGAN, USER_STAMP, USER_VALIDASI, IS_ACTIVE, REF_MUTASI, ID_VALIDASI, NAMA_VALIDASI, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                    ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR)
        --                    SELECT NEW_ID_HUTANG,PAR_TGL_MUTASI, PAR_PERIODE_MUTASI, NIP, NAMA_PESERTA, PAR_TGL_MUTASI, PAR_KURANG_BAYAR_MPYD,53, 'MUTASI OTOMATIS', 'HUTANG KURANG BAYAR MP, NO REKENING TIDAK ADA/REK. DAPENBI',
        --                    OTOMATIS_STAMP, OTOMATIS_VALIDASI, IS_ACTIVE, PAR_ID_MUTASI, 6, 'Otomatis Validasi',  ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                    ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR
        --                    FROM TBL_M_PENSIUN WHERE NIP=PAR_NIP;
        --
        --                    INSERT INTO TBL_T_HUTANG (NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG_BAYAR,  TOTAL_HUTANG, SUDAH_DIBAYAR, SISA_HUTANG, USER_STAMP, TIME_STAMP, IS_ACTIVE)
        --                    SELECT NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG, JUMLAH_HUTANG, 0, JUMLAH_HUTANG + SALDO_AKHIR_HUTANG, OTOMATIS_STAMP, SYSTIMESTAMP, 1 FROM TBL_T_HUTANG_DETAIL
        --                    WHERE ID_HUTANG = NEW_ID_HUTANG;
        --
        --                END IF;
        --                -- HUTANG MPS
        --                --1	MPS 20%
        --                --2	MPS 10 Juta
        --                --3	MPS 100%
        --                --4	MPS 20% + MPS 10 Juta
        --                --5	Tidak Ambil MPS
        --
        --                SELECT CASE WHEN MAX(ID_HUTANG) IS NULL THEN 1 ELSE MAX(ID_HUTANG) + 1 END INTO NEW_ID_HUTANG FROM TBL_T_HUTANG_DETAIL;
        --                BEGIN
        --                    SELECT CASE WHEN TBL_T_HUTANG.SISA_HUTANG IS NULL THEN 0 ELSE TBL_T_HUTANG.SISA_HUTANG END INTO SALDO_AKHIR_HUTANG FROM (SELECT  MAX(TIME_STAMP) AS TIME_STAMP, NIP FROM TBL_T_HUTANG
        --                    WHERE NIP=PAR_NIP GROUP BY NIP) MAX_DATA INNER JOIN TBL_T_HUTANG ON MAX_DATA.NIP= TBL_T_HUTANG.NIP AND TBL_T_HUTANG.TIME_STAMP = MAX_DATA.TIME_STAMP;
        --                    EXCEPTION
        --                WHEN NO_DATA_FOUND THEN
        --                     SALDO_AKHIR_HUTANG:= 0;
        --                END;
        --                -- HUTANG MPS
        --                INSERT INTO TBL_T_HUTANG_DETAIL (ID_HUTANG, TGL_MUTASI, PERIODE_MUTASI, NIP, NAMA_PESERTA, TGL_TRANSAKSI, JUMLAH_HUTANG, ID_KATEGORI_CATATAN, NAMA_KATEGORI_CATATAN,
        --                KETERANGAN, USER_STAMP, USER_VALIDASI, IS_ACTIVE, REF_MUTASI, ID_VALIDASI, NAMA_VALIDASI, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR)
        --                SELECT NEW_ID_HUTANG, PAR_TGL_MUTASI, PAR_PERIODE_MUTASI, NIP, NAMA_PESERTA, PAR_TGL_MUTASI, CASE WHEN ID_JENIS_MPS = 1 THEN MPS_20PERSEN WHEN ID_JENIS_MPS=2 THEN MPS_10JUTA WHEN
        --                ID_JENIS_MPS = 3 THEN MPS_100PERSEN WHEN ID_JENIS_MPS=4 THEN MPS_10JUTA + MPS_20PERSEN  END AS JUMLAH_HUTANG,53, 'MUTASI OTOMATIS', 'HUTANG MPS, NO REKENING TIDAK ADA/REK. DAPENBI',
        --                OTOMATIS_STAMP, OTOMATIS_VALIDASI, IS_ACTIVE, PAR_ID_MUTASI, 6, 'Otomatis Validasi',  ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR
        --                FROM TBL_M_PENSIUN WHERE NIP=PAR_NIP AND ID_JENIS_MPS <> 5;
        --
        --                INSERT INTO TBL_T_HUTANG (NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG_BAYAR,  TOTAL_HUTANG, SUDAH_DIBAYAR, SISA_HUTANG, USER_STAMP, TIME_STAMP, IS_ACTIVE)
        --                SELECT NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG, JUMLAH_HUTANG, 0, JUMLAH_HUTANG + SALDO_AKHIR_HUTANG, OTOMATIS_STAMP, SYSTIMESTAMP, 1 FROM TBL_T_HUTANG_DETAIL
        --                WHERE ID_HUTANG = NEW_ID_HUTANG;
        --
        --                SELECT CASE WHEN MAX(ID_HUTANG) IS NULL THEN 1 ELSE MAX(ID_HUTANG) + 1 END INTO NEW_ID_HUTANG FROM TBL_T_HUTANG_DETAIL;
        --                BEGIN
        --                    SELECT CASE WHEN TBL_T_HUTANG.SISA_HUTANG IS NULL THEN 0 ELSE TBL_T_HUTANG.SISA_HUTANG END INTO SALDO_AKHIR_HUTANG FROM (SELECT  MAX(TIME_STAMP) AS TIME_STAMP, NIP FROM TBL_T_HUTANG
        --                    WHERE NIP=PAR_NIP GROUP BY NIP) MAX_DATA INNER JOIN TBL_T_HUTANG ON MAX_DATA.NIP= TBL_T_HUTANG.NIP AND TBL_T_HUTANG.TIME_STAMP = MAX_DATA.TIME_STAMP;
        --                    EXCEPTION
        --                WHEN NO_DATA_FOUND THEN
        --                     SALDO_AKHIR_HUTANG:= 0;
        --                END;
        --                -- HUTANG MP
        --                INSERT INTO TBL_T_HUTANG_DETAIL (ID_HUTANG, TGL_MUTASI, PERIODE_MUTASI, NIP, NAMA_PESERTA, TGL_TRANSAKSI, JUMLAH_HUTANG, ID_KATEGORI_CATATAN, NAMA_KATEGORI_CATATAN,
        --                KETERANGAN, USER_STAMP, USER_VALIDASI, IS_ACTIVE, REF_MUTASI, ID_VALIDASI, NAMA_VALIDASI, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR)
        --                SELECT NEW_ID_HUTANG,  PAR_TGL_MUTASI, PAR_PERIODE_MUTASI, NIP, NAMA_PESERTA, PAR_TGL_MUTASI, MPYD,53, 'MUTASI OTOMATIS', 'HUTANG MP, NO REKENING TIDAK ADA/REK. DAPENBI',
        --                OTOMATIS_STAMP, OTOMATIS_VALIDASI, IS_ACTIVE, PAR_ID_MUTASI, 6, 'Otomatis Validasi',  ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA_MP, NAMA_KATEGORI_PENERIMA_MP,
        --                ID_KANTOR_BAYAR, NAMA_KANTOR_BAYAR
        --                FROM TBL_M_PENSIUN WHERE NIP=PAR_NIP;
        --
        --
        --                INSERT INTO TBL_T_HUTANG (NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG_BAYAR,  TOTAL_HUTANG, SUDAH_DIBAYAR, SISA_HUTANG, USER_STAMP, TIME_STAMP, IS_ACTIVE)
        --                SELECT NIP, NAMA_PESERTA, TGL_MUTASI, PERIODE_MUTASI, ID_HUTANG, JUMLAH_HUTANG, 0, JUMLAH_HUTANG + SALDO_AKHIR_HUTANG, OTOMATIS_STAMP, SYSTIMESTAMP, 1 FROM TBL_T_HUTANG_DETAIL
        --                WHERE ID_HUTANG = NEW_ID_HUTANG;

        --
        --                SELECT COUNT(*) INTO MASTER_HUTANG_EXISTS FROM TBL_T_HUTANG WHERE NIP=PAR_NIP ;
        --
        --                IF (MASTER_HUTANG_EXISTS = 0) THEN  -- INSERT MASTER HUTANG BARU
        --                    INSERT INTO TBL_T_HUTANG (NIP, NAMA_PESERTA, TOTAL_HUTANG, SUDAH_DIBAYAR, SISA_HUTANG, USER_STAMP, IS_ACTIVE)
        ----                    VALUES(PAR_NIP, PAR_NAMA_PESERTA, PAR_KURANG_BAYAR_MPYD, 0, PAR_KURANG_BAYAR_MPYD, USER_STAMP_NEW, 1);
        --                    SELECT A.NIP, A.NAMA_PESERTA, A.JUMLAH_HUTANG, 0, A.JUMLAH_HUTANG, OTOMATIS_STAMP, 1
        --                    FROM (SELECT NIP, NAMA_PESERTA, SUM(JUMLAH_HUTANG) AS JUMLAH_HUTANG
        --                    FROM TBL_T_HUTANG_DETAIL
        --                    WHERE NIP=PAR_NIP
        --                    GROUP BY NIP, NAMA_PESERTA) A;
        --                END IF;
        END IF;
      ----
      ----             -- MUTASI OTOMATIS REKENING PENSIUNAN
      --              SELECT COUNT(*) INTO MASTER_REKENING_EXISTS FROM TBL_M_REKENING_PENERIMA_MP WHERE NIP=PAR_NIP ;
      --              IF (MASTER_REKENING_EXISTS = 0) THEN  -- INSERT MASTER REKENING BARU
      --                    INSERT INTO TBL_M_REKENING_PENERIMA_MP (NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA, NAMA_KATEGORI_PENERIMA,
      --                    ID_BANK, JENIS_BANK, NAMA_CABANG_BANK, NAMA_REKENING, NOMOR_REKENING, IS_ACTIVE, USER_STAMP, REF_ID_MUTASI)
      --                    VALUES (PAR_NIP, PAR_NAMA_PESERTA, PAR_ID_PENERIMA_MP, PAR_NAMA_PENERIMA_MP, PAR_ID_KATEGORI_PENERIMA_MP, PAR_NAMA_KATEGORI_PENERIMA_MP,
      --                     ID_BANK_UPDATE, JENIS_BANK_UPDATE, NAMA_CABANG_BANK_UPDATE, NAMA_PADA_REK_BANK_UPDATE, NOMOR_REKENING_UPDATE,1, OTOMATIS_STAMP, PAR_ID_MUTASI);
      --
      --                    INSERT INTO TBL_T_HISTORY_REKENING (NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA, NAMA_KATEGORI_PENERIMA,
      --                    ID_BANK_LAMA, JENIS_BANK_LAMA, NAMA_CABANG_BANK_LAMA, NAMA_REKENING_LAMA, NOMOR_REKENING_LAMA, ID_KETERANGAN_PERUBAHAN, NAMA_KETERANGAN_PERUBAHAN,
      --                    USER_STAMP, USER_VALIDASI, REF_MUTASI, ID_CATATAN, NAMA_KATEGORI_CATATAN, KETERANGAN, ID_VALIDASI, NAMA_VALIDASI, IS_ACTIVE)
      --                    SELECT NIP, NAMA_PESERTA, ID_PENERIMA_MP, NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA, NAMA_KATEGORI_PENERIMA,
      --                    ID_BANK, JENIS_BANK, NAMA_CABANG_BANK, NAMA_REKENING, NOMOR_REKENING, 1, 'BARU',
      --                    OTOMATIS_STAMP, OTOMATIS_VALIDASI, PAR_ID_MUTASI, 28, 'MUTASI OTOMATIS', 'MUTASI OTOMATIS DARI MUTASI PENSIUN BARU', PAR_ID_VALIDASI, PAR_NAMA_VALIDASI, 1
      --                    FROM  TBL_M_REKENING_PENE RIMA_MP WHERE NIP=PAR_NIP;
      ----                    VALUES (PAR_NIP, PAR_NAMA_PESERTA, PAR_ID_PENERIMA_MP, PAR_NAMA_PENERIMA_MP, PAR_ID_KATEGORI_PENERIMA_MP, PAR_NAMA_KATEGORI_PENERIMA_MP,
      ----                     ID_BANK_UPDATE, JENIS_BANK_UPDATE, NAMA_CABANG_BANK_UPDATE, NAMA_PADA_REK_BANK_UPDATE, NOMOR_REKENING_UPDATE, 1, 'BARU', USER_STAMP_NEW, USER_VALIDASI, PAR_ID_MUTASI,
      ----                     '99', 'MUTASI OTOMATIS', 'REKENING BARU DARI PENSIUN BARU', PAR_ID_VALIDASI, PAR_NAMA_VALIDASI, 1);
      ----
      ----              ELSE
      ----                    UPDATE TBL_M_REKENING_PENERIMA_MP -- UPDATE MASTER REKENING
      ----                    SET NAMA_PESERTA = PAR_NAMA_PESERTA, ID_PENERIMA_MP=PAR_ID_PENERIMA_MP, NAMA_PENERIMA_MP=PAR_NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA=PAR_ID_KATEGORI_PENERIMA_MP,
      ----                    NAMA_KATEGORI_PENERIMA=PAR_NAMA_KATEGORI_PENERIMA_MP,
      ----                    ID_BANK=ID_BANK_UPDATE, JENIS_BANK=JENIS_BANK_UPDATE, NAMA_CABANG_BANK=NAMA_CABANG_BANK_UPDATE, NAMA_REKENING=NAMA_PADA_REK_BANK_UPDATE,
      ----                    NOMOR_REKENING=NOMOR_REKENING_UPDATE, USER_STAMP=USER_STAMP_NEW
      ----                    WHERE NIP = PAR_NIP;
      ----
      ----                    UPDATE TBL_T_HISTORY_REKENING -- UPDATE MASTER REKENING
      ----                    SET NAMA_PESERTA = PAR_NAMA_PESERTA, ID_PENERIMA_MP=PAR_ID_PENERIMA_MP, NAMA_PENERIMA_MP=PAR_NAMA_PENERIMA_MP, ID_KATEGORI_PENERIMA=PAR_ID_KATEGORI_PENERIMA_mp,
      ----                    NAMA_KATEGORI_PENERIMA=PAR_NAMA_KATEGORI_PENERIMA_mp,
      ----                    ID_BANK_LAMA=ID_BANK_UPDATE, JENIS_BANK_LAMA=JENIS_BANK_UPDATE, NAMA_CABANG_BANK_LAMA=NAMA_CABANG_BANK_UPDATE, NAMA_REKENING_LAMA=NAMA_PADA_REK_BANK_UPDATE,
      ----                    NOMOR_REKENING_LAMA=NOMOR_REKENING_UPDATE,USER_STAMP=USER_STAMP_NEW, USER_VALIDASI = USER_VALIDASI
      ----                    WHERE NIP = PAR_NIP;
      --             END IF;
      ----
      ----            elsif (PAR_id_validasi=2 and master_exists = 1) then
      ----             UPDATE TBL_M_PENSIUN
      ----             SET nama_peserta=PAR_nama_peserta,jenis_kelamin_peserta=PAR_jenis_kelamin_peserta,tgl_lahir_peserta=PAR_tgl_lahir_peserta,tgl_kerja_peserta=PAR_tgl_kerja_peserta,tgl_dptht_peserta=PAR_tgl_dptht_peserta,tgl_henti_kerja_peserta=PAR_tgl_henti_kerja_peserta,tempat_meninggal_peserta=PAR_tempat_meninggal_peserta,
      ----             tgl_meninggal_peserta=PAR_tgl_meninggal_peserta,tempat_lahir_peserta=par_tempat_lahir_peserta,id_golongan=par_id_golongan,golongan_pangkat=par_golongan_pangkat,id_agama=par_id_agama,nama_agama=par_nama_agama,id_kantor_bayar=par_id_kantor_bayar,nama_kantor_bayar=par_nama_kantor_bayar,
      ----             id_predikat=PAR_id_predikat,nama_predikat=par_nama_predikat,
      ----             id_henti=par_id_henti,keterangan_henti=par_keterangan_henti,tgl_sp_bi=par_tgl_sp_bi,no_sp_bi=par_no_sp_bi,tgl_sk_bi=par_tgl_sk_bi,no_sk_bi=par_no_sk_bi,phdp=PAR_phdp_lama,upah_veteran=par_upah_veteran,id_jenis_mps=par_id_jenis_mps,nama_mps=par_nama_mps,id_kategori_pensiun=par_id_kategori_pensiun,nama_kategori_pensiun=par_nama_kategori_pensiun,id_usia_bayar=par_id_usia_bayar,
      ----             nama_usia_bayar=PAR_nama_usia_bayar,id_status_bayar=PAR_id_status_bayar,status_bayar=PAR_status_bayar,tgl_tunda_jatuh_tempo=PAR_tgl_tunda_jatuh_tempo,tgl_awal_bayar=PAR_tgl_awal_bayar,
      ----             tgl_mp_bulan_ke13=par_tgl_mp_bulan_ke13,tgl_henti_bayar=par_tgl_henti_bayar,id_penerima_mp=PAR_id_penerima_mp,nama_penerima_mp=PAR_nama_penerima_mp,
      ----             tgl_lahir_penerima_mp=par_tgl_lahir_penerima_mp,jenis_kelamin_penerima_mp=par_jenis_kelamin_penerima_mp,id_kategori_penerima_mp=par_id_kategori_penerima_mp,nama_kategori_penerima_mp=par_nama_kategori_penerima_mp,tgl_sk_dapenbi=par_tgl_sk_dapenbi,
      ----             no_sk_dapenbi=par_no_sk_dapenbi,alamat_is_dalam_negeri=par_alamat_is_dalam_negeri,id_provinsi=par_id_provinsi,nama_provinsi=par_nama_provinsi,id_kota_kab=par_id_kota_kab,
      ----             nama_kota_kab=par_nama_kota_kab,id_kecamatan=par_id_kecamatan,nama_kecamatan=par_nama_kecamatan,id_kelurahan=par_id_kelurahan,nama_kelurahan=par_nama_kelurahan,kode_pos=par_kode_pos,alamat_lengkap=par_alamat_lengkap, rt=par_rt,rw=par_rw,id_negara=par_id_negara,nama_negara=par_nama_negara,usia_saat_henti=par_usia_saat_henti,
      ----             usia_saat_henti_bulat=par_usia_saat_henti_bulat,usia_penerima_bayar=par_usia_penerima_bayar,usia_penerima_bayar_bulat=par_usia_penerima_bayar_bulat,
      ----             masa_kerja_tambahan=par_masa_kerja_tambahan,masa_kerja_tambahan_bulat=par_masa_kerja_tambahan_bulat,masa_kerja_veteran=par_masa_kerja_veteran,masa_kerja_veteran_bulat=par_masa_kerja_veteran_bulat,
      ----             total_masa_kerja=par_total_masa_kerja,total_masa_kerja_bulat=par_total_masa_kerja_bulat,masa_kerja_mp=par_masa_kerja_mp,id_faktor_fpr=par_id_faktor_fpr,nama_faktor_fpr=par_nama_faktor_fpr,
      ----             nilai_fpr=PAR_nilai_fpr,id_faktor_fs=PAR_id_faktor_fs,nama_faktor_fs=PAR_nama_faktor_fs,nilai_fs=PAR_nilai_fs,mps_20persen=PAR_mps_20persen_LAMA,
      ----             mps_10juta=PAR_mps_10juta_lama, mps_100persen=PAR_mps_100persen_lama, mp_perbulan_rumus=PAR_mp_perbulan_rumus_lama, mp_perbulan_20persen=PAR_mp_perbulan_20persen_lama, mp_perbulan_10juta=PAR_mp_perbulan_10juta_lama,mpyd=PAR_mpyd_lama,mp_bulan13=par_mp_bulan13,
      ----             total_masa_kerja_adj=par_total_masa_kerja_adj,total_masa_kerja_adj_bulat=PAR_total_masa_kerja_bulat_adj, id_suskel=par_id_suskel,nama_suskel=par_nama_suskel,id_status_kawin_penerima_mp=par_id_kawin_penerima_mp,nama_status_kawin_penerima_mp=par_nama_kawin_penerima_mp,no_hp=par_no_hp,
      ----             email=PAR_email,keterangan_otomatis=keterangan_otomatis_update,is_active=1
      ----             where NIP=PAR_NIP;
      end if;
    ----

    END IF;

    PAR_STATUS_EKSEKUSI := '1';
    PAR_MSG := 'Data Saved Successfully';

    Commit;

    EXCEPTION
    WHEN OTHERS THEN
    PAR_STATUS_EKSEKUSI := '0';
    PAR_MSG := SQLERRM;
    ROLLBACK TO sp_mutasi_pensiun_baru;


  END CUSP_MUTASI_PENSIUN_BARU;
