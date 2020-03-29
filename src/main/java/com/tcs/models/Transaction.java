package com.tcs.models;

import java.util.Date;

public class Transaction {
    private Integer transactionid;
    private Date time;
    private double amount;
    private String updatetype;
    private String modeofpayment;
    private int fromaccountid,toaccountid;


    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUpdatetype() {
        return updatetype;
    }

    public void setUpdatetype(String updatetype) {
        this.updatetype = updatetype;
    }

    public String getModeofpayment() {
        return modeofpayment;
    }

    public void setModeofpayment(String modeofpayment) {
        this.modeofpayment = modeofpayment;
    }

    public int getFromaccountid() {
        return fromaccountid;
    }

    public void setFromaccountid(int fromaccountid) {
        this.fromaccountid = fromaccountid;
    }

    public int getToaccountid() {
        return toaccountid;
    }

    public void setToaccountid(int toaccountid) {
        this.toaccountid = toaccountid;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionid=" + transactionid +
                ", time=" + time +
                ", amount=" + amount +
                ", updatetype='" + updatetype + '\'' +
                ", modeofpayment='" + modeofpayment + '\'' +
                ", fromaccountid=" + fromaccountid +
                ", toaccountid=" + toaccountid +
                '}';
    }
}
