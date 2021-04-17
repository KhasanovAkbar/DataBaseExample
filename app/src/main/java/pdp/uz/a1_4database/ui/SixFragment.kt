package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pdp.uz.a1_4database.databinding.FragmentSixBinding
import pdp.uz.a1_4database.db.MyDbHelper

class SixFragment : Fragment() {
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentSixBinding = FragmentSixBinding.inflate(inflater, container, false)
        myDbHelper = MyDbHelper(container!!.context)
        val id = arguments?.getInt("id")

        val phone = myDbHelper.getPhoneById(id!!)

        fragmentSixBinding.phoneGroup.text = phone.name
        fragmentSixBinding.phoneFeature.text = phone.info

        return fragmentSixBinding.root
    }

}