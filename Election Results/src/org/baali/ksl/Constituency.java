package org.baali.ksl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Constituency
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consId;
	private String cName;
	private int resultStatus;
	@ManyToOne
	@JoinColumn(name="sid")
	private States state;
	
	public States getState()
	{
		return state;
	}
	public void setState(States state)
	{
		this.state = state;
	}
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
	
	public int getResultStatus()
	{
		return resultStatus;
	}
	public void setResultStatus(int resultStatus)
	{
		this.resultStatus = resultStatus;
	}
	
	

}
