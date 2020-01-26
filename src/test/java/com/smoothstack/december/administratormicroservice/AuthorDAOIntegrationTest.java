package com.smoothstack.december.administratormicroservice;

import com.smoothstack.december.administratormicroservice.dao.AuthorDAO;
import com.smoothstack.december.administratormicroservice.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorDAOIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private AuthorDAO authorRepository;

    @Test
    public void whenFindById_thenReturnAuthor() {
        // given
        Author homer = new Author(1, "Homer");
        entityManager.persist(homer);
        entityManager.flush();

        // when
        Optional<Author> found = authorRepository.findById(homer.getId());

        // then
        assertThat(found).isPresent().containsInstanceOf(Author.class);
        assertThat(found.get().getName()).isEqualTo(homer.getName());
    }
}
