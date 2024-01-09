package com.ty.gamewingmanagementapp.exception;

public class SportClubNotFoundException extends RuntimeException
{
	@Override
	public String getMessage() {
		return "Sport Club Not Found";
	}

}
