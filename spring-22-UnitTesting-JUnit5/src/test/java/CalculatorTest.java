import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {//main Asserts()
    @BeforeAll
    static void setUpAll() {

        System.out.println("BeforeAll is executed");
    }
        @AfterAll
        static void tearDownAll(){
            System.out.println("AfterAll is executed");
    }



  @BeforeEach
    void setUpEach(){
      System.out.println("Before each executed");

    }
    @AfterEach
    void tearDownEach(){
        System.out.println("After each executed");

    }

    @Test
    @DisplayName("MyMethode")
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5, actual,"Test failed");
    }
    @Test
    void add2() {
        System.out.println("Add2 method");
       // assertThrows(IllegalArgumentException.class, ()->Calculator.add2(3,2));
       // assertThrows(AccessDeniedException.class, ()->Calculator.add2(3,2));
        assertThrows(IllegalArgumentException.class, ()->Calculator.add2(2,3));
    }

    @Test
    void testCase1(){
//        System.out.println("TEST CASE 1");
        fail("Not implemented yet.");
    }

    @Test
    void testCase2(){
        System.out.println("TEST CASE 2");
        assertEquals("add",Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }
    @Test
    void testCase3(){
        System.out.println("TEST CASE 3");
        assertArrayEquals(new int[]{1,2,3}, new int[]{2,1,3}, "Arrays are not equal");
    }

    @Test
    void testCase4(){
        System.out.println("TEST CASE 4");

        String nullString=null;
        String notNullString="Cydeo";

        assertNotNull(notNullString);
        assertNull(nullString);

//        assertNotNull(nullString);
//        assertNull(notNullString);
//
    }
    @Test
    void testCase5() {
        System.out.println("TEST CASE 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }
}