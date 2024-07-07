package test.java;

import org.testng.TestNG;

class FactorialTest {

    public static void main(String[] strings) {
        final TestNG testNG = new TestNG(true);
        testNG.setTestClasses(new Class[] {FactorialTests.class});
        testNG.setExcludedGroups("optional");
        testNG.run();
    }
}