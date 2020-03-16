package br.com.tamanduasoft.drinkwater

import android.app.Application
import br.com.tamanduasoft.drinkwater.features.home.homeKoinModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DrinkWaterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@DrinkWaterApp)
            modules(
                listOf(
                    homeKoinModule
                )
            )
        }
    }
}