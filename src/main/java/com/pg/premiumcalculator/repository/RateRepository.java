package com.pg.premiumcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pg.premiumcalculator.models.RateModel;

@Repository
public interface RateRepository extends JpaRepository<RateModel, Integer> {
	
	//for two wheeler, private car and taxi upto 6 passengers
	@Query(value="SELECT cost from rate left join ccRange on rate.ccId=ccRange.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=?1 and Zone.zone_name=?2 and ccRange.start<=?3 and ccRange.end>=?3 and dayRange.start<=?4 and dayRange.end>=?4",
			nativeQuery = true)
	Double findRateA(Integer vehicleId,String zone,Double cc,Integer day);
	
	//for pcv 3 wheeler
	@Query(value="SELECT cost from rate left join passengerRange on rate.passengerId=passengerRange.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=?1 and Zone.zone_name=?2 and passengerRange.start<=?3 and passengerRange.end>=?3 and dayRange.start<=?4 and dayRange.end>=?4",
			nativeQuery = true)
	Double findRateB(Integer vehicleId,String zone,Integer passenger,Integer day);
	
	//for gcv, gcv 3 wheeler
	@Query(value="SELECT cost from rate left join Carrier on rate.carrierId=Carrier.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=?1 and Zone.zone_name=?2 and Carrier.carrier_name=?3 and dayRange.start<=?4 and dayRange.end>=?4",
			nativeQuery = true)
	Double findRateC(Integer vehicleId,String zone,String carrier,Integer day);
	
	// for bus and school bus and miscellaneous vehicle
	@Query(value="SELECT cost from rate left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=?1 and Zone.zone_name=?2 and dayRange.start<=?3 and dayRange.end>=?3",
			nativeQuery = true)
	Double findRateD(Integer vehicleId,String zone,Integer day);
}
