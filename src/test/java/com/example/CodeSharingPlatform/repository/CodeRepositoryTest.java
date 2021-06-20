package com.example.CodeSharingPlatform.repository;

import com.example.CodeSharingPlatform.exception.CodeNotFoundException;
import com.example.CodeSharingPlatform.model.Code;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

@RunWith(SpringRunner.class)
@DataJpaTest                               // will disable full auto-configuration and instead apply only configuration relevant to JPA tests
@AutoConfigureTestDatabase(replace = NONE) // determines what type of existing DataSource bean can be replaced
public class CodeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager; // use in JPA tests

    @Autowired
    private CodeRepository codeRepository;

    @Test
    public void whenFindCodeById() {
        // given
        Code code = new Code();
        code.setCode("public void testMethod() {}");
        entityManager.persist(code);
        entityManager.flush();

        // when
        Code testCode = codeRepository
                .findCodeById(code.getId())
                .orElseThrow(CodeNotFoundException::new);

        // then
        assertThat(testCode.getCode()).isEqualTo(code.getCode());
    }
}