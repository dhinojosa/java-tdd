package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DieTest {

    @Test
    public void testDefaultIs1() {
        Die die = new JavaUtilRandomDie(mock(Random.class));
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testRollOf4() {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Die die = new JavaUtilRandomDie(random);
        Die newDie = die.roll();
        assertThat(newDie.getPips()).isEqualTo(4);
    }

    @Test
    public void testRollOf3() {
        //Mock
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(2);
        Die die = new JavaUtilRandomDie(random);
        Die newDie = die.roll();
        assertThat(newDie.getPips()).isEqualTo(3);
        verify(random).nextInt(6);
    }

    @Test
    public void testRollOf3And5() {
        //Mock
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(2,4);
        Die die = new JavaUtilRandomDie(random);
        Die newDie = die.roll().roll();
        assertThat(newDie.getPips()).isEqualTo(5);
        verify(random, times(2)).nextInt(6);
    }

    @Test
    @Category(value = IntegrationTest.class)
    public void testIntegrationWithAActualRandom() {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
          Die die = new JavaUtilRandomDie(random);
          assertThat(die.roll().getPips())
                  .isGreaterThan(0).isLessThan(7);
        }
    }

    @Test
    public void testBUG302() {
        //Mock
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(3);
        Die die = new JavaUtilRandomDie(random);
        Die newDie = die.roll();
        assertThat(newDie.getPips()).isEqualTo(4);
        verify(random, times(1)).nextInt(6);
    }

    @Test
    public void testBUG302HandlingZeroCase() {
        //Mock
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(0);
        Die die = new JavaUtilRandomDie(random);
        Die newDie = die.roll();
        assertThat(newDie.getPips()).isEqualTo(1);
        verify(random, times(1)).nextInt(6);
    }
}
