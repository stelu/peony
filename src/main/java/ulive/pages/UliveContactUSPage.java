package ulive.pages;


public class UliveContactUSPage {

	//Contact US header links
	public static final String CONTACTUS_FAQ_LINK = "//div[@id='frmContainer']/p/span/a/b";
	public static final String CONTACTUS_VIEWOURFAQ_LINK = "//div[@id='frmContainer']/p/a/b";
	public static final String CONTACTUS_ADVERTISEWITHUS_LINK = "//div[@id='frmContainer']/p/a[2]/b";
	public static final String CONTACTUS_BECOMEPARTNER_LINK = "//div[@id='frmContainer']/p/b[4]/a";
	
	public static final String CONTACTUS_MSGTYPE_SELECTDROPDOWN = "//select[@id='qc']";
	public static final String CONTACTUS_REGARDING_SELECTDROPDOWN = "//select[@id='topicSelect']";
	public static final String CONTACTUS_FIRSTNAME_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div/div/div/div/input";
	public static final String CONTACTUS_LASTNAME_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div/div[2]/div/div/input";
	public static final String CONTACTUS_EMAIL_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[2]/div/div/div/input";
	public static final String CONTACTUS_CONFIRMEMAIL_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[2]/div[2]/div/div/input";
	public static final String CONTACTUS_ZIPCODE_TEXTFIELD = "//form[@id='contactUs']/fieldset[2]/div[3]/div/div/div/input";
	public static final String CONTACTUS_YOURMSG_TEXTFIELD = "//form[@id='contactUs']/div/div/textarea";
	public static final String CONTACTUS_SUBMIT_BUTTON = "//button[@id='submitBttn']";
	
	public String getCONTACTUS_EMAIL_TEXTFIELD() {
		return CONTACTUS_EMAIL_TEXTFIELD;
	}
	
	
}
