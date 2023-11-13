package com.altov.vlad.numbercomposition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.altov.vlad.numbercomposition.databinding.FragmentGameFinishedBinding
import com.altov.vlad.numbercomposition.domain.entity.GameResult


class GameFinishedFragment : Fragment() {
    private  var _binding: FragmentGameFinishedBinding? = null
    private lateinit var gameResult: GameResult
    private val binding:FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsArgs()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    retryGame()
                }

            })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun retryGame(){
        requireActivity().supportFragmentManager.popBackStack(GameFragment.NAME,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun parsArgs(){
        gameResult = requireArguments().getSerializable(KEY_GAME_RESULT) as GameResult
    }
    companion object{
        private const val KEY_GAME_RESULT = "gameResult"
        fun newInstance(gameResult: GameResult):GameFinishedFragment{
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_GAME_RESULT,gameResult)
                }
            }
        }
    }

}