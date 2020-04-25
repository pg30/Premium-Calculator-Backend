#SELECT * FROM premiumcalculator.rate;
use premiumcalculator;
# two wheeler and private cars and taxi upto 6 passengers
SELECT cost from rate left join ccRange on rate.ccId=ccRange.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=2 and Zone.zone_name='B' and ccRange.start<=100 and ccRange.end>=100 and dayRange.start<=3652 and dayRange.end>=3652; 
# for pcv 3 wheeler
SELECT cost from rate left join passengerRange on rate.passengerId=passengerRange.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=8 and Zone.zone_name='A' and passengerRange.start<=6 and passengerRange.end>=6 and dayRange.start<=3652 and dayRange.end>=3652; 
# for goods carrying vehicles and gcv 3 wheeler
SELECT cost from rate left join Carrier on rate.carrierId=Carrier.id left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=3 and Zone.zone_name='B' and Carrier.carrier_name="Private" and dayRange.start<=3652 and dayRange.end>=3652; 
# for bus and school bus and miscellaneous vehicle
SELECT cost from rate left join Zone on rate.zoneId=Zone.id left join dayRange on rate.dayId=dayRange.id where vehicleId=5 and Zone.zone_name='B' and dayRange.start<=3652 and dayRange.end>=3652; 


#tp rate queries

#for two wheeler, private car, taxi upto 6 pasenger
SELECT cost from Tp left join ccRange on Tp.ccId=ccRange.id where vehicleId=1 and ccRange.start<=350 and ccRange.end>=350;
#for pcv 3 wheeler
SELECT cost from Tp left join passengerRange on Tp.passengerId=passengerRange.id where vehicleId=8 and passengerRange.start<=6 and passengerRange.end>=6; 
#for goods carrying vehicles
SELECT cost from Tp left join Carrier on Tp.carrierId=Carrier.id left join weightRange on Tp.weightId=weightRange.id where vehicleId=3 and Carrier.carrier_name="Private" and weightRange.start<=1000 and weightRange.end>=1000; 
#for gcv 3 wheeler
SELECT cost from Tp left join Carrier on Tp.carrierId=Carrier.id where vehicleId=7 and Carrier.carrier_name="Private"; 
#for bus, school bus
SELECT cost from Tp where Tp.vehicleId=6;
#for miscellaneous vehicle
SELECT cost from Tp left join MiscType on Tp.miscTypeId=MiscType.id left join MiscUse on Tp.miscUseId=MiscUse.id where vehicleId=9 and MiscType.type_name="Others" and MiscUse.use_name="Trailer";

#tp per passenger queries

#for taxi upto 6 passenger
SELECT cost from TpPerPassenger left join ccRange on TpPerPassenger.ccId=ccRange.id where vehicleId=4 and ccRange.start<=350 and ccRange.end>=350;
#for 3 wheeler pcv
SELECT cost from TpPerPassenger left join passengerRange on TpPerPassenger.passengerId=passengerRange.id where vehicleId=8 and passengerRange.start<=6 and passengerRange.end>=6; 
#for bus, school bus
SELECT cost from TpPerPassenger where TpPerPassenger.vehicleId=6;