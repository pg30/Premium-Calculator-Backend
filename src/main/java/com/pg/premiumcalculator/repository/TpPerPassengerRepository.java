package com.pg.premiumcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pg.premiumcalculator.models.TpPerPassenger;

@Repository
public interface TpPerPassengerRepository extends JpaRepository<TpPerPassenger, Integer> {

	//for  taxi upto 6 passengers
	@Query(value="SELECT cost from TpPerPassenger left join ccRange on TpPerPassenger.ccId=ccRange.id where vehicleId=?1 and ccRange.start<=?2 and ccRange.end>=?2",
			nativeQuery = true)
	Integer findTpPerPassengerA(Integer vehicleId,Double cc);
	
	//for pcv 3 wheeler
	@Query(value="SELECT cost from TpPerPassenger left join passengerRange on TpPerPassenger.passengerId=passengerRange.id where vehicleId=?1 and passengerRange.start<=?2 and passengerRange.end>=?2",
			nativeQuery = true)
	Integer findTpPerPassengerB(Integer vehicleId,Integer passenger);
	
	// for bus and school bus
	@Query(value="SELECT cost from TpPerPassenger where TpPerPassenger.vehicleId=?1",
			nativeQuery = true)
	Integer findTpPerPassengerC(Integer vehicleId);
}
