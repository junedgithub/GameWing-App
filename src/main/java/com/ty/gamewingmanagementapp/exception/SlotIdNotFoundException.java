package com.ty.gamewingmanagementapp.exception;

public class SlotIdNotFoundException extends RuntimeException 
{
	public String getMessage()
	{
		return "Slot Id not found";
	}

}
