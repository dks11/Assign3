/**
This is an exception for when the file name is missing
*/
public class MissingFileNameArgumentException extends Exception
{
	public MissingFileNameArgumentException(String msg)
	{
		super(msg);
	}
}