package rules;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    
    // New test for self-written code
    @Test
    public void testMayUseSelfWrittenCode() {
        assertTrue("Expected true: self-written code",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, true));
    }
    
    // New test for publicly available code that is cited
    @Test
    public void testMayUseCitedPublicCode() {
        assertTrue("Expected true: cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }
    
    // New test for uncited public code
    @Test
    public void testMayNotUseUncitedPublicCode() {
        assertFalse("Expected false: uncited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }
    
    // New test for non-coursework and non-implementation required
    @Test
    public void testMayUseNonCourseworkCode() {
        assertTrue("Expected true: non-coursework code without implementation requirement",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, false, false));
    }
}
