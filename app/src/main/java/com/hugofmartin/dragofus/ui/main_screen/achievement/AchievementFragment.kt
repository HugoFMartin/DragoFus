package com.hugofmartin.dragofus.ui.main_screen.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.common.Constants
import kotlinx.android.synthetic.main.achievement_fragment.*

class AchievementFragment : Fragment() {

    private lateinit var achievementViewModel: AchievementViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            achievementViewModel = ViewModelProvider(this, AchievementViewModel).get(
                AchievementViewModel::class.java) as AchievementViewModel

        } ?: throw IllegalStateException("Invalid Activity")

        return inflater.inflate(R.layout.achievement_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        birth_progressBar.max = Constants.NB_MAX_BIRTH
        coupling_progressBar.max = Constants.NB_MAX_COUPLING

        achievementViewModel.appAchievement.observe(viewLifecycleOwner){
            birth_progressBar.progress = it.nbBirth
            birth_achivement_desc_textView.text = resources.getString(R.string.birth_desc_achivement, it.nbBirth, Constants.NB_MAX_BIRTH)

            coupling_progressBar.progress = it.nbCoupling
            coupling_achivement_desc_textView.text = resources.getString(R.string.coupling_desc_achivement, it.nbCoupling, Constants.NB_MAX_COUPLING)
        }
    }
}