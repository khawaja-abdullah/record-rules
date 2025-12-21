package com.joseph.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule is a base class for all rules.
 * @param <T> Type of the value to validate
 * @param <R> Type of the rule
 */
public abstract class Rule<T, R extends Rule<T, R>> {
    /**
     * Value to validate
     */
    protected final T value;
    /**
     * Field name
     */
    protected final String fieldName;
    /**
     * List of violations
     */
    protected final List<String> violations = new ArrayList<>();

    /**
     * Rule constructor.
     * @param value Value to validate
     * @param fieldName Field name
     */
    protected Rule(T value, String fieldName) {
        this.value = value;
        this.fieldName = fieldName;
    }

    /**
     *  Creates a StringRule.
     * @param value Value to validate
     * @param name Field name
     * @return StringRule
     */
    public static StringRule on(String value, String name) {
        return new StringRule(value, name);
    }

    /**
     * Creates a NumberRule.
     * @param value Value to validate
     * @param name Field name
     * @return NumberRule
     */
    public static NumberRule on(Integer value, String name) {
        return new NumberRule(value, name);
    }

    /**
     * Creates a NumberRule.
     * @param value Value to validate.
     * @param name Field name
     * @return NumberRule
     */
    public static NumberRule on(Long value, String name) {
        return new NumberRule(value.intValue(), name);
    }

    /**
     * Returns the current rule.
     * @return the current rule
     */
    @SuppressWarnings("unchecked")
    protected R self() {
        return (R) this;
    }

    /**
     * Get the field name.
     * @return Field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Get the violations.
     * @return List of violations
     */
    public List<String> getViolations() {
        return violations;
    }

    /**
     * Validates that the value is not null.
     * @return the current rule
     */
    public R required() {
        if (value == null) violations.add("must not be null");
        return self();
    }
}
