var lloydsHomeApp = angular.module('lloydsHomeApp', []);

lloydsHomeApp.controller('PropertyListingsController', function ($scope) {
    $scope.properties = [
        {
            "description": "Rarely to the open market a spacious penthouse in the heart of the City. This bright home extends to 1579 square foot and comprises 3 double bedrooms, two bathrooms and a large 41 foot reception room. A 300sqft+ terrace enjoys city views with the world famous Tower Bridge visible to the south. The property would make an ideal home or pied-a-terre.  Aldgate is enjoying a huge amount of investment with some very exciting redevelopment in the area. Located to the east of the Square Mile Aldgate Tube station is minutes away with Tower Hill (District and Circle line) and the DLR in close proximity.",
            "image_url": "http://li.zoocdn.com/59999f4551cec97a548ef62d834556fda2e51e82_354_255.jpg"
        },
        {
            "description": "A spacious two bedroom apartment in the heart of the City - The apartment is situated on the second floor of a 1950s Art Deco style Building. This well presented property has two double bedrooms, with en suite to master, a modern separate kitchen and a spacious reception/dining room.  The property is ideally placed for anyone working in the City or Canary Wharf. There are a variety of local amenities with the vibrant Brick Lane or St Katherine's docks being a short walk away.",
            "image_url": "http://li.zoocdn.com/3591e51531d6d6682b29d3832b83765459bd244b_354_255.jpg"
        },
        {
            "description": "Short let - city - A selection of serviced apartments located in the heart of the City close to Tower Hill and Fenchurch Street stations, whilst the River Thames and The Tower of London are also nearby. (contd...)",
            "image_url": "http://li.zoocdn.com/f57ded99b9115e6d26b60181701796b9d45f3a82_354_255.jpg"
        }
    ];
});
