package track.individual.read4share.config;


public class GlobalConstants {
    /**
     * Maximum number of returned records for the Advertisements Overview section
     */
    public static int maxRecordsAdvOverview = 40;

    /**
     * JWT expiration time represented in milliseconds
     */
    public static int jwtExpirationMs = 3600000;

    public static String gBooksApiUrl = "https://www.googleapis.com/books/v1/volumes?q=intitle:";

    public static String standardCover = "http://localhost:8080/no-cover.png";
}
