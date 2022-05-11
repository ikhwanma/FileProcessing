package ikhwan.binar.fileprocess.handlepdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_pdf_web_view.*

class PdfWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_web_view)

        wv_pdf.webViewClient = WebViewClient()
        wv_pdf.settings.setSupportZoom(true)
        wv_pdf.settings.javaScriptEnabled = true
        wv_pdf.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=https://kotlinlang.org/assets/kotlin-media-kit.pdf")
    }
}