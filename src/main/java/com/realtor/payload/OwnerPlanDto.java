package com.realtor.payload;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor



public class OwnerPlanDto {

    private long planId;

    private String  planName;

    private int planValidity;

    private double price;

    private boolean relationshipManager;

    private boolean renalAgreement;

    private boolean propertyPromotion;

    private boolean guaranteedTenants;

    private boolean showingProperty;

    private boolean facebookMarketingOfProperty;





}

