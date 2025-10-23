package org.example.lab1.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkateboardAdapterTest {

    @Test
    void accelerateTest() {
        // given
        Skateboard skateboard = mock(Skateboard.class);
        SkateboardAdapter adapter = new SkateboardAdapter(skateboard);

        // when
        adapter.accelerate();

        // then
        verify(skateboard, times(1)).pushKick();
        verifyNoMoreInteractions(skateboard);
    }

    @Test
    void accelerateTestMoreThanOnceTest() {
        // given
        Skateboard skateboard = mock(Skateboard.class);
        SkateboardAdapter adapter = new SkateboardAdapter(skateboard);
        int expectedCallsNumber = 3;

        // when
        for(int i = 0; i < expectedCallsNumber; i++) {
            adapter.accelerate();
        }

        // then
        verify(skateboard, times(expectedCallsNumber)).pushKick();
        verifyNoMoreInteractions(skateboard);
    }

    @Test
    void brakeTest() {
        // given
        Skateboard skateboard = mock(Skateboard.class);
        SkateboardAdapter adapter = new SkateboardAdapter(skateboard);

        // when
        adapter.brake();

        // then
        verify(skateboard, times(1)).footBrake();
        verifyNoMoreInteractions(skateboard);
    }

    @Test
    void doOllieTest() {
        // given
        Skateboard skateboard = mock(Skateboard.class);
        SkateboardAdapter adapter = new SkateboardAdapter(skateboard);

        // when
        adapter.doOllie();

        // then
        verify(skateboard, times(1)).ollie();
        verifyNoMoreInteractions(skateboard);
    }

    @Test
    void shouldThrowNpeTest() {
        // given
        SkateboardAdapter adapter = new SkateboardAdapter(null);

        // when / then
        assertThrows(NullPointerException.class, adapter::accelerate);
        assertThrows(NullPointerException.class, adapter::brake);
        assertThrows(NullPointerException.class, adapter::doOllie);

        assertDoesNotThrow(adapter::ringBell);
    }

}