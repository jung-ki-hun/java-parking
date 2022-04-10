package com.nhnacademy.parking;

public class PaycoServer {
    private String [] member = new String[1];
    public PaycoServer() {
        for (int i = 0; i < member.length ; i++) {
            member[i] = "jodon"+i;
        }
    }

    public boolean checkPayco(String user){
        for (String s : member) {
            if (s.equals(user))
                return true;
        }
        return false;
    }


}
