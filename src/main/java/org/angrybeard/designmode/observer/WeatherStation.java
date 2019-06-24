package org.angrybeard.designmode.observer;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new CurrentConditionsDisplay(weatherData);
        new ThirdPartyDisplay(weatherData);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            weatherData.setMeasurements(13.4f + i, 12L + i, 13.4f + i);
        }
    }
}
