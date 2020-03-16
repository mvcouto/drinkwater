package br.com.tamanduasoft.drinkwater.features.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import br.com.tamanduasoft.drinkwater.R
import br.com.tamanduasoft.drinkwater.domain.Cup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_drink_selection.*

class CupSelectionFragment : BottomSheetDialogFragment() {

    var onCupSelectedListener: (Cup) -> Unit = { }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drink_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSeekBar()
        setupCupDescription()
        setupButton()
    }

    private fun setupSeekBar() {
        val cups = getCups()
        seekbarCupOptions.max = cups.size-1
        seekbarCupOptions.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateCupDescription(progress)
            }
        })
    }

    private fun getCups() = arguments?.getParcelableArrayList(ARGS_CUPS) ?: emptyList<Cup>()

    private fun updateCupDescription(progress: Int) {
        val volume = getCups()[progress].volume
        textCupDescription.text = "${volume}ml"
    }

    private fun setupCupDescription() {
        updateCupDescription(0)
    }

    private fun setupButton() {
        buttonSelect.setOnClickListener { onCupSelectedListener(getCups()[seekbarCupOptions.progress]) }
    }

    companion object {

        private const val ARGS_CUPS = "args_cups"

        fun newInstance(cups: List<Cup>) = CupSelectionFragment().also {
            it.arguments = Bundle().apply { putParcelableArrayList(ARGS_CUPS, ArrayList(cups)) }
        }
    }
}