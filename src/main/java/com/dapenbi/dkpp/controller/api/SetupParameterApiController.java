package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.SETUPPARAMETER)
public class SetupParameterApiController {

    @Autowired
    SetupParameterDao setupParameterDao;

    @GetMapping
    public Page<SetupParameterDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<SetupParameter> pIt = (Page<SetupParameter>) setupParameterDao.findAll(new String[]{"periode"}, "%" + searchParam + "%", pageRequest);

        Page<SetupParameterDto> spDto = pIt.map(p ->p.toDto() );
        return spDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addSetupParameter(@ModelAttribute SetupParameterFormDto setupParameterFormDto){
        SetupParameter setupParameter = new SetupParameter();
        setupParameter.setPeriode(setupParameterFormDto.getPeriode());
        setupParameter.setTglAwalBayar(setupParameterFormDto.getTglAwalBayar());
        setupParameter.setAdaPotKewajiban(setupParameterFormDto.getAdaPotKewajiban() !=null && setupParameterFormDto.getAdaPotKewajiban().size() > 0);
        setupParameter.setAdaPerubahanFprFs(setupParameterFormDto.getAdaPerubahanFprFs() !=null && setupParameterFormDto.getAdaPerubahanFprFs().size() > 0);
        setupParameter.setAdaKenaikanMp(setupParameterFormDto.getAdaKenaikanMp() !=null && setupParameterFormDto.getAdaKenaikanMp().size() > 0);
        setupParameter.setBukaPeriode(setupParameterFormDto.getBukaPeriode() !=null && setupParameterFormDto.getBukaPeriode().size() > 0);
        setupParameter.setUserStamp(DkppUserStamp.postModeUserStamp());
        SetupParameterDto dto = setupParameterDao.save(setupParameter).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateJenisMutasi(@ModelAttribute SetupParameterFormDto setupParameterFormDto){
        SetupParameter setupParameter = setupParameterDao.findByPeriode(setupParameterFormDto.getPeriode());

        setupParameter.setPeriode(setupParameterFormDto.getPeriode());
        setupParameter.setTglAwalBayar(setupParameterFormDto.getTglAwalBayar());
        setupParameter.setAdaPotKewajiban(setupParameterFormDto.getAdaPotKewajiban() !=null && setupParameterFormDto.getAdaPotKewajiban().size() > 0);
        setupParameter.setAdaPerubahanFprFs(setupParameterFormDto.getAdaPerubahanFprFs() !=null && setupParameterFormDto.getAdaPerubahanFprFs().size() > 0);
        setupParameter.setAdaKenaikanMp(setupParameterFormDto.getAdaKenaikanMp() !=null && setupParameterFormDto.getAdaKenaikanMp().size() > 0);
        setupParameter.setBukaPeriode(setupParameterFormDto.getBukaPeriode() !=null && setupParameterFormDto.getBukaPeriode().size() > 0);
        setupParameter.setActive(setupParameterFormDto.getActive() !=null && setupParameterFormDto.getActive().size() > 0);
        setupParameter.setUserStamp(DkppUserStamp.postModeUserStamp());
        SetupParameterDto dto = setupParameterDao.save(setupParameter).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }

    @GetMapping("/get_periode")
    public MutasiUtilFormDto getPeriode(){
        MutasiUtilFormDto mufd = new MutasiUtilFormDto();
        SetupParameter setupParameter = (SetupParameter) setupParameterDao.findByBukaPeriode();
        mufd.setPeriodeMutasi(setupParameter.getPeriode());
        mufd.setTglMutasi(setupParameterDao.getSystemDate());
        mufd.setCompName(DkppUserStamp.getCompName());
        mufd.setUserName(DkppUserStamp.getUserName());
        mufd.setPostModeUserStamp(DkppUserStamp.postModeUserStamp());
        mufd.setPutModeUserStamp(DkppUserStamp.putModeUserStamp());
        mufd.setRealName(DkppUserStamp.getUserRealName());
        return mufd;
    }

    @GetMapping("/get_periode_tutup")
    public MutasiUtilFormDto getTutupPeriode(){
        MutasiUtilFormDto mufd = new MutasiUtilFormDto();
        SetupParameter setupParameter = (SetupParameter) setupParameterDao.findByTutupPeriode();
        mufd.setPeriodeMutasi(setupParameter.getPeriode());
        mufd.setTglMutasi(setupParameterDao.getSystemDate());
        mufd.setCompName(DkppUserStamp.getCompName());
        mufd.setUserName(DkppUserStamp.getUserName());
        mufd.setPostModeUserStamp(DkppUserStamp.postModeUserStamp());
        mufd.setPutModeUserStamp(DkppUserStamp.putModeUserStamp());
        mufd.setRealName(DkppUserStamp.getUserRealName());
        return mufd;
    }
}
