package az.anvar.servicesworkmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import az.anvar.servicesworkmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.simpleService.setOnClickListener {
            val intent = MyService.newIntent(this)
            startService(intent)
        }
    }
}