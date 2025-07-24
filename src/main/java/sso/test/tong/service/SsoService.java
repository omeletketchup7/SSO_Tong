package sso.test.tong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sso.test.tong.dto.SsoDTO;
import sso.test.tong.model.Res;
import sso.test.tong.model.ResData;
import sso.test.tong.entity.SsoEntity;
import sso.test.tong.repository.SsoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SsoService {

    @Autowired
    private SsoRepository ssoRepo;

    public ResponseEntity<Object> post(SsoDTO sso) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("my-custom-header", "my-custom-value");

        try {
            SsoEntity ssoEntity = new SsoEntity();
            if (sso.getRequestDate() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                ssoEntity.setRequestDate(LocalDateTime.parse(sso.getRequestDate(), formatter));
            }else {
                ssoEntity.setRequestDate(LocalDateTime.now());
            }
            ssoEntity.setClientLocation(sso.getClientLocation());
            ssoEntity.setSsoType(sso.getSsoType());
            ssoEntity.setSystemId(sso.getSystemId());
            ssoEntity.setSystemName(sso.getSystemName());
            ssoEntity.setSystemTransactions(sso.getSystemTransactions());
            ssoEntity.setSystemPrivileges(sso.getSystemPrivileges());
            ssoEntity.setSystemUserGroup(sso.getSystemUserGroup());
            ssoEntity.setSystemLocationGroup(sso.getSystemLocationGroup());
            ssoEntity.setUserId(sso.getUserId());
            ssoEntity.setUserFullName(sso.getUserFullName());
            ssoEntity.setUserRdOfficeCode(sso.getUserRdOfficeCode());
            ssoEntity.setUserOfficeCode(sso.getUserOfficeCode());
            ssoEntity.setLocationMachineNumber(sso.getLocationMachineNumber());
            ssoEntity.setTokenId(sso.getTokenId());

            SsoEntity entity = ssoRepo.save(ssoEntity);
            ResData resData = new ResData();
            resData.setUserId(entity.getUserId());
            resData.setTokenId(entity.getTokenId());

            return new ResponseEntity<>(new Res("I07000","ทำรายการเรียบร้อย",resData), responseHeaders, HttpStatus.OK);
        } catch (Exception e) {
            ResData resData = new ResData();
            resData.setUserId(sso.getUserId());
            resData.setTokenId(sso.getTokenId());
            return new ResponseEntity<>(new Res("E000001","ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้",resData), responseHeaders, HttpStatus.BAD_REQUEST);
        }


    }

    public List<SsoEntity> getAll() {
        return ssoRepo.findAll();
    }
}
