package com.example.CodeSharingPlatform.repository;

import com.example.CodeSharingPlatform.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {

    Optional<Code> findCodeById(Long id);


}
