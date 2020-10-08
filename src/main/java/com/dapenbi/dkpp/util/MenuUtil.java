package com.dapenbi.dkpp.util;

import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.dto.component.MenuComponentDto;
import com.dapenbi.dkpp.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuUtil {

    @Autowired
    private ServletContext servletContext;

    public List<MenuComponentDto> getList(SecurityContext context, MenuDao menuDao, String basePath) {

        UserDto user = ((DkppUserDetail) context.getAuthentication().getPrincipal()).getUser();
        List<Menu> menu = menuDao.findByRoleCodeAndPathStart(user.getRoles().get(0).getCode(), basePath);

        return menu.stream().map(
                m -> new MenuComponentDto(m.getTitle(), m.getIcon(), servletContext.getContextPath() + m.getPath(), m.getStyle())
        ).collect(Collectors.toList());
    }
}
