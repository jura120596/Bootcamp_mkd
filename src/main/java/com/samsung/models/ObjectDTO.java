package com.samsung.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.samsung.entity.Address;
import com.samsung.entity.ObjectMkd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDTO {

    private Long id;
    private String houseNumber;
    private String houseBlock;
    private String seria;
    private int 	year;
    private float 	square;
    private int 	houseDoorsCount;
    private int 	minFloorCount;
    private int	 	maxFloorCount;
    private int 	accountsCount;
    private int 	personsCount;
    private int 	flatsCount;
    private int 	roomsCount;
    private float 	areaSquare;
    private Date 	firstPrivatisationDate;
    private Date 	created_at;
    private AddressDTO address;
    private RepairDataDTO repair;
    private CommunicationDTO communication;
    

	public static ObjectMkd fromDto(ObjectDTO o) {
		if (o == null) return null;
        Address a = AddressDTO.fromDto(o.getAddress());
        a.setId(o.getAddress().getId());
        return ObjectMkd.builder()
        		.houseNumber(o.houseNumber)
        		.houseBlock(o.houseBlock)
        		.seria(o.seria)
        		.year(o.year)
        		.square(o.square)
        		.houseDoorsCount(o.houseDoorsCount)
        		.minFloorCount(o.minFloorCount)
        		.maxFloorCount(o.maxFloorCount)
        		.accountsCount(o.accountsCount)
        		.personsCount(o.personsCount)
        		.flatsCount(o.flatsCount)
        		.roomsCount(o.roomsCount)
        		.areaSquare(o.areaSquare)
        		.firstPrivatisationDate(o.firstPrivatisationDate)
        		.created_at(o.created_at)
        		.address(a)
        		.build();
    }

    public static ObjectDTO toDto(ObjectMkd o) {

        AddressDTO a = AddressDTO.toDto(o.getAddress());
        CommunicationDTO c = CommunicationDTO.toDto(o.getCommunication());
        RepairDataDTO r = RepairDataDTO.toDto(o.getRepair());
        return ObjectDTO.builder()
        		.id(o.getId())
        		.houseNumber(o.getHouseNumber())
        		.houseBlock(o.getHouseBlock())
        		.seria(o.getSeria())
        		.year(o.getYear())
        		.square(o.getSquare())
        		.houseDoorsCount(o.getHouseDoorsCount())
        		.minFloorCount(o.getMinFloorCount())
        		.maxFloorCount(o.getMaxFloorCount())
        		.accountsCount(o.getAccountsCount())
        		.personsCount(o.getPersonsCount())
        		.flatsCount(o.getFlatsCount())
        		.roomsCount(o.getRoomsCount())
        		.firstPrivatisationDate(o.getFirstPrivatisationDate())
        		.created_at(o.getCreated_at())
        		.address(a)
        		.communication(c)
        		.repair(r)
        		.build();
    }

	@Override
	public String toString() {
		return "ObjectDTO [id=" + id + ", houseNumber=" + houseNumber + ", houseBlock=" + houseBlock + ", seria="
				+ seria + ", year=" + year + ", square=" + square + ", houseDoorsCount=" + houseDoorsCount
				+ ", minFloorCount=" + minFloorCount + ", maxFloorCount=" + maxFloorCount + ", accountsCount="
				+ accountsCount + ", personsCount=" + personsCount + ", flatsCount=" + flatsCount + ", roomsCount="
				+ roomsCount + ", areaSquare=" + areaSquare + ", firstPrivatisationDate=" + firstPrivatisationDate
				+ ", created_at=" + created_at + ", address=" + address + ", repair=" + repair + ", communication="
				+ communication + "]";
	}
}
