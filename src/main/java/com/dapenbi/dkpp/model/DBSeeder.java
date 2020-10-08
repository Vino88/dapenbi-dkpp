package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.util.BCryptHash;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class DBSeeder {

    private UserDao userDao;

    private MenuDao menuDao;

    private RoleDao roleDao;

    private AgamaDao agamaDao;

    private JenisMpsDao jenisMpsDao;

    private AlasanHentiDao alasanHentiDao;

    private GolonganDao golonganDao;

    private PredikatPemberhentianDao predikatPemberhentianDao;

    @Autowired
    public DBSeeder(
            UserDao userDao,
            MenuDao menuDao,
            RoleDao roleDao,
            AgamaDao agamaDao,
            JenisMpsDao jenisMpsDao,
            AlasanHentiDao alasanHentiDao,
            GolonganDao golonganDao,
            PredikatPemberhentianDao predikatPemberhentianDao
    ) {
        this.userDao = userDao;
        this.menuDao = menuDao;
        this.roleDao = roleDao;
        this.agamaDao = agamaDao;
        this.jenisMpsDao = jenisMpsDao;
        this.alasanHentiDao = alasanHentiDao;
        this.golonganDao = golonganDao;
        this.predikatPemberhentianDao = predikatPemberhentianDao;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        try {
            seedMenuTable();
            seedRoleTable();
//            seedAdminUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void seedAdminUser()  {
        User existingAdmin = userDao.findByUsernameOrEmail("admin@dkpp.com");
        if(existingAdmin == null) {
            User adminUser = new User();
            adminUser.setUsername("Admin");
            adminUser.setEmail("admin@dkpp.com");
            adminUser.setName("Admin");
            adminUser.setPassword(new BCryptHash().encode("Admin231!!"));
            adminUser.setLoginRetryCount(0);
            adminUser.setLastLogin(new Date());
            adminUser.setLastLoginIP("0.0.0.0");
            adminUser.setRoles(new ArrayList<Role>() {{
                add(roleDao.findOneByCode("ROLE_ADMIN"));
            }});

            userDao.save(adminUser);
        }
    }

    private void seedMenuTable() {
        List<Menu> rs = (ArrayList) menuDao.findAll();
        if(rs == null || rs.size() <= 0) {
            try {
                List<Menu> menuLevel1 = new ArrayList<>();
                menuLevel1.add(new Menu(1, "MENU UTAMA", true));
                menuLevel1.add(new Menu(2, null, true));
                menuLevel1.add(new Menu(3, "PENGATURAN", true));

                List<Menu> menuLevel1Result = new ArrayList<>();
                menuLevel1.forEach(mn -> menuLevel1Result.add(menuDao.save(mn)));

                List<Menu> menuLevel2 = new ArrayList<>();
                menuLevel1Result.forEach(m1 -> {
                    int order = 0;
                    String title = StringUtil.nullToEmpty(m1.getTitle());
                    switch (title) {
                        case "MENU UTAMA":
                            order = 0;
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Home", "/", "home", "text-primary", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Pensiun Baru", "/pensiun-baru", "person_add", "text-success", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Pensiun Lama", "/pensiun-lama", "person", "text-danger", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Mutasi Kurang Bayar MP", "/mutasi-kurang-bayar", "remove_circle", "text-primary", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Mutasi Lebih Bayar MP", "/mutasi-lebih-bayar", "add_circle", "text-success", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Pembayaran", "/pembayaran", "local_atm", "text-warning", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Her Registrasi", "/her-registrasi", "storage", "text-info", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Manajemen File", "/manajemen-file", "archive", "text-muted", true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Master Data Pensiunan", "/master-data-pensiunan", "portrait", "text-danger", true));

                            break;
                        case "PENGATURAN":
                            order = 0;
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Konfigurasi", "/konfigurasi", "settings", null, true));
                            menuLevel2.add(new Menu(m1.getId(), ++order, "Master Data", "/master-data", "view_headline", null, true));
                            break;
                    }
                });
                List<Menu> menuLevel2Result = new ArrayList<>();
                menuLevel2.forEach(mn -> menuLevel2Result.add(menuDao.save(mn)));

                List<Menu> menuLevel3 = new ArrayList<>();
                menuLevel2Result.forEach(m2 -> {
                    int order = 0;
                    String path = StringUtil.nullToEmpty(m2.getPath());
                    switch (path) {
                        case "/pensiun-baru":
                            order = 0;
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Pensiun Baru", m2.getPath() + "/mutasi-pensiun-baru", "fa-group", "red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Pensiun Tunda Jatuh Tempo Dibayar", m2.getPath() + "/mutasi-pensiun-tunda", "fa-calendar", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Perubahan PHDP/Merit Increase", m2.getPath() + "/mutasi-pensiun-tunda", "fa-line-chart", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Laporan", m2.getPath() + "/laporan-mutasi-pensiun-baru", "fa-file", "yellow", false));
                            break;
                        case "/pensiun-lama":
                            order = 0;
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Penerima MP Meninggal Dunia", m2.getPath() + "/mutasi-penerima-meninggal", "fa-user-times", "red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Penerima MP Janda/Duda Menikah Kembali", m2.getPath() + "/mutasi-penerima-menikah", "fa-venus-mars", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Penerima MP Anak 25 Tahun dan MP Bulan Ke-13", m2.getPath() + "/mutasi-penerima-anak", "", "fa fa-birthday-cake fa-4x orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Manfaat Pensiun Sekaligus 100%", m2.getPath() + "/mutasi-penerima-sekaligus", "fa-percent", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Susunan Keluarga", m2.getPath() + "/mutasi-susunan-keluarga", "fa-group", "btn-big green-bright", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Perubahan Nama Penerima MP", m2.getPath() + "/mutasi-perubahan-nama", "fa-pencil-square", "purple", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Kantor Bayar", m2.getPath() + "/mutasi-kantor-bayar", "fa-building", "btn-big green-bright", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Upload Potongan Kewajiban Pensiunan ", m2.getPath() + "/mutasi-kantor-bayar", "fa-upload", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Laporan", m2.getPath() + "/laporan-pensiun-lama", "fa-file", "yellow", false));
                            break;
                        case "/pembayaran":
                            order = 0;
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Pembayaran MP Bulanan", m2.getPath() + "/pembayaran-bulanan", "fa-money", "red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Tata Usaha Piutang Manfaat Pensiun", m2.getPath() + "/tata-usaha-piutang", "fa fa-usd fa-4x", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Penerima MP NF", m2.getPath() + "/penerima-manfaat", "fa-birthday-cake", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Kenaikan MP Berdasarkan Keputusan Pendiri", m2.getPath() + "/kenaikan-berdasarkan-keputusan", "fa-sort-amount-asc", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Rekening Pensiunan", m2.getPath() + "/mutasi-rekening-pensiunan", "fa fa-copy fa-4x", "btn-big green-bright", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Pembayaran Uang Pembinaan", m2.getPath() + "/mutasi-pembayaran-uang-pembinaan", "fa fa-bank fa-4x ", "btn-big red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Perubahan FPr dan FS", m2.getPath() + "/mutasi-perubahan-fpr", "fa-pencil-square", "purple", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Tata Usaha Hutang MP dan Hutang Uang Pembinaan", m2.getPath() + "/tata-usaha-hutang", "fa-credit-card", "btn-big green-bright", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Pengembalian MP", m2.getPath() + "/mutasi-pengembalian", "fa-sign-out", "red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Proyeksi Pembayaran Manfaat Pensiun", m2.getPath() + "/proyeksi-pembayaran-manfaat", "fa-line-chart", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Pengolahan Data Berkala", m2.getPath() + "/pengolhana-data-berkala", "fa-bar-chart", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Pengolahan Data Berkala Untuk Pihak Ke-3", m2.getPath() + "/pengolhana-pihak-ketiga", "fa-area-chart", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Laporan", m2.getPath() + "/laporan", "fa-file", "yellow", false));
                            break;
                        case "/her-registrasi":
                            order = 0;
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Her Registrasi", m2.getPath() + "/registrasi-ulang-pensiun", "fa fa-database fa-4x", "btn-big red", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Laporan", m2.getPath() + "/laporan-registrasi", "fa fa-file fa-4x", "btn-big yellow", false));
                            break;
                        case "/master-data":
                            order = 0;
                            menuLevel3.add(new Menu(m2.getId(), ++order, "User Master", m2.getPath() + "/user", "fa-user", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Role Master", m2.getPath() + "/role", "fa-group", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Menu Master", m2.getPath() + "/menu", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Kategori Penerima Master", m2.getPath() + "/kategori-penerima", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Keluarga Peserta Master", m2.getPath() + "/keluarga-peserta", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Kantor Bayar Master", m2.getPath() + "/kantor-bayar", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order,  "Peserta", m2.getPath() + "/peserta", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Bank NF", m2.getPath()+ "/bank-nf", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Golongan", m2.getPath() + "/golongan", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Jenis Bank", m2.getPath() + "/jenis-bank", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Penerima MP", m2.getPath() + "/penerima-mp", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Mutasi Keluarga Pensiun", m2.getPath() + "/mutasi-keluarga-pensiun", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Negara", m2.getPath() + "/negara", " fa-plane", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kategori Catatan", m2.getPath() + "/kategoricatatan", "fa-book", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Provinsi", m2.getPath() + "/provinsi", "fa-location-arrow", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Status Bayar", m2.getPath() + "/status-bayar", "fa-money", "green", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Agama", m2.getPath() + "/masteragama", "fa-reorder", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Status Kawin", m2.getPath() + "/status-kawin", "fa-heart", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Predikat Pemberhentian", m2.getPath() + "/predikat-pemberhentian", " fa-minus-circle", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kategori Pensiun", m2.getPath() + "/kategori-pensiun", "fa-wheelchair", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Faktor FPR", m2.getPath() + "/faktorfpr", " fa-file-text-o", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kota", m2.getPath() + "/kota", " fa-building-o", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kecamatan", m2.getPath() + "/kecamatan", "fa-building-o", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kelurahan", m2.getPath() + "/kelurahan", "fa-building-o", "green", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Aktuaria FPR", m2.getPath() + "/aktuariafpr", " fa-file-text-o", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Jenis MPS", m2.getPath() + "/jenismps", "fa-th-large", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Jenis Mutasi", m2.getPath() + "/jenismutasi", "fa-archive", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Setup Parameter", m2.getPath() + "/setupparameter", "perm_data_setting", "green", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kategori Mutasi", m2.getPath() + "/kategorimutasi", "fa-sticky-note-o", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Usia Bayar", m2.getPath() + "/usiabayar", " fa-universal-access", "blue", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Status Validasi", m2.getPath() + "/statusvalidasi", "fa-question-circle-o", "orange", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Kurs", m2.getPath() + "/kurs", "fa-line-chart", "green", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Pensiun", m2.getPath() + "/mpensiun", "fa-hourglass", "redish", false));
                            menuLevel3.add(new Menu(m2.getId(), ++order, "Master Alasan MPS 100%", m2.getPath() + "/alasan-mp100", "fa-file", "blue", false));
                            break;
                    }
                });
                menuLevel3.forEach(mn -> menuDao.save(mn));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void seedRoleTable() {
        List<Role> rs = (ArrayList) roleDao.findAll();
        if(rs == null || rs.size() <= 0) {
            Role adminRole = new Role("Admin", "ROLE_ADMIN");
            List<Menu> menus = (ArrayList) menuDao.findAll();
            adminRole.setMenus(menus);
            roleDao.save(adminRole);
        }
    }

    private void seedAgamaTable() {
        List<Menu> rs = (ArrayList) agamaDao.findAll();
        if(rs == null || rs.size() <= 0) {
            String[] agamaList = new String[] {
                    "1,ISLAM",
                    "2,KRISTEN PROTESTAN",
                    "3,KRISTEN KATOLIK",
                    "4,BUDHA",
                    "5,HINDU",
                    "9,LAIN-LAIN"
            };

            for (String namaAgama : agamaList) {
                Agama agama = new Agama();
                String[] aT = namaAgama.split(",");
                agama.setId(Long.parseLong(aT[0]));
                agama.setNamaAgama(aT[1]);
                agama.setActive(true);
                agamaDao.save(agama);
            }
        }
    }

    private void seedJenisMPSTable() {
        List<Menu> rs = (ArrayList) jenisMpsDao.findAll();
        if(rs == null || rs.size() <= 0) {
            String[] mpsList = new String[] {
                    "Tidak Ada MPS",
                    "MPS 20%",
                    "MPS 20% + MPS > 10 juta",
                    "MPS > 10 Juta",
                    "MPS 100%",
            };

            for (String namaMps : mpsList) {
                JenisMps mps = new JenisMps();
                mps.setNamamps(namaMps);
                mps.setActive(true);
                jenisMpsDao.save(mps);
            }
        }
    }

    private void seedAlasanHentiTable() {
        List<Menu> rs = (ArrayList) alasanHentiDao.findAll();
        if(rs == null || rs.size() <= 0) {
            List<AlasanHenti> listAlasanHenti = new ArrayList<>();
            listAlasanHenti.add(new AlasanHenti("UMUR PENSIUN", 1));
            listAlasanHenti.add(new AlasanHenti("CACAT / ALASAN KESEHATAN", 2));
            listAlasanHenti.add(new AlasanHenti("MENINGGAL DUNIA", 3));
            listAlasanHenti.add(new AlasanHenti("PERMINTAAN SENDIRI", 4));
            listAlasanHenti.add(new AlasanHenti("NIKAH ANTAR PEGAWAI", 5));
            listAlasanHenti.add(new AlasanHenti("BERHENTI TIDAK HORMAT", 6));
            listAlasanHenti.add(new AlasanHenti("DIANGKAT SEBAGAI DIREKSI", 7));
            listAlasanHenti.add(new AlasanHenti("LAIN-LAIN", 8));
            listAlasanHenti.add(new AlasanHenti("PERATURAN PEMERINTAH", 9));
            listAlasanHenti.add(new AlasanHenti("INPRES 12 / 1970", 10));
            listAlasanHenti.add(new AlasanHenti("KEPUTUSAN PRESIDEN", 11));
            listAlasanHenti.add(new AlasanHenti("PROGRAM PENSIUN DINI", 12));

            listAlasanHenti.forEach(ah -> alasanHentiDao.save(ah));
        }
    }

    private void seedGolonganTable() {
        List<Menu> rs = (ArrayList) golonganDao.findAll();
        if(rs == null || rs.size() <= 0) {
            List<Golongan> listGolongan = new ArrayList<>();

            listGolongan.add(new Golongan("2", "Pelaksana Yunior", "PTU", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Pengawas Yunior", "Pengawas Bank Pertama", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Analis Yunior", "Analis Pertama", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Programmer Yunior", "Programmer Yunior", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Data Base Administrator Yunior", "Data Base Administrator Yunior", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Sekretaris Yunior", "Sekretaris Pertama", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Kasir Yunior", "Kasir Pertama", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Satpam Yunior", "Satpam Pertama", "Staf", null, "-"));
            listGolongan.add(new Golongan("1", "Asisten Pelaksana", "Pegawai Dasar", "Asisten", null, "-"));
            listGolongan.add(new Golongan("2", "Operator", "Operator", "Staf", null, "-"));
            listGolongan.add(new Golongan("2", "Teknisi", "Teknisi", "Staf", null, "-"));
            listGolongan.add(new Golongan("3", "Peneliti (Pemangku Jabatan Asisten Manajer)", "Peneliti Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Analis (Pemangku Jabatan Asisten Manajer)", "Analis Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Pengawas  (Pemangku Jabatan Asisten Manajer)", "Pengawas Bank Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Pengelola Portofolio  (Pemangku Jabatan Asisten Manajer)", "Pengelola Portofolio Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Dealer  (Pemangku Jabatan Asisten Manajer)", "Dealer Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Penasehat Hukum  (Pemangku Jabatan Asisten Manajer)", "Penasehat Hukum Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Sekretaris  (Pemangku Jabatan Asisten Manajer)", "Sekretaris Hukum Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Programmer  (Pemangku Jabatan Asisten Manajer)", "Programmer Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Data Base Administrator  (Pemangku Jabatan Asisten Manajer)", "Data Base Administrator Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "System Administrator  (Pemangku Jabatan Asisten Manajer)", "System Administrator Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Kasir", "Kasir Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("3", "Satpam", "Satpam Muda", "Asisten Manager", null, "-"));
            listGolongan.add(new Golongan("4", "Kepala Unit", "Kepala Seksi", "Manager", "Struktural", "IV"));
            listGolongan.add(new Golongan("4", "Kasir Senior", "Kasir Muda Senior", "Manager", "Struktural", "IV"));
            listGolongan.add(new Golongan("4", "Protokol Senior", "Protokol Muda Senior", "Manager", "Struktural", "IV"));
            listGolongan.add(new Golongan("4", "Satpam Senior", "Satpam Muda Senior", "Manager", "Struktural", "IV"));
            listGolongan.add(new Golongan("4", "Peneliti (Pemangku Jabatan Manajer)", "Peneliti Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Analis (Pemangku Jabatan Manajer)", "Analis Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Pengelola Portofolio (Pemangku Jabatan Manajer)", "Pengelola Portofolio Bank Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Dealer (Pemangku Jabatan Manajer)", "Dealer Bank Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Sekretaris (Pemangku Jabatan Manajer)", "Sekretaris Bank Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Programmer (Pemangku Jabatan Manajer)", "Programmer Bank Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Database Administrator (Pemangku Jabatan Manajer)", "Database Administrator Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "System Programmer (Pemangku Jabatan Manajer)", "System Programmer Muda Senior", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("4", "Pengendali Proyek (Pemangku Jabatan Manajer)", "Pengendali Proyek Muda", "Manager", "Fungsional", "IV"));
            listGolongan.add(new Golongan("5", "Kepala Tim", "Deputi Kepala Bagian", "Asisten Direktur", "Struktural", "III"));
            listGolongan.add(new Golongan("5", "Deputi Kepala Perwakilan BI", "Deputi PBI Kelas III", "Asisten Direktur", "Struktural", "III"));
            listGolongan.add(new Golongan("5", "Kepala Kasir", "Kasir Madya", "Asisten Direktur", "Struktural", "III"));
            listGolongan.add(new Golongan("5", "Kepala Protokol", "Protokol Madya", "Asisten Direktur", "Struktural", "III"));
            listGolongan.add(new Golongan("5", "Kepala Satuan Pengamanan", "Satuan Pengamanan Madya", "Asisten Direktur", "Struktural", "III"));
            listGolongan.add(new Golongan("5", "Peneiliti Senior (Pemangku Jabatan Asisten Direktur)", "Peneliti Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Pengawas Senior (Pemangku Jabatan Asisten Direktur)", "Pengawas Bank Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Analis Senior (Pemangku Jabatan Asisten Direktur)", "Analis Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Penasehat Hukum Senior (Pemangku Jabatan Asisten Direktur)", "Penasehat Hukum Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Programmer Senior (Pemangku Jabatan Asisten Direktur)", "Programmer Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Pengelola Portofolio Senior (Pemangku Jabatan Asisten Direktur)", "Pengelola Portofolio Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Dealer Senior (Pemangku Jabatan Asisten Direktur)", "Dealer Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Sekretaris Senior (Pemangku Jabatan Asisten Direktur)", "Sekretaris Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("5", "Pengendali Proyek Senior (Pemangku Jabatan Asisten Direktur)", "Pengendali Proyek Madya", "Asisten Direktur", "Fungsional", "III"));
            listGolongan.add(new Golongan("6", "Kepala Divisi", "Kepala Bagian", "Deputi Direktur", "Struktural", "II B"));
            listGolongan.add(new Golongan("6", "Kepala Perwakilan BI", "Pemimpin Bank Indonesia kelas III", "Deputi Direktur", "Struktural", "II B"));
            listGolongan.add(new Golongan("6", "Deputi Kepala Perwakilan BI", "Deputi PBI Kelas II", "Deputi Direktur", "Struktural", "II B"));
            listGolongan.add(new Golongan("6", "Peneiliti Senior (Pemangku Jabatan Deputi Direktur)", "Peneliti Madya Senior", "Deputi Direktur", "Fungsional", "II B"));
            listGolongan.add(new Golongan("6", "Pengawas Senior (Pemangku Jabatan Deputi Direktur)", "Pengawas Bank Madya Senior", "Deputi Direktur", "Fungsional", "II B"));
            listGolongan.add(new Golongan("6", "Analis Senior (Pemangku Jabatan Deputi Direktur)", "Analis Madya Senior", "Deputi Direktur", "Fungsional", "II B"));
            listGolongan.add(new Golongan("6", "Penasehat Hukum Senior (Pemangku Jabatan Deputi Direktur)", "Penasehat Hukum Madya Senior", "Deputi Direktur", "Fungsional", "II B"));
            listGolongan.add(new Golongan("7", "Kepala Group", "Kepala Biro", "Direktur", "Struktural", "II A"));
            listGolongan.add(new Golongan("7", "Kepala Group", "Deputi Direktur", "Direktur", "Struktural", "II A"));
            listGolongan.add(new Golongan("7", "Kepala Perwakilan BI", "Pemimpin Bank Indonesia Kelas II", "Direktur", "Struktural", "II A"));
            listGolongan.add(new Golongan("7", "Deputi Kepala Perwakilan BI", "Deputi PBI Kelas I", "Direktur", "Struktural", "II A"));
            listGolongan.add(new Golongan("7", "Advisor", "Peneliti Utama", "Direktur", "Fungsional", "II A"));
            listGolongan.add(new Golongan("8", "Kepala Departemen", "Direktur Senior", "Direktur Eksekutif", "Struktural", "I B"));
            listGolongan.add(new Golongan("8", "Kepala Departemen", "Direktur", "Direktur Eksekutif", "Struktural", "I B"));
            listGolongan.add(new Golongan("8", "Kepala Perwakilan BI", "Pemimpin Bank Indonesia Kelas I", "Direktur Eksekutif", "Struktural", "I B"));
            listGolongan.add(new Golongan("8", "Kepala Perwakilan BI", "Kepala Kantor Perwakilan BI", "Direktur Eksekutif", "Struktural", "I B"));
            listGolongan.add(new Golongan("8", "Advisor Senior", "Peneliti Utama Senior", "Direktur Eksekutif", "Fungsional", "I B"));
            listGolongan.add(new Golongan("9", "Asisten Gubernur", "Asisten Gubernur", "Direktur Jenderal", "Struktural", "I A"));
            listGolongan.add(new Golongan("9", "Penasehat Ahli", "Penasehat Ahli", "Direktur Jenderal", "Fungsional", "I A"));

            listGolongan.forEach(g -> golonganDao.save(g));
        }
    }

    private void seedPredikatPemberhentianTable() {
        List<Menu> rs = (ArrayList) predikatPemberhentianDao.findAll();
        if (rs == null || rs.size() <= 0) {
            predikatPemberhentianDao.save(new PredikatPemberhentian("Dengan Hormat"));
        }
    }
}
