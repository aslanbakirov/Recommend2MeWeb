package com.recommender.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.recommender.domain.Food;
import com.recommender.hz.client.HZClient;


@ManagedBean(name="homeBean")
public class HomeBean {
	
    
	Map<String, Integer> userMap = new HashMap<String, Integer>();
	
	/**
	 * 
	 */
	/*@PostConstruct
	public void init(){
		//userMap.put("test", 100304);
		//userMap.put("aslan", 100282);
		//userMap.put("kevser", 100303);
		userMap.put("test", 1);
		userMap.put("aslan", 2);
		userMap.put("kevser", 3);
	}*/
	
	List<Food> foodList = new ArrayList<Food>();
	
	public List<Food> loadFoodByUsername() {

		Food food = new Food();
		Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String username=parameterMap.get("username");
		Integer userID= HZClient.loadIDUserMap().get(username);
		List<String> productList= HZClient.loadUserProductMap().get(userID);
		Map<Integer, String> productMap = HZClient.loadIDProductMap();
		
		for(String str: productList){
			
			String[] split = str.split(":");
			
			food.setId(new Integer(split[0]));
			food.setName(productMap.get(new Integer(split[0])));
			food.setPrediction(new Double(split[1]));
			foodList.add(food);
			food=new Food();
		}
		return foodList;
	}

	public List<Food> getFoodList() {
		return loadFoodByUsername();
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	
	
}
