package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pdp.uz.a1_4database.R
import pdp.uz.a1_4database.adapters.RvGroupListAdapter
import pdp.uz.a1_4database.databinding.FragmentFourBinding
import pdp.uz.a1_4database.db.MyDbHelper

class FourFragment : Fragment() {

    lateinit var list: ArrayList<String>
    lateinit var myDbHelper: MyDbHelper
    private lateinit var rvGroupListAdapter: RvGroupListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentFourBinding = FragmentFourBinding.inflate(inflater, container, false)
        myDbHelper = MyDbHelper(container!!.context)
        loadData()

        rvGroupListAdapter =
            RvGroupListAdapter(list, object : RvGroupListAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val bundle = Bundle()

                    bundle.putString("group", list[position])
                    findNavController().navigate(R.id.fiveFragment, bundle)
                }
            })
        fragmentFourBinding.listRv.adapter = rvGroupListAdapter
        return fragmentFourBinding.root
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