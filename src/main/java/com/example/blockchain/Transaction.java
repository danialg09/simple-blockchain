package com.example.blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Transaction {
    public String transactionId;
    public PublicKey sender;
    public PublicKey recipient;
    public float value;
    public byte[] signature;

    public Transaction(PublicKey from, PublicKey to, float value) {
        this.sender = from;
        this.recipient = to;
        this.value = value;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = getData();
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = getData();
        return StringUtil.verifyECDSASig(sender, data, signature);
    }

    private String getData() {
        return StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + value;
    }
}
