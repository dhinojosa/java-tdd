package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class DieTest {

    @Test
    public void testDefaultOf1UsingTheConstructorWithRandom() throws Exception {
        JavaUtilRandomDie die = new JavaUtilRandomDie(new Random()); //Dummy
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testRollWithA4() {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        //Inversion of Control
        //Dependency Injection
        JavaUtilRandomDie die = new JavaUtilRandomDie(random);
        JavaUtilRandomDie copy = die.roll();
        assertThat(copy.getPips()).isEqualTo(4);
    }


    @Test
    public void testRollWithA5() {
        //Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        JavaUtilRandomDie die = new JavaUtilRandomDie(random);
        JavaUtilRandomDie copy = die.roll();
        assertThat(copy.getPips()).isEqualTo(5);
    }


    @Test
    @Category(value = UnitTest.class)
    public void testRollTwiceWithEasyMock() {
        Random random = createMock(Random.class);

        //rehearsal
        expect(random.nextInt(6)).andReturn(3).andReturn(4);

        //replay (EasyMock)
        replay(random);

        //do my test
        JavaUtilRandomDie die = new JavaUtilRandomDie(random);
        JavaUtilRandomDie copy = die.roll().roll();
        assertThat(copy.getPips()).isEqualTo(5);

        //verify
        verify(random);
    }



    @Test
    @Category(value = IntegrationTest.class)
    public void testIntegrationWithARealRandom() {
        JavaUtilRandomDie die = new JavaUtilRandomDie(new Random());
        for (int i = 0; i < 1000000; i++) {
            assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }

    @Test
    public void testBUG101() {
        Random random = createMock(Random.class);

        //rehearsal
        expect(random.nextInt(6)).andReturn(5);

        //replay (EasyMock)
        replay(random);

        //do my test
        JavaUtilRandomDie die = new JavaUtilRandomDie(random);
        JavaUtilRandomDie copy = die.roll();
        assertThat(copy.getPips()).isGreaterThan(0).isLessThan(7);

        //verify
        verify(random);
    }

    @Test
    public void testBUG101WithAZero() {
        Random random = createMock(Random.class);

        //rehearsal
        expect(random.nextInt(6)).andReturn(0);

        //replay (EasyMock)
        replay(random);

        //do my test
        JavaUtilRandomDie die = new JavaUtilRandomDie(random);
        JavaUtilRandomDie copy = die.roll();
        assertThat(copy.getPips()).isGreaterThan(0).isLessThan(7);

        //verify
        verify(random);
    }

}
