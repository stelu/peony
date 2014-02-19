package ulive.pages;


public class UliveCompletedContactUSPage 
{

	//Contact US header links
	public static final String COMPLETEDCONTACTUS_VIEWOURFAQ_LINK = "//div[@class='contact-success']/div/a";
	public static final String COMPLETEDCONTACTUS_CONTACTUS_LINK = "//div[@class='contact-success']/div/a[2]";
	
	public String getCOMPLETEDCONTACTUS_VIEWOURFAQ_LINK() 
	{
		return COMPLETEDCONTACTUS_VIEWOURFAQ_LINK;
	}
	
	public String getCOMPLETEDCONTACTUS_CONTACTUS_LINK() 
	{
		return COMPLETEDCONTACTUS_CONTACTUS_LINK;
	}
}
