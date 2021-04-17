package pdp.uz.a1_4database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import pdp.uz.a1_4database.R
import pdp.uz.a1_4database.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentFirstBinding = FragmentFirstBinding.inflate(inflater, container, false)
        fragmentFirstBinding.phoneListBtn.setOnClickListener {
            fragmentFirstBinding.root.findNavController().navigate(R.id.fourFragment)

        }

        fragmentFirstBinding.phoneAddBtn.setOnClickListener {
            fragmentFirstBinding.root.findNavController().navigate(R.id.secondFragment)
        }

        return fragmentFirstBinding.root

    }

}