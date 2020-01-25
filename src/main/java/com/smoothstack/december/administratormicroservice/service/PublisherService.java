package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.PublisherDAO;
import com.smoothstack.december.administratormicroservice.entity.Publisher;
import com.smoothstack.december.administratormicroservice.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherService {
    @Autowired
    private PublisherDAO PublisherDAO;

    public Optional<Publisher> getPublisher(long id) {
        return PublisherDAO.findById(id);
    }

    public List<Publisher> getPublishers() {
        return PublisherDAO.findAll();
    }

    public Publisher setPublisher(Publisher Publisher) {
        return PublisherDAO.save(Publisher);
    }

    public void deletePublisher(Publisher Publisher) {
        PublisherDAO.delete(Publisher);
    }
}
