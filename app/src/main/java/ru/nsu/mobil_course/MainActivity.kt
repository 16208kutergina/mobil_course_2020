package ru.nsu.mobil_course

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu.*


class MainActivity : AppCompatActivity() {
//    lateinit var adapter: NfcAdapter
//    var mytag: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            showFragment("start", "start text")
        }
        button1.setOnClickListener { showFragment("label_1", "text_1")  }
        button2.setOnClickListener { showFragment("label_2", "text_2") }
        button3.setOnClickListener { showFragment("label_3", "text_3") }
    }

    fun showFragment(label: String, text: String){
        val fragment = ButtonFragment()
        fragment.arguments = Bundle().also{
            it.putString("label", label)
            it.putString("text", text)
        }

        supportFragmentManager.also { it.popBackStack("Text", FragmentManager.POP_BACK_STACK_INCLUSIVE) }
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
//        if (webView != null) {
//            webView.loadUrl("https://githab.com")
//        }
//        adapter = NfcAdapter.getDefaultAdapter(this)
//        button.setOnClickListener { onNewIntent(Intent()) }
//    }

//    override fun onNewIntent(intent: Intent) {
//        if (NfcAdapter.ACTION_TAG_DISCOVERED == intent.action) {
//            mytag =
//                intent.getParcelableExtra(NfcAdapter.EXTRA_TAG) // get the detected tag
//            val msgs =
//                intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
//            val firstRecord = (msgs[0] as NdefMessage).records[0]
//            val payload = firstRecord.payload
//            val payloadLength = payload.size
//            val langLength = payload[0].toInt()
//            val textLength = payloadLength - langLength - 1
//            val text = ByteArray(textLength)
//            System.arraycopy(payload, 1 + langLength, text, 0, textLength)
//            Toast.makeText(
//                this,
//                this.getString(R.string.ok_detection) + String(text),
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
}
