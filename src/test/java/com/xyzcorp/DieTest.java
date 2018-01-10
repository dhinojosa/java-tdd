package com.xyzcorp;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class DieTest {
    @Test
    public void testDefault1() {
        Die die = new JavaUtilRandomDie(null);
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testRollOf4() {
        //Collaborator
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        //Subject Under Test
        Die die = new JavaUtilRandomDie(random);
        assertThat(die.roll().getPips()).isEqualTo(4);
    }

    @Test
    public void testRollOf4WithMock() {
        Random random = createMock(Random.class);

        expect(random.nextInt(6)).andReturn(2).andReturn(5);

        //rehearsal
        replay(random);

        //setup
        Die die = new JavaUtilRandomDie(random);

        //assertion
        assertThat(die.roll().roll().getPips()).isEqualTo(5);

        //verification
        verify(random);
    }

}
