package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pdp.uz.a1_4database.R
import pdp.uz.a1_4database.adapters.RvAddAdapter
import pdp.uz.a1_4database.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var rvAddAdapter: RvAddAdapter
    lateinit var list: ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentSecondBinding = FragmentSecondBinding.inflate(inflater, container, false)
        loadData()
        rvAddAdapter = RvAddAdapter(list, object : RvAddAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("groupId", list[position])
                findNavController().navigate(R.id.thirdFragment, bundle)
            }
        })

        fragmentSecondBinding.listRv.adapter = rvAddAdapter
        return fragmentSecondBinding.root
    }

    private fun loadData() {
        list = ArrayList()
        list.add("iPhone")
        list.add("Samsung")
        list.add("Mi")
        list.add("Sony")
        list.add("Huawei")
        list.add("Artel")
    }
}