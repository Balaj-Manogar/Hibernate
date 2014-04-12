package org.baali.ksl;

import javax.persistence.*;

@Entity
public class Candidate
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String name;
	private String gender;
	private int votes;
	
	@ManyToOne
	@JoinColumn(name="consId")
	private Constituency constituency;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Party party;

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public int getVotes()
	{
		return votes;
	}

	public void setVotes(int votes)
	{
		this.votes = votes;
	}

	public Constituency getConstituency()
	{
		return constituency;
	}

	public void setConstituency(Constituency constituency)
	{
		this.constituency = constituency;
	}

	public Party getParty()
	{
		return party;
	}

	public void setParty(Party party)
	{
		this.party = party;
	}

}
