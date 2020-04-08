package android.latihan.modul_8

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class fragment_second : Fragment() {
    private var communicationViewModel: CommuViewModel? = null
    private var txtName: TextView? = null
    private var kirim: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommuViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,
            container, false) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        kirim = view.findViewById(R.id.kirim)
        var to = view.findViewById<EditText>(R.id.subInputTextSend)
        var isi = view.findViewById<EditText>(R.id.isiInputSend)
        txtName = view.findViewById(R.id.urmail)
        communicationViewModel!!.name.observe(requireActivity(), Observer { s -> txtName!!.text = s })
        kirim!!.setOnClickListener {
            val mail_send = Intent(Intent.ACTION_SEND)
            val recipient = txtName!!.text.toString().trim()
            val subject = to.text.toString().trim()
            val message = isi.text.toString().trim()
            mail_send.data = Uri.parse("mailto:")
            mail_send.type = "text/plain"
            mail_send.setType("message/rfc822")
            mail_send.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            mail_send.putExtra(Intent.EXTRA_SUBJECT, subject)
            mail_send.putExtra(Intent.EXTRA_TEXT,message)
            try {
                //mulai kirim email
                startActivity(Intent.createChooser(mail_send, "Choose Email Client..."))
            }
            catch (e: Exception){
                //
                //jika ada yang salah misalnya tidak ada aplikasi email
                //tampil pesan errornya
                //
            }
        }
    }
    companion object {
        fun newInstance(): fragment_second {
            return fragment_second()
        }
    }
    fun kirim (){

    }
}