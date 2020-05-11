package com.smoothstack.lms.adminservice.service;

import com.smoothstack.lms.adminservice.dao.PublisherDAO;
import com.smoothstack.lms.adminservice.entity.Publisher;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {
    @Mock
    private PublisherDAO publisherDAO;

    @InjectMocks
    private PublisherService publisherService;

    private void testGetPublisher() {
        // given
        Publisher publisher = new Publisher(null, "Penguin", "London, UK", "555-5555");
        Mockito.when(this.publisherDAO.getOne(publisher.getId())).thenReturn(publisher);

        // when
        Publisher result = publisherService.getPublisher(publisher.getId());

        // then
        assertThat(result.getId()).isEqualTo(publisher.getId());
        assertThat(result.getName()).isEqualTo(publisher.getName());
    }

    private void testGetPublishers() {
        // given
        Publisher publisher1 = new Publisher(1L, "Penguin", "London, UK", "555-5555");
        Publisher publisher2 = new Publisher(2L, "Pakt", "New York, USA", "666-6666");
        List<Publisher> publishers = Arrays.asList(publisher1, publisher2);

        // when
        List<Publisher> result = publisherService.getPublishers();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(publisher1.getName());
        assertThat(result.get(1).getName()).isEqualTo(publisher2.getName());
    }

    private void testSetPublisher() {
        // given
        Publisher publisher = new Publisher(1L, "Penguin", "London, UK", "555-5555");
        Mockito.when(this.publisherDAO.save(publisher)).thenReturn(publisher);

        // when
        Publisher result = publisherService.setPublisher(publisher);

        // then
        assertThat(result.getId()).isEqualTo(publisher.getId());
        assertThat(result.getName()).isEqualTo(publisher.getName());
    }

    private void testDeletePublisher() {
        // given
        Publisher publisher = new Publisher(1L, "Penguin", "London, UK", "555-5555");
        doNothing().when(publisherDAO).delete(isA(Publisher.class));

        // when
        publisherService.deletePublisher(publisher.getId());

        // then
        assertThat(true).isTrue();
    }
}
