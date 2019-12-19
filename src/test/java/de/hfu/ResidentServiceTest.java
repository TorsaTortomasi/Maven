package de.hfu;

import java.util.Date;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRespositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentServiceTest {

	
	
	BaseResidentService baseresident = new BaseResidentService();
	ResidentRespositoryStub stub = new ResidentRespositoryStub();
	
	Date datum = new Date(1993,1,1);
	
	Resident Peter = new Resident("Peter","Ohmann","WinkelGasse","Furtwangen",datum);
	Resident Hans = new Resident("Hans","Polizeimann","Windkraftwerkweg","Freiburg",datum);
	Resident Uwe = new Resident("Uwe","Feuerwehrmann","Scheffelstr","Furtwangen",datum);
	Resident Georg = new Resident("Georg","Eismann","Alemanenstrasse","Furtwangen",datum);
	Resident Lachmachum = new Resident("Lachmachum","Dönermann","Zebraweg","Furtwangen",datum);
	
	
	@Test
	public void Test(){
		
		stub.add(Georg);
		stub.add(Hans);
		stub.add(Lachmachum);
		stub.add(Peter);
		stub.add(Uwe);
		
		baseresident.setResidentRepository(stub);
		baseresident.getFilteredResidentsList(Peter);
		baseresident.getFilteredResidentsList(Hans);
		baseresident.getFilteredResidentsList(Uwe);
		baseresident.getFilteredResidentsList(Georg);
		baseresident.getFilteredResidentsList(Lachmachum);
		
		baseresident.getFilteredResidentsList(new Resident("*","*","*","*",datum));
		baseresident.getFilteredResidentsList(new Resident("*P","*O","*W","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*H","*P","*W","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*U","*F","*S","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*G","*E","*A","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*L","*D","*Z","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*P","*O","*W","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("*P","*O","*W","*F",datum));
		baseresident.getFilteredResidentsList(new Resident("P","O","W","F",datum));
		baseresident.getFilteredResidentsList(new Resident("Z","Z","Z","Z",datum));
		
		try {
			baseresident.getUniqueResident(Peter);
			baseresident.getUniqueResident(Hans);
			baseresident.getUniqueResident(Uwe);
			baseresident.getUniqueResident(Georg);
			baseresident.getUniqueResident(new Resident("Z","Z","Z","Z",datum));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
