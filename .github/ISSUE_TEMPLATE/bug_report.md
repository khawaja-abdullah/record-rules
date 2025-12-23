---
name: Bug report
about: Create a report to help us improve
title: ''
labels: ''
assignees: ''

---

name: 🐛 Bug report
about: Create a report to help us improve RecordRules
title: '[BUG] '
labels: bug
assignees: ''

---

## 📝 Description
A clear and concise description of what the bug is.

## 🔄 Steps to Reproduce
1. Define a Record with specific rules...
2. Instantiate the Record with specific data...
3. Observe the `RecordValidationException` (or lack thereof).

## 💻 Sample Code
Please provide a minimal code snippet to help us reproduce the issue.

```java
public record MyRecord(String field) {
    public MyRecord {
        RecordRules.check(
            Rule.on(field, "field").required() // example rule
        );
    }
}

// How are you calling it?
new MyRecord(null); 
```

## 🎯 Expected Behavior
A clear and concise description of what you expected to happen.

## ❌ Actual Behavior
What actually happened? (Include the `RecordValidationException` error map if applicable, or a stack trace if the library crashed).

## ⚙️ Environment
*   **RecordRules Version:** [e.g., 1.0.3]
*   **Java Version:** [e.g., Java 21]
*   **Build System:** [e.g., Maven, Gradle]

## 📸 Screenshots
If applicable, add screenshots to help explain your problem.

## 🕵️ Additional Context
Add any other context about the problem here (e.g., custom `satisfies` logic that isn't working).
