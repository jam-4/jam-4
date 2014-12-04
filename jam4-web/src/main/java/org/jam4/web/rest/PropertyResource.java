package org.jam4.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Path("/property")
public class PropertyResource {

    public static final String STRING_ENCODING = "UTF-8";

    private static final String API_BASE_URL = "http://api.zoopla.co.uk/api/v1/property_listings.js?api_key=gzj2nbsj5cy9x3b5gqwdtake&";
    private static final String API_AREA_PARAMETER_KEY = "area=";
    private static final String API_LISTING_ID_PARAMETER_KEY = "listing_id=";

    private static Map<String, String> cannedListingsMap = populateCannedListingsMap();
    private static String allCannedListings = populateAllCannedListings();

    private boolean localOnly = false;


    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "pong";
    }

    @GET
    @Path("local/{localOnly}")
    @Produces(MediaType.TEXT_PLAIN)
    public String localOnly(@PathParam("localOnly") boolean localOnly) {
        this.localOnly = localOnly;

        return "local set to " + localOnly;
    }

    @GET
    @Path("area/{area}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPropertiesIn(@PathParam("area") String area) throws IOException {
        String json;

        if (localOnly) {
            json = getAllCannedListings();
        }
        else {
            String query = API_BASE_URL + API_AREA_PARAMETER_KEY + URLEncoder.encode(area, STRING_ENCODING);
            json = new JsonReader().readJsonFromUrl(query);
        }

        return json;
    }

    @GET
    @Path("{listingId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPropertyDetails(@PathParam("listingId") String listingId) throws IOException {
        String json;

        if (localOnly) {
            json = getCannedPropertyDetails(listingId);
        }
        else {
            String query = API_BASE_URL + API_LISTING_ID_PARAMETER_KEY + URLEncoder.encode(listingId, STRING_ENCODING);
            json = new JsonReader().readJsonFromUrl(query);
        }

        return json;
    }

    private String getAllCannedListings() {
        return allCannedListings;
    }

    private String getCannedPropertyDetails(String listingId) {
        return cannedListingsMap.get(listingId);
    }

    private static Map<String, String> populateCannedListingsMap() {
        Map<String, String> cannedListingsMap = new HashMap<>();

        cannedListingsMap.put("34700970", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"image_caption\":\"Picture No. 24\",\"status\":\"for_sale\",\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"6\",\"agent_name\":\"Hamptons International - Weybridge\",\"latitude\":51.39648,\"agent_address\":\"26 High Street\",\"num_recepts\":\"0\",\"property_type\":\"Detached house\",\"country\":\"England\",\"longitude\":-0.526526,\"first_published_date\":\"2014-10-01 16:05:04\",\"displayable_address\":\"St. Anns Hill Rd, Chertsey, Surrey KT16\",\"floor_plan\":[\"http://lc.zoocdn.com/6a8e23c6aec830327a4fb7864ff69e6d01958ada.gif\",\"http://lc.zoocdn.com/640b6cb6fcad955a9c8bc5f1f07a024675c4fbf4.pdf\"],\"street_name\":\"Chertsey Surrey\",\"num_bathrooms\":\"0\",\"thumbnail_url\":\"http://li.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6_80_60.jpg\",\"description\":\"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings. These have commercial usage and are currently used as a recording studio and a separate one bedroom annexe. Originally built in 1966 with strong Scandinavian overtones, the property is located in a semi-rural setting adjacent to open paddocks, on a mature good size plot with an outdoor swimming pool and parking for several vehicles. The ground floor comprises an entrance hall with a cloakroom, a study, a dual aspect dining room, a triple aspect luxury kitchen and steps up to a vaulted lounge with panoramic windows giving spectacular views. There are stairs down to a lower ground floor which comprises a double bedroom, cloakroom and a utility room. The first floor boasts a master bedroom suite with a five piece bathroom suite and French doors leading out onto a private terrace. There are three further bedrooms and a family bathroom.SituationSituated in a highly desirable road on the outskirts of Chertsey elevated in an attractive semi rural position and surrounded by fields and country views. Offering privacy and seclusion but still extremely convenient for commuting to London due to the close proximity of the M25 and A30. There is excellent schooling in the area, both private and independent and two nearby international schools. It is also within easy reach of the local centres of Virginia Water, Chertsey, Ascot and Windsor which cater for day to day shopping requirements. Communications are excellent with the M25, M3 and M4 close by giving fast access to the motorway network, London, Heathrow and Gatwick. There are good train services from Chertsey into London (approx. 45 minutes) and there is racing at Ascot, Windsor and Polo at nearby Smiths Lawn. There are many fine golf courses in the area, in particular Wentworth and Sunningdale which are just a short drive from the property. Windsor Great Park is within easy reach as are the boating facilities in the River Thames..OutsideThe landscaped gardens of approximately 2 acres have been beautifully maintained with an extensive patio and steps leading down to the pool area with paved surroundings and a full length pool house, ideal for entertaining with a lounge, dining area and kitchen. Wrought iron gates open onto an extensive driveway providing plenty of parking spaces and gives access to the detached recording studio and a separate detached annexe.\",\"post_town\":\"Chertsey\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/34700970?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(58008).jpeg\",\"price_change\":[{\"date\":\"2014-10-01 15:00:40\",\"price\":\"1690000.00\"}],\"short_description\":\"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings and in grounds of approximately two acres.\",\"agent_phone\":\"01932 807844\",\"outcode\":\"KT16\",\"image_url\":\"http://lc.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6.jpg\",\"last_published_date\":\"2014-12-03 13:20:50\",\"county\":\"Surrey\",\"price\":\"1690000\",\"listing_id\":\"34700970\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("34782084", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"4\",\"latitude\":51.40455,\"agent_address\":\"20 Station Approach\",\"property_type\":\"Detached house\",\"longitude\":-0.559881,\"thumbnail_url\":\"http://li.zoocdn.com/741c99caf1bc43b32df7bc1386444d6a151ab6f3_80_60.jpg\",\"description\":\"A rare opportunity to purchase a unique home forming part of this Grade 1 listed building, set on the prestigious Virginia Park with excellent residents' leisure facilities and 24 hour gated security. EPC rating D.A beautifully presented 4 bedroom home, enjoying a superb position on the exclusive Virginia Park gated estate. The property is close to Virginia Water village with its good selection of shops, restaurants and station. Access from the drawing room/dining area leads to a privately owned sun terrace with hedge surround. A gate leads to a very well maintained area of communal grounds. There is underground parking for 3 cars and further visitors parking.Crossland House and the surrounding development is situated in Virginia Park, a 24 acre walled parkland estate. Residents' facilities within the main building include a swimming pool, gymnasium, jacuzzi, sauna, sun beds and changing facilities.Communications to London and the airports are excellent due to the convenient proximity of the M25 as well as having a mainline station to Waterloo. Other attractions within the area include Ascot racecourse, Windsor Castle, Legoland and Savill Gardens. Schooling is exceptional with many renowned private schools. There are two international schools.Ascot 4 miles, M3 5 miles, M4 9 miles, Heathrow Airport (T5) 9 miles, Central London 28 miles. (All distances are approximate).\",\"post_town\":\"Virginia Water\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/34782084?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"short_description\":\"Victorian Masterpiece in gated development - A rare opportunity to purchase a unique home forming part of this Grade 1 listed building, set on the prestigious Virginia Park with excellent residents' leisure facilities and 24 hour gated security. EPC rating D.  A beautifully presented 4 bedroom home, enjoying a superb position on the exclusive Virginia Park gated estate. The property is close to Virginia Water village with its good selection of shops, restaurants and station. Access from the drawing room/dining area leads to a privately owned sun terrace with hedge surround. A gate leads to a very well maintained area of communal grounds. There is underground parking for 3 cars and further visitors parking.  Crossland House and the surrounding development is situated in Virginia Park, a 24 acre walled parkland estate. Residents' facilities within the main building include a swimming pool, gymnasium, jacuzzi, sauna, sun beds and changing facilities.  Communications to London and the airports are excellent due to the convenient pr\",\"outcode\":\"GU25\",\"county\":\"Surrey\",\"price\":\"1950000\",\"listing_id\":\"34782084\",\"image_caption\":\"Virginia Park\",\"status\":\"for_sale\",\"agent_name\":\"Knight Frank - Virginia Water\",\"num_recepts\":\"2\",\"country\":\"England\",\"displayable_address\":\"Crossland House, Holloway Drive, Virginia Water, Surrey GU25\",\"first_published_date\":\"2014-10-08 20:28:11\",\"price_modifier\":\"guide_price\",\"floor_plan\":[\"http://lc.zoocdn.com/a05aac35f82aad8a7f8d62a7a12ac3216266d8e7.pdf\"],\"street_name\":\"Crossland House\",\"num_bathrooms\":\"2\",\"price_change\":[{\"date\":\"2014-10-08 19:30:32\",\"price\":\"1950000.00\"}],\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(134849).png\",\"agent_phone\":\"01344 527001\",\"image_url\":\"http://lc.zoocdn.com/741c99caf1bc43b32df7bc1386444d6a151ab6f3.jpg\",\"last_published_date\":\"2014-11-26 12:20:35\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("35241360", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"5\",\"latitude\":51.40601,\"agent_address\":\"6 Station Approach\",\"property_type\":\"\",\"letting_fees\":\"Fees for tenants: Â£180 for Agreement Fee, Â£60 for Admin and References, Â£30 tds fee, all including vat.\",\"longitude\":-0.566794,\"thumbnail_url\":\"http://li.zoocdn.com/293ce3e351485076f8e923a75ed37051a22720d0_80_60.jpg\",\"description\":\"The Pines is a well planned modern family home providing excellent, adaptable living space; the property is set behind gates in this highly convenient location, being just a short stroll to village centre shops and rail station while benefiting from a quiet location on the exclusive Wentworth Estate.\",\"post_town\":\"Virginia Water\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/35241360?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"short_description\":\"A spacious modern home offering superb family accommodation and enjoying a mature, private plot in excess of half an acre, close to the village centre.\",\"outcode\":\"GU25\",\"county\":\"Surrey\",\"price\":\"2250000\",\"listing_id\":\"35241360\",\"image_caption\":\"\",\"status\":\"for_sale\",\"agent_name\":\"Buckinghams\",\"num_recepts\":\"0\",\"country\":\"England\",\"displayable_address\":\"Heath Rise, Virginia Water GU25\",\"first_published_date\":\"2014-11-21 15:18:05\",\"floor_plan\":[\"http://lc.zoocdn.com/76e8fd7812c5a091ab959f7d849af9e18c9a4cfd.jpg\"],\"street_name\":\"\",\"num_bathrooms\":\"5\",\"price_change\":[{\"date\":\"2014-11-21 14:11:46\",\"price\":\"2250000.00\"}],\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(72423).jpeg\",\"agent_phone\":\"01344 238035\",\"image_url\":\"http://lc.zoocdn.com/293ce3e351485076f8e923a75ed37051a22720d0.jpg\",\"last_published_date\":\"2014-11-28 15:15:04\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("35020741", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"3\",\"latitude\":51.403088,\"agent_address\":\"38 High Street\",\"property_type\":\"Flat\",\"longitude\":-0.488732,\"thumbnail_url\":\"http://li.zoocdn.com/b177b95a0ee91e3816b40e57ddd2e0b308807e2a_80_60.jpg\",\"description\":\"  Laleham Abbey was built in the Palladian style by renowned architect John Buanarotti Papworth between 1803-1806, as a second home for the 2nd Earl of Lucan. The property has fascinating history having been an officer's hospital, school and convent and is one of the most notable buildings within the area.The Collonade is the principle apartment extending to 4000sqft and gained its name from the row of impressive architectural pillars to the rear of the apartment.The accommodation comprises, grand entrance hall, kitchen, dining room, drawing room, galleried study area, three double bedrooms, family bathroom, media/family room and cellar.The main hub of this stunning property is dining room which has French doors opening onto beautiful views over the southerly facing gardens.The kitchen has handmade units with granite work surfaces and a range of integrated appliances.A staircase to the side leads to the galleried study area above the kitchen, which overlooks the dining room.A pair of original mahogany doors open into the elegant double aspect drawing room which approaches 36' x 24' with an Adam style fireplace and three sets of French doors onto the terrace.A central corridor gives access to the three double bedrooms and the family bathroom. The master bedroom has an en-suite bathroom and has doors opening onto the terrace.Stairs leading down to the media/family room and wine cellar which has power, electric and water.The property has a private and secluded garden approaching Â¼ acre including its own outdoor swimming pool.Â \",\"post_town\":\"Staines\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/35020741?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"short_description\":\"The Collonade is a superb split level three bedroom apartment, with an outdoor swimming pool and gardens of 1/4 acre.\",\"outcode\":\"TW18\",\"county\":\"Surrey\",\"price\":\"1700000\",\"listing_id\":\"35020741\",\"image_caption\":\"\",\"status\":\"for_sale\",\"agent_name\":\"UK Sotheby's International Realty - Cobham\",\"num_recepts\":\"0\",\"country\":\"England\",\"displayable_address\":\"Laleham Abbey, Laleham Park, Staines TW18\",\"first_published_date\":\"2014-10-22 21:24:39\",\"price_modifier\":\"guide_price\",\"floor_plan\":[\"http://lc.zoocdn.com/241cd923c02ba6e50b015bf211ed00af47dceeea.png\"],\"street_name\":\"Laleham Park\",\"num_bathrooms\":\"0\",\"price_change\":[{\"date\":\"2014-10-30 19:03:25\",\"price\":\"1700000.00\"}],\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(143839).png\",\"agent_phone\":\"01932 379423\",\"image_url\":\"http://lc.zoocdn.com/b177b95a0ee91e3816b40e57ddd2e0b308807e2a.jpg\",\"last_published_date\":\"2014-12-03 07:29:15\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("35025779", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"image_caption\":\"Front View\",\"status\":\"for_sale\",\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"0\",\"agent_name\":\"Savills - Ascot\",\"latitude\":51.4069,\"agent_address\":\"Mount Lodge London Road\",\"num_recepts\":\"0\",\"property_type\":\"Land\",\"country\":\"England\",\"longitude\":-0.574185,\"first_published_date\":\"2014-10-31 21:27:50\",\"displayable_address\":\"Woodlands Road West, Virginia Water, Surrey GU25\",\"price_modifier\":\"guide_price\",\"street_name\":\"Virginia Water Surrey\",\"num_bathrooms\":\"0\",\"thumbnail_url\":\"http://li.zoocdn.com/0699304c2d5514bba2eea309e1b2704303630dce_80_60.jpg\",\"description\":\"LocationThe plot is situated in a prestigious road on the Wentworth Estate, one of the uk's most desirable residential areas.The area is rural and leafy yet perfectly positioned for access to the M25 (J13) leading to Heathrow, the M3, M4 and central London. Virginia Water has a range of shops for daily needs and a station serving London (Waterloo).Sporting and leisure facilities are outstanding; the world famous golf clubs of Wentworth, Sunningdale and The Berkshire are nearby; there is racing at Ascot and polo at Smith's Lawn. There is an excellent choice of schools in the area including Eton College, St George's, St Mary's, Papplewick and The acs Egham International School.DescriptionSituated in an extremely private, elevated and southerly position, this is a rare opportunity to acquire a plot of about 1.2 acres.Planning permission has been granted for a replacement dwelling of over 16, 000 sq ft which includes a sumptuous leisure complex with direct access onto the gardens and a pool house.\",\"post_town\":\"Virginia Water\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/35025779?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(114945).png\",\"price_change\":[{\"date\":\"2014-10-31 16:39:47\",\"price\":\"4500000.00\"},{\"date\":\"2014-11-01 16:31:56\",\"price\":\"3950000.00\"}],\"short_description\":\"Development opportunity with full planning permission on the Wentworth Estate\",\"agent_phone\":\"01344 859733\",\"outcode\":\"GU25\",\"image_url\":\"http://lc.zoocdn.com/0699304c2d5514bba2eea309e1b2704303630dce.jpg\",\"last_published_date\":\"2014-11-27 07:58:35\",\"county\":\"Surrey\",\"price\":\"3950000\",\"listing_id\":\"35025779\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("35085370", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"5\",\"latitude\":51.401287,\"agent_address\":\"2 Station Approach\",\"property_type\":\"Detached house\",\"longitude\":-0.568163,\"thumbnail_url\":\"http://li.zoocdn.com/83dc7237e74737a42cce993f7c8b10c259fdd3b9_80_60.jpg\",\"description\":\"Double height galleried entrance hall, drawing room, dining room, study, kitchen/breakfast room/family room, cloakroom, utility room, magnificent master suite with sitting room, dressing room and luxurious bathroom, four further en-suite bedrooms, au-pair suite/annexe, integral double garage, private landscaped grounds, approximately half an acre.Designed and built to the highest standards, a sumptously appointed brand new home built by renowned builders Runnymede Homes.Located on a prime residential road on the world famous Wentworth Esate available for immediate occupation.\",\"post_town\":\"Virginia Water\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/35085370?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"short_description\":\"Located on a prime residential road on the world famous Wentworth Esate available for immediate occupation.  Preview/launch date Saturday 15th November from 10am  Double height galleried entrance hall, drawing room, dining room, study, kitchen/breakfast room/family room, cloakroom, utility room, magnificent master suite with sitting room, dressing room and luxurious bathroom, four further en-suite bedrooms, au-pair suite/annexe, integral double garage, private landscaped grounds, approximately half an acre.\",\"outcode\":\"GU25\",\"new_home\":\"true\",\"county\":\"Surrey\",\"price\":\"3795000\",\"listing_id\":\"35085370\",\"image_caption\":\"Main\",\"status\":\"for_sale\",\"agent_name\":\"Barton Wyatt\",\"num_recepts\":\"4\",\"country\":\"England\",\"displayable_address\":\"Nuns Walk, Wentworth, Virginia Water GU25\",\"first_published_date\":\"2014-11-06 17:14:41\",\"price_modifier\":\"guide_price\",\"floor_plan\":[\"http://lc.zoocdn.com/165e904d8935dbcfa75bbc1b28be5713b4c1f14e.gif\"],\"street_name\":\"Wentworth Estate\",\"num_bathrooms\":\"5\",\"price_change\":[{\"date\":\"2014-11-06 16:24:29\",\"price\":\"3795000.00\"}],\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(26148).gif\",\"agent_phone\":\"01344 238033\",\"image_url\":\"http://lc.zoocdn.com/83dc7237e74737a42cce993f7c8b10c259fdd3b9.jpg\",\"last_published_date\":\"2014-11-27 08:23:51\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");
        cannedListingsMap.put("35280894", "{\"result_count\":1,\"area_name\":\"\",\"listing\":[{\"num_floors\":\"0\",\"listing_status\":\"sale\",\"num_bedrooms\":\"5\",\"latitude\":51.43982,\"agent_address\":\"11 Station Parade\",\"property_type\":\"Detached house\",\"letting_fees\":\"Fees apply<br><br>The asking rent does not include letting fees. Depending on your circumstances and the property you select, one or more of the following upfront fees may apply:<br><br>â€¢ general administration fees<br>â€¢ reference fees (including credit checks, bank, guarantor, previous landlord, etc)<br>â€¢ application fees<br>â€¢ fees for drawing up tenancy agreements<br>â€¢ inventory fees, including check-in and check-out fees<br>â€¢ guarantor arrangement/application fees<br>â€¢ additional occupant fees<br>â€¢ pets disclaimer fees/additional pet deposit<br><br>Fees may be charged on a per person or per property basis, so please confirm before viewing.<br>\",\"longitude\":-0.579318,\"thumbnail_url\":\"http://li.zoocdn.com/26de24f9ed15d87357ee4f2428e15c0b3bb890e8_80_60.jpg\",\"description\":\"Property DescriptionOffering Three Reception Rooms, Four Bathrooms and Boasting Character Features such as Oak Flooring and Fireplaces, Set in Wonderful Private Gardens.\",\"post_town\":\"Egham\",\"details_url\":\"http://www.zoopla.co.uk/for-sale/details/35280894?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\"short_description\":\"Offering Three Reception Rooms, Four Bathrooms and Boasting Character Features such as Oak Flooring and Fireplaces, Set in Wonderful Private Gardens.\",\"outcode\":\"TW20\",\"county\":\"Surrey\",\"price\":\"2750000\",\"listing_id\":\"35280894\",\"image_caption\":\"Front Of Property\",\"status\":\"for_sale\",\"agent_name\":\"Chancellors\",\"num_recepts\":\"0\",\"country\":\"England\",\"displayable_address\":\"Ridgemead Road, Englefield Green, Egham TW20\",\"first_published_date\":\"2014-11-26 19:26:35\",\"price_modifier\":\"offers_over\",\"floor_plan\":[\"http://lc.zoocdn.com/457df76b8e2348fdcc376e836b58319b7ee62b81.png\",\"http://lc.zoocdn.com/c617583023ef459ae807b063df24c8a23e807cb3.png\"],\"street_name\":\"\",\"num_bathrooms\":\"0\",\"price_change\":[{\"date\":\"2014-11-26 15:07:49\",\"price\":\"2750000.00\"}],\"agent_logo\":\"http://st.zoocdn.com/zoopla_static_agent_logo_(46693).jpeg\",\"agent_phone\":\"01344 238034\",\"image_url\":\"http://lc.zoocdn.com/26de24f9ed15d87357ee4f2428e15c0b3bb890e8.jpg\",\"last_published_date\":\"2014-11-29 04:20:20\"}],\"street\":\"\",\"county\":\"\",\"town\":\"\",\"postcode\":\"\"}");

        return cannedListingsMap;
    }

    private static String populateAllCannedListings() {
        return "{\n" +
                "    \"result_count\": 7,\n" +
                "    \"longitude\": -0.0761165,\n" +
                "    \"area_name\": \"\",\n" +
                "    \"listing\": [\n" +
                "        {\n" +
                "            \"image_caption\": \"Picture No. 24\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"6\",\n" +
                "            \"agent_name\": \"Hamptons International - Weybridge\",\n" +
                "            \"latitude\": 51.39648,\n" +
                "            \"agent_address\": \"26 High Street\",\n" +
                "            \"num_recepts\": \"0\",\n" +
                "            \"property_type\": \"Detached house\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"longitude\": -0.526526,\n" +
                "            \"first_published_date\": \"2014-10-01 16:05:04\",\n" +
                "            \"displayable_address\": \"St. Anns Hill Rd, Chertsey, Surrey KT16\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/6a8e23c6aec830327a4fb7864ff69e6d01958ada.gif\", \"http://lc.zoocdn.com/640b6cb6fcad955a9c8bc5f1f07a024675c4fbf4.pdf\"],\n" +
                "            \"street_name\": \"Chertsey Surrey\",\n" +
                "            \"num_bathrooms\": \"0\",\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6_354_255.jpg\",\n" +
                "            \"description\": \"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings. These have commercial usage and are currently used as a recording studio and a separate one bedroom annexe. Originally built in 1966 with strong Scandinavian overtones, the property is located in a semi-rural setting adjacent to open paddocks, on a mature good size plot with an outdoor swimming pool and parking for several vehicles. The ground floor comprises an entrance hall with a cloakroom, a study, a dual aspect dining room, a triple aspect luxury kitchen and steps up to a vaulted lounge with panoramic windows giving spectacular views. There are stairs down to a lower ground floor which comprises a double bedroom, cloakroom and a utility room. The first floor boasts a master bedroom suite with a five piece bathroom suite and French doors leading out onto a private terrace. There are three further bedrooms and a family bathroom.SituationSituated in a highly desirable road on the outskirts of Chertsey elevated in an attractive semi rural position and surrounded by fields and country views. Offering privacy and seclusion but still extremely convenient for commuting to London due to the close proximity of the M25 and A30. There is excellent schooling in the area, both private and independent and two nearby international schools. It is also within easy reach of the local centres of Virginia Water, Chertsey, Ascot and Windsor which cater for day to day shopping requirements. Communications are excellent with the M25, M3 and M4 close by giving fast access to the motorway network, London, Heathrow and Gatwick. There are good train services from Chertsey into London (approx. 45 minutes) and there is racing at Ascot, Windsor and Polo at nearby Smiths Lawn. There are many fine golf courses in the area, in particular Wentworth and Sunningdale which are just a short drive from the property. Windsor Great Park is within easy reach as are the boating facilities in the River Thames..OutsideThe landscaped gardens of approximately 2 acres have been beautifully maintained with an extensive patio and steps leading down to the pool area with paved surroundings and a full length pool house, ideal for entertaining with a lounge, dining area and kitchen. Wrought iron gates open onto an extensive driveway providing plenty of parking spaces and gives access to the detached recording studio and a separate detached annexe.\",\n" +
                "            \"post_town\": \"Chertsey\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/34700970?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(58008).jpeg\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-10-01 15:00:40\",\n" +
                "                    \"price\": \"1690000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"short_description\": \"A visually striking spacious detached family home offering flexible and versatile accommodation, arranged over three floors with various outbuildings and in grounds of approximately two acres.\",\n" +
                "            \"agent_phone\": \"01932 807844\",\n" +
                "            \"outcode\": \"KT16\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/29a549016538c3904abbf71e087100693491e8f6.jpg\",\n" +
                "            \"last_published_date\": \"2014-12-03 13:20:50\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"1690000\",\n" +
                "            \"listing_id\": \"34700970\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"4\",\n" +
                "            \"latitude\": 51.40455,\n" +
                "            \"agent_address\": \"20 Station Approach\",\n" +
                "            \"property_type\": \"Detached house\",\n" +
                "            \"longitude\": -0.559881,\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/741c99caf1bc43b32df7bc1386444d6a151ab6f3_354_255.jpg\",\n" +
                "            \"description\": \"A rare opportunity to purchase a unique home forming part of this Grade 1 listed building, set on the prestigious Virginia Park with excellent residents' leisure facilities and 24 hour gated security. EPC rating D.A beautifully presented 4 bedroom home, enjoying a superb position on the exclusive Virginia Park gated estate. The property is close to Virginia Water village with its good selection of shops, restaurants and station. Access from the drawing room/dining area leads to a privately owned sun terrace with hedge surround. A gate leads to a very well maintained area of communal grounds. There is underground parking for 3 cars and further visitors parking.Crossland House and the surrounding development is situated in Virginia Park, a 24 acre walled parkland estate. Residents' facilities within the main building include a swimming pool, gymnasium, jacuzzi, sauna, sun beds and changing facilities.Communications to London and the airports are excellent due to the convenient proximity of the M25 as well as having a mainline station to Waterloo. Other attractions within the area include Ascot racecourse, Windsor Castle, Legoland and Savill Gardens. Schooling is exceptional with many renowned private schools. There are two international schools.Ascot 4 miles, M3 5 miles, M4 9 miles, Heathrow Airport (T5) 9 miles, Central London 28 miles. (All distances are approximate).\",\n" +
                "            \"post_town\": \"Virginia Water\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/34782084?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"short_description\": \"Victorian Masterpiece in gated development - A rare opportunity to purchase a unique home forming part of this Grade 1 listed building, set on the prestigious Virginia Park with excellent residents' leisure facilities and 24 hour gated security. EPC rating D.  A beautifully presented 4 bedroom home, enjoying a superb position on the exclusive Virginia Park gated estate. The property is close to Virginia Water village with its good selection of shops, restaurants and station. Access from the drawing room/dining area leads to a privately owned sun terrace with hedge surround. A gate leads to a very well maintained area of communal grounds. There is underground parking for 3 cars and further visitors parking.  Crossland House and the surrounding development is situated in Virginia Park, a 24 acre walled parkland estate. Residents' facilities within the main building include a swimming pool, gymnasium, jacuzzi, sauna, sun beds and changing facilities.  Communications to London and the airports are excellent due to the convenient pr\",\n" +
                "            \"outcode\": \"GU25\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"1950000\",\n" +
                "            \"listing_id\": \"34782084\",\n" +
                "            \"image_caption\": \"Virginia Park\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"agent_name\": \"Knight Frank - Virginia Water\",\n" +
                "            \"num_recepts\": \"2\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"displayable_address\": \"Crossland House, Holloway Drive, Virginia Water, Surrey GU25\",\n" +
                "            \"first_published_date\": \"2014-10-08 20:28:11\",\n" +
                "            \"price_modifier\": \"guide_price\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/a05aac35f82aad8a7f8d62a7a12ac3216266d8e7.pdf\"],\n" +
                "            \"street_name\": \"Crossland House\",\n" +
                "            \"num_bathrooms\": \"2\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-10-08 19:30:32\",\n" +
                "                    \"price\": \"1950000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(134849).png\",\n" +
                "            \"agent_phone\": \"01344 527001\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/741c99caf1bc43b32df7bc1386444d6a151ab6f3.jpg\",\n" +
                "            \"last_published_date\": \"2014-11-26 12:20:35\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"5\",\n" +
                "            \"latitude\": 51.40601,\n" +
                "            \"agent_address\": \"6 Station Approach\",\n" +
                "            \"property_type\": \"\",\n" +
                "            \"letting_fees\": \"Fees for tenants: Â£180 for Agreement Fee, Â£60 for Admin and References, Â£30 tds fee, all including vat.\",\n" +
                "            \"longitude\": -0.566794,\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/293ce3e351485076f8e923a75ed37051a22720d0_354_255.jpg\",\n" +
                "            \"description\": \"The Pines is a well planned modern family home providing excellent, adaptable living space; the property is set behind gates in this highly convenient location, being just a short stroll to village centre shops and rail station while benefiting from a quiet location on the exclusive Wentworth Estate.\",\n" +
                "            \"post_town\": \"Virginia Water\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/35241360?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"short_description\": \"A spacious modern home offering superb family accommodation and enjoying a mature, private plot in excess of half an acre, close to the village centre.\",\n" +
                "            \"outcode\": \"GU25\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"2250000\",\n" +
                "            \"listing_id\": \"35241360\",\n" +
                "            \"image_caption\": \"\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"agent_name\": \"Buckinghams\",\n" +
                "            \"num_recepts\": \"0\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"displayable_address\": \"Heath Rise, Virginia Water GU25\",\n" +
                "            \"first_published_date\": \"2014-11-21 15:18:05\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/76e8fd7812c5a091ab959f7d849af9e18c9a4cfd.jpg\"],\n" +
                "            \"street_name\": \"\",\n" +
                "            \"num_bathrooms\": \"5\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-11-21 14:11:46\",\n" +
                "                    \"price\": \"2250000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(72423).jpeg\",\n" +
                "            \"agent_phone\": \"01344 238035\",\n" +
                "            \"image_url\": \"http://li.zoocdn.com/293ce3e351485076f8e923a75ed37051a22720d0_354_255.jpg\",\n" +
                "            \"last_published_date\": \"2014-11-28 15:15:04\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"3\",\n" +
                "            \"latitude\": 51.403088,\n" +
                "            \"agent_address\": \"38 High Street\",\n" +
                "            \"property_type\": \"Flat\",\n" +
                "            \"longitude\": -0.488732,\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/b177b95a0ee91e3816b40e57ddd2e0b308807e2a_354_255.jpg\",\n" +
                "            \"description\": \"  Laleham Abbey was built in the Palladian style by renowned architect John Buanarotti Papworth between 1803-1806, as a second home for the 2nd Earl of Lucan. The property has fascinating history having been an officer's hospital, school and convent and is one of the most notable buildings within the area.The Collonade is the principle apartment extending to 4000sqft and gained its name from the row of impressive architectural pillars to the rear of the apartment.The accommodation comprises, grand entrance hall, kitchen, dining room, drawing room, galleried study area, three double bedrooms, family bathroom, media/family room and cellar.The main hub of this stunning property is dining room which has French doors opening onto beautiful views over the southerly facing gardens.The kitchen has handmade units with granite work surfaces and a range of integrated appliances.A staircase to the side leads to the galleried study area above the kitchen, which overlooks the dining room.A pair of original mahogany doors open into the elegant double aspect drawing room which approaches 36' x 24' with an Adam style fireplace and three sets of French doors onto the terrace.A central corridor gives access to the three double bedrooms and the family bathroom. The master bedroom has an en-suite bathroom and has doors opening onto the terrace.Stairs leading down to the media/family room and wine cellar which has power, electric and water.The property has a private and secluded garden approaching Â¼ acre including its own outdoor swimming pool.Â \",\n" +
                "            \"post_town\": \"Staines\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/35020741?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"short_description\": \"The Collonade is a superb split level three bedroom apartment, with an outdoor swimming pool and gardens of 1/4 acre.\",\n" +
                "            \"outcode\": \"TW18\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"1700000\",\n" +
                "            \"listing_id\": \"35020741\",\n" +
                "            \"image_caption\": \"\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"agent_name\": \"UK Sotheby's International Realty - Cobham\",\n" +
                "            \"num_recepts\": \"0\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"displayable_address\": \"Laleham Abbey, Laleham Park, Staines TW18\",\n" +
                "            \"first_published_date\": \"2014-10-22 21:24:39\",\n" +
                "            \"price_modifier\": \"guide_price\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/241cd923c02ba6e50b015bf211ed00af47dceeea.png\"],\n" +
                "            \"street_name\": \"Laleham Park\",\n" +
                "            \"num_bathrooms\": \"0\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-10-30 19:03:25\",\n" +
                "                    \"price\": \"1700000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(143839).png\",\n" +
                "            \"agent_phone\": \"01932 379423\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/b177b95a0ee91e3816b40e57ddd2e0b308807e2a.jpg\",\n" +
                "            \"last_published_date\": \"2014-12-03 07:29:15\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"image_caption\": \"Front View\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"0\",\n" +
                "            \"agent_name\": \"Savills - Ascot\",\n" +
                "            \"latitude\": 51.4069,\n" +
                "            \"agent_address\": \"Mount Lodge London Road\",\n" +
                "            \"num_recepts\": \"0\",\n" +
                "            \"property_type\": \"Land\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"longitude\": -0.574185,\n" +
                "            \"first_published_date\": \"2014-10-31 21:27:50\",\n" +
                "            \"displayable_address\": \"Woodlands Road West, Virginia Water, Surrey GU25\",\n" +
                "            \"price_modifier\": \"guide_price\",\n" +
                "            \"street_name\": \"Virginia Water Surrey\",\n" +
                "            \"num_bathrooms\": \"0\",\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/0699304c2d5514bba2eea309e1b2704303630dce_354_255.jpg\",\n" +
                "            \"description\": \"LocationThe plot is situated in a prestigious road on the Wentworth Estate, one of the uk's most desirable residential areas.The area is rural and leafy yet perfectly positioned for access to the M25 (J13) leading to Heathrow, the M3, M4 and central London. Virginia Water has a range of shops for daily needs and a station serving London (Waterloo).Sporting and leisure facilities are outstanding; the world famous golf clubs of Wentworth, Sunningdale and The Berkshire are nearby; there is racing at Ascot and polo at Smith's Lawn. There is an excellent choice of schools in the area including Eton College, St George's, St Mary's, Papplewick and The acs Egham International School.DescriptionSituated in an extremely private, elevated and southerly position, this is a rare opportunity to acquire a plot of about 1.2 acres.Planning permission has been granted for a replacement dwelling of over 16, 000 sq ft which includes a sumptuous leisure complex with direct access onto the gardens and a pool house.\",\n" +
                "            \"post_town\": \"Virginia Water\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/35025779?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(114945).png\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-10-31 16:39:47\",\n" +
                "                    \"price\": \"4500000.00\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"date\": \"2014-11-01 16:31:56\",\n" +
                "                    \"price\": \"3950000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"short_description\": \"Development opportunity with full planning permission on the Wentworth Estate\",\n" +
                "            \"agent_phone\": \"01344 859733\",\n" +
                "            \"outcode\": \"GU25\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/0699304c2d5514bba2eea309e1b2704303630dce.jpg\",\n" +
                "            \"last_published_date\": \"2014-11-27 07:58:35\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"3950000\",\n" +
                "            \"listing_id\": \"35025779\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"5\",\n" +
                "            \"latitude\": 51.401287,\n" +
                "            \"agent_address\": \"2 Station Approach\",\n" +
                "            \"property_type\": \"Detached house\",\n" +
                "            \"longitude\": -0.568163,\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/83dc7237e74737a42cce993f7c8b10c259fdd3b9_354_255.jpg\",\n" +
                "            \"description\": \"Double height galleried entrance hall, drawing room, dining room, study, kitchen/breakfast room/family room, cloakroom, utility room, magnificent master suite with sitting room, dressing room and luxurious bathroom, four further en-suite bedrooms, au-pair suite/annexe, integral double garage, private landscaped grounds, approximately half an acre.Designed and built to the highest standards, a sumptously appointed brand new home built by renowned builders Runnymede Homes.Located on a prime residential road on the world famous Wentworth Esate available for immediate occupation.\",\n" +
                "            \"post_town\": \"Virginia Water\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/35085370?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"short_description\": \"Located on a prime residential road on the world famous Wentworth Esate available for immediate occupation.  Preview/launch date Saturday 15th November from 10am  Double height galleried entrance hall, drawing room, dining room, study, kitchen/breakfast room/family room, cloakroom, utility room, magnificent master suite with sitting room, dressing room and luxurious bathroom, four further en-suite bedrooms, au-pair suite/annexe, integral double garage, private landscaped grounds, approximately half an acre.\",\n" +
                "            \"outcode\": \"GU25\",\n" +
                "            \"new_home\": \"true\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"3795000\",\n" +
                "            \"listing_id\": \"35085370\",\n" +
                "            \"image_caption\": \"Main\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"agent_name\": \"Barton Wyatt\",\n" +
                "            \"num_recepts\": \"4\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"displayable_address\": \"Nuns Walk, Wentworth, Virginia Water GU25\",\n" +
                "            \"first_published_date\": \"2014-11-06 17:14:41\",\n" +
                "            \"price_modifier\": \"guide_price\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/165e904d8935dbcfa75bbc1b28be5713b4c1f14e.gif\"],\n" +
                "            \"street_name\": \"Wentworth Estate\",\n" +
                "            \"num_bathrooms\": \"5\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-11-06 16:24:29\",\n" +
                "                    \"price\": \"3795000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(26148).gif\",\n" +
                "            \"agent_phone\": \"01344 238033\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/83dc7237e74737a42cce993f7c8b10c259fdd3b9.jpg\",\n" +
                "            \"last_published_date\": \"2014-11-27 08:23:51\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"num_floors\": \"0\",\n" +
                "            \"listing_status\": \"sale\",\n" +
                "            \"num_bedrooms\": \"5\",\n" +
                "            \"latitude\": 51.43982,\n" +
                "            \"agent_address\": \"11 Station Parade\",\n" +
                "            \"property_type\": \"Detached house\",\n" +
                "            \"letting_fees\": \"Fees apply<br><br>The asking rent does not include letting fees. Depending on your circumstances and the property you select, one or more of the following upfront fees may apply:<br><br>â€¢ general administration fees<br>â€¢ reference fees (including credit checks, bank, guarantor, previous landlord, etc)<br>â€¢ application fees<br>â€¢ fees for drawing up tenancy agreements<br>â€¢ inventory fees, including check-in and check-out fees<br>â€¢ guarantor arrangement/application fees<br>â€¢ additional occupant fees<br>â€¢ pets disclaimer fees/additional pet deposit<br><br>Fees may be charged on a per person or per property basis, so please confirm before viewing.<br>\",\n" +
                "            \"longitude\": -0.579318,\n" +
                "            \"thumbnail_url\": \"http://li.zoocdn.com/26de24f9ed15d87357ee4f2428e15c0b3bb890e8_354_255.jpg\",\n" +
                "            \"description\": \"Property DescriptionOffering Three Reception Rooms, Four Bathrooms and Boasting Character Features such as Oak Flooring and Fireplaces, Set in Wonderful Private Gardens.\",\n" +
                "            \"post_town\": \"Egham\",\n" +
                "            \"details_url\": \"http://www.zoopla.co.uk/for-sale/details/35280894?utm_source=v1:8a6VSjnPHRmN_grzZOso4jLuOBEq1rOK&utm_medium=api\",\n" +
                "            \"short_description\": \"Offering Three Reception Rooms, Four Bathrooms and Boasting Character Features such as Oak Flooring and Fireplaces, Set in Wonderful Private Gardens.\",\n" +
                "            \"outcode\": \"TW20\",\n" +
                "            \"county\": \"Surrey\",\n" +
                "            \"price\": \"2750000\",\n" +
                "            \"listing_id\": \"35280894\",\n" +
                "            \"image_caption\": \"Front Of Property\",\n" +
                "            \"status\": \"for_sale\",\n" +
                "            \"agent_name\": \"Chancellors\",\n" +
                "            \"num_recepts\": \"0\",\n" +
                "            \"country\": \"England\",\n" +
                "            \"displayable_address\": \"Ridgemead Road, Englefield Green, Egham TW20\",\n" +
                "            \"first_published_date\": \"2014-11-26 19:26:35\",\n" +
                "            \"price_modifier\": \"offers_over\",\n" +
                "            \"floor_plan\": [\"http://lc.zoocdn.com/457df76b8e2348fdcc376e836b58319b7ee62b81.png\", \"http://lc.zoocdn.com/c617583023ef459ae807b063df24c8a23e807cb3.png\"],\n" +
                "            \"street_name\": \"\",\n" +
                "            \"num_bathrooms\": \"0\",\n" +
                "            \"price_change\": [\n" +
                "                {\n" +
                "                    \"date\": \"2014-11-26 15:07:49\",\n" +
                "                    \"price\": \"2750000.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"agent_logo\": \"http://st.zoocdn.com/zoopla_static_agent_logo_(46693).jpeg\",\n" +
                "            \"agent_phone\": \"01344 238034\",\n" +
                "            \"image_url\": \"http://lc.zoocdn.com/26de24f9ed15d87357ee4f2428e15c0b3bb890e8.jpg\",\n" +
                "            \"last_published_date\": \"2014-11-29 04:20:20\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"street\": \"\",\n" +
                "    \"town\": \"\",\n" +
                "    \"latitude\": 51.511499,\n" +
                "    \"county\": \"\",\n" +
                "    \"bounding_box\": {\n" +
                "        \"longitude_min\": \"-0.08054499999999998\",\n" +
                "        \"latitude_min\": \"51.508602\",\n" +
                "        \"longitude_max\": \"-0.07168799999999997\",\n" +
                "        \"latitude_max\": \"51.514396\"\n" +
                "    },\n" +
                "    \"postcode\": \"\"\n" +
                "}";
    }

}
