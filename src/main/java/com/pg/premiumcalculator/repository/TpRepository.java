package com.pg.premiumcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pg.premiumcalculator.models.Tp;

@Repository
public interface TpRepository extends JpaRepository<Tp, Integer> {

	
	//for two wheeler, private car and taxi upto 6 passengers
	@Query(value="SELECT cost from Tp left join ccRange on Tp.ccId=ccRange.id where vehicleId=?1 and ccRange.start<=?2 and ccRange.end>=?2",
			nativeQuery = true)
	Integer findTpA(Integer vehicleId,Double cc);
	
	//for pcv 3 wheeler
	@Query(value="SELECT cost from Tp left join passengerRange on Tp.passengerId=passengerRange.id where vehicleId=?1 and passengerRange.start<=?2 and passengerRange.end>=?2",
			nativeQuery = true)
	Integer findTpB(Integer vehicleId,Integer passenger);
	
	//for gcv
	@Query(value="SELECT cost from Tp left join Carrier on Tp.carrierId=Carrier.id left join weightRange on Tp.weightId=weightRange.id where vehicleId=?1 and Carrier.carrier_name=?2 and weightRange.start<=?3 and weightRange.end>=?3",
			nativeQuery = true)
	Integer findTpC(Integer vehicleId,String carrier,Double weight);
	
	//for gcv 3 wheeler
	@Query(value="SELECT cost from Tp left join Carrier on Tp.carrierId=Carrier.id where vehicleId=?1 and Carrier.carrier_name=?2",
			nativeQuery = true)
	Integer findTpD(Integer vehicleId,String carrier);
	
	// for bus and school bus
	@Query(value="SELECT cost from Tp where Tp.vehicleId=?1",
			nativeQuery = true)
	Integer findTpE(Integer vehicleId);
	
	// for miscellaneous vehicle
	@Query(value="SELECT cost from Tp left join MiscType on Tp.miscTypeId=MiscType.id left join MiscUse on Tp.miscUseId=MiscUse.id where vehicleId=?1 and MiscType.type_name=?2 and MiscUse.use_name=?3",
			nativeQuery = true)
	Integer findTpF(Integer vehicleId,String miscType,String miscUse);
}
