package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AgamaDao;
import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.dto.MenuDto;
import com.dapenbi.dkpp.form.AgamaFormDto;
import com.dapenbi.dkpp.form.MenuFormDto;
import com.dapenbi.dkpp.model.Agama;
import com.dapenbi.dkpp.model.Menu;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API+PathPrefix.MENU)
public class MenuApiController {

    @Autowired
    MenuDao menuDao;

    @GetMapping
    public Page<MenuDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){

        Page<Menu> aIt = (Page<Menu>) menuDao.findAll(new String[] {"title","path"},"%" + searchParam + "%",pageRequest);

        return aIt.map(Menu::toDto);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAgama(@ModelAttribute MenuFormDto menuFormDto){

        Menu menu = new Menu();
        menu.setTitle(menuFormDto.getTitle());
        menu.setPath(menuFormDto.getPath());
        menu.setIcon(menuFormDto.getIcon());
        menu.setStyle(menuFormDto.getStyle());
        menu.setParent(menuFormDto.getParent());
        menu.setMenuOrder((int)(long)menuFormDto.getMenuOrder());
        MenuDto dto = menuDao.save(menu).toDto();

        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateAgama(@ModelAttribute MenuFormDto menuFormDto){
        Menu menu = menuDao.findById(menuFormDto.getIdMenu());

        menu.setTitle(menuFormDto.getTitle());
        menu.setPath(menuFormDto.getPath());
        menu.setIcon(menuFormDto.getIcon());
        menu.setStyle(menuFormDto.getStyle());
        menu.setParent(menuFormDto.getParent());
        menu.setMenuOrder((int)(long)menuFormDto.getMenuOrder());
        menu.setActive(menuFormDto.getActive() !=null && menuFormDto.getActive().size() > 0);
        MenuDto dto = menuDao.save(menu).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
