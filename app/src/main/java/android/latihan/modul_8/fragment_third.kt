package android.latihan.modul_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
class fragment_third : Fragment() {
    private var communicationViewModel: CommuViewModel? = null
    private var txtName: TextView? = null
    private var url_web: String? = "google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommuViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third,
            container, false) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.link)
        communicationViewModel!!.linkWeb.observe(requireActivity(),
            Observer { s -> txtName!!.text  = s })
    }

    companion object {
        fun newInstance(): fragment_third {
            return fragment_third()
        }
    }
}