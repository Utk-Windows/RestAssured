package rsaMapsApi;

public class PayLoad {


    public static String AddPlacePostRequest()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.3835224,\n" +
                "    \"lng\": 11.1023455\n" +
                "  },\n" +
                "  \"accuracy\": 1011,\n" +
                "  \"name\": \"New API of utk SIR\",\n" +
                "  \"phone_number\": \"(+91) 983 8914534\",\n" +
                "  \"address\": \"New Api Data Lane\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"Hindi-IN\"\n" +
                "}\n";
    }



}
