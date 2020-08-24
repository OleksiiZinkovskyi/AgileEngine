package com.agile.engine.test.image.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TokenEntity
{
	@Id
	@GeneratedValue
	//TODO: Should be Long
	private Integer id;

	private Timestamp issued;

	private Boolean expired;

	private String token;

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public Timestamp getIssued()
	{
		return issued;
	}

	public void setIssued(final Timestamp issued)
	{
		this.issued = issued;
	}

	public Boolean getExpired()
	{
		return expired;
	}

	public void setExpired(final Boolean expired)
	{
		this.expired = expired;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(final String token)
	{
		this.token = token;
	}

}
