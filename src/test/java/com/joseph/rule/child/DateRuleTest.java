package com.joseph.rule.child;

import com.joseph.rule.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateRuleTest {

    @Test
    void testIsFutureBranches() {
        // Branch 1: Value is null (Should skip logic and not crash)
        DateRule ruleNull = Rule.on((LocalDate) null, "date").isFuture();
        assertTrue(ruleNull.getViolations().isEmpty());

        // Branch 2: Value is in the future (Valid)
        LocalDate future = LocalDate.now().plusDays(1);
        DateRule ruleValid = Rule.on(future, "date").isFuture();
        assertTrue(ruleValid.getViolations().isEmpty());

        // Branch 3: Value is NOT in the future (Invalid - Today or Past)
        LocalDate past = LocalDate.now().minusDays(1);
        DateRule ruleInvalid = Rule.on(past, "date").isFuture();
        assertEquals(1, ruleInvalid.getViolations().size());
        assertEquals("must be a future date", ruleInvalid.getViolations().get(0));

        // Edge case: Today is not "Future"
        DateRule ruleToday = Rule.on(LocalDate.now(), "date").isFuture();
        assertEquals(1, ruleToday.getViolations().size());
    }

    @Test
    void testIsPastBranches() {
        // Branch 1: Value is null
        DateRule ruleNull = Rule.on((LocalDate) null, "date").isPast();
        assertTrue(ruleNull.getViolations().isEmpty());

        // Branch 2: Value is in the past (Valid)
        LocalDate past = LocalDate.now().minusDays(1);
        DateRule ruleValid = Rule.on(past, "date").isPast();
        assertTrue(ruleValid.getViolations().isEmpty());

        // Branch 3: Value is NOT in the past (Invalid - Today or Future)
        LocalDate future = LocalDate.now().plusDays(1);
        DateRule ruleInvalid = Rule.on(future, "date").isPast();
        assertEquals(1, ruleInvalid.getViolations().size());
        assertEquals("must be a past date", ruleInvalid.getViolations().get(0));

        // Edge case: Today is not "Past"
        DateRule ruleToday = Rule.on(LocalDate.now(), "date").isPast();
        assertEquals(1, ruleToday.getViolations().size());
    }

    @Test
    void testConstructorAndInheritance() {
        // Targets the constructor explicitly (though covered via Rule.on)
        LocalDate now = LocalDate.now();
        DateRule rule = new DateRule(now, "birthDate");
        assertEquals("birthDate", rule.getFieldName());
    }
}