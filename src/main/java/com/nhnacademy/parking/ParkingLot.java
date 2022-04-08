package com.nhnacademy.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingSpace> spaceArrayList = new ArrayList<>();


    public void enter(String scanCarNumber) {
        ParkingSpace parkingSpace;
        int codeIndex = spaceArrayList.size();
        String code = "A - "+codeIndex;
        if(checkSpace(scanCarNumber) == -1) {
           parkingSpace =  new ParkingSpace(code,new Car(scanCarNumber));
           spaceArrayList.add(parkingSpace);
        }
        if(checkSpace(scanCarNumber) != -1 ){
            throw new CarNumberIsNotSameException();
        }

    }
    public int checkSpace(String scanCarNumber){
        return spaceArrayList.indexOf(new ParkingSpace(new Car(scanCarNumber)));
    }
    public String findParkingCode(String scanCarNumber){
        int pakingCodeIndex = spaceArrayList.indexOf(scanCarNumber);
        if(pakingCodeIndex != -1)
            return spaceArrayList.get(pakingCodeIndex).getCode();

        return null;
    }
}
