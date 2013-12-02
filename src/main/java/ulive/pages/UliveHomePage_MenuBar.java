package ulive.pages;

public class UliveHomePage_MenuBar {

	//main page links
	public static final String HEADER_ULIVELOGO_ICON = "//a[contains(text(),'uLive')]";
	public static final String HEADER_TODAY_LINK =	"(//a[contains(text(),'Today')])[2]";
	public static final String HEADER_BROWSER_LINK = "//a[contains(text(),'Browse')]";
	public static final String HEADER_TVSHOWS_LINK = "//div[@class='mainnav-container']/nav/ul/li[2]/a";
	public static final String HEADER_ORIGINALSERIES_LINK = "//div[@class='mainnav-container']/nav/ul/li[3]/a";
	public static final String HEADER_SEARCH_TEXTFIELD = "//input[@placeholder='Search uLive (e.g. beaches)']";
	public static final String HEADER_SEARCHSUBMIT_BUTTON = "//button[@type='submit']";
	
	public static final String MENUNAV_INACTIVE_ICON = "//div[@class='mainnav-container']/nav/a";
}
