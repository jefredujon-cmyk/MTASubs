MTA Subs Ordering System
“Through the Pain and Through the Storm… We Still Serving Subs.”

A fully interactive Java console app for building custom New York–style sandwiches.

🥖 Build Subs
🥤 Add Drinks
🍟 Add Chips
🧾 Generate Receipts
💻 100% Java 
🚇 What Is This Project?

MTA Subs Ordering System is a menu-driven Java application where the user can create full meal orders including sandwiches, drinks, and chips.
Every sandwich is fully customizable and priced dynamically based on size, bread, and toppings.

The app also generates a clean, itemized receipt file so every order is saved.

🔥 Key Features
🥖 Custom Sandwich Builder

Choose everything:

Bread type

Size (ROLL, SIDEKICK, HERO)

Toasted or not

Meats

Cheeses

Regular toppings

Sauces

💲 Every topping auto-calculates price by category + size.

🥤 Drinks & 🍟 Chips

Add:

A drink (choose size & flavor)

A chips bag (any type)

🧾 Receipt Generation

At checkout, the app instantly saves a receipt with:

Full itemized list

Prices

Sandwich toppings

Total cost

Receipts are stored locally in a clean folder.

🎛️ Menu System

Easy console-based interface:

🏠 Welcome to MTA Subs
1) New Order
0) Exit


Inside each order:

🧺 Order Menu:
1) Add Sandwich
2) Add Drink
3) Add Chips
4) Checkout
0) Cancel Order

🧱 Project Structure
📦 src
 ├── com.pluralsight
 │    ├── Application.java
 │    ├── models/
 │    │    ├── Sandwich.java
 │    │    ├── Topping.java
 │    │    ├── Size.java
 │    │    ├── Drink.java
 │    │    ├── Chips.java
 │    │    └── Order.java
 │    ├── ui/
 │    │    └── UserInterface.java
 │    └── util/
 │         └── ReceiptWriter.java
📂 receipts/
     └── saved receipt files

🧮 Size Enum System
public enum Size {
    ROLL(5.0, "ROLL"),
    SIDEKICK(12.0, "SIDEKICK"),
    HERO(15.0, "HERO");
}


Each size includes:

A display name

A base price

A numeric size passed into Sandwich logic
