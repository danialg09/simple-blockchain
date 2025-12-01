package com.example.blockchain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BlockchainApplication implements CommandLineRunner {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int DIFFICULTY = 4;

    public static void main(String[] args) {
        SpringApplication.run(BlockchainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n🚀 SpringBoot Started Blockchain Mining\n");

        // --- 1. BLOK ---
        System.out.println("1. Block mining...");
        Block genesisBlock = new Block("GenesisBlock start", "0");
        genesisBlock.mineBlock(DIFFICULTY);
        blockchain.add(genesisBlock);

        // --- 2. BLOK ---
        System.out.println("\n2. Block mining...");
        Block secondBlock = new Block("SecondBlock start", blockchain.get(blockchain.size()-1).hash);
        secondBlock.mineBlock(DIFFICULTY);
        blockchain.add(secondBlock);

        // --- 3. BLOK ---
        System.out.println("\n3. Block mining...");
        Block thirdBlock = new Block("Third block start", blockchain.get(blockchain.size()-1).hash);
        thirdBlock.mineBlock(DIFFICULTY);
        blockchain.add(thirdBlock);

        System.out.println("\n--- Wallet Test Start ---");

        Wallet myWallet = new Wallet();

        System.out.println("Public Key (Address): " + java.util.Base64.getEncoder().encodeToString(myWallet.publicKey.getEncoded()));
        System.out.println("Private Key (Secret): " + java.util.Base64.getEncoder().encodeToString(myWallet.privateKey.getEncoded()));

        System.out.println("-----------------------------");

        System.out.println("\n--- Transactions Test Start ---");

        System.out.println("\n--- Wallets Creation ---");
        Wallet walletA = new Wallet();
        Wallet walletB = new Wallet();

        System.out.println("Wallet A Public Key: " + java.util.Base64.getEncoder().encodeToString(walletA.publicKey.getEncoded()));
        System.out.println("Wallet B Public Key: " + java.util.Base64.getEncoder().encodeToString(walletB.publicKey.getEncoded()));

        System.out.println("\n--- Creating Transaction ---");
        Transaction tx = new Transaction(walletA.publicKey, walletB.publicKey, 10);
        tx.generateSignature(walletA.privateKey);

        System.out.println("Transaction created from Wallet A to Wallet B");
        System.out.println("Transaction signature: " + java.util.Base64.getEncoder().encodeToString(tx.signature));

        System.out.println("\n--- Mining Block with Transaction ---");
        Block block4 = new Block("Block with transaction", blockchain.get(blockchain.size()-1).hash);
        block4.addTransaction(tx);
        block4.mineBlock(DIFFICULTY);
        blockchain.add(block4);

        System.out.println("Block successfully mined and added to blockchain!");
        System.out.println("Block hash: " + block4.hash);
        System.out.println("Block contains transactions:");
        for (Transaction t : block4.getTransactions()) {
            System.out.println(" - From: " + java.util.Base64.getEncoder().encodeToString(t.sender.getEncoded())
                    + " To: " + java.util.Base64.getEncoder().encodeToString(t.recipient.getEncoded())
                    + " Amount: " + t.value);
        }

        System.out.println("\n✅ Done now you are in Spring Boot Application");
    }
}
