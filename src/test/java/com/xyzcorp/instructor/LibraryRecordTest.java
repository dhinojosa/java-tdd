package com.xyzcorp.instructor;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryRecordTest {
    private LibraryRecord sarahSmith;
    private LibraryRecord subhaMelapalayam;

    @Before
    public void setUp() {
        sarahSmith = new LibraryRecord("Sarah Smith",
                "To Kill a Mockingbird",
                LocalDate.of(2014, 11, 19));

        subhaMelapalayam = new LibraryRecord("Subha Melapalayam",
                "TDD: The Advanced Guide",
                LocalDate.of(2018, 10, 9));
    }

    @Test
    public void testCreateALibraryAndCheckFirstName() {
        assertThat(sarahSmith.getName()).isEqualTo("Sarah Smith");
    }

    @Test
    public void testCreateALibraryWithSubhaMelapalayamAndCheckFirstName() {
        assertThat(subhaMelapalayam.getName()).isEqualTo("Subha Melapalayam");
    }

    @Test
    public void testCreateALibraryWithToKillMockingbirdAndCheckTitle() {
        assertThat(sarahSmith.getTitle()).isEqualTo("To Kill a Mockingbird");
    }

    @Test
    public void testCreateALibraryWithTDDAdvancedAndCheckTitle() {
        assertThat(subhaMelapalayam.getTitle()).isEqualTo("TDD: The Advanced " +
                "Guide");
    }

    @Test
    public void testCreateALibraryWithNov2014DateAndCheckDate() {
        assertThat(sarahSmith.getCheckoutDate()).isEqualTo(LocalDate.of(2014,
                11, 19));
    }

    @Test
    public void testCreateALibraryWithOct2018DateAndCheckDate() {
        assertThat(subhaMelapalayam.getCheckoutDate()).isEqualTo(LocalDate.of(2018, 10, 9));
    }

    @Test
    public void testToStringWithSarahSmith() {
        assertThat(sarahSmith.toString())
                .isEqualTo("LibraryRecord(name=Sarah Smith,title=To Kill a " +
                        "Mockingbird,checkoutDate=2014-11-19)");
    }

    @Test
    public void testToStringWithSubahMelapalayam() {
        assertThat(subhaMelapalayam.toString()).isEqualTo("LibraryRecord" +
                "(name=Subha Melapalayam,title=TDD: The Advanced Guide," +
                "checkoutDate=2018-10-09)");
    }

    @Test
    public void testEqualityWithSarahSmith() {
        LibraryRecord sarahSmith2 = new LibraryRecord("Sarah Smith",
                "To Kill a Mockingbird",
                LocalDate.of(2014, 11, 19));
        assertThat(sarahSmith.equals(sarahSmith2)).isTrue();
    }

    @Test
    public void testEqualityWithSubhaMelapalayam() {
        LibraryRecord subhaMelapalayam2 = new LibraryRecord("Subha Melapalayam",
                "TDD: The Advanced Guide",
                LocalDate.of(2018, 10, 9));
        assertThat(subhaMelapalayam.equals(subhaMelapalayam2)).isTrue();
    }

    @Test
    public void testEqualityWithSubhaMelapalayamDifferentDate() {
        LibraryRecord subhaMelapalayam2 = new LibraryRecord("Subha Melapalayam",
                "TDD: The Advanced Guide",
                LocalDate.of(2018, 10, 10));
        assertThat(subhaMelapalayam.equals(subhaMelapalayam2)).isFalse();
    }

    @Test
    public void testEqualityWithSubhaMelapalayamWithAnotherObject() {
        assertThat(subhaMelapalayam.equals("A String")).isFalse();
    }

    @Test
    public void testEqualityWithSubhaMelapalayamDifferentUser() {
        LibraryRecord saulGoodman1 = new LibraryRecord("Saul Goodman",
                "TDD: The Advanced Guide",
                LocalDate.of(2018, 10, 9));
        assertThat(saulGoodman1.equals(subhaMelapalayam)).isFalse();
    }

    @Test
    public void testEqualityWithSubhaMelapalayamDifferentTitle() {
        LibraryRecord subhaMelapalayam2 = new LibraryRecord("Subha Melapalayam",
                "Castles",
                LocalDate.of(2018, 10, 9));
        assertThat(subhaMelapalayam2.equals(subhaMelapalayam)).isFalse();
    }


    @Test
    public void testHashCode() {
        LibraryRecord subhaMelapalayam2 = new LibraryRecord("Subha Melapalayam",
                "TDD: The Advanced Guide",
                LocalDate.of(2018, 10, 9));
        assertThat(subhaMelapalayam.hashCode()).isEqualTo(subhaMelapalayam2.hashCode());
    }

    @Test
    public void testHashCode2() {
        LibraryRecord subhaMelapalayam2 = new LibraryRecord("Subha Melapalayam",
                "TDD: The Advanced Guide!",
                LocalDate.of(2018, 10, 9));
        assertThat(subhaMelapalayam.hashCode()).isNotEqualTo(subhaMelapalayam2.hashCode());
    }
}
