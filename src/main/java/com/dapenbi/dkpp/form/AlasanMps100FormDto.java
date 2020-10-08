package com.dapenbi.dkpp.form;

import java.util.Map;

public class AlasanMps100FormDto {

        private Long idAlasanMps100;
        private String namaAlasanMps100;
        private Map active;
        private String userStamp;

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

        public Map getActive() {
            return active;
        }

        public void setActive(Map active) {
            this.active = active;
        }

        public String getUserStamp() {
            return userStamp;
        }

        public void setUserStamp(String userStamp) {
            this.userStamp = userStamp;
        }

}
