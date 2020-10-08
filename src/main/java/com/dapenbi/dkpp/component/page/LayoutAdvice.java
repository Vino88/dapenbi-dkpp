package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.Layout;
import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.dto.component.MenuComponentDto;
import com.dapenbi.dkpp.dto.component.MenuSeparatorComponentDto;
import com.dapenbi.dkpp.dto.component.ProfileComponentDto;
import com.dapenbi.dkpp.model.Menu;
import com.dapenbi.dkpp.util.StringUtil;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
class LayoutAdvice {

    @Autowired
    private MenuDao menuDao;

    private final Mustache.Compiler compiler;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    public LayoutAdvice(Mustache.Compiler compiler, MenuDao menuDao, ServletContext servletContext) {
        this.compiler = compiler;
        this.menuDao = menuDao;
        this.servletContext = servletContext;
    }

    @ModelAttribute("layout")
    public Mustache.Lambda layout() {
        return new Layout(compiler);
    }

    @ModelAttribute("userInfo")
    public ProfileComponentDto user() {
        ProfileComponentDto userInfo = new ProfileComponentDto();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context.getAuthentication().getPrincipal() instanceof DkppUserDetail) {
            UserDto user = ((DkppUserDetail) context.getAuthentication().getPrincipal()).getUser();
            userInfo.setName(user.getName());
            userInfo.setDivision(user.getRoles().get(0).getName());
            userInfo.setProfilePicture("/assets/images/face1.jpg");
        }

        return userInfo;
    }

    @ModelAttribute("menus")
    public Iterable<MenuComponentDto> menus() {
        ArrayList<MenuComponentDto> layoutMenu = new ArrayList<>();

        SecurityContext context = SecurityContextHolder.getContext();
        String url = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();

        if (!url.contains("api") && context.getAuthentication().getPrincipal() instanceof DkppUserDetail) {
            List<Menu> menus = menuDao.findByRoleCode(context.getAuthentication().getAuthorities().toArray()[0].toString());

            List<Menu> parentMenus = menus.stream().filter(m -> m.getParent() == null).sorted(Comparator.comparing(Menu::getMenuOrder)).collect(Collectors.toList());

            for (Menu parentMenu : parentMenus) {
                List<Menu> childMenus = menus.stream().filter(m -> m.getParent() != null && m.getParent().equals(parentMenu.getId())).sorted(Comparator.comparing(Menu::getMenuOrder)).collect(Collectors.toList());
                ArrayList<MenuComponentDto> child = new ArrayList<>();
                for (Menu childMenu : childMenus) {
                    child.add(new MenuComponentDto(StringUtil.nullToEmpty(childMenu.getTitle()), StringUtil.nullToEmpty(childMenu.getIcon()), StringUtil.nullToEmpty(childMenu.getPath()), StringUtil.nullToEmpty(childMenu.getStyle())));
                }
                if (StringUtil.isNullOrEmpty(parentMenu.getTitle())) {
                    layoutMenu.add(new MenuSeparatorComponentDto());
                } else {
                    layoutMenu.add(new MenuComponentDto(parentMenu.getTitle(), child));
                }
            }
        }

        return layoutMenu;
    }

    @ModelAttribute("title")
    public Mustache.Lambda title(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            layout.title = frag.execute();
        };
    }

    @ModelAttribute("styles")
    public Mustache.Lambda styles(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            layout.styles = frag.execute();
        };
    }

    @ModelAttribute("scripts")
    public Mustache.Lambda scripts(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            layout.scripts = frag.execute();
        };
    }

    @ModelAttribute("modal")
    public Mustache.Lambda modal(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            layout.modal = frag.execute();
        };
    }

    @ModelAttribute("contextPath")
    public String getContextPath() {
        return servletContext.getContextPath();
    }
}