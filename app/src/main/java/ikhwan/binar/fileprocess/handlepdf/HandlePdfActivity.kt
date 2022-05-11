package ikhwan.binar.fileprocess.handlepdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_handle_pdf.*

class HandlePdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_pdf)

        btn_webview.setOnClickListener {
            startActivity(Intent(this, PdfWebViewActivity::class.java))
        }
        btn_asset.setOnClickListener {
            startActivity(Intent(this, PdfAssetActivity::class.java))
        }
        btn_storage.setOnClickListener {
            startActivity(Intent(this, PdfStorageActivity::class.java))
        }
        btn_internet.setOnClickListener {
            startActivity(Intent(this, PdfInternetActivity::class.java))
        }
    }
}