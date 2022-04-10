package com.nhnacademy.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpace> spaceArrayList = new ArrayList<>();

    public List<ParkingSpace> getSpaceArrayList() {
        return spaceArrayList;
    }



    public void enter(String scanCarNumber) {
        ParkingSpace parkingSpace;
        int codeIndex = spaceArrayList.size()+1;
        String code = "A-"+codeIndex;
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
        for (ParkingSpace parkingSpace : spaceArrayList) {
            if (parkingSpace.getCar().getNumber().equals(scanCarNumber))
                return parkingSpace.getCode();
        }
        return null;
    }
    public ParkingSpace getParkingCarData(String scanCarNumber){
        int index = getIndex(scanCarNumber);
        if ( index != -1)
            return spaceArrayList.get(index);
        return null;
    }
    public int getIndex(String scanCarNumber){
        for (int i = 0; i < spaceArrayList.size(); i++) {
            if(spaceArrayList.get(i).getCar().getNumber().equals(scanCarNumber)) {
                return i;
            }
        }
        return -1;
    }
    public void out(String scanCarNumber) {
        if(getIndex(scanCarNumber) != -1)
        {
            spaceArrayList.remove(getIndex(scanCarNumber));
        }
    }
}
