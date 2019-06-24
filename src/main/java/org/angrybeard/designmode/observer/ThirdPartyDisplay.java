package org.angrybeard.designmode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temp;
    private float humidity;

    public ThirdPartyDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Third Party Display: " + temp + "°C;" + humidity + "湿度");
    }
}
