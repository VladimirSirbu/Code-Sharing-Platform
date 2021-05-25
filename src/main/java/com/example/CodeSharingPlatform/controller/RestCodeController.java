package com.example.CodeSharingPlatform.controller;

import com.example.CodeSharingPlatform.model.Code;
import com.example.CodeSharingPlatform.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class RestCodeController {

    private final CodeService codeService;

    @Autowired
    public RestCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<Code> addNewCodeAsJSON(@RequestBody Code newCode) {
        if (newCode == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Code code = codeService.addNewCode(newCode);
        return new ResponseEntity<>(code, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{codeId}", produces = "application/json")
    public ResponseEntity<Code> getCodeByIdAsJSON(@PathVariable("codeId") Long codeId) {
        Code code = codeService.getCodeById(codeId);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @GetMapping(value = "/latest", produces = "application/json")
    public ResponseEntity<List<Code>> getLatestCodeAsJSON() {
        List<Code> latestCode = codeService.getLatestCodes();
        return new ResponseEntity<>(latestCode, HttpStatus.OK);
    }
}
