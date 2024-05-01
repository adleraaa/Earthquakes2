package com.example.earthquakes.api
import com.example.earthquakes.models.FeatureCollection
import retrofit2.Call
import retrofit2.http.GET

interface EarthquakeService {
    @GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
    fun getEarthquakeData(): Call<FeatureCollection>
}