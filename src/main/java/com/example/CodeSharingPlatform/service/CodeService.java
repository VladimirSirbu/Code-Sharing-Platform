package com.example.CodeSharingPlatform.service;

import com.example.CodeSharingPlatform.exception.CodeNotFoundException;
import com.example.CodeSharingPlatform.model.Code;
import com.example.CodeSharingPlatform.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code addNewCode(Code newCode) {
        return codeRepository.save(newCode);
    }

    public Code getCodeById(Long id) {
        return codeRepository
                .findCodeById(id)
                .orElseThrow(() -> new CodeNotFoundException("Code with id " + id + " was not found"));
    }

    public List<Code> getLatestCodes() {
        return codeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Code::getDateTime).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
