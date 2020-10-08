package com.dapenbi.dkpp.util;

import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import static java.net.InetAddress.*;

public class DkppUserStamp {
    public static String getCompName(){
        java.net.InetAddress localMachine;
        try {
            localMachine = getLocalHost();
            return localMachine.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static DkppUserDetail getUserPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (DkppUserDetail) auth.getPrincipal();
    }

    public static String getUserName() {
        DkppUserDetail user = getUserPrincipal();
        return user.getUsername();
    }

    public static String getUserRealName() {
        DkppUserDetail user = getUserPrincipal();
        return user.getUser().getName();
    }

    public static RoleDto getUserRoles() {
        DkppUserDetail user = getUserPrincipal();
        return user.getUser().getRoles().get(0);
    }

    public static Boolean isStaff() {
        DkppUserDetail user = getUserPrincipal();
        return user.getUser().getRoles().get(0).getId().equals(43L);
    }

    public static Boolean isPejabat() {
        DkppUserDetail user = getUserPrincipal();
        return user.getUser().getRoles().get(0).getId().equals(44L);
    }

    public static Timestamp getTimeStamp(){
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }

    public static String postModeUserStamp(){
        return "BARU:" + getCompName() + "#" + getUserName() + "#" + getTimeStamp();
    }

    public static String putModeUserStamp(){
        return "EDIT:" + getCompName() + "#" + getUserName() + "#" + getTimeStamp();
    }
}
