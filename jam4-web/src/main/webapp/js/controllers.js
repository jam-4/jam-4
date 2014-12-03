var lloydsHomeControllers = angular.module('lloydsHomeControllers', []);

lloydsHomeControllers.controller('PropertyListingsController', function ($scope) {
    $scope.properties = [
        {
            "property_id": 1,
            "listing_id": "33249223",
            "description": "Rarely to the open market a spacious penthouse in the heart of the City. This bright home extends to 1579 square foot and comprises 3 double bedrooms, two bathrooms and a large 41 foot reception room. A 300sqft+ terrace enjoys city views with the world famous Tower Bridge visible to the south. The property would make an ideal home or pied-a-terre.  Aldgate is enjoying a huge amount of investment with some very exciting redevelopment in the area. Located to the east of the Square Mile Aldgate Tube station is minutes away with Tower Hill (District and Circle line) and the DLR in close proximity.",
            "image_url": "http://li.zoocdn.com/59999f4551cec97a548ef62d834556fda2e51e82_354_255.jpg"
        },
        {
            "property_id": 2,
            "listing_id": "35275235",
            "description": "A spacious two bedroom apartment in the heart of the City - The apartment is situated on the second floor of a 1950s Art Deco style Building. This well presented property has two double bedrooms, with en suite to master, a modern separate kitchen and a spacious reception/dining room.  The property is ideally placed for anyone working in the City or Canary Wharf. There are a variety of local amenities with the vibrant Brick Lane or St Katherine's docks being a short walk away.",
            "image_url": "http://li.zoocdn.com/3591e51531d6d6682b29d3832b83765459bd244b_354_255.jpg"
        },
        {
            "property_id": 3,
            "listing_id": "28972518",
            "description": "Exclusively available on a short term rental is this selection of superbly furnished serviced one bedroom apartments within easy reach of London's financial district, located on a quiet side street close to local restaurants, coffee shops and bars and the excellent facilities of St. (contd...)",
            "image_url": "http://li.zoocdn.com/6f149b08b6ece1c35b371e03ae537696f181ea9c_354_255.jpg"
        }
    ];
});

lloydsHomeControllers.controller('PropertyDetailsController', [
        '$scope',
        '$routeParams',
        function ($scope, $routeParams) {
            $scope.listing_id = $routeParams.listing_id;
            $scope.property_details = {
                "listing_id": "28972518",
                "description": "Rarely to the open market a spacious penthouse in the heart of the City. This bright home extends to 1579 square foot and comprises 3 double bedrooms, two bathrooms and a large 41 foot reception room. A 300sqft+ terrace enjoys city views with the world famous Tower Bridge visible to the south. The property would make an ideal home or pied-a-terre.  Aldgate is enjoying a huge amount of investment with some very exciting redevelopment in the area. Located to the east of the Square Mile Aldgate Tube station is minutes away with Tower Hill (District and Circle line) and the DLR in close proximity.",
                "image_url": "http://li.zoocdn.com/59999f4551cec97a548ef62d834556fda2e51e82_354_255.jpg"
            };
        }]
);
