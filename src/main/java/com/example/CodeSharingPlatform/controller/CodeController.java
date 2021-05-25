package com.example.CodeSharingPlatform.controller;

import com.example.CodeSharingPlatform.model.Code;
import com.example.CodeSharingPlatform.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/code")
public class CodeController {

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }


    @GetMapping("/new")
    public String addNewCodeAsHTML() {
        return "submitForm";
    }

    @GetMapping("/{codeId}")
    public String getCodeByIdAsHTML(@PathVariable("codeId") Long codeId, Model model) {
        Code code = codeService.getCodeById(codeId);
        model.addAttribute("code", code);
        return "codePage";
    }

    @GetMapping("/latest")
    public String getLatestCodeAsHTML(Model model) {
        List<Code> latestCode = codeService.getLatestCodes();
        model.addAttribute("latestCode", latestCode);
        return "latest";
    }

}
