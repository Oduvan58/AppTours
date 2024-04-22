package com.example.apptours.view.listCountryTo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.core.widget.addTextChangedListener
import com.example.apptours.app
import com.example.apptours.databinding.FragmentChooseToBinding
import com.example.apptours.domain.Country
import com.example.apptours.view.presenter.ChooseToPresenter
import com.example.apptours.view.presenter.ChooseToView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import moxy.MvpBottomSheetDialogFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ChooseToFragment : MvpBottomSheetDialogFragment(), ChooseToView {

    private var _binding: FragmentChooseToBinding? = null
    private val binding get() = _binding!!

    private var dataPasser: OnToDataPass? = null

    @Inject
    lateinit var presenterProvider: Provider<ChooseToPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var toAdapter: ToAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        app.appComponent.inject(this)
        dataPasser = try {
            context as OnToDataPass
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnDataPass interface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseToBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        searchInput()
        cancelClick()
        bottomSheetState()
    }

    private fun initRecyclerView() {
        toAdapter = ToAdapter(presenter::onClickToItem)
        binding.listChooseToRecyclerView.adapter = toAdapter
    }

    private fun searchInput() {
        binding.inputChooseToEditText.addTextChangedListener {
            presenter.onChangeListener(it.toString())
        }
    }

    private fun cancelClick() {
        binding.closeChooseToTextView.setOnClickListener {
            dismiss()
        }
    }

    private fun bottomSheetState() {
        this.dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val frameLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(frameLayout)
            val layoutParams = frameLayout.layoutParams
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            frameLayout.layoutParams = layoutParams
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getCountries(list: List<Country>) {
        toAdapter.submitList(list)
    }

    override fun onDismiss(country: String, countryId: Int) {
        dismiss()
        dataPasser?.onToDataPass(country, countryId)
    }

    interface OnToDataPass {
        fun onToDataPass(country: String, countryId: Int)
    }

}