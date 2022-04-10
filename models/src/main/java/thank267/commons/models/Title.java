package thank267.commons.models;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Title  {
	
	public static String getTitle(Holding holding) {
		
		return holding.getName()+". "+holding.getSlogan()+ ". "+holding.getPhone();
		
	}
	
	public static String getTitle(Holding holding, Property property) {
		
		return property.getName()+" - "+holding.getName()+ ". "+property.getRieltorPhone();
		
	}

	public static String getTitle(Holding holding, thank267.commons.models.Service service) {
		
		return service.getName()+" - "+holding.getName()+ ". "+holding.getPhone();
		
	}
	
    public static String getTitle(Holding holding, Category category) {
		
		return category.getPage()+" - "+holding.getName()+ ". "+holding.getPhone();
		
	}

	public static String getTitle(Holding holding, String title) {
		
		return title+" - "+holding.getName()+ ". "+holding.getPhone();
		
	}
	
	
	
	
	
	
	
}
