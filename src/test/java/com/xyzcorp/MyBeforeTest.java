package com.xyzcorp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class MyBeforeTest {

    @Test
    public void testImportantMethod() {
        Collaborator collaborator = createMock(Collaborator.class);

        //rehearsal
        expect(collaborator.method1(4,3)).andReturn(7);

        replay(collaborator); //You only need this for easy mock

        //invoke subject under test

        MyBefore mb = new MyBefore(collaborator);
        int result = mb.importantMethod();

        assertThat(result).isEqualTo(7);

        verify(collaborator); //Might not be necessary with mockito
    }
}
