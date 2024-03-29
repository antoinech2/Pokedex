package dev.antoinech.pokedex.adapter
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.antoinech.pokedex.R
import dev.antoinech.pokedex.model.Pokemon
import dev.antoinech.pokedex.PokedexListActivity.Companion.getAssetsDrawable

class PokemonListAdapter(private val context: Context, private val dataset:
List<Pokemon>): RecyclerView.Adapter<PokemonListAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.pokedex_list_item_name)
        val imageView: ImageView = view.findViewById(R.id.pokedex_list_item_image)
        val type1View: ImageView = view.findViewById(R.id.pokedex_list_item_type1)
        val type2View: ImageView = view.findViewById(R.id.pokedex_list_item_type2)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.pokedex_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }
    override fun getItemCount() = dataset.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val fullId = String.format("%03d", item.id)
        holder.textView.text = "#$fullId ${item.name}"
        val imageDrawable: BitmapDrawable? = getAssetsDrawable(context, "$fullId.png")
        holder.imageView.setImageDrawable(imageDrawable)
        val type1Drawable: BitmapDrawable? = getAssetsDrawable(context,
            "${item.type1}.png")
        holder.type1View.setImageDrawable(type1Drawable)
        if (item.type2 != null) {
            val type2Drawable: BitmapDrawable? =
                getAssetsDrawable(context, "${item.type2}.png"
                )
            holder.type2View.setImageDrawable(type2Drawable)
            holder.type2View.visibility = View.VISIBLE
        } else {
            holder.type2View.visibility = View.GONE
        }
    }
}
