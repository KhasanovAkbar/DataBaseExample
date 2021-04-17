package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pdp.uz.a1_4database.R
import pdp.uz.a1_4database.databinding.FragmentThirdBinding
import pdp.uz.a1_4database.db.MyDbHelper
import pdp.uz.a1_4database.models.Phone

class ThirdFragment : Fragment() {
    lateinit var myDbHelper: MyDbHelper
    private var isClick = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentThirdBinding = FragmentThirdBinding.inflate(inflater, container, false)
        myDbHelper = MyDbHelper(container!!.context)
        fragmentThirdBinding.addBtn.setOnClickListener {
            val group = arguments?.getString("groupId")
            val name = fragmentThirdBinding.nameEt.text.toString()
            val feature = fragmentThirdBinding.phoneFeature.text.toString()
            var temp1 = 0
            var temp2 = 0
            for (i in name.indices) {
                if (name[i] == ' ') temp1++
            }
            for (i in feature.indices) {
                if (feature[i] == ' ') temp2++
            }

            if (name.isEmpty() && feature.isEmpty()) {
                Toast.makeText(container.context, "Fields are empty", Toast.LENGTH_SHORT).show()
            } else if (name.length == temp1 || feature.length == temp2) {
                Toast.makeText(container.context, "It's impossible to save", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val phone = Phone(group.toString(), name, feature)
                myDbHelper.addPhone(phone)
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
                isClick = false

            }
        }
        return fragmentThirdBinding.root
    }
}