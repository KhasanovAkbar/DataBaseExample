package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pdp.uz.a1_4database.R
import pdp.uz.a1_4database.adapters.RvListAdapter
import pdp.uz.a1_4database.databinding.FragmentFiveBinding
import pdp.uz.a1_4database.db.MyDbHelper
import pdp.uz.a1_4database.models.Phone

class FiveFragment : Fragment() {
    lateinit var rvListAdapter: RvListAdapter
    private var fragmentFiveBinding: FragmentFiveBinding? = null
    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Phone>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFiveBinding = FragmentFiveBinding.inflate(inflater, container, false)
        val group = arguments?.getString("group")
        myDbHelper = MyDbHelper(container!!.context)
        fragmentFiveBinding!!.phoneGroupTv.text = group
        list = myDbHelper.getAllPhones()
        var tempList = ArrayList<Phone>()
        for (i in 0 until list.size) {
            if (list[i].group == group) {
                tempList.add(list[i])
            }
        }

        rvListAdapter = RvListAdapter(tempList, object : RvListAdapter.OnItemClickListener {
            override fun onItemClick(phone: Phone, position: Int) {
                val bundle = Bundle()
                bundle.putInt("id", phone.id!!)
                findNavController().navigate(R.id.sixFragment, bundle)
            }
        })
        fragmentFiveBinding!!.listRv.adapter = rvListAdapter
        return fragmentFiveBinding!!.root
    }
}
