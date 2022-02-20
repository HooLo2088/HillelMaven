package test.mvnTest.BasicTest.homeWork15For23;

import org.testng.annotations.Test;
import test.mvnTest.BasicTest.BaseTest;
import ua.hillel.BasicCourse.pageObjects.GeoPage;

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
