package com.example.earthquakes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakes.api.EarthquakeService
import com.example.earthquakes.models.FeatureCollection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EarthquakeListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var earthquakeAdapter: EarthquakeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earthquake_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        // Assuming you want to start fetching data as soon as this activity starts
        fetchEarthquakeData()
    }

    private fun fetchEarthquakeData() {
        val earthquakeService = RetrofitHelper.getInstance().create(EarthquakeService::class.java)
        val call = earthquakeService.getEarthquakeData()

        call.enqueue(object : Callback<FeatureCollection> {
            override fun onResponse(call: Call<FeatureCollection>, response: Response<FeatureCollection>) {
                if (response.isSuccessful) {
                    // Assuming your FeatureCollection has a list of Feature objects named 'features'
                    val features = response.body()?.features ?: emptyList()
                    earthquakeAdapter = EarthquakeAdapter(features)
                    recyclerView.adapter = earthquakeAdapter
                } else {
                    Log.e(TAG, "onResponse: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<FeatureCollection>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    companion object {
        private const val TAG = "EarthquakeListActivity"
    }
}