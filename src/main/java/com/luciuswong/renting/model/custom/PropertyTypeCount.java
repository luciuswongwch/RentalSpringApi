package com.luciuswong.renting.model.custom;


public class PropertyTypeCount {
    private PropertyType propertyType;
    private Long count;
    public PropertyTypeCount(PropertyType propertyType, Long count) {
        this.propertyType = propertyType;
        this.count = count;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public Long getCount() {
        return count;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
