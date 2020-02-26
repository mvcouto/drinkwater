package br.com.tamanduasoft.drinkwater.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.tamanduasoft.drinkwater.R
import br.com.tamanduasoft.drinkwater.home.model.HomeAction
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupStateListener()
        setupActionsListener()
        buttonAdd.setOnClickListener { viewModel.onAddClicked() }

        viewModel.getInformation()
    }

    private fun setupStateListener() {
        viewModel.state.observe(viewLifecycleOwner, Observer { homeState ->
            homeState?.let {
                textObjectivePercentage.text = String.format("%.1f", it.progress)
            }
        })
    }

    private fun setupActionsListener() {
        viewModel.action.observe(viewLifecycleOwner, Observer {
            when(it) {
                is HomeAction.ShowDrinkingOptions -> TODO()
            }
        })
    }
}