package test.mvnTest.homeWork15For23;

import org.testng.annotations.Test;
import ua.hillel.pageObjects.GeoPage;

public class GeoTest extends BaseTest {

    @Test
    public void geoTest() {
        GeoPage geoPage = openApp()
                .goToGeoPage()
                .clickWhereAmIButton();

        String latitudeTex = geoPage.getLatitudeText();
        String longitudeText = geoPage.getLongitudeText();

        System.out.printf("Lalitude = %s%nLongitude = %s", latitudeTex, longitudeText);
    }
}
