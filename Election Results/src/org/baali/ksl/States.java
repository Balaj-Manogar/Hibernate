package org.baali.ksl;

import javax.persistence.*;

@Entity
public class States
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String name;
	private int isUnionTerritory;
	@Embedded
	private Constituency constituency;

	public int getSid()
	{
		return sid;
	}
	public void setSid(int sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getIsUnionTerritory()
	{
		return isUnionTerritory;
	}
	public void setIsUnionTerritory(int isUnionTerritory)
	{
		this.isUnionTerritory = isUnionTerritory;
	}
	public Constituency getConstituency()
	{
		return constituency;
	}
	public void setConstituency(Constituency constituency)
	{
		this.constituency = constituency;
	}



}