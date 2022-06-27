package com.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class StackTest {

    Stack<Object> stack;

    @Test
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        void addAnItem() {
            assumeTrue(stack.isEmpty());
            stack.push("A");
            assertEquals(1,stack.size());
        }


    }

}
