package pdp.uz.a1_4database.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pdp.uz.a1_4database.databinding.ItemGroupListPhoneBinding

class RvGroupListAdapter(
    var list: ArrayList<String>,
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RvGroupListAdapter.Vh>() {
    inner class Vh(var itemGroupListPhoneBinding: ItemGroupListPhoneBinding) :
        RecyclerView.ViewHolder(itemGroupListPhoneBinding.root) {
        fun onBind(str: String, position: Int) {
            itemGroupListPhoneBinding.itemGroupName.text = str
            itemGroupListPhoneBinding.itemGroupPhone.setOnClickListener {
                onItemClickListener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemGroupListPhoneBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}