package com.example.apptours.view.listCountryFrom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.widget.addTextChangedListener
import com.example.apptours.app
import com.example.apptours.databinding.FragmentChooseFromBinding
import com.example.apptours.domain.City
import com.example.apptours.view.presenter.ChoosePresenter
import com.example.apptours.view.presenter.ChooseView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import moxy.MvpBottomSheetDialogFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class ChooseFromFragment : MvpBottomSheetDialogFragment(), ChooseView {

    private var _binding: FragmentChooseFromBinding? = null
    private val binding get() = _binding!!

    private var dataPasser: OnDataPass? = null

    @Inject
    lateinit var presenterProvider: Provider<ChoosePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var fromAdapter: FromAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        app.appComponent.inject(this)
        dataPasser = try {
            context as OnDataPass
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnDataPass interface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseFromBinding.inflate(inflater, container, false)
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
        fromAdapter = FromAdapter(presenter::onClickItem)
        binding.listChooseFromRecyclerView.adapter = fromAdapter
    }

    private fun searchInput() {
        binding.inputChooseFromEditText.addTextChangedListener {
            presenter.onChangeListener(it.toString())
        }
    }

    private fun cancelClick() {
        binding.closeChooseFromTextView.setOnClickListener {
            dismiss()
        }
    }

    private fun bottomSheetState() {
        this.dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val frameLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(frameLayout)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getCities(list: List<City>) {
        fromAdapter.submitList(list)
    }

    override fun onDismiss(city: String, departCityId: Int) {
        dismiss()
        dataPasser?.onDataPass(city, departCityId)
    }


    interface OnDataPass {
        fun onDataPass(city: String, departCityId: Int)
    }


}