package com.xyzcorp.instructor;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.mockito.Mockito.*;

public class JavaUtilRandomDieTest {

    @Test
    public void testDefaultShouldBe1() {
        Random dummy = createMock(Random.class);
        Die die = new JavaUtilRandomDie(dummy);
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testRollOf4() {
        Random randomStub = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Die die = new JavaUtilRandomDie(randomStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);
    }

    @Test
    public void testRollOf2UsingEasyMock() {
        //Initialization
        Random randomMock = createMock(Random.class);

        //Rehearsal
        expect(randomMock.nextInt(6)).andReturn(4).once();

        //Easy Mock Only
        replay(randomMock);

        //Actual Test
        Die die = new JavaUtilRandomDie(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);

        //Verify
        verify(randomMock);
    }


    public void testRollOf2UsingMockito() {
        //Initialization
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(6)).thenReturn(2);

        //Actual Test
        Die die = new JavaUtilRandomDie(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(3);

        Mockito.verify(randomMock).nextInt(6);
    }

    @Test
    public void testRollOf2ThenARollOf4UsingMockito() {
        //Initialization
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(6)).thenReturn(2,4);

        //Actual Test
        Die die = new JavaUtilRandomDie(randomMock);
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);

        Mockito.verify(randomMock, times(2)).nextInt(6);
    }

    @Test
    public void testBUG43040() {
        Random randomMock = mock(Random.class);
        int someLargeNumber = 50090;
        when(randomMock.nextInt(6)).thenReturn(5);

        //Actual Test
        Die die = new JavaUtilRandomDie(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isGreaterThan(0).isLessThan(7);

        Mockito.verify(randomMock).nextInt(6);
    }


    public void testBUG43040WithZero() {
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(6)).thenReturn(0);

        //Actual Test
        Die die = new JavaUtilRandomDie(randomMock);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isGreaterThan(0).isLessThan(7);

        Mockito.verify(randomMock).nextInt(7);
    }


    /**
     * Google Search for Unit vs. Integration
     * Integration test Humor:
     * https://twitter.com/elgwhoppo/status/1125541620206788608
     * https://twitter.com/timbray/status/822470746773409794
     * https://tenor.com/view/unittest-unit-test-gif-10813141
     * https://tenor.com/view/unittest-integrationtest-bug-baddesign-crappydesign-gif-8112114
     */
    @Test
    public void testRealRandomDistributionIT() {
        Die die = new JavaUtilRandomDie(new Random());
        for(int i = 1; i <= 1000000; i++) {
           assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }



    @Test
    public void testFactoryMethodToCreateDie() {
        Die die = JavaUtilRandomDie.create();
        assertThat(die).isNotNull();
    }

}
