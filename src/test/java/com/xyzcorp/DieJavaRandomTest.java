package com.xyzcorp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class DieJavaRandomTest {

    @Test
    void testSimpleRollOf4() {
        //Stub
        Random randomStub = new Random(){
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Die die = new DieJavaRandom(randomStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }

    @Test
    void testDefaultIs1WithRandomConstructor() {
        Random randomStub = new Random(){
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Die die = new DieJavaRandom(randomStub);
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    void testRollTwiceWithEasyMock() {
        //Create the mock
        Random randomMock = createMock(Random.class);

        //Rehearse with the mock
        expect(randomMock.nextInt(6)).andReturn(5).andReturn(2);

        //Replay (EasyMock only)
        replay(randomMock);

        Die die = new DieJavaRandom(randomMock);
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(3);

        //Verify
        verify(randomMock);
    }

    @Test
    void testRollTwiceWithMockito() {
        //Create the mock
        Random randomMock = Mockito.mock(Random.class);

        //Rehearse with the mock
        Mockito.when(randomMock.nextInt(6)).thenReturn(5,2);

        Die die = new DieJavaRandom(randomMock);
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(3);
        //Verify
        //Mockito.verifyNoMoreInteractions(randomMock);
    }

    @Test
    public void testBUG2040() {
        //Create the mock
        Random randomMock = createMock(Random.class);

        //Rehearse with the mock
        expect(randomMock.nextInt(6)).andReturn(2);

        //Replay (EasyMock only)
        replay(randomMock);

        Die die = new DieJavaRandom(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isLessThan(7);

        //Verify
        verify(randomMock);
    }

    @Test
    public void testBUG2040WithAZero() {
        //Create the mock
        Random randomMock = createMock(Random.class);

        //Rehearse with the mock
        expect(randomMock.nextInt(6)).andReturn(0);

        //Replay (EasyMock only)
        replay(randomMock);

        Die die = new DieJavaRandom(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(1);

        //Verify
        verify(randomMock);
    }

    @Test
    public void testIntegrationTestWithARealRandom() {
        Die die = new DieJavaRandom(new Random());
        for (int i = 0; i < 1000000; i++) {
            assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }

    @Test
    public void testDieFactory() {
        Die die = DieJavaRandom.create();
        assertThat(die).isInstanceOf(DieJavaRandom.class).isNotNull();
    }
}
