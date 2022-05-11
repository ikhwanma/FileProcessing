package ikhwan.binar.fileprocess.handlepdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_pdf_asset.*

class PdfAssetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_asset)

        pdf_asset.fromAsset("kotlin-media-kit.pdf").load()
    }

}