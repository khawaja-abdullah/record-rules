package com.joseph.rule.child;

import com.joseph.rule.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberRuleTest {

    @Test
    void testMinBranches() {
        // Branch 1: Value is null (Should skip validation)
        NumberRule ruleNull = Rule.on((Integer) null, "age").min(18);
        assertTrue(ruleNull.getViolations().isEmpty());

        // Branch 2: Value is exactly the minimum (Pass)
        NumberRule ruleEqual = Rule.on(18, "age").min(18);
        assertTrue(ruleEqual.getViolations().isEmpty());

        // Branch 3: Value is greater than minimum (Pass)
        NumberRule ruleGreater = Rule.on(20, "age").min(18);
        assertTrue(ruleGreater.getViolations().isEmpty());

        // Branch 4: Value is less than minimum (Fail)
        NumberRule ruleFail = Rule.on(15, "age").min(18);
        assertEquals(1, ruleFail.getViolations().size());
        assertEquals("must be at least 18", ruleFail.getViolations().get(0));
    }

    @Test
    void testMaxBranches() {
        // Branch 1: Value is null
        NumberRule ruleNull = Rule.on((Integer) null, "score").max(100);
        assertTrue(ruleNull.getViolations().isEmpty());

        // Branch 2: Value is exactly the maximum (Pass)
        NumberRule ruleEqual = Rule.on(100, "score").max(100);
        assertTrue(ruleEqual.getViolations().isEmpty());

        // Branch 3: Value is less than maximum (Pass)
        NumberRule ruleLess = Rule.on(50, "score").max(100);
        assertTrue(ruleLess.getViolations().isEmpty());

        // Branch 4: Value is greater than maximum (Fail)
        NumberRule ruleFail = Rule.on(101, "score").max(100);
        assertEquals(1, ruleFail.getViolations().size());
        assertEquals("must be at most 100", ruleFail.getViolations().get(0));
    }

    @Test
    void testLongConversionFactory() {
        // This targets Rule.on(Long, String) in the base Rule class
        // which internally calls the NumberRule(Integer, String) constructor.
        NumberRule rule = Rule.on(500L, "count").min(100);
        assertNotNull(rule);
        assertEquals("count", rule.getFieldName());
    }
}