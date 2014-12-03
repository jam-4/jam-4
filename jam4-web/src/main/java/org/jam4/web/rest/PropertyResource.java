package org.jam4.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;

@Path("/property")
public class PropertyResource {

    public static final String STRING_ENCODING = "UTF-8";

    private static final String API_BASE_URL = "http://api.zoopla.co.uk/api/v1/property_listings.js?api_key=gzj2nbsj5cy9x3b5gqwdtake&";
    private static final String API_AREA_PARAMETER_KEY = "area=";
    private static final String API_LISTING_ID_PARAMETER_KEY = "listing_id=";

    private boolean localOnly = false;


    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "pong";
    }

    @GET
    @Path("area/{area}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPropertiesIn(@PathParam("area") String area) throws IOException {
        if (localOnly) {
            return "[\n" +
                    "    {\n" +
                    "        \"property_id\": 1,\n" +
                    "        \"listing_id\": \"33249223\",\n" +
                    "        \"description\": \"Rarely to the open market a spacious penthouse in the heart of the City. This bright home extends to 1579 square foot and comprises 3 double bedrooms, two bathrooms and a large 41 foot reception room. A 300sqft+ terrace enjoys city views with the world famous Tower Bridge visible to the south. The property would make an ideal home or pied-a-terre.  Aldgate is enjoying a huge amount of investment with some very exciting redevelopment in the area. Located to the east of the Square Mile Aldgate Tube station is minutes away with Tower Hill (District and Circle line) and the DLR in close proximity.\",\n" +
                    "        \"image_url\": \"http://li.zoocdn.com/59999f4551cec97a548ef62d834556fda2e51e82_354_255.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"property_id\": 2,\n" +
                    "        \"listing_id\": \"35275235\",\n" +
                    "        \"description\": \"A spacious two bedroom apartment in the heart of the City - The apartment is situated on the second floor of a 1950s Art Deco style Building. This well presented property has two double bedrooms, with en suite to master, a modern separate kitchen and a spacious reception/dining room.  The property is ideally placed for anyone working in the City or Canary Wharf. There are a variety of local amenities with the vibrant Brick Lane or St Katherine's docks being a short walk away.\",\n" +
                    "        \"image_url\": \"http://li.zoocdn.com/3591e51531d6d6682b29d3832b83765459bd244b_354_255.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"property_id\": 3,\n" +
                    "        \"listing_id\": \"28972518\",\n" +
                    "        \"description\": \"Exclusively available on a short term rental is this selection of superbly furnished serviced one bedroom apartments within easy reach of London's financial district, located on a quiet side street close to local restaurants, coffee shops and bars and the excellent facilities of St. (contd...)\",\n" +
                    "        \"image_url\": \"http://li.zoocdn.com/6f149b08b6ece1c35b371e03ae537696f181ea9c_354_255.jpg\"\n" +
                    "    }\n" +
                    "];";
        }

        String query = API_BASE_URL + API_AREA_PARAMETER_KEY + URLEncoder.encode(area, STRING_ENCODING);
        System.out.println(" --> PropertyResource : About to call '" + query + "'");

        String json = new JsonReader().readJsonFromUrl(query);
        System.out.println(" --> PropertyResource : Query result : '" + json + "'");

        return json;
    }

    @GET
    @Path("{listingId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPropertyDetails(@PathParam("listingId") String listingId) throws IOException {
        if (localOnly) {
            return "{\"result_count\": 1, \"area_name\": \"\", \"listing\": [\n" +
                    "    {\n" +
                    "        \"image_caption\": \"Picture No. 24\",\n" +
                    "        \"status\": \"for_sale\",\n" +
                    "        \"num_floors\": \"0\",\n" +
                    "        \"listing_status\": \"sale\",\n" +
                    "        \"num_bedrooms\": \"6\",\n" +
                    "        \"agent_name\": \"Hamptons International - Weybridge\",\n" +
                    "        \"latitude\": 51.39648,\n" +
                    "        \"agent_address\": \"26 High Street\",\n" +
                    "        \"num_recepts\": \"0\",\n" +
                    "        \"property_type\": \"Detached house\",\n" +
                    "        \"country\": \"England\",\n" +
                    "        \"longitude\": -0.526526,\n" +
                    "        \"first_published_date\": \"2014-10-01 16:05:04\",\n" +
                    "        \"displayable_address\": \"St. Anns Hill Rd, Chertsey, Surrey KT16\",\n" +
                    "        \"floor_plan\": [\"http://lc.zoocdn.com/6a8e23c6aec830327a4fb7864ff69e6d01958ada.gif\", \"http://lc.zoocdn.com/640b6cb6fcad955a9c8bc5f1f07a024675c4fbf4.pdf\"],\n" +
                    "        \"street_name\": \"Chertsey Surrey\",\n" +
                    "        \"num_bathrooms\": \"0\",\n" +
                    "        \"thumbnail_url\": \"http://li.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6_80_60.jpg\",\n" +
                    "        \"description\": \"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings. These have commercial usage and are currently used as a recording studio and a separate one bedroom annexe. Originally built in 1966 with strong Scandinavian overtones, the property is located in a semi-rural setting adjacent to open paddocks, on a mature good size plot with an outdoor swimming pool and parking for several vehicles. The ground floor comprises an entrance hall with a cloakroom, a study, a dual aspect dining room, a triple aspect luxury kitchen and steps up to a vaulted lounge with panoramic windows giving spectacular views. There are stairs down to a lower ground floor which comprises a double bedroom, cloakroom and a utility room. The first floor boasts a master bedroom suite with a five piece bathroom suite and French doors leading out onto a private terrace. There are three further bedrooms and a family bathroom.SituationSituated in a highly desirable road on the outskirts of Chertsey elevated in an attractive semi rural position and surrounded by fields and country views. Offering privacy and seclusion but still extremely convenient for commuting to London due to the close proximity of the M25 and A30. There is excellent schooling in the area, both private and independent and two nearby international schools. It is also within easy reach of the local centres of Virginia Water, Chertsey, Ascot and Windsor which cater for day to day shopping requirements. Communications are excellent with the M25, M3 and M4 close by giving fast access to the motorway network, London, Heathrow and Gatwick. There are good train services from Chertsey into London (approx. 45 minutes) and there is racing at Ascot, Windsor and Polo at nearby Smiths Lawn. There are many fine golf courses in the area, in particular Wentworth and Sunningdale which are just a short drive from the property. Windsor Great Park is within easy reach as are the boating facilities in the River Thames..OutsideThe landscaped gardens of approximately 2 acres have been beautifully maintained with an extensive patio and steps leading down to the pool area with paved surroundings and a full length pool house, ideal for entertaining with a lounge, dining area and kitchen. Wrought iron gates open onto an extensive driveway providing plenty of parking spaces and gives access to the detached recording studio and a separate detached annexe.\",\n" +
                    "        \"post_town\": \"Chertsey\",\n" +
                    "        \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/34700970?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                    "        \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(58008).jpeg\",\n" +
                    "        \"price_change\": [\n" +
                    "            {\n" +
                    "                \"date\": \"2014-10-01 15:00:40\",\n" +
                    "                \"price\": \"1690000.00\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"short_description\": \"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings and in grounds of approximately two acres.\",\n" +
                    "        \"agent_phone\": \"01932 807844\",\n" +
                    "        \"outcode\": \"KT16\",\n" +
                    "        \"image_url\": \"http://li.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6_354_255.jpg\",\n" +
                    "        \"last_published_date\": \"2014-12-03 13:20:50\",\n" +
                    "        \"county\": \"Surrey\",\n" +
                    "        \"price\": \"1690000\",\n" +
                    "        \"listing_id\": \"34700970\"\n" +
                    "    }\n" +
                    "], \"street\": \"\", \"county\": \"\", \"town\": \"\", \"postcode\": \"\"}";
        }

        String query = API_BASE_URL + API_LISTING_ID_PARAMETER_KEY + URLEncoder.encode(listingId, STRING_ENCODING);
        System.out.println(" --> PropertyResource : About to call '" + query + "'");

        String json = new JsonReader().readJsonFromUrl(query);
        System.out.println(" --> PropertyResource : Query result : '" + json + "'");

        return json;
    }

}
