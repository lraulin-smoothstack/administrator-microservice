package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.PublisherDAO;
import com.smoothstack.december.administratormicroservice.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService {
    @Autowired
    private PublisherDAO PublisherDAO;

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
