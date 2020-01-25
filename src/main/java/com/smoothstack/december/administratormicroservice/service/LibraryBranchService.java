package com.smoothstack.december.administratormicroservice.service;

import com.smoothstack.december.administratormicroservice.dao.LibraryBranchDAO;
import com.smoothstack.december.administratormicroservice.entity.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LibraryBranchService {
    @Autowired
    private LibraryBranchDAO LibraryBranchDAO;

    public List<LibraryBranch> getLibraryBranchs() {
        return LibraryBranchDAO.findAll();
    }

    public LibraryBranch setLibraryBranch(LibraryBranch LibraryBranch) {
        return LibraryBranchDAO.save(LibraryBranch);
    }

    public void deleteLibraryBranch(LibraryBranch LibraryBranch) {
        LibraryBranchDAO.delete(LibraryBranch);
    }
}
