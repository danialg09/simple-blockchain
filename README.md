# ⛓️ Simple Blockchain Core

A fundamental implementation demonstrating the **Proof-of-Work (PoW)** consensus algorithm, secure transaction validation, and block mining.

---

## 🛠️ Tech Stack

The project is implemented using the following modern stack:

* **Language:** Java 17
* **Build Tool:** Gradle

## ✨ Key Features

This project implements the core concepts of a blockchain:

* **Proof-of-Work (PoW):** Custom implementation of the PoW consensus mechanism for mining and chain security.
* **Transactions:** Handling, storage, and validation of transactions within a transaction pool.
* **Wallets:** Basic generation of public/private key pairs for user accounts.
* **Cryptographic Security:** The chain structure is secured by hashing, ensuring immutability.

## 🚀 Getting Started

The project requires **JDK 17+** to run.

1.  **Clone the repository:**
    ```bash
    git clone <YOUR_REPOSITORY_URL>
    cd simple-blockchain
    ```

2.  **Build and Run (using Gradle Wrapper):**
    ```bash
    ./gradlew run
    ```
    *(On Windows, use the command `gradlew run`)*

## 🛣️ Roadmap & Known Limitations

To demonstrate planning and understanding of the system's current state, always include this section:

* [ ] Implement **Balance Check** validation to prevent double spending.
* [ ] Introduce a simple P2P layer for node synchronization.
* [ ] Add comprehensive unit tests.