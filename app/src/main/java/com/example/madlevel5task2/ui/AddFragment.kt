package com.example.madlevel5task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game
import kotlinx.android.synthetic.main.fragment_add.*
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddFragment : Fragment() {

    private val viewModel: AddViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_save.setOnClickListener {onAddGame()}


    }

    private fun onAddGame(){
        val title = input_title.text.toString()
        val platform = input_platform.text.toString()
        val day = input_day.text.toString().toInt()
        val month = input_month.text.toString().toInt()
        val year = input_year.text.toString().toInt()
//        val date = Calendar.getInstance();
//        date.set(year, month-1, day);




//            //set the data as fragmentResult, we are listening for REQ_REMINDER_KEY in RemindersFragment!
//            setFragmentResult(REQ_REMINDER_KEY, bundleOf(Pair(BUNDLE_REMINDER_KEY, reminderText)))
//            viewModel.insertGame(Game(title,platform, date))
//
            //"pop" the backstack, this means we destroy
            //this fragment and go back to the RemindersFragment
            findNavController().popBackStack()




    }
}