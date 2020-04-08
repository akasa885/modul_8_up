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
        var v =  inflater.inflate(R.layout.fragment_third,
            container, false)
        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        var web = view.findViewById<WebView>(R.id.sec_web)
        web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()
//        fungsi yang digunakan untuk menangkap aktifitas pada WebView, atau overRide url click
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        communicationViewModel!!.linkWeb.observe(requireActivity(),
            Observer { s -> url_web  = s })
        web.loadUrl("https://${url_web}")
    }

    companion object {
        fun newInstance(): fragment_third {
            return fragment_third()
        }
    }
}