package com.altov.vlad.numbercomposition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.altov.vlad.numbercomposition.R
import com.altov.vlad.numbercomposition.databinding.FragmentGameBinding
import com.altov.vlad.numbercomposition.domain.entity.GameResult
import com.altov.vlad.numbercomposition.domain.entity.GameSettings
import com.altov.vlad.numbercomposition.domain.entity.Level


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private lateinit var level: Level
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //delete after
        val gameResult = GameResult(
            true, 0, 0,
            GameSettings(0, 0, 0, 0)
        )
        binding.tvOption1.setOnClickListener { launchGameFinishedFragment(gameResult) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsArgs()
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        val gameFinishedFragment = GameFinishedFragment.newInstance(gameResult)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, gameFinishedFragment)
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsArgs() {
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    companion object {
        const val NAME = "GameFragment"

        private const val KEY_LEVEL = "level"
        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL, level)
                }
            }
        }
    }


}