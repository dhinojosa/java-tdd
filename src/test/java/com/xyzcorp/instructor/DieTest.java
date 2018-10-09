package com.xyzcorp.instructor;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.mockito.Mockito.*;

public class DieTest {

    @Test
    public void testDefaultOf1WithRandom() {
        Die die = new Die(mock(Random.class)); //Dummy
        assertThat(die.getPip()).isEqualTo(1);
    }

    @Test
    public void testRollAndGetA4() {
        Random random = new Random() {  //Collaborator, Stub
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Die die = new Die(random);
        Die resultDie = die.roll();
        assertThat(resultDie.getPip()).isEqualTo(4);
    }

    @Test
    public void testRollAndGetA3() {
        Random random = new Random() {  //Collaborator
            @Override
            public int nextInt(int bound) {
                return 2;
            }
        };
        Die die = new Die(random);
        Die resultDie = die.roll();
        assertThat(resultDie.getPip()).isEqualTo(3);
    }

    @Test
    public void testRollAndGet5() {
        Random random = new Random() {  //Collaborator
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Die die = new Die(random);  //SUT (Subject under test)
        Die resultDie = die.roll();
        assertThat(resultDie.getPip()).isEqualTo(5);
    }

    @Test
    public void testTwoRollsGetA6() {
        Random random = mock(Random.class); //Collaborator
        when(random.nextInt(6)).thenReturn(3,5);

        Die die = new Die(random);
        Die result = die.roll().roll();
        assertThat(result.getPip()).isEqualTo(6);

        verify(random, times(2)).nextInt(6);
    }

    @Test
    public void testBUG4012Mockito() {
        Random random = mock(Random.class); //Collaborator
        when(random.nextInt(6)).thenReturn(5);

        Die die = new Die(random);
        Die result = die.roll();
        assertThat(result.getPip()).isGreaterThan(0).isLessThan(7);

        verify(random, times(1)).nextInt(6);
    }

    @Test
    public void testBUG4012EasyMock() {
        Random random = createMock(Random.class); //Collaborator
        expect(random.nextInt(6)).andReturn(5);

        replay(random);

        Die die = new Die(random);
        Die result = die.roll();
        assertThat(result.getPip()).isGreaterThan(0).isLessThan(7);

        EasyMock.verify(random);
    }

    @Test
    public void testBUG4012EasyMockWith0() {
        Random random = createMock(Random.class); //Collaborator
        expect(random.nextInt(6)).andReturn(0);

        replay(random);

        Die die = new Die(random);
        Die result = die.roll();
        assertThat(result.getPip()).isGreaterThan(0).isLessThan(7);

        EasyMock.verify(random);
    }
    @Test
    @Category(value = IntegrationTest.class)
    public void testIntegrationWithRealRandom() { //4012
        Random random = new Random();
        Die die = new Die(random); //TDD
        for(int i = 0; i < 1000000; i++) {
            assertThat(die.roll().getPip()).isGreaterThan(0).isLessThan(7);
        }
    }
}
