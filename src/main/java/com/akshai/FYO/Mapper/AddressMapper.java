package com.akshai.FYO.Mapper;

import com.akshai.FYO.DTO.AddressDto;
import com.akshai.FYO.Model.Address;

public class AddressMapper {

    public static AddressDto addressToAddressDto(Address address){
        AddressDto addressDto=new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setVillage(address.getVillage());
        addressDto.setTown(address.getTown());
        addressDto.setState(address.getState());
        addressDto.setCountry(address.getCountry());
        addressDto.setPinCode(address.getPinCode());
        return addressDto;
    }

    public static Address addressDtoToAddress(AddressDto addressDto){
        Address address=new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setVillage(addressDto.getVillage());
        address.setTown(addressDto.getTown());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setPinCode(addressDto.getPinCode());
        return address;
    }
}
