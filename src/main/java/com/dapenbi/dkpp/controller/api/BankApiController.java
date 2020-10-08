package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BankDao;
import com.dapenbi.dkpp.dto.BankDto;
import com.dapenbi.dkpp.form.BankFormDto;
import com.dapenbi.dkpp.model.BankNF;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.BANK_NF)
public class BankApiController extends DropdownApiController {

    BankDao bankDao;

    @Autowired
    public BankApiController(BankDao bankDao){
        super(bankDao);
        this.bankDao = bankDao;
    }

    @GetMapping
    public Page<BankDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<BankNF> aIt = (Page<BankNF>) bankDao.findAll(new String[] {"namaBankNF"}, "%" + searchParam + "%", pageRequest);

        Page<BankDto> bankDto = aIt.map(u -> u.toDto());

        return bankDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addBank(@ModelAttribute BankFormDto bankForm){
        BankNF bankNF = new BankNF();
        bankNF.setNamaBankNF(bankForm.getNamaBankNF());
        bankNF.setAlamat(bankForm.getAlamat());
        bankNF.setNegara(bankForm.getNegara());
        bankNF.setTlp(bankForm.getTlp());
        bankNF.setSwiftCode(bankForm.getSwiftCode());
        bankNF.setIbanCode(bankForm.getIbanCode());
        bankNF.setActive(bankForm.getActive() != null && bankForm.getActive().size() > 0);
        bankForm.setUserStamp(DkppUserStamp.postModeUserStamp());
        BankDto dto = bankDao.save(bankNF).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateBank(@ModelAttribute BankFormDto bankForm) {
        BankNF bankNF = bankDao.findById(bankForm.getId());

        bankNF.setNamaBankNF(bankForm.getNamaBankNF());
        bankNF.setAlamat(bankForm.getAlamat());
        bankNF.setNegara(bankForm.getNegara());
        bankNF.setTlp(bankForm.getTlp());
        bankNF.setSwiftCode(bankForm.getSwiftCode());
        bankNF.setIbanCode(bankForm.getIbanCode());
        bankNF.setActive(bankForm.getActive() != null && bankForm.getActive().size() > 0);
        bankForm.setUserStamp(DkppUserStamp.postModeUserStamp());

        BankDto dto = bankDao.save(bankNF).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
