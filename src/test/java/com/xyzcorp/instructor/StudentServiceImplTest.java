package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {
    @Test
    public void testRegisterStudentSuccessfully() {
        Student fakeStudent = new Student(40239L, "Bob", "Marley");

        StudentDAO studentDAO = createMock(StudentDAO.class);
        expect(studentDAO.findById(40239L)).andReturn(Optional.empty());
        expect(studentDAO.persist(fakeStudent)).andReturn(1L);

        replay(studentDAO); //Mockito doesn't do this
        StudentServiceImpl studentService = new StudentServiceImpl(studentDAO);
        boolean result = studentService.registerStudent(fakeStudent);
        assertThat(result).isTrue();
        verify(studentDAO);
    }

    @Test
    public void testRegisterStudentButStudentAlreadyRegistered() {
        Student fakeStudent = new Student(40239L, "Bob", "Marley");

        StudentDAO studentDAO = mock(StudentDAO.class);
        doReturn(Optional.of(fakeStudent)).when(studentDAO).findById(40239L);
        when(studentDAO.findById(anyLong())).thenAnswer(invocation -> {
            if (invocation.getArgumentAt(0, Long.class) == 40239L) {
                return Optional.of(fakeStudent);
            }
            return Optional.empty();
        });

        StudentServiceImpl studentService = new StudentServiceImpl(studentDAO);
        boolean result = studentService.registerStudent(fakeStudent);
        assertThat(result).isFalse();

        Mockito.verify(studentDAO, times(1)).findById(40239L);
        Mockito.verifyNoMoreInteractions(studentDAO);
    }


}
