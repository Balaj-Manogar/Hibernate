package org.baali.ksl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Group
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gid;
	private String name;
	
	@OneToMany(mappedBy="group")
	private Collection<Party> party = new ArrayList<Party>();

	public int getGid()
	{
		return gid;
	}

	public void setGid(int gid)
	{
		this.gid = gid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Collection<Party> getParty()
	{
		return party;
	}

	public void setParty(Collection<Party> party)
	{
		this.party = party;
	}
}
