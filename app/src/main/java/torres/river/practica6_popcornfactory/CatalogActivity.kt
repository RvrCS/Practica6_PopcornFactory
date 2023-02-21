package torres.river.practica6_popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class CatalogActivity : AppCompatActivity() {

    var adapter: MovieAdapter? = null
    //var seriesAdapter: MovieAdapter? = null
    var movies = ArrayList<Movie>()
    var series = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        loadMovies()
        adapter = MovieAdapter(this, movies)
       // seriesAdapter = MovieAdapter(this, series)

        var gridMovies: GridView = findViewById(R.id.movies_catalog)

        gridMovies.adapter = adapter
    }

    fun loadMovies(){
        movies.add(Movie("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "" +
                "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends " +
                "adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends " +
                "into a band of high-tech heroes called ‘Big Hero 6.’", arrayListOf<Client>()))

        movies.add(Movie("Inception",R.drawable.inception, R.drawable.inceptionheader, "" +
                "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious " +
                "during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of " +
                "corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at " +
                "redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and" +
                " his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect " +
                "crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that" +
                "only Cobb could have seen coming.", arrayListOf<Client>()))

        movies.add(Movie("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "" +
                "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 " +
                "rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her" +
                " cross-country odyssey just might result in her getting engaged.", arrayListOf<Client>()))

        movies.add(Movie("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "" +
                "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite " +
                "toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys" +
                " of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into " +
                "all kind of trouble while trying to get home.", arrayListOf<Client>()))

        series.add(Movie("Smallville", R.drawable.smallville, R.drawable.smallvilleheader, "" +
                "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst " +
                "colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic " +
                "egresses in the past. They say he&#39;s either too fast or has a penchant for finding trouble. He was " +
                "found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. " +
                "Clark&#39;s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for " +
                "Clark&#39;s outlandish valor. However, on the face of it, Clark just seems a normal boy who&#39;s slightly " +
                "more secretive than usual. ", arrayListOf<Client>()))

        series.add(Movie("Dr. Who",R.drawable.drwho, R.drawable.drwhoheader, "" +
                "Traveling across time and space, the immortal time-lord known as &#39;The Doctor&#39; travels across the " +
                "universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The " +
                "Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-" +
                "lord adversary The Master to the sinister Davros, creator of The Daleks.", arrayListOf<Client>()))

        series.add(Movie("Bones", R.drawable.bones, R.drawable.bonesheader, "" +
                "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an " +
                "ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by " +
                "identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth " +
                "and Dr. Brennan and her team come up again a variety of interference from red tape, corruption, " +
                "and local noncooperation.", arrayListOf<Client>()))

        series.add(Movie("Dr. House",R.drawable.drhouse, R.drawable.drhouse,"" +
                "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory " +
                "House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try " +
                "to cure complex and rare diseases from very ill ordinary people in the United States of America.", arrayListOf<Client>()))

        series.add(Movie("Friends",R.drawable.friends, R.drawable.friendsheader, "" +
                "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory " +
                "House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try " +
                "to cure complex and rare diseases from very ill ordinary people in the United States of America.", arrayListOf<Client>()))

    }

    class MovieAdapter: BaseAdapter{
        var context: Context? = null
        var movies = ArrayList<Movie>()

        constructor(context: Context, movies: ArrayList<Movie>){
            this.context = context
            this.movies = movies
        }

        override fun getCount(): Int {
            return movies.size
        }

        override fun getItem(p0: Int): Any {
            return movies[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var movie = movies[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflator.inflate(R.layout.cell_movie, null)
            var image: ImageView = view.findViewById(R.id.image_movie_cell)
            var title: TextView = view.findViewById(R.id.movie_title_cell)

            image.setImageResource(movie.image)
            title.setText(movie.title)

            image.setOnClickListener {
                var seatsAvailable = 20 - movie.seats.size
                Log.d("SEATS", "$seatsAvailable" )
                var intent = Intent(context, MovieDetail::class.java)
                intent.putExtra("title",  movie.title)
                intent.putExtra("synopsis", movie.sinopsis)
                intent.putExtra("header", movie.header)
                intent.putExtra("image", movie.image)
                intent.putExtra("numberSeats", seatsAvailable)
                intent.putExtra("pos", p0)

                context!!.startActivity(intent)


            }


            return view
        }
    }

}