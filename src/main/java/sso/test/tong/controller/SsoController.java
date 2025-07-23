package sso.test.tong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import sso.test.tong.DTO.SsoDTO;
import sso.test.tong.Model.Res;
import sso.test.tong.Model.SsoModel;
import sso.test.tong.entity.SsoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import sso.test.tong.repository.SsoRepository;
import sso.test.tong.service.SsoService;

import java.util.List;

@RestController
@RequestMapping("/sso")
public class SsoController {

    @Autowired
    private SsoService ssoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody SsoDTO user) {
        return ssoService.post(user);
    }

    @GetMapping("/get")
    public List<SsoEntity> getAll() {
        return ssoService.getAll();
    }
}
