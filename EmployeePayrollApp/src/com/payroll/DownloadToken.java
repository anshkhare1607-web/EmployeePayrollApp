
package com.payroll;

public class DownloadToken {
    
    private long createdTime;
    private long expiryMillis;

    public DownloadToken() {
        this.createdTime = System.currentTimeMillis();
        this.expiryMillis = 60 * 1000; // 1 minute validity
    }

    public boolean isExpired() {
        long now = System.currentTimeMillis();
        return (now - createdTime) > expiryMillis;
    }
}
