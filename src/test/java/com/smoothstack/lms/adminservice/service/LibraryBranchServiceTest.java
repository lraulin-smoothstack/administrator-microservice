package com.smoothstack.lms.adminservice.service;

import com.smoothstack.lms.adminservice.dao.LibraryBranchDAO;
import com.smoothstack.lms.adminservice.entity.LibraryBranch;
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
public class LibraryBranchServiceTest {
    @Mock
    private LibraryBranchDAO libraryBranchDAO;

    @InjectMocks
    private LibraryBranchService libraryBranchService;

    private void testGetLibraryBranch() {
        // given
        LibraryBranch libraryBranch = new LibraryBranch(1L, "Library of Congress", "101 Independence Ave SE, Washington, DC 20540");
        Mockito.when(this.libraryBranchDAO.getOne(libraryBranch.getId())).thenReturn(libraryBranch);

        // when
        LibraryBranch result = libraryBranchService.getLibraryBranch(libraryBranch.getId());

        // then
        assertThat(result.getId()).isEqualTo(libraryBranch.getId());
        assertThat(result.getName()).isEqualTo(libraryBranch.getName());
    }

    private void testGetLibraryBranches() {
        // given
        LibraryBranch libraryBranch1 = new LibraryBranch(1L, "Library of Congress", "101 Independence Ave SE, Washington, DC 20540");
        LibraryBranch libraryBranch2 = new LibraryBranch(2L, "Library of Alexandria", "Alexandria, Egypt, Ancient");
        List<LibraryBranch> libraryBranches = Arrays.asList(libraryBranch1, libraryBranch2);

        // when
        List<LibraryBranch> result = libraryBranchService.getLibraryBranches();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(libraryBranch1.getName());
        assertThat(result.get(1).getName()).isEqualTo(libraryBranch2.getName());
    }

    private void testSetLibraryBranch() {
        // given
        LibraryBranch libraryBranch = new LibraryBranch(1L, "Library of Congress", "101 Independence Ave SE, Washington, DC 20540");
        Mockito.when(this.libraryBranchDAO.save(libraryBranch)).thenReturn(libraryBranch);

        // when
        LibraryBranch result = libraryBranchService.setLibraryBranch(libraryBranch);

        // then
        assertThat(result.getId()).isEqualTo(libraryBranch.getId());
        assertThat(result.getName()).isEqualTo(libraryBranch.getName());
    }

    private void testDeleteLibraryBranch() {
        // given
        LibraryBranch libraryBranch = new LibraryBranch(1L, "Library of Congress", "101 Independence Ave SE, Washington, DC 20540");
        doNothing().when(libraryBranchDAO).delete(isA(LibraryBranch.class));

        // when
        libraryBranchService.deleteLibraryBranch(libraryBranch.getId());

        // then
        assertThat(true).isTrue();
    }
}
