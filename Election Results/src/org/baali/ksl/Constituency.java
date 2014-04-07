package org.baali.ksl;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Constituency
{
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int consId;
	private String cName;	
	private int stateId;
	private int resultStatus;
	
	public int getConsId()
	{
		return consId;
	}
	public void setConsId(int consId)
	{
		this.consId = consId;
	}
	public String getcName()
	{
		return cName;
	}
	public void setcName(String cName)
	{
		this.cName = cName;
	}
	public int getStateId()
	{
		return stateId;
	}
	public void setStateId(int stateId)
	{
		this.stateId = stateId;
	}
	public int getResultStatus()
	{
		return resultStatus;
	}
	public void setResultStatus(int resultStatus)
	{
		this.resultStatus = resultStatus;
	}
	
	

}
