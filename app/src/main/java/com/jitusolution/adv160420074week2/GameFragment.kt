package com.jitusolution.adv160420074week2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        val randomNumOne = (0..100).random()
        val randomNumTwo = (0..100).random()
        textNumber.text = "$randomNumOne + $randomNumTwo"
        val result = (randomNumOne + randomNumTwo).toString()

        var answer = ""

        txtAnswer.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    answer = txtAnswer.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        btnSubmit.setOnClickListener {
            var pointScore = 0
            if(answer==result){
                pointScore++
            }
            else{
                pointScore
            }

            val action = GameFragmentDirections.actionResultFragment(pointScore)
            Navigation.findNavController(it).navigate(action)

        }
    }
}