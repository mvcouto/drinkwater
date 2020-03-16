package br.com.tamanduasoft.drinkwater.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.tamanduasoft.drinkwater.R
import br.com.tamanduasoft.drinkwater.domain.Cup
import br.com.tamanduasoft.drinkwater.features.home.model.HomeAction
import br.com.tamanduasoft.drinkwater.features.selection.CupSelectionFragment
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
                textObjectivePercentage.text = getString(R.string.objective_accomplished_percentage, it.progress)
                textDetailedObjectivePercentage.text = getString(R.string.detailed_objective, it.accomplished, it.objective, it.pending)
            }
        })
    }

    private fun setupActionsListener() {
        viewModel.action.observe(viewLifecycleOwner, Observer {
            when (it) {
                is HomeAction.ShowDrinkingOptions -> showCupSelectionScreen(it.cups)
            }
        })
    }

    private fun showCupSelectionScreen(cups: List<Cup>) {
        CupSelectionFragment.newInstance(cups)
            .also { it.onCupSelectedListener = { cup -> viewModel.onCupSelected(cup)} }
            .showNow(childFragmentManager, CupSelectionFragment::class.java.name)
    }
}