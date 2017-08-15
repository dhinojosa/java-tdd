package com.xyzcorp;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class RandomDieTest {
    @Test
    @Category(value=UnitTest.class)
    public void testDefaultIs1() {
        Die die = new RandomDie(null);
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    @Category(value=UnitTest.class)
    public void testRollOf4() throws Exception {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Die die = new RandomDie(random);
        Die dieCopy = die.roll();
        assertThat(dieCopy.getPips()).isEqualTo(4);
    }

    @Test
    @Category(value=UnitTest.class)
    public void testRollOf2() throws Exception {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 1;
            }
        };
        Die die = new RandomDie(random);
        Die dieCopy = die.roll();
        assertThat(dieCopy.getPips()).isEqualTo(2);
    }

    @Test
    @Category(value=UnitTest.class)
    public void testRollTwice() throws Exception {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Die die = new RandomDie(random);
        Die dieCopy = die.roll().roll();
        assertThat(dieCopy.getPips()).isEqualTo(5);
    }

    @Test
    @Category(value=IntegrationTest.class)
    public void testIntegrationWithARealRandom() {
       Random random = new Random();
       Die die = new RandomDie(random);
       for (int i = 0; i < 1000000; i++) {
           assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
       }
    }


    @Test
    @Category(value=IntegrationTest.class)
    public void testIntegrationWithDistribution() {
        Random random = new Random();
        Die die = new RandomDie(random);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 1; i < 7; i++) {
            map.put(i, 0L);
        }
        for (int i = 0; i < 1000000; i++) {
            int result = die.roll().getPips();
            map.put(result, map.getOrDefault(result, 0L) + 1L);
        }
        map.forEach((integer, aLong) -> {
                    System.out.println(integer);
                assertThat(aLong).isGreaterThan(0).as("from the integer: %d", integer);
        });
    }

    @Test
    public void testBUG1040() {
        Random random = createMock(Random.class);

        //Rehearse
        expect(random.nextInt(6)).andReturn(5);

        //Replay/Rewind (EasyMock only)
        replay(random);

        //Do my test!
        Die die = new RandomDie(random);
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);

        //Verify
        verify(random);
    }

    @Test
    public void testBUG1040_Zero() {
        Random random = createMock(Random.class);

        //Rehearse
        expect(random.nextInt(6)).andReturn(0);

        //Replay/Rewind (EasyMock only)
        replay(random);

        //Do my test!
        Die die = new RandomDie(random);
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);

        //Verify
        verify(random);
    }

    @Test
    public void testBUG1040_No6() {
        Random random = createMock(Random.class);

        //Rehearse
        expect(random.nextInt(6)).andReturn(3);

        //Replay/Rewind (EasyMock only)
        replay(random);

        //Do my test!
        Die die = new RandomDie(random);
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);

        //Verify
        verify(random);
    }
}
