package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.LibraryBranchDAO;
import com.smoothstack.december.administratormicroservice.entity.LibraryBranch;
import com.smoothstack.december.administratormicroservice.entity.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryBranchService {
    @Autowired
    private LibraryBranchDAO LibraryBranchDAO;

    public Optional<LibraryBranch> getLibraryBranch(long id) {
        return LibraryBranchDAO.findById(id);
    }
    public List<LibraryBranch> getLibraryBranchs() {
        return LibraryBranchDAO.findAll();
    }

    public LibraryBranch setLibraryBranch(LibraryBranch libraryBranch) {
        return LibraryBranchDAO.save(libraryBranch);
    }

    public void deleteLibraryBranch(LibraryBranch libraryBranch) {
        LibraryBranchDAO.delete(libraryBranch);
    }
}
