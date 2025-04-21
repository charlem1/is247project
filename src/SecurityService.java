package com.club.service;
import java.util.Date;
import java.util.Random;
public class SecurityService {
   public boolean verifyAge(int age) {
        return age >= 21; // Minimum legal drinking age
    }

    public boolean isVIP(Member member) {
        return member.isVip() && verifyAge(member.getAge());
    }

    public String getAccessLevel(Member member) {
        if (isVIP(member)) {
            return "VIP Access Granted";
        } else if (member.isPreRegistered()) {
            return "Standard Access Granted";
        } else {
            return "Paper Wristband Issued - Limited Access";
        }
    }
}
