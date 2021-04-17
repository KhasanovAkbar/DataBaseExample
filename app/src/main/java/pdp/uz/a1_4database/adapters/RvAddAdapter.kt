package pdp.uz.a1_4database.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pdp.uz.a1_4database.databinding.ItemAddPhoneBinding

class RvAddAdapter(var list: List<String>, var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RvAddAdapter.Vh>() {
    inner class Vh(var itemAddPhoneBinding: ItemAddPhoneBinding) :
        RecyclerView.ViewHolder(itemAddPhoneBinding.root) {
        fun onBind(str: String, position: Int) {
            itemAddPhoneBinding.itemAddName.text = str
            itemAddPhoneBinding.itemAddPhone.setOnClickListener {
                onItemClickListener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemAddPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}