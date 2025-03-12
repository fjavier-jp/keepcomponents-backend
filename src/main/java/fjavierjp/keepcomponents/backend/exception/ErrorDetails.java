package fjavierjp.keepcomponents.backend.exception;

import java.util.Date;

public class ErrorDetails
{
	private Date timestamp;
	private String message;
	private String details;
	private String stackTrace;
	
	public ErrorDetails(Date timestamp, String message, String details, String stackTrace)
	{
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.stackTrace = stackTrace;
	}
}
