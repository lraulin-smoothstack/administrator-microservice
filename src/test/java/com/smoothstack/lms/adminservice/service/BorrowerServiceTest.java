package com.smoothstack.lms.adminservice.service;


import com.smoothstack.lms.adminservice.dao.BorrowerDAO;
import com.smoothstack.lms.adminservice.entity.Borrower;
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
public class BorrowerServiceTest {
    @Mock
    private BorrowerDAO borrowerDAO;

    @InjectMocks
    private BorrowerService borrowerService;

    private void testGetBorrower() {
        // given
        Borrower borrower = new Borrower(1L, "Fred Flinstone", "The Town of Bedrock", "555-5555");
        Mockito.when(this.borrowerDAO.getOne(borrower.getId())).thenReturn(borrower);

        // when
        Borrower result = borrowerService.getBorrower(borrower.getId());

        // then
        assertThat(result.getId()).isEqualTo(borrower.getId());
        assertThat(result.getName()).isEqualTo(borrower.getName());
    }

    private void testGetBorrowers() {
        // given
        Borrower borrower1 = new Borrower(1L, "Fred Flinstone", "The Town of Bedrock", "555-5555");
        Borrower borrower2 = new Borrower(1L, "Wilma Flinstone", "The Town of Bedrock", "555-5555");
        List<Borrower> borrowers = Arrays.asList(borrower1, borrower2);

        // when
        List<Borrower> result = borrowerService.getBorrowers();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(borrower1.getName());
        assertThat(result.get(1).getName()).isEqualTo(borrower2.getName());
    }

    private void testSetBorrower() {
        // given
        Borrower borrower = new Borrower(1L, "Fred Flinstone", "The Town of Bedrock", "555-5555");
        Mockito.when(this.borrowerDAO.save(borrower)).thenReturn(borrower);

        // when
        Borrower result = borrowerService.setBorrower(borrower);

        // then
        assertThat(result.getId()).isEqualTo(borrower.getId());
        assertThat(result.getName()).isEqualTo(borrower.getName());
    }

    private void testDeleteBorrower() {
        // given
        Borrower borrower = new Borrower(1L, "Fred Flinstone", "The Town of Bedrock", "555-5555");
        doNothing().when(borrowerDAO).delete(isA(Borrower.class));

        // when
        borrowerService.deleteBorrower(borrower.getId());

        // then
        assertThat(true).isTrue();
    }
}
