package examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5ExamplesTestCase {


    @AfterEach
    void tearDown() {
    System.out.println("After each!");
    }

    @BeforeAll
    static void beforeAll() {
    System.out.println("Let the tests begin!");
    }

    @BeforeEach
    void SetUp() {
        System.out.println("Before each!");
    }

    @Test
    void firstTest(){
        System.out.println("Here is first test()");
    }

    @Test
    void secondTest() {
        System.out.println("Here is second test()");
    }
}
