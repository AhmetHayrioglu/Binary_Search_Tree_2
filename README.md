# Binary Search Tree (BST) — Object-Oriented Java Implementation

This project is a clean and modular re-implementation of a Binary Search Tree (BST) in Java. It was designed with a strong emphasis on **readability**, **maintainability**, and **object-oriented principles**, and reflects my growth as a software developer.

---

## 🧠 Motivation

While my earlier BST implementation was functional, it lacked structure and scalability. This version was rewritten from the ground up to:

- **Improve code clarity and readability**
- **Separate responsibilities across classes and interfaces**
- **Follow clean coding practices and OOP design patterns**
- **Enable extensibility for features like visualization**

---

## ✨ Key Features

### ✅ Clean Object-Oriented Design
- Each class (`BST`, `BSTNode`, `TreeDrawer`, etc.) has a single, focused responsibility.
- The code uses proper encapsulation and method abstraction.
- Behavior and structure are decoupled for maintainability.

### 🔁 Enum-Based Branching for Clarity
- Introduced a `ChildStatus` enum to make node state handling (in delete logic) intuitive and less error-prone.
- Improved readability and removed nested conditional blocks using `switch-case`.

### 🖼️ Visualization Support (Strategy Pattern)
- Added a `TreeDrawer` interface to enable runtime visualization strategy injection.
- The tree can be visualized using any custom implementation of `TreeDrawer`.
- Included a sample visualization class: `BasicTreeDraw`.

### 🔍 Traversals and Utilities
- In-order traversal to verify BST structure.
- Utility method for computing tree depth.

---

## 📁 Project Structure

Binary_Search_Tree_2/ ├── BST.java // Main Binary Search Tree class ├── BSTNode.java // Node class with child status logic ├── ChildStatus.java // Enum for node type (leaf, one child, both) ├── TreeNode.java // Interface for node abstraction ├── TreeDrawer.java // Strategy interface for visualization └── BasicTreeDraw.java // Sample visualization using Swing
