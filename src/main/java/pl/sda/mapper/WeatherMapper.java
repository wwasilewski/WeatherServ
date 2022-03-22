package pl.sda.mapper;

import pl.sda.dto.WeatherDto;
import pl.sda.model.Weather;

public class WeatherMapper implements Mapper<WeatherDto, Weather> {

    @Override
    public WeatherDto mapEntityToDto(Weather weather) {
        return WeatherDto.builder()
                .temp(weather.getTemp())
                .pressure(weather.getPressure())
                .humidity(weather.getHumidity())
                .windSpeed(weather.getWindSpeed())
                .windDeg(weather.getWindDeg())
                .timestamp(weather.getTimestamp())
                .build();
    }

    @Override
    public Weather mapDtoToEntity(WeatherDto weatherDto) {
        return Weather.builder()
                .temp(weatherDto.getTemp())
                .pressure(weatherDto.getPressure())
                .humidity(weatherDto.getHumidity())
                .windSpeed(weatherDto.getWindSpeed())
                .windDeg(weatherDto.getWindDeg())
                .timestamp(weatherDto.getTimestamp())
                .build();
    }
}
