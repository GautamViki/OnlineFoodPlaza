package com.masai.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.masai.entity.Restaurant;
@Service
public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public Restaurant removeRestaurant(Restaurant res);
	public Restaurant viewRestaurant (Restaurant res);
	public Restaurant viewBearByRestaurant (List<Restaurant> location);
	public Restaurant viewRestaurantByItemName (List<Restaurant> name);
}
