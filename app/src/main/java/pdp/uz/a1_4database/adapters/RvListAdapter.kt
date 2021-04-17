package pdp.uz.a1_4database.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pdp.uz.a1_4database.databinding.ItemListPhoneBinding
import pdp.uz.a1_4database.models.Phone

class RvListAdapter(var list: ArrayList<Phone>, var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RvListAdapter.Vh>() {
    inner class Vh(var itemListPhoneBinding: ItemListPhoneBinding) :
        RecyclerView.ViewHolder(itemListPhoneBinding.root) {
        fun onBind(phone: Phone, position: Int) {
            itemListPhoneBinding.itemListName.text = phone.name
            itemListPhoneBinding.itemListPhone.setOnClickListener {
                onItemClickListener.onItemClick(phone, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemListPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onItemClick(phone: Phone, position: Int)
    }
}
