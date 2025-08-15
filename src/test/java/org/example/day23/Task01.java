package org.example.day23;

// Tag Annotation
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

class Task01 {

    @Test
    @Tag("firstPriority")
    void testMethod01() {
        System.out.println("Running testMethod01 with firstPriority tag");
    }

    @Test
    @Tag("firstPriority")
    void runTestcase02() {
        System.out.println("Running runTestcase02 with firstPriority tag");
    }

    @Test
    @Tag("fastTag")
    void testMethod03() {
        System.out.println("Running testMethod03 with fastTag");
    }

    @Test
    @Tag("slowTag")
    void runTestcase04() {
        System.out.println("Running runTestcase04 with slowTag");
    }
}
