create or replace view VW_MUTASI_OTOM_ANK25MP80 AS
SELECT
    rownum as ID,
    km.tgl_proses,
    km.periode_mutasi,
    km.nama_kategori_mutasi,
    'SYSTEM' as user_stamp,
    to_date('2018-12-31', 'YYYY-MM-DD') as created_at,
    to_date('2018-12-31', 'YYYY-MM-DD') as updated_at,
    1 AS IS_ACTIVE,
    (SELECT COUNT(*) FROM tbl_t_mutasi_pensiun mp WHERE mp.id_kategori_mutasi = km.id_kategori_mutasi ) as total_data,
    (SELECT COUNT(*) FROM tbl_t_mutasi_pensiun mp WHERE mp.id_kategori_mutasi = km.id_kategori_mutasi AND mp.id_validasi = '1') as belum_validasi,
    (SELECT COUNT(*) FROM tbl_t_mutasi_pensiun mp WHERE mp.id_kategori_mutasi = km.id_kategori_mutasi AND mp.id_validasi = '2') as sudah_validasi,
    (SELECT COUNT(*) FROM tbl_t_mutasi_pensiun mp WHERE mp.id_kategori_mutasi = km.id_kategori_mutasi AND mp.id_validasi = '7') as batal_validasi

FROM
(
    SELECT otom.tgl_proses, otom.periode_mutasi, km.id_kategori_mutasi, km.nama_kategori_mutasi
    FROM TBL_T_MUTASI_OTOM_ANK25MP80 otom,
        tbl_r_kategori_mutasi km
        WHERE km.id_kategori_Mutasi IN ('16', '31', '15', '11')
) km