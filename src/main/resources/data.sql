INSERT INTO `region` (`place`, `description`) VALUES ('new_jersey', 'Perfect City!');

INSERT INTO `region` (`place`, `description`) VALUES ('paris', 'Best Place to live');

INSERT INTO `region` (`place`, `description`) VALUES ('london', 'Perfect City!');

INSERT INTO `region` (`place`, `description`) VALUES ('japan', 'Best Place to live');

INSERT INTO `region` (`place`, `description`) VALUES ('france', 'Perfect City!');

INSERT INTO `region` (`place`, `description`) VALUES ('italy', 'Best Place to live');

INSERT INTO `region` (`place`, `description`) VALUES ('sydney', 'Perfect City!');

INSERT INTO `region` (`place`, `description`) VALUES ('san_francisco', 'Best Place to live');

INSERT INTO `region` (`place`, `description`) VALUES ('osaka', 'Perfect City!');

INSERT INTO `region` (`place`, `description`) VALUES ('australia', 'Best Place to live');


INSERT INTO `rental_detail` (`description`, `address`, `exterior_material`, `structure_type`, `monthly_rent`, `square_feet`, `number_of_bedrooms`, `number_of_baths`, `garage_size`, `built_year`, `available_from`)
VALUES ('<p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis.
Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis, ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta
sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci egestas scelerisque class cras per tristique tempor.</p><p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula
habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis. Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis,
ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci
egestas scelerisque class cras per tristique tempor.</p>', '1234 Main Road, British Columbia, Canada', 'Brick', 'Wood', 2200, 750, 2, 2, 3, '2000', 'Feb 2023');

INSERT INTO `rental` (`property_type`, `region_id`, `rental_detail_id`)
VALUES ('Apartment', 1, 1);


INSERT INTO `rental_detail` (`description`, `address`, `exterior_material`, `structure_type`, `monthly_rent`, `square_feet`, `number_of_bedrooms`, `number_of_baths`, `garage_size`, `built_year`, `available_from`)
VALUES ('<p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis.
Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis, ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta
sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci egestas scelerisque class cras per tristique tempor.</p><p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula
habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis. Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis,
ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci
egestas scelerisque class cras per tristique tempor.</p>', '1234 Main Road, British Columbia, Canada', 'Brick', 'Wood', 2200, 750, 2, 2, 3, '2000', 'Feb 2023');

INSERT INTO `rental` (`property_type`, `region_id`, `rental_detail_id`)
VALUES ('Condo', 2, 2);


INSERT INTO `rental_detail` (`description`, `address`, `exterior_material`, `structure_type`, `monthly_rent`, `square_feet`, `number_of_bedrooms`, `number_of_baths`, `garage_size`, `built_year`, `available_from`)
VALUES ('<p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis.
Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis, ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta
sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci egestas scelerisque class cras per tristique tempor.</p><p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula
habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis. Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis,
ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci
egestas scelerisque class cras per tristique tempor.</p>', '1234 Main Road, British Columbia, Canada', 'Brick', 'Wood', 2200, 750, 2, 2, 3, '2000', 'Feb 2023');

INSERT INTO `rental` (`property_type`, `region_id`, `rental_detail_id`)
VALUES ('House', 3, 3);


INSERT INTO `rental_detail` (`description`, `address`, `exterior_material`, `structure_type`, `monthly_rent`, `square_feet`, `number_of_bedrooms`, `number_of_baths`, `garage_size`, `built_year`, `available_from`)
VALUES ('<p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis.
Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis, ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta
sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci egestas scelerisque class cras per tristique tempor.</p><p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula
habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis. Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis,
ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci
egestas scelerisque class cras per tristique tempor.</p>', '1234 Main Road, British Columbia, Canada', 'Brick', 'Wood', 2200, 750, 2, 2, 3, '2000', 'Feb 2023');

INSERT INTO `rental` (`property_type`, `region_id`, `rental_detail_id`)
VALUES ('Townhouse', 4, 4);


INSERT INTO `rental_detail` (`description`, `address`, `exterior_material`, `structure_type`, `monthly_rent`, `square_feet`, `number_of_bedrooms`, `number_of_baths`, `garage_size`, `built_year`, `available_from`)
VALUES ('<p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis.
Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis, ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta
sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci egestas scelerisque class cras per tristique tempor.</p><p>Lorem ipsum dolor sit amet consectetur adipiscing elit vehicula
habitant lectus cras sodales rhoncus, class elementum lacinia gravida integer erat fusce aptent parturient dictumst convallis. Dignissim leo fames phasellus felis fusce aliquam himenaeos praesent magnis,
ligula faucibus semper ante lobortis ac mollis porta. Suspendisse sem blandit sed gravida interdum facilisi dapibus porta sagittis, rutrum litora nisl hac sociosqu rhoncus inceptos semper mattis, orci
egestas scelerisque class cras per tristique tempor.</p>', '1234 Main Road, British Columbia, Canada', 'Brick', 'Wood', 2200, 750, 2, 2, 3, '2000', 'Feb 2023');

INSERT INTO `rental` (`property_type`, `region_id`, `rental_detail_id`)
VALUES ('Villa', 5, 5);
