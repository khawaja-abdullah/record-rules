package com.joseph.rule.child;

import com.joseph.rule.Rule;

/**
 * NumberRule is a rule that validates a number.
 * Supports any numeric type (Integer, Long, etc.).
 */
public class NumberRule extends Rule<Number, NumberRule> {

    /**
     * NumberRule constructor.
     * @param value Value to validate
     * @param name Field name
     */
    public NumberRule(Number value, String name) {
        super(value, name);
    }

    /**
     * Validates that the number is at least the specified minimum value.
     * @param min Minimum value
     * @return NumberRule
     */
    public NumberRule min(Number min) {
        if (value != null && value.doubleValue() < min.doubleValue()) {
            violations.add("must be at least " + min);
        }
        return this;
    }

    /**
     * Validates that the number is at most the specified maximum value.
     * @param max Maximum value
     * @return NumberRule
     */
    public NumberRule max(Number max) {
        if (value != null && value.doubleValue() > max.doubleValue()) {
            violations.add("must be at most " + max);
        }
        return this;
    }
}
