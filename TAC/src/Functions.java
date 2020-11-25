public class Functions
{
	Data data=new Data();
	
	public boolean correctLoginFunctions(String username, String password)
	{
		return data.correctLoginData(username, password);
	}
	
	public void registerFunctions(String username, String displayedName, String password)
	{
		data.registerData(username, displayedName, password);
	}
	
	public String showNameFunctions(String username)
	{
		return data.showNameData(username);
	}
}
