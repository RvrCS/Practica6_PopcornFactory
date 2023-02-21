package torres.river.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0
        var id = -1

        if (bundle != null){

            ns = bundle.getInt("numberSeats")
            movie_header.setImageResource(bundle.getInt("header"))
            movie_title_detail.setText(bundle.getString("title"))
            movie_summary.setText(bundle.getString("synopsis"))
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")

        }

        if (ns == 0){
            buyTickets.isEnabled = false
        }else if (bundle != null){
            buyTickets.setOnClickListener {

                val intent: Intent = Intent(this, SeatSelectionActivity::class.java)

                intent.putExtra("id", id)
                    intent.putExtra("name", bundle.getString("title"))

                this.startActivity(intent)

            }
        }

    }
}