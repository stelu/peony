package ulive.pages;


public class UliveHomePage_Onboarding 
{

	//main page links
	public static final String ONBOARDING_PARTNERLOGOS_ICON = "//ul[@class='logos']";
	public static final String ONBOARDING_BLUEBAR = "//div[@id='onboardBlueBar']";
	public static final String ONBOARDING_OVERLAY_ACTIVE = "//div[@class='onboardOverlayBg active']";
	public static final String ONBOARDING_OVERLAY_INACTIVE = "//div[@class='onboardOverlayBg']";
	public static final String ONBOARDING_OVERLAY_CLOSE = "//div[@class='onboardOverlayBg active']/span";
	
	public static final String ONBOARDING_SIDEBAR_TOOLTIP = "//section[@class='player-component row']/div/div[2]/div/div/p";
	public static final String ONBOARDING_BELOWBAR_TOOLTIP = "(//div[@class='module onboardTooltip show-tooltip']/p)[2]";

	public static String getOnboardingPartnerlogosIcon() 
	{
		return ONBOARDING_PARTNERLOGOS_ICON;
	}

	public static String getOnboardingBluebarImage() 
	{
		return ONBOARDING_BLUEBAR;
	}

	public static String getOnboardingSidebarTooltip() 
	{
		return ONBOARDING_SIDEBAR_TOOLTIP;
	}

	public static String getOnboardingBelowbarTooltip() 
	{
		return ONBOARDING_BELOWBAR_TOOLTIP;
	}
	
}

