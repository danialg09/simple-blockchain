package com.example.blockchain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public Long timestamp;
    public int nonce;
    public ArrayList<Transaction> transactions = new ArrayList<>();

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public void addTransaction(Transaction transaction) {
        if(transaction != null) {
            if(transaction.verifySignature()) {
                transactions.add(transaction);
            } else {
                System.out.println("Transaction signature failed to verify");
            }
        }
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Congratulations you have successfully mined the block!");
        System.out.println("Hash: " + hash);
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        timestamp +
                        nonce +
                        data +
                        transactions.toString()
        );
    }
}
