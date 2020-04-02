package android.latihan.modul_8

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
class fragment_first : Fragment() {
    private var communicationViewModel: CommuViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel =
            ViewModelProviders.of(requireActivity()).
                get(CommuViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first,
            container, false) }
    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
        val webEditUrl = view.findViewById<TextInputEditText>(R.id.webInputText)
        nameEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence,
                                           i: Int, i1: Int, i2: Int) {
                    communicationViewModel!!.setName(charSequence.toString())
                }
                override fun afterTextChanged(editable: Editable) {
                }
            }
        )
        webEditUrl.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence,
                                           i: Int, i1: Int, i2: Int) {
                    communicationViewModel!!.setWeb(charSequence.toString())
                }
                override fun afterTextChanged(editable: Editable) {
                }
            }
        )
    }
    companion object {
        fun newInstance(): fragment_first {
            return fragment_first()
        } } }