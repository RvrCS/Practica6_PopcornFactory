package torres.river.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.button_getIn)

        button.setOnClickListener {

            var intent = Intent(this, CatalogActivity::class.java)
            this.startActivity(intent)
        }
    }
}