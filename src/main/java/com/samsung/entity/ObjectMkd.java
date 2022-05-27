package com.samsung.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "objects")
@Transactional
public class ObjectMkd {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(name= "house_number")
    private String houseNumber;
	@Column(name= "house_block")
    private String houseBlock;
	@Column(name= "seria")
    private String seria;
	@Column(name= "year")
    private int year;
	@Column(name= "square")
    private float square;
	@Column(name= "house_doors_count")
    private int houseDoorsCount;
	@Column(name= "min_floor_count")
    private int minFloorCount;
	@Column(name= "max_floor_count")
    private int maxFloorCount;
	@Column(name= "accounts_count")
    private int accountsCount;
	@Column(name= "persons_count")
    private int personsCount;
	@Column(name= "flats_count")
    private int flatsCount;
	@Column(name= "rooms_count")
    private int roomsCount;
	@Column(name= "area_square")
    private float areaSquare;
	@Column(name= "first_privatisation_date")
    private Date firstPrivatisationDate;
	@Column(name = "created_at")
    private Date created_at;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;
	@OneToOne(mappedBy="object", fetch = FetchType.LAZY)
	private RepairData repair;
	@OneToOne(mappedBy="object", fetch = FetchType.LAZY)
	private Communication communication;
}
