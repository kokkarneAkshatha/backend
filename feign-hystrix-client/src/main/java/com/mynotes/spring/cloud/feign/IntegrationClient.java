package com.mynotes.spring.cloud.feign;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {

	@Autowired
	private OffersServiceClient offersClient;

	@Autowired
	private RecommendationServiceClient recommnedationClient;

	public Collection<Product> getRecommendationFallback() {
		System.out.println("=======getRecommendationFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getRecommendationFallback")
	public Collection<Product> getRecommendations() {
		return this.recommnedationClient.getRecommendations();
	}

	public Collection<Offers> getOffersFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getOffersFallback")
	public Collection<Offers> getOffers() {
		return this.offersClient.getCurrentOffers();
	}
	
	public Collection<Offers> postOffersFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}
	
	@HystrixCommand(fallbackMethod = "postOffersFallback")
	public void postOffers(Offers offer) {
		// TODO Auto-generated method stub
		offersClient.postCurrentOffers(offer);
		
	}
	
	

}
