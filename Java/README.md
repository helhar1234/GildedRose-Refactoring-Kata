# Exercise 6 - Refactoring (Testing)

## Testing Strategy
1. Testing the normal items and refactoring the code to make it easier to read.
2. Testing the special items.
3. Testing edge cases such as a negative sellIn for sulfuras, which should not happen.

For every test, there is a respective negative test.

## Test Coverage
- Normal Items
- Aged Brie
- Backstage Passes
- Sulfuras
- Edge Cases

## Challenges
- Understanding initial code logic and refactoring.

# Exercise 7 - Refactoring
## Refactoring Choices

To improve the maintainability and scalability of the Gilded Rose codebase, we implemented several refactoring strategies aimed at enhancing code structure and readability while preserving existing functionality.

### Key Improvements

1. **Separation of Concerns**
    - We introduced an `ItemUpdater` abstraction, which encapsulates item-specific update logic into separate classes. This separation allows for better organization and easier extensibility when adding new item types.

2. **Encapsulation**
    - Common operations such as decreasing `sellIn` and adjusting `quality` have been centralized in the base class, reducing code duplication and ensuring consistent behavior across item types.

3. **Open/Closed Principle**
    - The refactoring aligns with this principle by making it easier to introduce new item behaviors without modifying the core logic. The update mechanism now relies on a factory method to instantiate the appropriate `ItemUpdater` subclass based on item type.

4. **Improved Readability & Maintainability**
    - The switch to a class-based strategy pattern makes it easier for developers to understand and maintain each item's behavior independently without complex conditionals in a single method.

5. **Package Structure**
    - The `ItemUpdaters` package contains all logic related to item-specific behavior, while the `model` package contains the `Item` class, maintaining a clear separation between data and business logic.

By implementing these changes, we have created a cleaner and more modular codebase that is easier to test, extend, and maintain in the future.

