import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.R
import com.example.superheroes.features.domain.SuperHeroe

class SuperHeroAdapter(private val lista: List<SuperHeroe>): RecyclerView.Adapter<SuperHeroeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superheroe, parent, false)
        return SuperHeroeViewHolder(view)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: SuperHeroeViewHolder, position: Int) {
        val heroe = lista[position]
        holder.name.text = heroe.name
        holder.slug.text = heroe.slug
    }
}

class SuperHeroeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.SuperHeroName)
    val slug: TextView = view.findViewById(R.id.SuperHeroSlug))
}