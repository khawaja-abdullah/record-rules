---
name: Feature request
about: Suggest an idea for this project
title: ''
labels: ''
assignees: ''

---

name: "🚀 Feature request"
about: Suggest an idea or a new validation rule for RecordRules
title: '[FEAT] '
labels: enhancement
assignees: ''

---

## 💡 Problem Statement
Is your feature request related to a problem? Please describe. 
*(e.g., "I am currently unable to validate the range of a Double field without using a custom predicate.")*

## 🌟 Proposed Solution
A clear and concise description of what you want to happen.

## 🛠 Proposed API / Usage Syntax
How would you like to use this feature? Please provide a code snippet of the ideal fluent API call.

```java
public record Product(double price) {
    public Product {
        RecordRules.check(
            // Example of a new rule you might want:
            Rule.on(price, "price").greaterThan(0.0) 
        );
    }
}
```

## 🎯 Use Case / Rationale
Why is this feature important to you or other developers? How does it improve the project?

## 🔄 Alternatives Considered
A clear and concise description of any alternative solutions or features you've considered (e.g., using `.satisfies(...)`).

## 🕵️ Additional Context
Add any other context, screenshots, or library comparisons here.
