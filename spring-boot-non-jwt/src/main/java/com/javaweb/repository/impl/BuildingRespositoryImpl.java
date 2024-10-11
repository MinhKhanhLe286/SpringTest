package com.javaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class BuildingRespositoryImpl implements  BuildingRepository {

	private static boolean checkTring(String str) {
		return (str == null && str.equals("") == true ) ? false : true;
	}
	public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql ) {
		String staffId = (String)params.get("staffId");
		if(checkTring(staffId)) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if (typeCode != null && typeCode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}
		String rentAreaTo = (params.get("areaTo").toString());
		String rentAreaFrom = (String)params.get("areaFrom");
		
		if(checkTring(rentAreaFrom) && checkTring(rentAreaTo)) {
			sql.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id ");
		}
		
	}
	
	public static void whereQuery(Map<String, String> params, List<String> typeCode ) {
		
	}
	
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.districtid, b,street, b.ward, b.numberofbasement, b.floorare");
						sql.append(" b.managername, b.managerphonemunber, b.servicefee, b.brokeragefee FROM building b ");
		joinTable(params, typeCode, sql);
		
		StringBuilder where = new StringBuilder(" Where 1=1 ");	
		
		System.out.println(sql);
		
		return null;
	}

}
